/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.benhnhan_md;
import model.dichvu_md;
import model.vekham_md;
import model.nhanvien_md;
import model.ketquakhambenh_md;

public class hoadonkhambenh_md {

    private String mahoadon, mave, madichvu;
    private int soluongdichvu;
    private String manhanvien;
    private dichvu_md dichvu;
    private nhanvien_md nhanvien;
    private benhnhan_md benhnhan;
    private vekham_md vekham;

    public vekham_md getVekham() {
        return vekham;
    }

    public void setVekham(vekham_md vekham) {
        this.vekham = vekham;
    }
    private ketquakhambenh_md ketquakhambenh;

    public ketquakhambenh_md getKetquakhambenh() {
        return ketquakhambenh;
    }

    public void setKetquakhambenh(ketquakhambenh_md ketquakhambenh) {
        this.ketquakhambenh = ketquakhambenh;
    }

    public benhnhan_md getBenhnhan() {
        return benhnhan;
    }

    public void setBenhnhan(benhnhan_md benhnhan) {
        this.benhnhan = benhnhan;
    }

    public dichvu_md getDichvu() {
        return dichvu;
    }

    public void setDichvu(dichvu_md dichvu) {
        this.dichvu = dichvu;
    }

    public nhanvien_md getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(nhanvien_md nhanvien) {
        this.nhanvien = nhanvien;
    }

    public hoadonkhambenh_md(String mahoadon, String mave, String madichvu, int soluongdichvu, String manhanvien) {
        this.mahoadon = mahoadon;
        this.mave = mave;
        this.madichvu = madichvu;
        this.soluongdichvu = soluongdichvu;
        this.manhanvien = manhanvien;
    }

    public hoadonkhambenh_md() {

    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public String getMadichvu() {
        return madichvu;
    }

    public void setMadichvu(String madichvu) {
        this.madichvu = madichvu;
    }

    public int getSoluongdichvu() {
        return soluongdichvu;
    }

    public void setSoluongdichvu(int soluongdichvu) {
        this.soluongdichvu = soluongdichvu;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }
}
