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
package org.sola.services.boundary.wsclients;

import java.util.Date;
import java.util.List;
import org.sola.services.boundary.wsclients.exception.WebServiceClientException;
import org.sola.webservices.admin.BrTO;
import org.sola.webservices.admin.LanguageTO;
import org.sola.webservices.admin.NepaliMonthTO;
import org.sola.webservices.transferobjects.referencedata.OfficeTO;
import org.sola.webservices.transferobjects.security.GroupSummaryTO;
import org.sola.webservices.transferobjects.security.GroupTO;
import org.sola.webservices.transferobjects.security.RoleTO;
import org.sola.webservices.transferobjects.security.UserTO;

/**
 * Interface for the Admin Service. Implemented by {@linkplain AdminClientImpl}
 * and {@linkplain mock.MockAdminClient}
 */
public interface AdminClient extends AbstractWSClient {

    boolean checkConnection() throws WebServiceClientException;

    UserTO getCurrentUser() throws WebServiceClientException;

    List<GroupTO> getGroups() throws WebServiceClientException;

    List<GroupSummaryTO> getGroupsSummary() throws WebServiceClientException;

    GroupTO getGroup(String groupId) throws WebServiceClientException;

    UserTO getUser(String userName) throws WebServiceClientException;

    UserTO saveUser(UserTO userTO) throws WebServiceClientException;

    GroupTO saveGroup(GroupTO groupTO) throws WebServiceClientException;

    RoleTO saveRole(RoleTO roleTO) throws WebServiceClientException;

    List<RoleTO> getRoles() throws WebServiceClientException;

    List<RoleTO> getCurrentUserRoles() throws WebServiceClientException;

    boolean changePassword(String userName, String password) throws WebServiceClientException;

    boolean changeCurrentUserPassword(String oldPassword, String newPassword);
    
    boolean isUserAdmin() throws WebServiceClientException;

    List<LanguageTO> getLanguages() throws WebServiceClientException;

    List<LanguageTO> getLanguages(String lang) throws WebServiceClientException;

    BrTO getBr(String id, String lang) throws WebServiceClientException;

    BrTO getBr(String id) throws WebServiceClientException;

    BrTO saveBr(BrTO brTO) throws WebServiceClientException;

    //<editor-fold defaultstate="collapsed" desc="By Kumar">
    //************************************************************************************************
    List<NepaliMonthTO> saveNepaliMonth(List<NepaliMonthTO> nepaliMonthsTO);
    
    List<NepaliMonthTO> getNepaliMonths(int nepYear);
    
    List<Integer> getNepaliYear();
    
    Date getGregorianDate(String nepaliDate) throws WebServiceClientException;
    
    String getNepaliDate(Date date) throws WebServiceClientException;
    //************************************************************************************************
    //</editor-fold>
    
    OfficeTO getCurrentOffice() throws WebServiceClientException;
}
