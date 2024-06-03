package com.huudung.lewlew.examforlab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Nhân viên không được để trống")
    @ManyToOne
    @JoinColumn(name = "idNhanVien", nullable = false)
    private NhanVien nhanVien;

    @NotNull(message = "Khách hàng không được để trống")
    @ManyToOne
    @JoinColumn(name = "idKhachHang", nullable = false)
    private KhachHang khachHang;

    @NotBlank(message = "Ngày mua hàng không được để trống")
    @Column(nullable = false)
    private String ngayMuaHang;

    @Column(nullable = false)
    private boolean trangThai;
}
