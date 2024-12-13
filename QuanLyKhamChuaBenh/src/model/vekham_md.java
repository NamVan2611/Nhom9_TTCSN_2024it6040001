/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class vekham_md {
    private String mave,mdd,maphongkhambenh,sothutuxephang,manhanvien,vandesuckhoe,vandebhyt;

    public String getMaphongkhambenh() {
        return maphongkhambenh;
    }

    public void setMaphongkhambenh(String maphongkhambenh) {
        this.maphongkhambenh = maphongkhambenh;
    }

    public vekham_md(String mave, String mdd, String maphongkhambenh, String sothutuxephang, String manhanvien, String vandesuckhoe, String vandebhyt) {
        this.mave = mave;
        this.mdd = mdd;
        this.maphongkhambenh = maphongkhambenh;
        this.sothutuxephang = sothutuxephang;
        this.manhanvien = manhanvien;
        this.vandesuckhoe = vandesuckhoe;
        this.vandebhyt = vandebhyt;
    }
   public vekham_md() {
        
    }
    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public String getMdd() {
        return mdd;
    }

    public void setMdd(String mdd) {
        this.mdd = mdd;
    }

  

    public String getSothutuxephang() {
        return sothutuxephang;
    }

    public void setSothutuxephang(String sothutuxephang) {
        this.sothutuxephang = sothutuxephang;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getVandesuckhoe() {
        return vandesuckhoe;
    }

    public void setVandesuckhoe(String vandesuckhoe) {
        this.vandesuckhoe = vandesuckhoe;
    }

    public String getVandebhyt() {
        return vandebhyt;
    }

    public void setVandebhyt(String vandebhyt) {
        this.vandebhyt = vandebhyt;
    }
}
