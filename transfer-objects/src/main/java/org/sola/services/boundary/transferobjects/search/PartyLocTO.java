/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.search;

import org.sola.services.common.contracts.AbstractBasicIdTO;

public class PartyLocTO extends AbstractBasicIdTO {
    private String name;
    private String lastName;
    private String fatherName;
    private String grandfatherName;
    private Integer idIssueDate;
    private String idNumber;
    private byte[] photo;
    private byte[] leftFingerprint;
    private byte[] rightFingerprint;
    private String vdcCode;
    private String vdcName;
    private String wardNo;
    private String street;
    private String officeName;
    
    public PartyLocTO(){
        super();
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGrandfatherName() {
        return grandfatherName;
    }

    public void setGrandfatherName(String grandfatherName) {
        this.grandfatherName = grandfatherName;
    }

    public Integer getIdIssueDate() {
        return idIssueDate;
    }

    public void setIdIssueDate(Integer idIssueDate) {
        this.idIssueDate = idIssueDate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getLeftFingerprint() {
        return leftFingerprint;
    }

    public void setLeftFingerprint(byte[] leftFingerprint) {
        this.leftFingerprint = leftFingerprint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getRightFingerprint() {
        return rightFingerprint;
    }

    public void setRightFingerprint(byte[] rightFingerprint) {
        this.rightFingerprint = rightFingerprint;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getWardNo() {
        return wardNo;
    }

    public void setWardNo(String wardNo) {
        this.wardNo = wardNo;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }
}
