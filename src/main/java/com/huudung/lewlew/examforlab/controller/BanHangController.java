package com.huudung.lewlew.examforlab.controller;

import com.huudung.lewlew.examforlab.entity.*;
import com.huudung.lewlew.examforlab.repositories.HoaDonChiTietRepository;
import com.huudung.lewlew.examforlab.repositories.HoaDonRepository;
import com.huudung.lewlew.examforlab.repositories.KhachHangRepository;
import com.huudung.lewlew.examforlab.repositories.SPChiTietRepository;
import com.huudung.lewlew.examforlab.service.HoaDonChiTietService;
import com.huudung.lewlew.examforlab.service.HoaDonService;
import com.huudung.lewlew.examforlab.service.KhachHangService;
import com.huudung.lewlew.examforlab.service.SPChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/banHang")
public class BanHangController {
    @Autowired
    private SPChiTietRepository spChiTietService;
    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietService;
    @Autowired
    private HoaDonRepository hoaDonService;
    @Autowired
    private KhachHangRepository khachHangService;

    @GetMapping("/home")
    public String showHome(Model model){
        this.setUpHome(model);
        return "banHang/home";
    }

    @PostMapping("/taoHoaDon")
    public String taoHoaDon(Model model, @RequestParam("khachHang") int id){

        this.setUpHoaDon(id);
        this.setUpHome(model);
        return "banHang/home";
    }

    @GetMapping("/chonHoaDon")
    public String chonHoaDon(Model model, @RequestParam("id") int id){
        this.setUpChiTietHoaDon(id, model);
        this.setUpChonHoaDon(id, model);
        this.setUpHome(model);
        return "banHang/home";
    }

    @GetMapping("/thanhToan")
    public String thanhToan(Model model, @RequestParam("id") int id){
        HoaDon hoaDon = hoaDonService.findById(id).get();
        hoaDon.setTrangThai(true);
        hoaDonService.save(hoaDon);
        this.setUpHome(model);
        return "banHang/home";
    }

    @GetMapping("/chonSanPham")
    public String chonSanPham(Model model,
                              @RequestParam("id") int id,
                              @RequestParam("idSanPham") int idSanPham
    ){
        SPChiTiet spChiTiet =  spChiTietService.findById(idSanPham).get();
        spChiTiet.setSoLuong(spChiTiet.getSoLuong() - 1);
        spChiTietService.save(spChiTiet);
        HoaDon hoaDon = hoaDonService.findById(id).get();



        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setSpChiTiet(spChiTiet);
            hoaDonChiTiet.setSoLuong(1);
            hoaDonChiTiet.setDonGia(spChiTiet.getDonGia());


        hoaDonChiTietService.save(hoaDonChiTiet);

        this.setUpChiTietHoaDon(id, model);
        this.setUpChonHoaDon(id, model);
        this.setUpHome(model);

        return "banHang/home";
    }

    @GetMapping("/deleteSanPhamSelect")
    public String deleteSanPhamSelect(Model model, @RequestParam("id") int id,
                                      @RequestParam("idHoaDon") int idHD,
                                      @RequestParam("idSPCT") int idSPCT
                                      ){
        System.out.println("day la id xoa" + id);
        hoaDonChiTietService.deleteById(id);
        this.setUpChiTietHoaDon(idHD, model);
        this.setUpChonHoaDon(idHD, model);
        this.setUpHome(model);
        return "banHang/home";
    }


    public void setUpHome(Model model){
        model.addAttribute("listHD", hoaDonService.findAll());
        model.addAttribute("listSPCT", spChiTietService.findAll());
        model.addAttribute("listKH", khachHangService.findAll());
    }



    public void setUpChonHoaDon(int id, Model model){
        HoaDon hoaDon = hoaDonService.findById(id).get();
        model.addAttribute("hoaDonSelct", hoaDon);
        int totalPrice = 0;
        for (HoaDonChiTiet hdct: hoaDonChiTietService.findByHoaDon(hoaDon)){
            totalPrice += hdct.getDonGia()*hdct.getSoLuong();
        }
        model.addAttribute("totalPrice", totalPrice);
    }

    public void setUpChiTietHoaDon(int id, Model model) {
        model.addAttribute("listHDCTByIDHD", hoaDonChiTietService.findByHoaDon(hoaDonService.findById(id).get()));

    }


    public void setUpHoaDon(int id){
        KhachHang khachHang = khachHangService.findById(id).get();

        HoaDon hoaDon = new HoaDon();

        hoaDon.setKhachHang(khachHang);
        hoaDon.setNgayMuaHang(new Date().toString());
        Random rand = new Random();
        hoaDon.setId(rand.nextInt(0,100));
        hoaDon.setNhanVien(new NhanVien(1, "Nguyen Van A", "NV01", "nguyenvana", "123456", true, "user"));

        hoaDonService.save(hoaDon);
    }



}
