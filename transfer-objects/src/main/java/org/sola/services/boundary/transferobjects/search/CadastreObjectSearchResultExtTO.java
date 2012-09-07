package org.sola.services.boundary.transferobjects.search;

import org.sola.services.common.contracts.AbstractTO;

public class CadastreObjectSearchResultExtTO extends AbstractTO {

    private String id;
    private String mapsheetId;
    private String mapsheetId2;
    private String mapsheetId3;
    private String mapsheetId4;
    private String mapsheetNumber;
    private String mapsheetNumber2;
    private String mapsheetNumber3;
    private String mapsheetNumber4;
    private String wardNumber;
    private String vdcCode;
    private String vdcName;
    private String firstName;
    private String lastName;
    private String parcelno;
    
    public CadastreObjectSearchResultExtTO() {
        super();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMapsheetId() {
        return mapsheetId;
    }

    public void setMapsheetId(String mapsheetId) {
        this.mapsheetId = mapsheetId;
    }

    public String getMapsheetId2() {
        return mapsheetId2;
    }

    public void setMapsheetId2(String mapsheetId2) {
        this.mapsheetId2 = mapsheetId2;
    }

    public String getMapsheetId3() {
        return mapsheetId3;
    }

    public void setMapsheetId3(String mapsheetId3) {
        this.mapsheetId3 = mapsheetId3;
    }

    public String getMapsheetId4() {
        return mapsheetId4;
    }

    public void setMapsheetId4(String mapsheetId4) {
        this.mapsheetId4 = mapsheetId4;
    }

    public String getMapsheetNumber() {
        return mapsheetNumber;
    }

    public void setMapsheetNumber(String mapsheetNumber) {
        this.mapsheetNumber = mapsheetNumber;
    }

    public String getMapsheetNumber2() {
        return mapsheetNumber2;
    }

    public void setMapsheetNumber2(String mapsheetNumber2) {
        this.mapsheetNumber2 = mapsheetNumber2;
    }

    public String getMapsheetNumber3() {
        return mapsheetNumber3;
    }

    public void setMapsheetNumber3(String mapsheetNumber3) {
        this.mapsheetNumber3 = mapsheetNumber3;
    }

    public String getMapsheetNumber4() {
        return mapsheetNumber4;
    }

    public void setMapsheetNumber4(String mapsheetNumber4) {
        this.mapsheetNumber4 = mapsheetNumber4;
    }

    public String getParcelno() {
        return parcelno;
    }

    public void setParcelno(String parcelno) {
        this.parcelno = parcelno;
    }


    public String getVdcCode() {
        return vdcCode;
    }

    public void setVdcCode(String vdcCode) {
        this.vdcCode = vdcCode;
    }

    public String getVdcName() {
        return vdcName;
    }

    public void setVdcName(String vdcName) {
        this.vdcName = vdcName;
    }

    public String getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(String wardNumber) {
        this.wardNumber = wardNumber;
    }
}
