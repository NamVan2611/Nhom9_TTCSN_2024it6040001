/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class truso_md {
   private String matruso,tentruso,diachi,sdt; 

    public String getMatruso() {
        return matruso;
    }

    public void setMatruso(String matruso) {
        this.matruso = matruso;
    }

    public String getTentruso() {
        return tentruso;
    }

    public void setTentruso(String tentruso) {
        this.tentruso = tentruso;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
  public truso_md() {
       
    }
    public truso_md(String matruso, String tentruso, String diachi, String sdt) {
        this.matruso = matruso;
        this.tentruso = tentruso;
        this.diachi = diachi;
        this.sdt = sdt;
    }
}
