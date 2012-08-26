package org.sola.services.boundary.transferobjects.administrative;

import java.util.Date;
import java.util.List;
import org.sola.services.boundary.transferobjects.casemanagement.PartySummaryTO;
import org.sola.services.boundary.transferobjects.casemanagement.SourceTO;
import org.sola.services.common.contracts.AbstractTO;

public class RrrLocTO extends AbstractTO {
    private String locId;
    private String typeCode;
    private String ownerTypeCode;
    private String shareTypeCode;
    private Date registrationDate;
    private String statusCode;
    private String notationText;
    
    private List<SourceTO> sourceList;
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<PartySummaryTO> getRightHolderList() {
        return rightHolderList;
    }

    public void setRightHolderList(List<PartySummaryTO> rightHolderList) {
        this.rightHolderList = rightHolderList;
    }

    public List<SourceTO> getSourceList() {
        return sourceList;
    }

    public void setSourceList(List<SourceTO> sourceList) {
        this.sourceList = sourceList;
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

    public String getShareTypeCode() {
        return shareTypeCode;
    }

    public void setShareTypeCode(String shareTypeCode) {
        this.shareTypeCode = shareTypeCode;
    }

    public String getNotationText() {
        return notationText;
    }

    public void setNotationText(String notationText) {
        this.notationText = notationText;
    }
}