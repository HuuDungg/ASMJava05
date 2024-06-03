package com.huudung.lewlew.examforlab.service;

import com.huudung.lewlew.examforlab.entity.SPChiTiet;
import com.huudung.lewlew.examforlab.entity.KichThuoc;
import com.huudung.lewlew.examforlab.entity.MauSac;
import com.huudung.lewlew.examforlab.entity.SanPham;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SPChiTietService {
    List<SPChiTiet> listSPChiTiet = new ArrayList<>();

    public SPChiTietService() {
        KichThuoc kichThuoc1 = new KichThuoc(1, "KT01", "Size M", true);
        MauSac mauSac1 = new MauSac(1, "MS01", "Red", true);
        SanPham sanPham1 = new SanPham(1, "sp1", "bread", true);
        listSPChiTiet.add(new SPChiTiet(1, "SPCT01", kichThuoc1, mauSac1, sanPham1, 10, 2000.0, true));

        KichThuoc kichThuoc2 = new KichThuoc(2, "KT02", "Size L", true);
        MauSac mauSac2 = new MauSac(2, "MS02", "Blue", true);
        SanPham sanPham2 = new SanPham(2, "sp2", "bread", true);
        listSPChiTiet.add(new SPChiTiet(2, "SPCT02", kichThuoc2, mauSac2, sanPham2, 20, 3000.0, true));

        KichThuoc kichThuoc3 = new KichThuoc(3, "KT03", "Size XL", true);
        MauSac mauSac3 = new MauSac(3, "MS03", "Green", true);
        SanPham sanPham3 = new SanPham(3, "sp3", "bread", true);
        listSPChiTiet.add(new SPChiTiet(3, "SPCT03", kichThuoc3, mauSac3, sanPham3, 30, 4000.0, true));
    }

    public List<SPChiTiet> getAllSPChiTiet(){
        return listSPChiTiet;
    }

    public List<SPChiTiet> getALlSPCHiTietByIDSanPham(int id){
        List<SPChiTiet> listByIDSanPham = new ArrayList<>();
        for (SPChiTiet spChiTiet : listSPChiTiet){
            if (spChiTiet.getSanPham().getId() == id){
                listByIDSanPham.add(spChiTiet);
            }
        }
        return listByIDSanPham;
    }

    public void deleteSPChiTiet(int id){
        listSPChiTiet.removeIf(spct -> spct.getId() == id);
    }

    public void themSPChiTiet(SPChiTiet spChiTiet){
        listSPChiTiet.add(spChiTiet);
    }

    public SPChiTiet updateSPChiTiet(int id, SPChiTiet spChiTiet){
        for (SPChiTiet spct : listSPChiTiet){
            if (spct.getId() == id){
                spct.setMaSPCT(spChiTiet.getMaSPCT());
                spct.setKichThuoc(spChiTiet.getKichThuoc());
                spct.setMauSac(spChiTiet.getMauSac());
                spct.setSanPham(spChiTiet.getSanPham());
                spct.setSoLuong(spChiTiet.getSoLuong());
                spct.setDonGia(spChiTiet.getDonGia());
                spct.setTrangThai(spChiTiet.isTrangThai());
                return spct;
            }
        }
        return null;
    }

    public SPChiTiet getSPChiTiet(int id){
        for (SPChiTiet spct : listSPChiTiet){
            if (spct.getId() == id){
                return spct;
            }
        }
        return null;
    }
}
