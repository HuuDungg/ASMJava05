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
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Tên không được để trống")
    @Column(nullable = false)
    private String ten;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Column(nullable = false)
    private String sdt;

    @NotBlank(message = "Mã khách hàng không được để trống")
    @Column(nullable = false)
    private String maKH;

    @Column(nullable = false)
    private boolean trangThai;
}
