/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class ketquakhambenh_md {
    private String mave,mabacsi,ketquakhambenh,ngaykham;

    public ketquakhambenh_md(String mave, String mabacsi, String ketquakhambenh, String ngaykham) {
        this.mave = mave;
        this.mabacsi = mabacsi;
        this.ketquakhambenh = ketquakhambenh;
        this.ngaykham = ngaykham;
    }
 public ketquakhambenh_md() {
    
    }
    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public String getMabacsi() {
        return mabacsi;
    }

    public void setMabacsi(String mabacsi) {
        this.mabacsi = mabacsi;
    }

    public String getKetquakhambenh() {
        return ketquakhambenh;
    }

    public void setKetquakhambenh(String ketquakhambenh) {
        this.ketquakhambenh = ketquakhambenh;
    }

    public String getNgaykham() {
        return ngaykham;
    }

    public void setNgaykham(String ngaykham) {
        this.ngaykham = ngaykham;
    }
}
