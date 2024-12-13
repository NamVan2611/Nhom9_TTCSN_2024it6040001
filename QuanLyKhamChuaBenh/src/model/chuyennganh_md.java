/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class chuyennganh_md {
  private String machuyennganh,tenchuyennganh,mota;  

    public chuyennganh_md(String machuyennganh, String tenchuyennganh, String mota) {
        this.machuyennganh = machuyennganh;
        this.tenchuyennganh = tenchuyennganh;
        this.mota = mota;
    }
   public chuyennganh_md() {
     
    }
    public String getMachuyennganh() {
        return machuyennganh;
    }

    public void setMachuyennganh(String machuyennganh) {
        this.machuyennganh = machuyennganh;
    }

    public String getTenchuyennganh() {
        return tenchuyennganh;
    }

    public void setTenchuyennganh(String tenchuyennganh) {
        this.tenchuyennganh = tenchuyennganh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
