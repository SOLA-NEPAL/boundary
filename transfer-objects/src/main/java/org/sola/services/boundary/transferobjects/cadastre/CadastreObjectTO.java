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

import java.util.Date;
import java.util.List;
import org.sola.services.common.contracts.AbstractIdTO;

public class CadastreObjectTO extends AbstractIdTO {

    private String typeCode;
    private String mapSheetCode;
    private Date approvalDatetime;
    private Date historicDatetime;
    private String sourceReference;
    private String nameFirstpart;
    private String nameLastpart;
    private String statusCode;
    private String transactionId;
    private byte[] geomPolygon;
    private int parcelno;
    private String parcelNote;
    private int parcelType;
    private List<SpatialValueAreaTO> spatialValueAreaList;
    private MapSheetTO mapSheet;
    private String officeCode;

    public String getParcelNote() {
        return parcelNote;
    }

    public void setParcelNote(String parcelNote) {
        this.parcelNote = parcelNote;
    }

    public int getParcelType() {
        return parcelType;
    }

    public void setParcelType(int parcelType) {
        this.parcelType = parcelType;
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

    public String getMapSheetCode() {
        return mapSheetCode;
    }

    public void setMapSheetCode(String mapSheetCode) {
        this.mapSheetCode = mapSheetCode;
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

    public String getSourceReference() {
        return sourceReference;
    }

    public void setSourceReference(String sourceReference) {
        this.sourceReference = sourceReference;
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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public List<SpatialValueAreaTO> getSpatialValueAreaList() {
        return spatialValueAreaList;
    }

    public void setSpatialValueAreaList(List<SpatialValueAreaTO> spatialValueAreaList) {
        this.spatialValueAreaList = spatialValueAreaList;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }
}
