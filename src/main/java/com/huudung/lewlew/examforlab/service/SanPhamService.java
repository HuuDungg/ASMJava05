package com.huudung.lewlew.examforlab.service;

import com.huudung.lewlew.examforlab.entity.SanPham;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SanPhamService {
    List<SanPham> listSanPham = new ArrayList<>();

    public SanPhamService() {
        listSanPham.add(new SanPham(1, "sp1", "bread", true));
        listSanPham.add(new SanPham(2, "sp2", "bread", true));
        listSanPham.add(new SanPham(3, "sp3", "bread", false));
        listSanPham.add(new SanPham(4, "sp4", "bread", true));
        listSanPham.add(new SanPham(5, "sp5", "bread", true));

    }

    public List<SanPham> getAllSanPham(){
        return listSanPham;
    }

    public void deleteSanPham(int id){
        for (SanPham sp: listSanPham){
            if (sp.getId() == id){
                listSanPham.remove(sp);
                break;
            }
        }
    }

    public void themSanPham(SanPham sanPham){
        listSanPham.add(sanPham);
    }

    public SanPham updateSanPham(int id, SanPham sanPham){
        for (SanPham sp: listSanPham){
            if (sp.getId() == id){
                sp.setMa(sanPham.getMa());
                sp.setTen(sanPham.getTen());
                sp.setTrangThai(sanPham.isTrangThai());
                break;
            }
        }
        return sanPham;
    }

    public SanPham getSanPham(int id){
        for (SanPham sp: listSanPham){
            if (sp.getId() == id){
                return sp;
            }
        }
        return null;
    }
}
