package com.huudung.lewlew.examforlab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MauSac")
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Mã không được để trống")
    @Column(nullable = false)
    private String ma;

    @NotBlank(message = "Tên không được để trống")
    @Column(nullable = false)
    private String ten;

    @Column(nullable = false)
    private boolean trangThai;
}
