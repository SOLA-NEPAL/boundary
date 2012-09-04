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
package org.sola.services.boundary.transferobjects.cadastre;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.sola.services.boundary.transferobjects.casemanagement.AddressTO;
import org.sola.services.common.contracts.AbstractIdTO;

public class CadastreObjectTO extends AbstractIdTO {

    private String typeCode;
    private String mapSheetId;
    private String mapSheetId2;
    private String mapSheetId3;
    private String mapSheetId4;
    private Date approvalDatetime;
    private Date historicDatetime;
    private String nameFirstpart;
    private String nameLastpart;
    private String statusCode;
    private String transactionId;
    private String addressId;
    private byte[] geomPolygon;
    private int parcelno;
    private String parcelNote;
    private String landTypeCode;
    private String landUseCode;
    private String landClassCode;
    private String guthiName;
    private AddressTO address;
    private MapSheetTO mapSheet;
    private String officeCode;
    private String fiscalYearCode;
    private String buildingUnitTypeCode;
    private String areaUnitTypeCode;
    private BigDecimal officialArea;

    public String getParcelNote() {
        return parcelNote;
    }

    public void setParcelNote(String parcelNote) {
        this.parcelNote = parcelNote;
    }

    public int getParcelno() {
        return parcelno;
    }

    public void setParcelno(int parcelno) {
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

    public CadastreObjectTO() {
        super();
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

    public byte[] getGeomPolygon() {
        return geomPolygon;
    }

    public void setGeomPolygon(byte[] geomPolygon) {
        this.geomPolygon = geomPolygon;
    }

    public String getGuthiName() {
        return guthiName;
    }

    public void setGuthiName(String guthiName) {
        this.guthiName = guthiName;
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
