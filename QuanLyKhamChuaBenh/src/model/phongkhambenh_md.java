/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.chuyennganh_md;
import model.phongkham_md;

public class phongkhambenh_md {
   private String maphongkhambenh,diachiphongkhambenh,tenphongkhambenh,machuyennganh; 
   private chuyennganh_md chuyennganh;


    public chuyennganh_md getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(chuyennganh_md chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    public phongkhambenh_md(String maphongkhambenh, String diachiphongkhambenh, String tenphongkhambenh, String machuyennganh) {
        this.maphongkhambenh = maphongkhambenh;
        this.diachiphongkhambenh = diachiphongkhambenh;
        this.tenphongkhambenh = tenphongkhambenh;
        this.machuyennganh = machuyennganh;
    }

    public String getMachuyennganh() {
        return machuyennganh;
    }

    public void setMachuyennganh(String machuyennganh) {
        this.machuyennganh = machuyennganh;
    }

  

  public phongkhambenh_md() {
     
    }
    public String getMaphongkhambenh() {
        return maphongkhambenh;
    }

    public void setMaphongkhambenh(String maphongkhambenh) {
        this.maphongkhambenh = maphongkhambenh;
    }


  
    public String getDiachiphongkhambenh() {
        return diachiphongkhambenh;
    }

    public void setDiachiphongkhambenh(String diachiphongkhambenh) {
        this.diachiphongkhambenh = diachiphongkhambenh;
    }

  
    public String getTenphongkhambenh() {
        return tenphongkhambenh;
    }

    public void setTenphongkhambenh(String tenphongkhambenh) {
        this.tenphongkhambenh = tenphongkhambenh;
    }

 
}
