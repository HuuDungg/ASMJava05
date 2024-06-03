package com.huudung.lewlew.examforlab.service;

import com.huudung.lewlew.examforlab.entity.KhachHang;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class KhachHangService {
    List<KhachHang> listKhachHang = new ArrayList<>();

    public KhachHangService() {
        listKhachHang.add(new KhachHang(5, "Khách lẻ", "0905678901", "KH05", true));
        listKhachHang.add(new KhachHang(1, "Nguyen Van A", "0901234567", "KH01", true));
        listKhachHang.add(new KhachHang(2, "Tran Thi B", "0902345678", "KH02", true));
        listKhachHang.add(new KhachHang(3, "Le Van C", "0903456789", "KH03", false));
        listKhachHang.add(new KhachHang(4, "Pham Thi D", "0904567890", "KH04", true));

    }

    public List<KhachHang> getAllKhachHang(){
        return listKhachHang;
    }

    public void deleteKhachHang(int id){
        for (KhachHang kh: listKhachHang){
            if (kh.getId() == id){
                listKhachHang.remove(kh);
                break;
            }
        }
    }

    public void themKhachHang(KhachHang khachHang){
        listKhachHang.add(khachHang);
    }

    public KhachHang updateKhachHang(int id, KhachHang khachHang){
        for (KhachHang kh: listKhachHang){
            if (kh.getId() == id){
                kh.setTen(khachHang.getTen());
                kh.setSdt(khachHang.getSdt());
                kh.setMaKH(khachHang.getMaKH());
                kh.setTrangThai(khachHang.isTrangThai());
                break;
            }
        }
        return khachHang;
    }

    public KhachHang getKhachHang(int id){
        for (KhachHang kh: listKhachHang){
            if (kh.getId() == id){
                return kh;
            }
        }
        return null;
    }
}
