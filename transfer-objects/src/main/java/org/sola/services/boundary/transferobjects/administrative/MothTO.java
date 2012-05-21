/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.administrative;

import org.sola.services.common.contracts.AbstractIdTO;

/**
 *
 * @author KumarKhadka
 */
public class MothTO extends AbstractIdTO{

    private int mothSid;
    private String mothlujNumber;
    private int vdcSid;
    private int wardNo;
    private String mothLuj;
    private int financialYear;
    private int lmocd;

    public int getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(int financialYear) {
        this.financialYear = financialYear;
    }

    public int getLmocd() {
        return lmocd;
    }

    public void setLmocd(int lmocd) {
        this.lmocd = lmocd;
    }

    public String getMothLuj() {
        return mothLuj;
    }

    public void setMothLuj(String mothLuj) {
        this.mothLuj = mothLuj;
    }   

    public String getMothlujNumber() {
        return mothlujNumber;
    }

    public void setMothlujNumber(String mothlujNumber) {
        this.mothlujNumber = mothlujNumber;
    }

    public int getVdcSid() {
        return vdcSid;
    }

    public void setVdcSid(int vdcSid) {
        this.vdcSid = vdcSid;
    }

    public int getWardNo() {
        return wardNo;
    }

    public void setWardNo(int wardNo) {
        this.wardNo = wardNo;
    }
    
    
}
