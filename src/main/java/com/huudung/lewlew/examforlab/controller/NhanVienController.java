package com.huudung.lewlew.examforlab.controller;

import com.huudung.lewlew.examforlab.entity.NhanVien;
import com.huudung.lewlew.examforlab.repositories.NhanVienRepository;
import com.huudung.lewlew.examforlab.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/nhanVien")
public class NhanVienController {

    @Autowired
    private NhanVienRepository nhanVienService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(name = "page", defaultValue = "0") int page){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, 4);

        model.addAttribute("listNV", nhanVienService.findAll(pageable));
        model.addAttribute("nhanVien", new NhanVien()); // Thêm một đối tượng NhanVien mới để binding với form
        return "nhanVien/index";
    }

    @GetMapping("/xoa")
    public String xoaNhanVien(@RequestParam("id") int id, Model model){
        nhanVienService.deleteById(id);
        return "redirect:/nhanVien/list";
    }

    @PostMapping("/them")
    public String themNhanVien(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien, BindingResult result){
        if (result.hasErrors()){
            return "nhanVien/index";
        }
        String password = passwordEncoder.encode(nhanVien.getPassword());
        nhanVien.setMatKhau(password);
        nhanVien.setRole("user");
        nhanVienService.save(nhanVien);
        return "redirect:/nhanVien/list";
    }

    @PostMapping("/search")
    public String searchNhanVien(@RequestParam("id") int id, Model model){
        try {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            Pageable pageable = PageRequest.of(0, 4);
            model.addAttribute("nhanVien", new NhanVien()); // Thêm một đối tượng NhanVien mới để binding với form
            model.addAttribute("listNV", nhanVienService.searchAllById(id, pageable));
            return "nhanVien/index";
        } catch (Exception e) {
            return "redirect:/nhanVien/list";
        }
    }

    @GetMapping("/chiTiet")
    public String chiTietNhanVien(@RequestParam("id") int id, Model model){
        NhanVien nhanVien = nhanVienService.findById(id).get();
        model.addAttribute("nhanVien", nhanVien);
        return "nhanVien/chiTiet";
    }

    @PostMapping("/update")
    public String updateNhanVien(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien, BindingResult result){
        if (result.hasErrors()){
            return "nhanVien/chiTiet";
        }
        nhanVienService.save(nhanVien);
        return "redirect:/nhanVien/list";
    }
}
