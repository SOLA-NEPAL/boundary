/**
 * ******************************************************************************************
 * Copyright (C) 2012 - Food and Agriculture Organization of the United Nations
 * (FAO). All rights reserved.
 * 
* Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
* 1. Redistributions of source code must retain the above copyright notice,this
 * list of conditions and the following disclaimer. 2. Redistributions in binary
 * form must reproduce the above copyright notice,this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution. 3. Neither the name of FAO nor the names of its
 * contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 * 
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT,STRICT LIABILITY,OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * *********************************************************************************************
 */
package org.sola.services.boundary.transferobjects.administrative;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.sola.services.boundary.transferobjects.casemanagement.PartySummaryTO;
import org.sola.services.boundary.transferobjects.casemanagement.SourceTO;
import org.sola.services.common.contracts.AbstractIdTO;

public class RrrTO extends AbstractIdTO {

    private String baUnitId;
    private String typeCode;
    private String nr;
    private String sn;
    private String statusCode;
    private boolean primary;
    private Integer registrationDate;
    private String transactionId;
    private Integer expirationDate;
    private BigDecimal mortgageAmount;
    private BigDecimal mortgageInterestRate;
    private Integer mortgageRanking;
    private String mortgageTypeCode;
    private boolean locked;
    private List<SourceTO> sourceList;
    private BaUnitNotationTO notation;
    private List<PartySummaryTO> rightHolderList;
    private String locId;
    private LocWithMothTO loc;
    private String restrictionReasonCode;
    private String restrictionOfficeName;
    private String restrictionReleaseOfficeName;
    private String restrictionOfficeAddress;
    private String restrictionReleaseReasonCode;
    private String officeCode;
    private boolean terminating;
    private String ownerTypeCode;
    private String ownershipTypeCode;
    private String tenancyTypeCode;
    private String bundleNumber;
    private String bundlePageNo;
    private String fiscalYearCode;
    private String registrationNumber;
    private BigDecimal valuationAmount;
    private BigDecimal taxAmount;

    public RrrTO() {
        super();
    }

    public String getRestrictionReasonCode() {
        return restrictionReasonCode;
    }

    public void setRestrictionReasonCode(String restrictionReasonCode) {
        this.restrictionReasonCode = restrictionReasonCode;
    }

    public String getBaUnitId() {
        return baUnitId;
    }

    public void setBaUnitId(String baUnitId) {
        this.baUnitId = baUnitId;
    }

    public Integer getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Integer registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BigDecimal getMortgageAmount() {
        return mortgageAmount;
    }

    public void setMortgageAmount(BigDecimal mortgageAmount) {
        this.mortgageAmount = mortgageAmount;
    }

    public BigDecimal getMortgageInterestRate() {
        return mortgageInterestRate;
    }

    public void setMortgageInterestRate(BigDecimal mortgageInterestRate) {
        this.mortgageInterestRate = mortgageInterestRate;
    }

    public Integer getMortgageRanking() {
        return mortgageRanking;
    }

    public void setMortgageRanking(Integer mortgageRanking) {
        this.mortgageRanking = mortgageRanking;
    }

    public String getMortgageTypeCode() {
        return mortgageTypeCode;
    }

    public void setMortgageTypeCode(String mortgageTypeCode) {
        this.mortgageTypeCode = mortgageTypeCode;
    }

    public BaUnitNotationTO getNotation() {
        return notation;
    }

    public void setNotation(BaUnitNotationTO notation) {
        this.notation = notation;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public List<PartySummaryTO> getRightHolderList() {
        return rightHolderList;
    }

    public void setRightHolderList(List<PartySummaryTO> rightHolderList) {
        this.rightHolderList = rightHolderList;
    }

    public void addRightHolder(PartySummaryTO partySummaryTO) {
        if (rightHolderList == null) {
            rightHolderList = new ArrayList<PartySummaryTO>();
        }
        rightHolderList.add(partySummaryTO);
    }

    public LocWithMothTO getLoc() {
        return loc;
    }

    public void setLoc(LocWithMothTO loc) {
        this.loc = loc;
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public List<SourceTO> getSourceList() {
        return sourceList;
    }

    public void setSourceList(List<SourceTO> sourceList) {
        this.sourceList = sourceList;
    }

    public void addSource(SourceTO source) {
        if (sourceList == null) {
            sourceList = new ArrayList<SourceTO>();
        }
        sourceList.add(source);
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

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public boolean isTerminating() {
        return terminating;
    }

    public void setTerminating(boolean terminating) {
        this.terminating = terminating;
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getRestrictionOfficeName() {
        return restrictionOfficeName;
    }

    public void setRestrictionOfficeName(String restrictionOfficeName) {
        this.restrictionOfficeName = restrictionOfficeName;
    }

    public String getRestrictionReleaseOfficeName() {
        return restrictionReleaseOfficeName;
    }

    public void setRestrictionReleaseOfficeName(String restrictionReleaseOfficeName) {
        this.restrictionReleaseOfficeName = restrictionReleaseOfficeName;
    }

    public String getRestrictionOfficeAddress() {
        return restrictionOfficeAddress;
    }

    public void setRestrictionOfficeAddress(String restrictionOfficeAddress) {
        this.restrictionOfficeAddress = restrictionOfficeAddress;
    }

    public String getRestrictionReleaseReasonCode() {
        return restrictionReleaseReasonCode;
    }

    public void setRestrictionReleaseReasonCode(String restrictionReleaseReasonCode) {
        this.restrictionReleaseReasonCode = restrictionReleaseReasonCode;
    }

    public String getTenancyTypeCode() {
        return tenancyTypeCode;
    }

    public void setTenancyTypeCode(String tenancyTypeCode) {
        this.tenancyTypeCode = tenancyTypeCode;
    }

    public String getBundleNumber() {
        return bundleNumber;
    }

    public void setBundleNumber(String bundleNumber) {
        this.bundleNumber = bundleNumber;
    }

    public String getBundlePageNo() {
        return bundlePageNo;
    }

    public void setBundlePageNo(String bundlePageNo) {
        this.bundlePageNo = bundlePageNo;
    }

    public String getFiscalYearCode() {
        return fiscalYearCode;
    }

    public void setFiscalYearCode(String fiscalYearCode) {
        this.fiscalYearCode = fiscalYearCode;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public BigDecimal getValuationAmount() {
        return valuationAmount;
    }

    public void setValuationAmount(BigDecimal valuationAmount) {
        this.valuationAmount = valuationAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }
}
