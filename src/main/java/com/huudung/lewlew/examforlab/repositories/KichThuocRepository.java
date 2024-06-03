package com.huudung.lewlew.examforlab.repositories;

import com.huudung.lewlew.examforlab.entity.KichThuoc;
import com.huudung.lewlew.examforlab.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc, Integer> {
    Page<KichThuoc> searchAllById(int id, Pageable pageable);
}
