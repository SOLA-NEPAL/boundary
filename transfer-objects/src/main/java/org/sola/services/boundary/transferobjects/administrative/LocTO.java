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
public class LocTO extends AbstractIdTO {

    private String mothId;
    private int panaNo;
    private int tmpPanaNo;
    private int propertyType;
    private int oshpType;
    private List<BaUnitTO> baUnits;
    private String officeCode;
    private String statusCode;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMothId() {
        return mothId;
    }

    public void setMothId(String mothId) {
        this.mothId = mothId;
    }

    public int getPanaNo() {
        return panaNo;
    }

    public void setPanaNo(int panaNo) {
        this.panaNo = panaNo;
    }

    public int getTmpPanaNo() {
        return tmpPanaNo;
    }

    public void setTmpPanaNo(int tmpPanaNo) {
        this.tmpPanaNo = tmpPanaNo;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }
}
