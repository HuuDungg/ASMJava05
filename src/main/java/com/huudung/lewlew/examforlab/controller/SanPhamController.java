package com.huudung.lewlew.examforlab.controller;

import com.huudung.lewlew.examforlab.entity.SanPham;
import com.huudung.lewlew.examforlab.repositories.SanPhamRepository;
import com.huudung.lewlew.examforlab.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/sanPham")
public class SanPhamController {

    @Autowired
    private SanPhamRepository sanPhamService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(name = "page", defaultValue = "0") int page){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, 4);
        model.addAttribute("listSP", sanPhamService.findAll(pageable));
        model.addAttribute("sanPham", new SanPham()); // Thêm một đối tượng SanPham mới để binding với form
        return "sanPham/index";
    }

    @GetMapping("/xoa")
    public String xoaSanPham(@RequestParam("id") int id, Model model){
        sanPhamService.deleteById(id);
        return "redirect:/sanPham/list";
    }

    @PostMapping("/them")
    public String themSanPham(@Valid @ModelAttribute("sanPham") SanPham sanPham, BindingResult result){
        if (result.hasErrors()){
            return "sanPham/index";
        }
        sanPhamService.save(sanPham);
        return "redirect:/sanPham/list";
    }

    @PostMapping("/search")
    public String searchSanPham( @RequestParam("id") int id, Model model){

        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            Pageable pageable = PageRequest.of(0, 4);
            model.addAttribute("sanPham", new SanPham()); // Thêm một đối tượng SanPham mới để binding với form
            model.addAttribute("listSP", sanPhamService.searchAllById(id, pageable));
            return "sanPham/index";
        }catch (Exception e){
            return "redirect:/sanPham/list";
        }
    }

    @GetMapping("/chiTiet")
    public String chiTietSanPham(@RequestParam("id") int id, Model model){
        SanPham sanPham = sanPhamService.findById(id).get();
        model.addAttribute("sanPham", sanPham);
        return "sanPham/chiTiet";
    }

    @PostMapping("/update")
    public String updateSanPham(@Valid @ModelAttribute("sanPham") SanPham sanPham, BindingResult result){
        if (result.hasErrors()){
            return "sanPham/chiTiet";
        }
        sanPhamService.save(sanPham);

        return "redirect:/sanPham/list";
    }
}
