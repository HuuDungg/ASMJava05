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
@Table(name = "SanPhamChiTiet")
public class SPChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Mã SPCT không được để trống")
    @Column(nullable = false)
    private String maSPCT;

    @NotNull(message = "Kích thước không được để trống")
    @ManyToOne
    @JoinColumn(name = "idKichThuoc", nullable = false)
    private KichThuoc kichThuoc;

    @NotNull(message = "Màu sắc không được để trống")
    @ManyToOne
    @JoinColumn(name = "idMauSac", nullable = false)
    private MauSac mauSac;

    @NotNull(message = "Sản phẩm không được để trống")
    @ManyToOne
    @JoinColumn(name = "idSanPham", nullable = false)
    private SanPham sanPham;

    @NotNull(message = "Số lượng không được để trống")
    @Column(nullable = false)
    private int soLuong;

    @NotNull(message = "Đơn giá không được để trống")
    @Column(nullable = false)
    private double donGia;

    @Column(nullable = false)
    private boolean trangThai;
}
