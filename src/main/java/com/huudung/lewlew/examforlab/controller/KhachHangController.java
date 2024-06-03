package com.huudung.lewlew.examforlab.controller;

import com.huudung.lewlew.examforlab.entity.KhachHang;
import com.huudung.lewlew.examforlab.repositories.KhachHangRepository;
import com.huudung.lewlew.examforlab.service.KhachHangService;
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
@RequestMapping("/khachHang")
public class KhachHangController {

    @Autowired
    private KhachHangRepository khachHangService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(name = "page", defaultValue = "0") int page){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, 4);
        model.addAttribute("listKH", khachHangService.findAll(pageable));
        model.addAttribute("khachHang", new KhachHang()); // Thêm một đối tượng KhachHang mới để binding với form
        return "khachHang/index";
    }

    @GetMapping("/xoa")
    public String xoaKhachHang(@RequestParam("id") int id, Model model){
        khachHangService.deleteById(id);
        return "redirect:/khachHang/list";
    }

    @PostMapping("/them")
    public String themKhachHang(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result){
        if (result.hasErrors()){
            return "khachHang/index";
        }
        khachHangService.save(khachHang);
        return "redirect:/khachHang/list";
    }

    @PostMapping("/search")
    public String searchKhachHang(@RequestParam("id") int id, Model model){
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            Pageable pageable = PageRequest.of(0, 4);
            model.addAttribute("khachHang", new KhachHang()); // Thêm một đối tượng KhachHang mới để binding với form
            model.addAttribute("listKH", khachHangService.searchAllById(id, pageable));
            return "khachHang/index";
        } catch (Exception e) {
            return "redirect:/khachHang/list";
        }
    }

    @GetMapping("/chiTiet")
    public String chiTietKhachHang(@RequestParam("id") int id, Model model){
        KhachHang khachHang = khachHangService.findById(id).get();
        model.addAttribute("khachHang", khachHang);
        return "khachHang/chiTiet";
    }

    @PostMapping("/update")
    public String updateKhachHang(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result){
        if (result.hasErrors()){
            return "khachHang/chiTiet";
        }
        khachHangService.save( khachHang);
        return "redirect:/khachHang/list";
    }
}
