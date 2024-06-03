package com.huudung.lewlew.examforlab.controller;

import com.huudung.lewlew.examforlab.entity.MauSac;
import com.huudung.lewlew.examforlab.repositories.MauSacRepository;
import com.huudung.lewlew.examforlab.service.MauSacService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mauSac")
public class MauSacController {

    @Autowired
    private MauSacRepository mauSacService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(name = "page", defaultValue = "0") int page){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, 4);

        model.addAttribute("listMS", mauSacService.findAll(pageable));

        model.addAttribute("mauSac", new MauSac()); // Thêm một đối tượng MauSac mới để binding với form
        return "mauSac/index";
    }

    @GetMapping("/xoa")
    public String xoaMauSac(@RequestParam("id") int id, Model model){
        mauSacService.deleteById(id);
        return "redirect:/mauSac/list";
    }

    @PostMapping("/them")
    public String themMauSac(@Valid @ModelAttribute("mauSac") MauSac mauSac, BindingResult result){
        if (result.hasErrors()){
            return "mauSac/index";
        }
        mauSacService.save(mauSac);
        return "redirect:/mauSac/list";
    }

    @PostMapping("/search")
    public String searchMauSac(@RequestParam("id") int id, Model model){
        try {
            model.addAttribute("mauSac", new MauSac());
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            Pageable pageable = PageRequest.of(0, 4);
            model.addAttribute("listMS", mauSacService.searchAllById(id, pageable));
            return "mauSac/index";
        } catch (Exception e) {
            return "redirect:/mauSac/list";
        }
    }

    @GetMapping("/chiTiet")
    public String chiTietMauSac(@RequestParam("id") int id, Model model){
        MauSac mauSac = mauSacService.findById(id).get();
        model.addAttribute("mauSac", mauSac);
        return "mauSac/chiTiet";
    }

    @PostMapping("/update")
    public String updateMauSac(@Valid @ModelAttribute("mauSac") MauSac mauSac, BindingResult result){
        if (result.hasErrors()){
            return "mauSac/chiTiet";
        }
        mauSacService.save( mauSac);
        return "redirect:/mauSac/list";
    }
}
