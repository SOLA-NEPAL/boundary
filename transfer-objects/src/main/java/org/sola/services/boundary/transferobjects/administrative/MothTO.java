/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.administrative;

import java.util.List;
import org.sola.services.boundary.transferobjects.referencedata.VdcTO;
import org.sola.services.common.contracts.AbstractIdTO;

/**
 *
 * @author KumarKhadka
 */
public class MothTO extends AbstractIdTO {

    private String mothlujNumber;
    private String vdcCode;
    private String mothLuj;
    private String financialYear;
    private List<LocTO> locList;
    private VdcTO vdc;
    private String officeCode;
    private String statusCode;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(String financialYear) {
        this.financialYear = financialYear;
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

    public List<LocTO> getLocList() {
        return locList;
    }

    public void setLocList(List<LocTO> locList) {
        this.locList = locList;
    }
}
