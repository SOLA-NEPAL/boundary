package org.sola.services.boundary.transferobjects.search;

import org.sola.services.common.contracts.AbstractBasicIdTO;

public class RestrictionRrrTO extends AbstractBasicIdTO {
    private String sn;
    private String regNumber;
    private Integer regDate;
    private String bundleNumber;
    private String bundlePageNumber;
    private String restrictionOfficeName;
    private String restrictionOfficeAddress;
    private String refNumber;
    private Integer refDate;
    private String remarks;
    
    public RestrictionRrrTO(){
        super();
    }

    public String getBundleNumber() {
        return bundleNumber;
    }

    public void setBundleNumber(String bundleNumber) {
        this.bundleNumber = bundleNumber;
    }

    public String getBundlePageNumber() {
        return bundlePageNumber;
    }

    public void setBundlePageNumber(String bundlePageNumber) {
        this.bundlePageNumber = bundlePageNumber;
    }

    public Integer getRefDate() {
        return refDate;
    }

    public void setRefDate(Integer refDate) {
        this.refDate = refDate;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public Integer getRegDate() {
        return regDate;
    }

    public void setRegDate(Integer regDate) {
        this.regDate = regDate;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRestrictionOfficeAddress() {
        return restrictionOfficeAddress;
    }

    public void setRestrictionOfficeAddress(String restrictionOfficeAddress) {
        this.restrictionOfficeAddress = restrictionOfficeAddress;
    }

    public String getRestrictionOfficeName() {
        return restrictionOfficeName;
    }

    public void setRestrictionOfficeName(String restrictionOfficeName) {
        this.restrictionOfficeName = restrictionOfficeName;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
