/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class nhanvien_md {
 private String manv,tennv,tenbophantructhuoc;


    public nhanvien_md(String manv, String tennv, String tenbophantructhuoc) {
        this.manv = manv;
        this.tennv = tennv;
        this.tenbophantructhuoc = tenbophantructhuoc;
       
    }
        public nhanvien_md() {
  
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getTenbophantructhuoc() {
        return tenbophantructhuoc;
    }

    public void setTenbophantructhuoc(String tenbophantructhuoc) {
        this.tenbophantructhuoc = tenbophantructhuoc;
    }

        
}
