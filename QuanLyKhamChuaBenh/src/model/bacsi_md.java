
package model;
import model.capbac_md;
import model.chuyennganh_md;
import model.phongkhambenh_md;
public class bacsi_md {
    private String mabacsi,maphongkhambenh,machuyennganh,hoten,sdt,diachi,macapbac;
private chuyennganh_md chuyennganh;
private phongkhambenh_md phongkhambenh;
private capbac_md capbac;
    public chuyennganh_md getChuyennganh() {
        return chuyennganh;
    }

    public capbac_md getCapbac() {
        return capbac;
    }

    public String getMacapbac() {
        return macapbac;
    }

    public void setMacapbac(String macapbac) {
        this.macapbac = macapbac;
    }

    public void setCapbac(capbac_md capbac) {
        this.capbac = capbac;
    }

    public void setChuyennganh(chuyennganh_md chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    public phongkhambenh_md getPhongkhambenh() {
        return phongkhambenh;
    }

    public void setPhongkhambenh(phongkhambenh_md phongkhambenh) {
        this.phongkhambenh = phongkhambenh;
    }

    public bacsi_md(String mabacsi, String maphongkhambenh, String machuyennganh, String hoten, String sdt, String diachi,  String macapbac) {
        this.mabacsi = mabacsi;
        this.maphongkhambenh = maphongkhambenh;
        this.machuyennganh = machuyennganh;
        this.macapbac = macapbac;
        this.hoten = hoten;
        this.sdt = sdt;
        this.diachi = diachi;
      
    }


  
     public bacsi_md() {
     
    }

    public String getMabacsi() {
        return mabacsi;
    }

    public void setMabacsi(String mabacsi) {
        this.mabacsi = mabacsi;
    }

    public String getMaphongkhambenh() {
        return maphongkhambenh;
    }

    public void setMaphongkhambenh(String maphongkhambenh) {
        this.maphongkhambenh = maphongkhambenh;
    }

    public String getMachuyennganh() {
        return machuyennganh;
    }

    public void setMachuyennganh(String machuyennganh) {
        this.machuyennganh = machuyennganh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

  
}
