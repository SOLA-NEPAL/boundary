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
    private String panaNo;
    private String tmpPanaNo;
    private String officeCode;

    public String getMothId() {
        return mothId;
    }

    public void setMothId(String mothId) {
        this.mothId = mothId;
    }

    public String getPanaNo() {
        return panaNo;
    }

    public void setPanaNo(String panaNo) {
        this.panaNo = panaNo;
    }

    public String getTmpPanaNo() {
        return tmpPanaNo;
    }

    public void setTmpPanaNo(String tmpPanaNo) {
        this.tmpPanaNo = tmpPanaNo;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }
}
