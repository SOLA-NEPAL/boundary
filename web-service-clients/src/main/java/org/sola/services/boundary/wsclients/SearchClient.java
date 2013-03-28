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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.wsclients;

import java.util.Date;
import java.util.List;
import org.sola.services.boundary.wsclients.exception.WebServiceClientException;
import org.sola.webservices.search.GenericResult;
import org.sola.webservices.search.QueryForSelect;
import org.sola.webservices.search.ResultForSelectionInfo;
import org.sola.webservices.transferobjects.search.*;

/**
 * Interface for the Search Service. Implemented by
 * {@linkplain SearchClientImpl} and {@linkplain mock.MockSearchClient}
 *
 * @author amcdowell
 */
public interface SearchClient extends AbstractWSClient {

    boolean checkConnection() throws WebServiceClientException;

    List<ApplicationSearchResultTO> getAssignedApplications() throws WebServiceClientException;

    List<ApplicationSearchResultTO> searchApplications(ApplicationSearchParamsTO applicationSearchParamsTO) throws WebServiceClientException;

    public List<ResultForSelectionInfo> select(List<QueryForSelect> queries)
            throws WebServiceClientException;

    List<PartySearchResultTO> searchParties(PartySearchParamsTO searchParams) throws WebServiceClientException;

    List<SourceSearchResultTO> searchSources(SourceSearchParamsTO searchParams) throws WebServiceClientException;

    List<UserSearchResultTO> getMyOfficeUsers() throws WebServiceClientException;

    List<UserSearchAdvancedResultTO> searchUsers(UserSearchParamsTO searchParams) throws WebServiceClientException;

    List<ApplicationLogResultTO> getApplicationLog(String applicationId);

    List<BrSearchResultTO> searchBr(BrSearchParamsTO searchParams) throws WebServiceClientException;

    List<BaUnitSearchResultTO> searchBaUnit(BaUnitSearchParamsTO searchParams) throws WebServiceClientException;

    List<CadastreObjectSearchResultTO> searchCadastreObjects(
            String searchBy, String searchString) throws WebServiceClientException;

    GenericResult test() throws WebServiceClientException;

    List<UserSearchResultTO> getMyDepartmentUsers() throws WebServiceClientException;

    List<UserSearchResultTO> getUsersWithAssignRightByDepartment(String departmentCode) throws WebServiceClientException;

    List<UserSearchResultTO> getUsersWithAssignRightByOffice() throws WebServiceClientException;

    List<CadastreObjectSearchResultExtTO> searchCadastreObjects(CadastreObjectSearchParamsTO searchParams) throws WebServiceClientException;

    List<BaUnitSearchResultTO> getAllBaUnitsByService(String serviceId) throws WebServiceClientException;

    LocDetailsTO getLocDetails(String locId, boolean current) throws WebServiceClientException;

    LocDetailsTO getLocDetails(String locId, boolean current, String lang) throws WebServiceClientException;

    List<LocSearchResultTO> searchLocs(LocSearchParamsTO searchParams) throws WebServiceClientException;

    List<RestrictionSearchResultTO> searchRestrictions(RestrictionSearchParamsTO searchParams) throws WebServiceClientException;

    List<RestrictionInfoTO> searchRestrictionInfo(RestrictionInfoParamsTO searchParams) throws WebServiceClientException;

    List<CadastreObjectSearchResultTO> searchCadastreObecjtsByIds(List<String> ids) throws WebServiceClientException;

    List<PartySearchResultTO> searchLandOwnersFromTo(Date fromDate, Date toDate, String lang) throws WebServiceClientException;

    List<PartySearchResultTO> searchLandOwnersUpto(Date upToDate, String lang) throws WebServiceClientException;

    List<PartySearchResultTO> searchLandOwnersFrom(Date from, String lang) throws WebServiceClientException;

    List<PartySearchResultTO> searchLandOwnersInFiscalYear(Date frmFiscalYear, Date toFiscalYear, String lang) throws WebServiceClientException;

    List<BaUnitSearchResultTO> searchTransactionFromTo(Date fromDate, Date toDate);

    List<BaUnitSearchResultTO> searchTransactionUpTo(Date upToDate);

    List<BaUnitSearchResultTO> searchTransactionFrom(Date from);

    List<BaUnitSearchResultTO> searchTransactionInFiscalYear(Date frmFiscalYear, Date toFiscalYear);

    List<BaUnitSearchResultTO> searchParcelsFromTo(Date fromDate, Date toDate);

    List<BaUnitSearchResultTO> searchParcelsUpTo(Date upToDate);

    List<BaUnitSearchResultTO> searchParcelsFrom(Date from);

    List<BaUnitSearchResultTO> searchParcelsInFiscalYear(Date frmFiscalYear, Date toFiscalYear);

    List<BaUnitSearchResultTO> searchRegistrationGenderWiseFromTo(Date fromDate, Date toDate, String genderCode, String handicapped, String deprived, String martyrs);

    List<BaUnitSearchResultTO> searchRegistrationGenderWiseUpTo(Date upToDate, String genderCode, String handicapped, String deprived, String martyrs);

    List<BaUnitSearchResultTO> searchRegistrationGenderWiseFrom(Date from, String genderCode, String handicapped, String deprived, String martyrs);

    List<BaUnitSearchResultTO> searchRegistrationGenderWiseInFiscalYear(Date frmFiscalYear, Date toFiscalYear, String genderCode, String handicapped, String deprived, String martyrs);

    List<BaUnitSearchResultTO> searchParcelsSplitFromTo(Date fromDate, Date toDate);

    List<BaUnitSearchResultTO> searchParcelsSplitUpTo(Date upToDate);

    List<BaUnitSearchResultTO> searchParcelsSplitFrom(Date from);

    List<BaUnitSearchResultTO> searchParcelsSplitInFiscalYear(Date frmFiscalYear, Date toFiscalYear);

    List<CadastreObjectSearchResultExtTO> searchPlotsByWard(String ward_no) throws WebServiceClientException;

    List<CadastreObjectSearchResultExtTO> searchPlotsBySheetNo(String sheet_no) throws WebServiceClientException;

    String getRuleByDatasetId(String datasetId);
}
