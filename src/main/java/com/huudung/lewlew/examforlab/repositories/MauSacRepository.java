package com.huudung.lewlew.examforlab.repositories;

import com.huudung.lewlew.examforlab.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Integer> {
    Page<MauSac> searchAllById(int id, Pageable pageable);
}
