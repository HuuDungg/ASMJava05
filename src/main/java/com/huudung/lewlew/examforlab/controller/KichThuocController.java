package com.huudung.lewlew.examforlab.controller;

import com.huudung.lewlew.examforlab.entity.KichThuoc;
import com.huudung.lewlew.examforlab.repositories.KichThuocRepository;
import com.huudung.lewlew.examforlab.service.KichThuocService;
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
@RequestMapping("/kichThuoc")
public class KichThuocController {

    @Autowired
    private KichThuocRepository kichThuocService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(name = "page", defaultValue = "0") int page){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, 4);

        model.addAttribute("listKT", kichThuocService.findAll(pageable));
        model.addAttribute("kichThuoc", new KichThuoc()); // Thêm một đối tượng KichThuoc mới để binding với form
        return "kichThuoc/index";
    }

    @GetMapping("/xoa")
    public String xoaKichThuoc(@RequestParam("id") int id, Model model){
        kichThuocService.deleteById(id);
        return "redirect:/kichThuoc/list";
    }

    @PostMapping("/them")
    public String themKichThuoc(@Valid @ModelAttribute("kichThuoc") KichThuoc kichThuoc, BindingResult result){
        if (result.hasErrors()){
            return "kichThuoc/index";
        }
        kichThuocService.save(kichThuoc);
        return "redirect:/kichThuoc/list";
    }

    @PostMapping("/search")
    public String searchKichThuoc(@RequestParam("id") int id, Model model){
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            Pageable pageable = PageRequest.of(0, 4);
            model.addAttribute("kichThuoc", new KichThuoc()); // Thêm một đối tượng KichThuoc mới để binding với form
            System.out.println("da serch");
            model.addAttribute("listKT", kichThuocService.searchAllById(id, pageable));
            System.out.println("da serch");
            return "kichThuoc/index";
        } catch (Exception e) {
            return "redirect:/kichThuoc/list";
        }
    }

    @GetMapping("/chiTiet")
    public String chiTietKichThuoc(@RequestParam("id") int id, Model model){
        KichThuoc kichThuoc = kichThuocService.findById(id).get();
        model.addAttribute("kichThuoc", kichThuoc);
        return "kichThuoc/chiTiet";
    }

    @PostMapping("/update")
    public String updateKichThuoc(@Valid @ModelAttribute("kichThuoc") KichThuoc kichThuoc, BindingResult result){
        if (result.hasErrors()){
            return "kichThuoc/chiTiet";
        }
        kichThuocService.save(kichThuoc);
        return "redirect:/kichThuoc/list";
    }
}
