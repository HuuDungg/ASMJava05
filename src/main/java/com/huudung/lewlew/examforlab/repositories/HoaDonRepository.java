package com.huudung.lewlew.examforlab.repositories;

import com.huudung.lewlew.examforlab.entity.HoaDon;
import com.huudung.lewlew.examforlab.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    Page<HoaDon> searchAllById(int id, Pageable pageable);
}
