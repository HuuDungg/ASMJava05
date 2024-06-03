package com.huudung.lewlew.examforlab.controller;

import com.huudung.lewlew.examforlab.entity.HoaDon;
import com.huudung.lewlew.examforlab.entity.KhachHang;
import com.huudung.lewlew.examforlab.entity.NhanVien;
import com.huudung.lewlew.examforlab.repositories.HoaDonRepository;
import com.huudung.lewlew.examforlab.repositories.KhachHangRepository;
import com.huudung.lewlew.examforlab.repositories.NhanVienRepository;
import com.huudung.lewlew.examforlab.service.HoaDonService;
import com.huudung.lewlew.examforlab.service.KhachHangService;
import com.huudung.lewlew.examforlab.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/hoaDon")
public class HoaDonController {

    @Autowired
    private HoaDonRepository hoaDonService;
    @Autowired
    private KhachHangRepository khachHangService;
    @Autowired
    private NhanVienRepository nhanVienService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(name = "page", defaultValue = "0") int page){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, 4);
        model.addAttribute("listHD", hoaDonService.findAll(pageable));
        return "hoaDon/index";
    }

    @PostMapping("/search")
    public String searchHoaDon(Model model, @RequestParam("id") int id){
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            Pageable pageable = PageRequest.of(0, 4);
            model.addAttribute("hoaDon", new HoaDon());
            model.addAttribute("listHD", hoaDonService.searchAllById(id, pageable));
            return "hoaDon/index";
        } catch (Exception e) {
            return "redirect:/admin/hoaDon/list";
        }
    }

    @GetMapping("/xoa")
    public String xoaHoaDon(@RequestParam("id") int id){
        hoaDonService.deleteById(id);
        return "redirect:/admin/hoaDon/list";
    }

    @GetMapping("/chiTiet")
    public String chiTietHoaDon(@RequestParam("id") int id, Model model){
        HoaDon hoaDon = hoaDonService.findById(id).get();
        model.addAttribute("hoaDon", hoaDon);
        return "hoaDon/chiTiet";
    }

    @PostMapping("/update")
    public String updateHoaDon(@Valid @ModelAttribute("hoaDon") HoaDon hoaDon, BindingResult result){
        if (result.hasErrors()){
            return "hoaDon/chiTiet";
        }

        hoaDon.setKhachHang(khachHangService.findById(hoaDon.getKhachHang().getId()).get());
        hoaDon.setNhanVien(nhanVienService.findById(hoaDon.getNhanVien().getId()).get());

        hoaDonService.save(hoaDon);
        return "redirect:/admin/hoaDon/list";
    }

    @ModelAttribute("khachHangList")
    public List<KhachHang> getKhachHang(){
        return khachHangService.findAll();
    }

    @ModelAttribute("nhanVienList")
    public List<NhanVien> getNhanVien(){
        return nhanVienService.findAll();
    }
}
