/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.administrative;


import org.sola.services.boundary.transferobjects.system.VdcTO;
import org.sola.services.common.contracts.AbstractIdTO;

/**
 *
 * @author KumarKhadka
 */
public class MothTO extends AbstractIdTO{
    
    private String mothlujNumber;
    private String vdcCode;
    private int wardNo;
    private String mothLuj;
    private int financialYear;
    private int lmocd;
    private VdcTO vdc;

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

    public VdcTO getVdc() {
        return vdc;
    }

    public void setVdc(VdcTO vdc) {
        this.vdc = vdc;
    }

    public String getVdcCode() {
        return vdcCode;
    }

    public void setVdcCode(String vdcCode) {
        this.vdcCode = vdcCode;
    }

    public int getWardNo() {
        return wardNo;
    }

    public void setWardNo(int wardNo) {
        this.wardNo = wardNo;
    }
    
    
}
