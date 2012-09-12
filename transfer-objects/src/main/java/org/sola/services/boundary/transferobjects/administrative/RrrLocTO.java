package org.sola.services.boundary.transferobjects.administrative;

import java.util.List;
import org.sola.services.boundary.transferobjects.casemanagement.PartySummaryTO;
import org.sola.services.common.contracts.AbstractTO;

public class RrrLocTO extends AbstractTO {
    private String locId;
    private String typeCode;
    private String ownerTypeCode;
    private String ownershipTypeCode;
    private String statusCode;
    private List<PartySummaryTO> rightHolderList;
    
    public RrrLocTO(){
        super();
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

    public List<PartySummaryTO> getRightHolderList() {
        return rightHolderList;
    }

    public void setRightHolderList(List<PartySummaryTO> rightHolderList) {
        this.rightHolderList = rightHolderList;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getOwnerTypeCode() {
        return ownerTypeCode;
    }

    public void setOwnerTypeCode(String ownerTypeCode) {
        this.ownerTypeCode = ownerTypeCode;
    }

    public String getOwnershipTypeCode() {
        return ownershipTypeCode;
    }

    public void setOwnershipTypeCode(String ownershipTypeCode) {
        this.ownershipTypeCode = ownershipTypeCode;
    }
}
