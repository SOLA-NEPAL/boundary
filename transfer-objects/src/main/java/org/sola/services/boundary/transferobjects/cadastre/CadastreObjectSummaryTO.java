package org.sola.services.boundary.transferobjects.cadastre;

import java.math.BigDecimal;
import java.util.Date;
import org.sola.services.boundary.transferobjects.casemanagement.AddressTO;
import org.sola.services.common.contracts.AbstractIdTO;

public class CadastreObjectSummaryTO extends AbstractIdTO {
    
    private String typeCode;
    private String mapSheetId;
    private String mapSheetId2;
    private String mapSheetId3;
    private String mapSheetId4;
    private String buildingUnitTypeCode;
    private Date approvalDatetime;
    private Date historicDatetime;
    private String nameFirstpart;
    private String nameLastpart;
    private String statusCode;
    private String transactionId;
    private String parcelno;
    private BigDecimal officialArea;
    private String areaUnitTypeCode;
    private String parcelNote;
    private String landTypeCode;
    private String landUseCode;
    private String landClassCode;
    private String addressId;
    private AddressTO address;
    private MapSheetTO mapSheet;
    private MapSheetTO mapSheet2;
    private MapSheetTO mapSheet3;
    private MapSheetTO mapSheet4;
    private String officeCode;
    private String fiscalYearCode;
    
    public CadastreObjectSummaryTO(){
        super();
    }
    
    public String getParcelNote() {
        return parcelNote;
    }

    public void setParcelNote(String parcelNote) {
        this.parcelNote = parcelNote;
    }

    public String getParcelno() {
        return parcelno;
    }

    public void setParcelno(String parcelno) {
        this.parcelno = parcelno;
    }

    public MapSheetTO getMapSheet() {
        return mapSheet;
    }

    public void setMapSheet(MapSheetTO mapSheet) {
        this.mapSheet = mapSheet;
    }

    public String getMapSheetId() {
        return mapSheetId;
    }

    public void setMapSheetId(String mapSheetId) {
        this.mapSheetId = mapSheetId;
    }

    public Date getApprovalDatetime() {
        return approvalDatetime;
    }

    public void setApprovalDatetime(Date approvalDatetime) {
        this.approvalDatetime = approvalDatetime;
    }

    public Date getHistoricDatetime() {
        return historicDatetime;
    }

    public void setHistoricDatetime(Date historicDatetime) {
        this.historicDatetime = historicDatetime;
    }

    public String getNameFirstpart() {
        return nameFirstpart;
    }

    public void setNameFirstpart(String nameFirstpart) {
        this.nameFirstpart = nameFirstpart;
    }

    public String getNameLastpart() {
        return nameLastpart;
    }

    public void setNameLastpart(String nameLastpart) {
        this.nameLastpart = nameLastpart;
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

    public String getLandClassCode() {
        return landClassCode;
    }

    public void setLandClassCode(String landClassCode) {
        this.landClassCode = landClassCode;
    }

    public String getLandUseCode() {
        return landUseCode;
    }

    public void setLandUseCode(String landUseCode) {
        this.landUseCode = landUseCode;
    }

    public String getLandTypeCode() {
        return landTypeCode;
    }

    public void setLandTypeCode(String landTypeCode) {
        this.landTypeCode = landTypeCode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public AddressTO getAddress() {
        return address;
    }

    public void setAddress(AddressTO address) {
        this.address = address;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getFiscalYearCode() {
        return fiscalYearCode;
    }

    public void setFiscalYearCode(String fiscalYearCode) {
        this.fiscalYearCode = fiscalYearCode;
    }

    public String getMapSheetId2() {
        return mapSheetId2;
    }

    public void setMapSheetId2(String mapSheetId2) {
        this.mapSheetId2 = mapSheetId2;
    }

    public String getMapSheetId3() {
        return mapSheetId3;
    }

    public void setMapSheetId3(String mapSheetId3) {
        this.mapSheetId3 = mapSheetId3;
    }

    public String getMapSheetId4() {
        return mapSheetId4;
    }

    public void setMapSheetId4(String mapSheetId4) {
        this.mapSheetId4 = mapSheetId4;
    }

    public MapSheetTO getMapSheet2() {
        return mapSheet2;
    }

    public void setMapSheet2(MapSheetTO mapSheet2) {
        this.mapSheet2 = mapSheet2;
    }

    public MapSheetTO getMapSheet3() {
        return mapSheet3;
    }

    public void setMapSheet3(MapSheetTO mapSheet3) {
        this.mapSheet3 = mapSheet3;
    }

    public MapSheetTO getMapSheet4() {
        return mapSheet4;
    }

    public void setMapSheet4(MapSheetTO mapSheet4) {
        this.mapSheet4 = mapSheet4;
    }

    public String getBuildingUnitTypeCode() {
        return buildingUnitTypeCode;
    }

    public void setBuildingUnitTypeCode(String buildingUnitTypeCode) {
        this.buildingUnitTypeCode = buildingUnitTypeCode;
    }

    public String getAreaUnitTypeCode() {
        return areaUnitTypeCode;
    }

    public void setAreaUnitTypeCode(String areaUnitTypeCode) {
        this.areaUnitTypeCode = areaUnitTypeCode;
    }

    public BigDecimal getOfficialArea() {
        return officialArea;
    }

    public void setOfficialArea(BigDecimal officialArea) {
        this.officialArea = officialArea;
    }
}
