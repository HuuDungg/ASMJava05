package com.huudung.lewlew.examforlab.service;

import com.huudung.lewlew.examforlab.entity.KichThuoc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class KichThuocService {
    List<KichThuoc> listKichThuoc = new ArrayList<>();

    public KichThuocService() {
        listKichThuoc.add(new KichThuoc(1, "kt1", "Small", true));
        listKichThuoc.add(new KichThuoc(2, "kt2", "Medium", true));
        listKichThuoc.add(new KichThuoc(3, "kt3", "Large", false));
        listKichThuoc.add(new KichThuoc(4, "kt4", "X-Large", true));
        listKichThuoc.add(new KichThuoc(5, "kt5", "XX-Large", true));
    }

    public List<KichThuoc> getAllKichThuoc(){
        return listKichThuoc;
    }

    public void deleteKichThuoc(int id){
        for (KichThuoc kt: listKichThuoc){
            if (kt.getId() == id){
                listKichThuoc.remove(kt);
                break;
            }
        }
    }

    public void themKichThuoc(KichThuoc kichThuoc){
        listKichThuoc.add(kichThuoc);
    }

    public KichThuoc updateKichThuoc(int id, KichThuoc kichThuoc){
        for (KichThuoc kt: listKichThuoc){
            if (kt.getId() == id){
                kt.setMa(kichThuoc.getMa());
                kt.setTen(kichThuoc.getTen());
                kt.setTrangThai(kichThuoc.isTrangThai());
                break;
            }
        }
        return kichThuoc;
    }

    public KichThuoc getKichThuoc(int id){
        for (KichThuoc kt: listKichThuoc){
            if (kt.getId() == id){
                return kt;
            }
        }
        return null;
    }
}
