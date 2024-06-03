package com.huudung.lewlew.examforlab.repositories;

import com.huudung.lewlew.examforlab.entity.MauSac;
import com.huudung.lewlew.examforlab.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    NhanVien findByTenDangNhap(String tenDangNhap);
    Page<NhanVien> searchAllById(int id, Pageable pageable);
}
