package org.sola.services.boundary.transferobjects.administrative;

import java.util.Date;
import org.sola.services.boundary.transferobjects.referencedata.VdcTO;
import org.sola.services.common.contracts.AbstractIdTO;

public class MothBasicTO extends AbstractIdTO {

    private String mothlujNumber;
    private String vdcCode;
    private String mothLuj;
    private Date creationDate;
    private VdcTO vdc;
    private String officeCode;

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
}
