package org.sola.services.boundary.transferobjects.search;

import java.util.Date;
import org.sola.services.common.contracts.AbstractTO;

public class CadastreObjectSearchParamsTO extends AbstractTO {

    private String vdcCode;
    private String mapSheetCode;
    private String parcelNo;
    private String wardNo;    
    private Date fromDate;
    private Date toDate;

    public CadastreObjectSearchParamsTO() {
        super();
    }

    public String getVdcCode() {
        return vdcCode;
    }

    public void setVdcCode(String vdcCode) {
        this.vdcCode = vdcCode;
    }

    public String getParcelNo() {
        return parcelNo;
    }

    public void setParcelNo(String parcelNo) {
        this.parcelNo = parcelNo;
    }

    public String getWardNo() {
        return wardNo;
    }

    public void setWardNo(String wardNo) {
        this.wardNo = wardNo;
    }

    public String getMapSheetCode() {
        return mapSheetCode;
    }

    public void setMapSheetCode(String mapSheetCode) {
        this.mapSheetCode = mapSheetCode;
    }
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
