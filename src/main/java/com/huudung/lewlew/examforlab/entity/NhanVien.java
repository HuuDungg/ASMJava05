package com.huudung.lewlew.examforlab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Tên không được để trống")
    @Column(nullable = false)
    private String ten;

    @NotBlank(message = "Mã nhân viên không được để trống")
    @Column(nullable = false)
    private String maNV;

    @NotBlank(message = "Tên đăng nhập không được để trống")
    @Column(nullable = false)
    private String tenDangNhap;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Column(nullable = false)
    private String matKhau;

    @Column(nullable = false)
    private boolean trangThai;

    @Column(nullable = false)
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List< GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }

    @Override
    public String getPassword() {
        return matKhau;
    }
    @Override
    public String getUsername() {
        return tenDangNhap;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
