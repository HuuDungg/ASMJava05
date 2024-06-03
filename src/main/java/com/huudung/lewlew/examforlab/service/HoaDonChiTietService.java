package com.huudung.lewlew.examforlab.service;

import com.huudung.lewlew.examforlab.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HoaDonChiTietService {
    List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();

    public HoaDonChiTietService() {
        HoaDon hoaDon1 = new HoaDon(1, new NhanVien(), new KhachHang(), "2023-05-01", true);
        SPChiTiet spChiTiet1 = new SPChiTiet(1, "SPCT01", new KichThuoc(), new MauSac(), new SanPham(), 10, 2000.0, true);
        listHoaDonChiTiet.add(new HoaDonChiTiet(1, hoaDon1, spChiTiet1, 2, 2000.0, true));

        HoaDon hoaDon2 = new HoaDon(2, new NhanVien(), new KhachHang(), "2023-05-02", true);
        SPChiTiet spChiTiet2 = new SPChiTiet(2, "SPCT02", new KichThuoc(), new MauSac(), new SanPham(), 20, 3000.0, true);
        listHoaDonChiTiet.add(new HoaDonChiTiet(2, hoaDon2, spChiTiet2, 3, 3000.0, true));

        HoaDon hoaDon3 = new HoaDon(3, new NhanVien(), new KhachHang(), "2023-05-03", false);
        SPChiTiet spChiTiet3 = new SPChiTiet(3, "SPCT03", new KichThuoc(), new MauSac(), new SanPham(), 30, 4000.0, false);
        listHoaDonChiTiet.add(new HoaDonChiTiet(3, hoaDon3, spChiTiet3, 4, 4000.0, false));
    }

    public List<HoaDonChiTiet> getAllHoaDonChiTiet(){
        return listHoaDonChiTiet;
    }
    public List<HoaDonChiTiet> getHoaDonChiTietByIdHoaDon(int id){
        List<HoaDonChiTiet> listByHDID = new ArrayList<>();
        for (HoaDonChiTiet hdct : listHoaDonChiTiet){
            if (hdct.getHoaDon().getId() == id){
                listByHDID.add(hdct);
            }
        }
        return  listByHDID;
    }

    public void deleteHoaDonChiTiet(int id){
        listHoaDonChiTiet.removeIf(hdct -> hdct.getId() == id);
    }

    public void deleteHDCTByIdSPCT(int id, int idSPCT){
        for (HoaDonChiTiet hdct: listHoaDonChiTiet){
            if(hdct.getId() == id && hdct.getSpChiTiet().getId() == idSPCT){
                listHoaDonChiTiet.remove(hdct);
                break;
            }
        }
    }

    public void themHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet){
        listHoaDonChiTiet.add(hoaDonChiTiet);
    }

    public HoaDonChiTiet updateHoaDonChiTiet(int id, HoaDonChiTiet hoaDonChiTiet){
        for (HoaDonChiTiet hdct : listHoaDonChiTiet){
            if (hdct.getId() == id){
                hdct.setHoaDon(hoaDonChiTiet.getHoaDon());
                hdct.setSpChiTiet(hoaDonChiTiet.getSpChiTiet());
                hdct.setSoLuong(hoaDonChiTiet.getSoLuong());
                hdct.setDonGia(hoaDonChiTiet.getDonGia());
                hdct.setTrangThai(hoaDonChiTiet.isTrangThai());
                return hdct;
            }
        }
        return null;
    }

    public HoaDonChiTiet getHoaDonChiTiet(int id){
        for (HoaDonChiTiet hdct : listHoaDonChiTiet){
            if (hdct.getId() == id){
                return hdct;
            }
        }
        return null;
    }

    public int getTotalPriceByIdHoaDon(int id){
        int totalPrice = 0;
        for (HoaDonChiTiet hdct : listHoaDonChiTiet){
            if (hdct.getHoaDon().getId() == id){
                totalPrice += (hdct.getSoLuong()*hdct.getDonGia());
            }
        }

        return totalPrice;
    }
}
