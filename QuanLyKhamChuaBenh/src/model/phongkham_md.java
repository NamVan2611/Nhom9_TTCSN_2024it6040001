/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.chuyennganh_md;
public class phongkham_md {
    private String maphong,machuyennganh,diachiphongkham,tenphongkham;
    private chuyennganh_md chuyennganh;

    public phongkham_md(String maphong, String machuyennganh, String diachiphongkham, String tenphongkham) {
        this.maphong = maphong;
        this.machuyennganh = machuyennganh;
        this.diachiphongkham = diachiphongkham;
        this.tenphongkham = tenphongkham;
    }
    public phongkham_md() {
      
    }
    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getMachuyennganh() {
        return machuyennganh;
    }

    public void setMachuyennganh(String machuyennganh) {
        this.machuyennganh = machuyennganh;
    }

    public String getDiachiphongkham() {
        return diachiphongkham;
    }

    public void setDiachiphongkham(String diachiphongkham) {
        this.diachiphongkham = diachiphongkham;
    }

    public String getTenphongkham() {
        return tenphongkham;
    }

    public void setTenphongkham(String tenphongkham) {
        this.tenphongkham = tenphongkham;
    }

    public chuyennganh_md getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(chuyennganh_md chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    
}
