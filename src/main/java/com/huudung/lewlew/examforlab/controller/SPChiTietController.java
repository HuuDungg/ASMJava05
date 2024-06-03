package com.huudung.lewlew.examforlab.controller;

import com.huudung.lewlew.examforlab.entity.KichThuoc;
import com.huudung.lewlew.examforlab.entity.MauSac;
import com.huudung.lewlew.examforlab.entity.SPChiTiet;
import com.huudung.lewlew.examforlab.entity.SanPham;
import com.huudung.lewlew.examforlab.repositories.KichThuocRepository;
import com.huudung.lewlew.examforlab.repositories.MauSacRepository;
import com.huudung.lewlew.examforlab.repositories.SPChiTietRepository;
import com.huudung.lewlew.examforlab.repositories.SanPhamRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/spChiTiet")
public class SPChiTietController {

    @Autowired
    private SPChiTietRepository spChiTietService;
    @Autowired
    private MauSacRepository mauSacService;
    @Autowired
    private SanPhamRepository sanPhamService;
    @Autowired
    private KichThuocRepository kichThuocService;

    private int idHoaDon = 0;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam("id") int id){
        model.addAttribute("listSPCT", spChiTietService.findBySanPham(sanPhamService.findById(id).get()));
        model.addAttribute("spChiTiet", new SPChiTiet());
        idHoaDon = id;
        return "spChiTiet/index";
    }

    @PostMapping("/them")
    public String themSPCT(Model model, @Valid@ModelAttribute("spChiTiet") SPChiTiet spChiTiet){
        System.out.println("day la id hd " + idHoaDon);
        spChiTietService.save(spChiTiet);
        return "redirect:/spChiTiet/list?id=" + idHoaDon ;

    }

    @PostMapping("/search")
    public String searchSPCT(Model model, @RequestParam("maSPCT") int maSPCT){

        try {
            model.addAttribute("spChiTiet", new SPChiTiet());
            model.addAttribute("listSPCT", List.of(spChiTietService.findById(maSPCT)));
            return "redirect:/spChiTiet/list?id=" + idHoaDon ;
        }catch (Exception e){
            return "redirect:/spChiTiet/list?id=" + idHoaDon ;
        }
    }

    @GetMapping("/xoa")
    public String xoaSPCT(@RequestParam("id") int id){
        spChiTietService.deleteById(id);
        return "redirect:/spChiTiet/list?id=" + idHoaDon ;
    }

    @GetMapping("/chiTiet")
    public String chiTietSPCT(@RequestParam("id") int id, Model model){
        SPChiTiet spChiTiet = spChiTietService.findById(id).get();
        model.addAttribute("spChiTiet", spChiTiet);
        return "spChiTiet/chiTiet";
    }

    @PostMapping("/update")
    public String updateSPCT(@Valid @ModelAttribute("spChiTiet") SPChiTiet spChiTiet, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/spChiTiet/list?id=" + idHoaDon ;
        }
        spChiTietService.save(spChiTiet);
        return "redirect:/spChiTiet/list?id=" + idHoaDon ;
    }



    @ModelAttribute("mauSacList")
    public List<MauSac> getMauSac(){
        return mauSacService.findAll();
    }

    @ModelAttribute("sanPhamList")
    public List<SanPham> getSanPham(){
        return sanPhamService.findAll();
    }

    @ModelAttribute("kichThuocList")
    public List<KichThuoc> getKichThuoc(){
        return kichThuocService.findAll();
    }
}
