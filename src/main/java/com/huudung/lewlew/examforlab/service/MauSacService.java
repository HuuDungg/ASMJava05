package com.huudung.lewlew.examforlab.service;

import com.huudung.lewlew.examforlab.entity.MauSac;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MauSacService {
    List<MauSac> listMauSac = new ArrayList<>();

    public MauSacService() {
        listMauSac.add(new MauSac(1, "ms1", "Red", true));
        listMauSac.add(new MauSac(2, "ms2", "Blue", true));
        listMauSac.add(new MauSac(3, "ms3", "Green", false));
        listMauSac.add(new MauSac(4, "ms4", "Yellow", true));
        listMauSac.add(new MauSac(5, "ms5", "Black", true));
    }

    public List<MauSac> getAllMauSac(){
        return listMauSac;
    }

    public void deleteMauSac(int id){
        for (MauSac ms: listMauSac){
            if (ms.getId() == id){
                listMauSac.remove(ms);
                break;
            }
        }
    }

    public void themMauSac(MauSac mauSac){
        listMauSac.add(mauSac);
    }

    public MauSac updateMauSac(int id, MauSac mauSac){
        for (MauSac ms: listMauSac){
            if (ms.getId() == id){
                ms.setMa(mauSac.getMa());
                ms.setTen(mauSac.getTen());
                ms.setTrangThai(mauSac.isTrangThai());
                break;
            }
        }
        return mauSac;
    }

    public MauSac getMauSac(int id){
        for (MauSac ms: listMauSac){
            if (ms.getId() == id){
                return ms;
            }
        }
        return null;
    }
}
