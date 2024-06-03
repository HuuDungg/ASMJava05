package com.huudung.lewlew.examforlab.service;

import com.huudung.lewlew.examforlab.entity.NhanVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NhanVienService {
    List<NhanVien> listNhanVien = new ArrayList<>();



    public List<NhanVien> getAllNhanVien(){
        return listNhanVien;
    }

    public void deleteNhanVien(int id){
        for (NhanVien nv: listNhanVien){
            if (nv.getId() == id){
                listNhanVien.remove(nv);
                break;
            }
        }
    }

    public void themNhanVien(NhanVien nhanVien){
        listNhanVien.add(nhanVien);
    }

    public NhanVien updateNhanVien(int id, NhanVien nhanVien){
        for (NhanVien nv: listNhanVien){
            if (nv.getId() == id){
                nv.setTen(nhanVien.getTen());
                nv.setMaNV(nhanVien.getMaNV());
                nv.setTenDangNhap(nhanVien.getTenDangNhap());
                nv.setMatKhau(nhanVien.getMatKhau());
                nv.setTrangThai(nhanVien.isTrangThai());
                break;
            }
        }
        return nhanVien;
    }

    public NhanVien getNhanVien(int id){
        for (NhanVien nv: listNhanVien){
            if (nv.getId() == id){
                return nv;
            }
        }
        return null;
    }
}
