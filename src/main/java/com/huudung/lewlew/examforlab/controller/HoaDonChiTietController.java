package com.huudung.lewlew.examforlab.controller;

import com.huudung.lewlew.examforlab.entity.HoaDon;
import com.huudung.lewlew.examforlab.entity.HoaDonChiTiet;
import com.huudung.lewlew.examforlab.entity.SPChiTiet;
import com.huudung.lewlew.examforlab.repositories.HoaDonChiTietRepository;
import com.huudung.lewlew.examforlab.repositories.HoaDonRepository;
import com.huudung.lewlew.examforlab.repositories.SPChiTietRepository;
import com.huudung.lewlew.examforlab.service.HoaDonChiTietService;
import com.huudung.lewlew.examforlab.service.HoaDonService;
import com.huudung.lewlew.examforlab.service.SPChiTietService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/hoaDonChiTiet")
public class HoaDonChiTietController {

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietService;

    @Autowired
    private HoaDonRepository hoaDonService;

    @Autowired
    private SPChiTietRepository spChiTietService;

    int idHoaDon= 0;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam("id") int id){
        model.addAttribute("listHDCT", hoaDonChiTietService.findByHoaDon(hoaDonService.findById(id).get()));
        model.addAttribute("hoaDonChiTiet", new HoaDonChiTiet());
        idHoaDon = id;
        return "hoaDonChiTiet/index";
    }

    @PostMapping("/search")
    public String searchHoaDonChiTiet(Model model, @RequestParam("id") int id){
        try {
            model.addAttribute("hoaDonChiTiet", new HoaDonChiTiet());
            model.addAttribute("listHDCT", List.of(hoaDonChiTietService.findById(id)));
            return "redirect:/admin/hoaDonChiTiet/list?id=" + idHoaDon;
        } catch (Exception e) {
            return "redirect:/admin/hoaDonChiTiet/list?id=" + idHoaDon;
        }
    }


    @GetMapping("/chiTiet")
    public String chiTietHoaDonChiTiet(@RequestParam("id") int id, Model model){
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietService.findById(id).get();
        model.addAttribute("hoaDonChiTiet", hoaDonChiTiet);
        return "hoaDonChiTiet/chiTiet";
    }

    @PostMapping("/update")
    public String updateHoaDonChiTiet(@Valid @ModelAttribute("hoaDonChiTiet") HoaDonChiTiet hoaDonChiTiet, BindingResult result){
        if (result.hasErrors()){
            return "hoaDonChiTiet/chiTiet";
        }
        hoaDonChiTiet.setSpChiTiet(spChiTietService.findById(hoaDonChiTiet.getSpChiTiet().getId()).get());
        hoaDonChiTietService.save(hoaDonChiTiet);
        return "redirect:/admin/hoaDonChiTiet/list?id=" + idHoaDon;
    }

    @ModelAttribute("hoaDonList")
    public List<HoaDon> getHoaDon(){
        return hoaDonService.findAll();
    }

    @ModelAttribute("spChiTietList")
    public List<SPChiTiet> getSPChiTiet(){
        return spChiTietService.findAll();
    }
}
