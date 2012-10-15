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
package org.sola.services.boundary.transferobjects.casemanagement;

import java.util.ArrayList;
import java.util.List;
import org.sola.services.boundary.transferobjects.digitalarchive.DocumentBinaryTO;

public class PartyTO extends PartySummaryTO {

    private PartySummaryTO parent;
    private String alias;
    private String addressId;
    private String idTypeCode;
    private String idOfficeDistrictCode;
    private String email;
    private String mobile;
    private String phone;
    private String fax;
    private String preferredCommunicationCode;
    private Integer birthDate;
    private String remarks;
    private String photoId;
    private String leftFingerId;
    private String rightFingerId;
    private String signatureId;
    private List<PartyRoleTO> roleList;
    private AddressTO address;
    private DocumentBinaryTO photoDoc;
    private DocumentBinaryTO leftFingerDoc;
    private DocumentBinaryTO rightFingerDoc;
    private DocumentBinaryTO signatureDoc;
    
    public PartyTO() {
        super();
    }

    public PartySummaryTO getParent() {
        return parent;
    }

    public void setParent(PartySummaryTO parent) {
        this.parent = parent;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getIdTypeCode() {
        return idTypeCode;
    }

    public void setIdTypeCode(String idTypeCode) {
        this.idTypeCode = idTypeCode;
    }

    public String getIdOfficeDistrictCode() {
        return idOfficeDistrictCode;
    }

    public void setIdOfficeDistrictCode(String idOfficeDistrictCode) {
        this.idOfficeDistrictCode = idOfficeDistrictCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPreferredCommunicationCode() {
        return preferredCommunicationCode;
    }

    public void setPreferredCommunicationCode(String preferredCommunicationCode) {
        this.preferredCommunicationCode = preferredCommunicationCode;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getLeftFingerId() {
        return leftFingerId;
    }

    public void setLeftFingerId(String leftFingerId) {
        this.leftFingerId = leftFingerId;
    }

    public String getRightFingerId() {
        return rightFingerId;
    }

    public void setRightFingerId(String rightFingerId) {
        this.rightFingerId = rightFingerId;
    }

    public String getSignatureId() {
        return signatureId;
    }

    public void setSignatureId(String signatureId) {
        this.signatureId = signatureId;
    }

    public List<PartyRoleTO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<PartyRoleTO> roleList) {
        this.roleList = roleList;
    }

    public AddressTO getAddress() {
        return address;
    }

    public void setAddress(AddressTO address) {
        this.address = address;
    }

    public DocumentBinaryTO getPhotoDoc() {
        return photoDoc;
    }

    public void setPhotoDoc(DocumentBinaryTO photoDoc) {
        this.photoDoc = photoDoc;
    }

    public DocumentBinaryTO getLeftFingerDoc() {
        return leftFingerDoc;
    }

    public void setLeftFingerDoc(DocumentBinaryTO leftFingerDoc) {
        this.leftFingerDoc = leftFingerDoc;
    }

    public DocumentBinaryTO getRightFingerDoc() {
        return rightFingerDoc;
    }

    public void setRightFingerDoc(DocumentBinaryTO rightFingerDoc) {
        this.rightFingerDoc = rightFingerDoc;
    }

    public DocumentBinaryTO getSignatureDoc() {
        return signatureDoc;
    }

    public void setSignatureDoc(DocumentBinaryTO signatureDoc) {
        this.signatureDoc = signatureDoc;
    }

    public void addRole(PartyRoleTO role) {
        if (roleList == null) {
            roleList = new ArrayList<PartyRoleTO>();
        }
        roleList.add(role);
    }
}
