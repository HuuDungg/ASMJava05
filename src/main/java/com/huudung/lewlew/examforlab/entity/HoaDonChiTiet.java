package com.huudung.lewlew.examforlab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Hóa đơn không được để trống")
    @ManyToOne
    @JoinColumn(name = "idHoaDon", nullable = false)
    private HoaDon hoaDon;

    @NotNull(message = "Sản phẩm chi tiết không được để trống")
    @ManyToOne
    @JoinColumn(name = "idSPCT", nullable = false)
    private SPChiTiet spChiTiet;

    @NotNull(message = "Số lượng không được để trống")
    @Column(nullable = false)
    private int soLuong;

    @NotNull(message = "Đơn giá không được để trống")
    @Column(nullable = false)
    private double donGia;

    @Column(nullable = false)
    private boolean trangThai;
}
