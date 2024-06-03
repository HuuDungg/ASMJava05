package com.huudung.lewlew.examforlab.repositories;

import com.huudung.lewlew.examforlab.entity.HoaDon;
import com.huudung.lewlew.examforlab.entity.HoaDonChiTiet;
import com.huudung.lewlew.examforlab.entity.MauSac;
import com.huudung.lewlew.examforlab.entity.SPChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {
    public List<HoaDonChiTiet> findByHoaDon(HoaDon hoaDon);

    @Transactional
    void deleteByHoaDonAndSpChiTiet(HoaDon hoaDon, SPChiTiet spChiTiet);

    Page<HoaDonChiTiet> searchAllById(int id, Pageable pageable);
}
