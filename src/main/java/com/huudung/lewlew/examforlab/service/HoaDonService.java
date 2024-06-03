package com.huudung.lewlew.examforlab.service;

import com.huudung.lewlew.examforlab.entity.HoaDon;
import com.huudung.lewlew.examforlab.entity.KhachHang;
import com.huudung.lewlew.examforlab.entity.NhanVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HoaDonService {
    List<HoaDon> listHoaDon = new ArrayList<>();


    public List<HoaDon> getAllHoaDon(){
        return listHoaDon;
    }

    public void deleteHoaDon(int id){
        listHoaDon.removeIf(hd -> hd.getId() == id);
    }

    public void themHoaDon(HoaDon hoaDon){
        listHoaDon.add(hoaDon);
    }

    public HoaDon updateHoaDon(int id, HoaDon hoaDon){
        for (HoaDon hd : listHoaDon){
            if (hd.getId() == id){
                hd.setNhanVien(hoaDon.getNhanVien());
                hd.setKhachHang(hoaDon.getKhachHang());
                hd.setNgayMuaHang(hoaDon.getNgayMuaHang());
                hd.setTrangThai(hoaDon.isTrangThai());
                return hd;
            }
        }
        return null;
    }

    public HoaDon getHoaDon(int id){
        for (HoaDon hd : listHoaDon){
            if (hd.getId() == id){
                return hd;
            }
        }
        return null;
    }
}
