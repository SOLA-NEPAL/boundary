/**
 * ******************************************************************************************
 * Copyright (C) 2012 - Food and Agriculture Organization of the United Nations (FAO).
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice,this list
 *       of conditions and the following disclaimer.
 *    2. Redistributions in binary form must reproduce the above copyright notice,this list
 *       of conditions and the following disclaimer in the documentation and/or other
 *       materials provided with the distribution.
 *    3. Neither the name of FAO nor the names of its contributors may be used to endorse or
 *       promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,PROCUREMENT
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,STRICT LIABILITY,OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * *********************************************************************************************
 */
package org.sola.services.boundary.transferobjects.casemanagement;

import org.sola.services.boundary.transferobjects.digitalarchive.DocumentTO;

public class SourceTO extends SourceSummaryTO {

    private String mainType;
    private String availabilityStatusCode;
    private String content;
    private DocumentTO archiveDocument;
    private String transactionId;
    private boolean locked;
    private String owner;
    private String description;
    private String packetNumber;
    private String tameliNumber;
    private String likhatRegistrationNumber;
    private String pageNumber;
    
    public SourceTO() {
        super();
    }

    public String getAvailabilityStatusCode() {
        return availabilityStatusCode;
    }

    public void setAvailabilityStatusCode(String availabilityStatusCode) {
        this.availabilityStatusCode = availabilityStatusCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public DocumentTO getArchiveDocument() {
        return archiveDocument;
    }

    public void setArchiveDocument(DocumentTO archiveDocument) {
        this.archiveDocument = archiveDocument;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    
    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLikhatRegistrationNumber() {
        return likhatRegistrationNumber;
    }

    public void setLikhatRegistrationNumber(String likhatRegistrationNumber) {
        this.likhatRegistrationNumber = likhatRegistrationNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPacketNumber() {
        return packetNumber;
    }

    public void setPacketNumber(String packetNumber) {
        this.packetNumber = packetNumber;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getTameliNumber() {
        return tameliNumber;
    }

    public void setTameliNumber(String tameliNumber) {
        this.tameliNumber = tameliNumber;
    }
}
