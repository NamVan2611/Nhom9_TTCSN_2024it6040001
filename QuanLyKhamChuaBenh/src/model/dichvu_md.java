
package model;
import model.phongkhambenh_md;

public class dichvu_md {
   private String madv,tendv,maphongkhambenh;
   private Float dongia;
private phongkhambenh_md phongkhambenh;

    public phongkhambenh_md getPhongkhambenh() {
        return phongkhambenh;
    }

    public void setPhongkhambenh(phongkhambenh_md phongkhambenh) {
        this.phongkhambenh = phongkhambenh;
    }
    public dichvu_md(String madv, String tendv, String maphongkhambenh, Float dongia) {
        this.madv = madv;
        this.tendv = tendv;
        this.maphongkhambenh = maphongkhambenh;
        this.dongia = dongia;
    }
   public dichvu_md() {
    
    }
    public String getMadv() {
        return madv;
    }

    public void setMadv(String madv) {
        this.madv = madv;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public String getMaphongkhambenh() {
        return maphongkhambenh;
    }

    public void setMaphongkhambenh(String maphongkhambenh) {
        this.maphongkhambenh = maphongkhambenh;
    }

    public Float getDongia() {
        return dongia;
    }

    public void setDongia(Float dongia) {
        this.dongia = dongia;
    }
}
