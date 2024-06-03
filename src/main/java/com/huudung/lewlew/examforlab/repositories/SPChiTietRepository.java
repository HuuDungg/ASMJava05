package com.huudung.lewlew.examforlab.repositories;

import com.huudung.lewlew.examforlab.entity.MauSac;
import com.huudung.lewlew.examforlab.entity.SPChiTiet;
import com.huudung.lewlew.examforlab.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SPChiTietRepository extends JpaRepository<SPChiTiet, Integer> {
    List<SPChiTiet> findBySanPham(SanPham sanPham);
    Page<SPChiTiet> searchAllById(int id, Pageable pageable);
}
