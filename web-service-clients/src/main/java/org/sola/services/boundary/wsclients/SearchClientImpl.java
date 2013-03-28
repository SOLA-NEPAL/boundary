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
import javax.xml.namespace.QName;
import org.sola.services.boundary.wsclients.exception.WebServiceClientException;
import org.sola.webservices.search.*;
import org.sola.webservices.transferobjects.search.*;

/**
 * Implementation class for the {@linkplain SearchClient} interface.
 *
 * @author amcdowell
 */
public class SearchClientImpl extends AbstractWSClientImpl implements SearchClient {

    private static final String NAMESPACE_URI = "http://webservices.sola.org/search";
    private static final String LOCAL_PART = "search-service";
    private static final String SERVICE_NAME = "Search.";

    public SearchClientImpl(String url) {
        super(url, new QName(NAMESPACE_URI, LOCAL_PART));
    }

    private Search getPort() {
        return getPort(Search.class, SearchService.class);
    }

    @Override
    public boolean checkConnection() throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "checkConnection";
        try {
            boolean result = getPort().checkConnection();
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return false;
        }
    }

    @Override
    public List<ApplicationSearchResultTO> getAssignedApplications() throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getAssignedApplications";
        try {
            List<ApplicationSearchResultTO> result = getPort().getAssignedApplications(getLanguageCode());
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<ApplicationSearchResultTO> searchApplications(ApplicationSearchParamsTO applicationSearchParamsTO)
            throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchApplications";
        try {
            if (applicationSearchParamsTO.getLocale() == null) {
                applicationSearchParamsTO.setLocale(getLanguageCode());
            }
            List<ApplicationSearchResultTO> result = getPort().searchApplications(applicationSearchParamsTO);
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<ResultForSelectionInfo> select(List<QueryForSelect> queries)
            throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "select";
        try {
            for (QueryForSelect query : queries) {
                query.setLocale(this.getLanguageCode());
            }
            List<ResultForSelectionInfo> result = getPort().select(queries);
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<PartySearchResultTO> searchParties(PartySearchParamsTO searchParams)
            throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchParties";
        try {
            return getPort().searchParties(searchParams);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<SourceSearchResultTO> searchSources(SourceSearchParamsTO searchParams) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchSources";
        try {
            if (searchParams.getLocale() == null) {
                searchParams.setLocale(getLanguageCode());
            }
            return getPort().searchSources(searchParams);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<UserSearchResultTO> getMyOfficeUsers() throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getActiveUsers";
        try {
            List<UserSearchResultTO> result = getPort().getMyOfficeUsers();
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<UserSearchAdvancedResultTO> searchUsers(UserSearchParamsTO searchParams)
            throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchUsers";
        try {
            List<UserSearchAdvancedResultTO> result = getPort().searchUsers(searchParams);
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<ApplicationLogResultTO> getApplicationLog(String applicationId)
            throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getApplicationLog";
        try {
            List<ApplicationLogResultTO> result = getPort().getApplicationLog(applicationId);
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BrSearchResultTO> searchBr(BrSearchParamsTO searchParams) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchBr";
        try {
            return getPort().searchBr(searchParams, getLanguageCode());
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<CadastreObjectSearchResultTO> searchCadastreObjects(
            String searchBy, String searchString) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchCadastreObjects";
        try {
            return getPort().searchCadastreObjects(searchBy, searchString);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    public GenericResult test() throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "test";
        try {
            return getPort().test(getLanguageCode());
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchBaUnit(BaUnitSearchParamsTO searchParams) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchBaUnit";
        try {
            return getPort().searchBaUnit(searchParams);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<UserSearchResultTO> getMyDepartmentUsers() {
        final String inputService = SERVICE_NAME + "getMyDepartmentUsers";
        try {
            return getPort().getMyDepartmentUsers();
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<UserSearchResultTO> getUsersWithAssignRightByDepartment(String departmentCode) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getUsersWithAssignRightByDepartment";
        try {
            return getPort().getUsersWithAssignRightByDepartment(departmentCode);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<UserSearchResultTO> getUsersWithAssignRightByOffice() throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getUsersWithAssignRightByOffice";
        try {
            return getPort().getUsersWithAssignRightByOffice();
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<CadastreObjectSearchResultExtTO> searchCadastreObjects(CadastreObjectSearchParamsTO searchParams) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchCadastreObjects";
        try {
            return getPort().searchCadastreObecjts(getLanguageCode(), searchParams);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> getAllBaUnitsByService(String serviceId) {
        final String inputService = SERVICE_NAME + "getAllBaUnitsByService";
        try {
            return getPort().getAllBaUnitsByService(serviceId);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public LocDetailsTO getLocDetails(String locId, boolean current) throws WebServiceClientException {
        return getLocDetails(locId, current, getLanguageCode());
    }

    @Override
    public LocDetailsTO getLocDetails(String locId, boolean current, String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getLocDetails";
        try {
            return getPort().getLocDetails(locId, current, lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<LocSearchResultTO> searchLocs(LocSearchParamsTO searchParams)
            throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchLocs";
        try {
            return getPort().searchLocs(searchParams);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<RestrictionSearchResultTO> searchRestrictions(RestrictionSearchParamsTO searchParams)
            throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchRestrictions";
        try {
            return getPort().searchRestrictions(searchParams);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<RestrictionInfoTO> searchRestrictionInfo(RestrictionInfoParamsTO searchParams) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchRestrictionInfo";
        try {
            return getPort().searchRestrictionInfo(searchParams);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<CadastreObjectSearchResultTO> searchCadastreObecjtsByIds(List<String> ids) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchCadastreObecjtsByIds";
        try {
            return getPort().searchCadastreObecjtsByIds(ids);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<PartySearchResultTO> searchLandOwnersFromTo(Date fromDate, Date toDate, String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchLandOwnersFromTo";
        try {
            return getPort().searchLandOwnersFromTo(DateToXMLDate(fromDate), DateToXMLDate(toDate), lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<PartySearchResultTO> searchLandOwnersUpto(Date upToDate, String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchLandOwnersUpto";
        try {
            return getPort().searchLandOwnersUpto(DateToXMLDate(upToDate), lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<PartySearchResultTO> searchLandOwnersFrom(Date from, String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchLandOwnersFrom";
        try {
            return getPort().searchLandOwnersFrom(DateToXMLDate(from), lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<PartySearchResultTO> searchLandOwnersInFiscalYear(Date frmFiscalYear, Date toFiscalYear, String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchLandOwnersInFiscalYear";
        try {
            return getPort().searchLandOwnersInFiscalYear(DateToXMLDate(frmFiscalYear), DateToXMLDate(toFiscalYear), lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchTransactionFromTo(Date fromDate, Date toDate) {
        final String inputService = SERVICE_NAME + "searchTransactionFromTo";
        try {
            return getPort().searchTransactionFromTo(DateToXMLDate(fromDate), DateToXMLDate(toDate));
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchTransactionUpTo(Date upToDate) {
        final String inputService = SERVICE_NAME + "searchTransactionUpTo";
        try {
            return getPort().searchTransactionUpTo(DateToXMLDate(upToDate));
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchTransactionFrom(Date from) {
        final String inputService = SERVICE_NAME + "searchTransactionFrom";
        try {
            return getPort().searchTransactionFrom(DateToXMLDate(from));
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchTransactionInFiscalYear(Date frmFiscalYear, Date toFiscalYear) {
        final String inputService = SERVICE_NAME + "searchTransactionInFiscalYear";
        try {
            return getPort().searchTransactionInFiscalYear(DateToXMLDate(frmFiscalYear), DateToXMLDate(toFiscalYear));
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchParcelsFromTo(Date fromDate, Date toDate) {
        final String inputService = SERVICE_NAME + "searchParcelsFromTo";
        try {
            return getPort().searchParcelsFromTo(DateToXMLDate(fromDate), DateToXMLDate(toDate));
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchParcelsUpTo(Date upToDate) {
        final String inputService = SERVICE_NAME + "searchParcelsUpTo";
        try {
            return getPort().searchParcelsUpTo(DateToXMLDate(upToDate));
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchParcelsFrom(Date from) {
        final String inputService = SERVICE_NAME + "searchParcelsFrom";
        try {
            return getPort().searchParcelsFrom(DateToXMLDate(from));
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchParcelsInFiscalYear(Date frmFiscalYear, Date toFiscalYear) {
        final String inputService = SERVICE_NAME + "searchParcelsInFiscalYear";
        try {
            return getPort().searchParcelsInFiscalYear(DateToXMLDate(frmFiscalYear), DateToXMLDate(toFiscalYear));
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchRegistrationGenderWiseFromTo(Date fromDate, Date toDate, String genderCode, String handicapped, String deprived, String martyrs) {
        final String inputService = SERVICE_NAME + "searchRegistrationGenderWiseFromTo";
        try {
            return getPort().searchRegistrationGenderWiseFromTo(DateToXMLDate(fromDate), DateToXMLDate(toDate), genderCode, handicapped, deprived, martyrs);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchRegistrationGenderWiseUpTo(Date upToDate, String genderCode, String handicapped, String deprived, String martyrs) {
        final String inputService = SERVICE_NAME + "searchRegistrationGenderWiseUpTo";
        try {
            return getPort().searchRegistrationGenderWiseUpTo(DateToXMLDate(upToDate), genderCode, handicapped, deprived, martyrs);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchRegistrationGenderWiseFrom(Date from, String genderCode, String handicapped, String deprived, String martyrs) {
        final String inputService = SERVICE_NAME + "searchRegistrationGenderWiseFrom";
        try {
            return getPort().searchRegistrationGenderWiseFrom(DateToXMLDate(from), genderCode, handicapped, deprived, martyrs);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchRegistrationGenderWiseInFiscalYear(Date frmFiscalYear, Date toFiscalYear, String genderCode, String handicapped, String deprived, String martyrs) {
        final String inputService = SERVICE_NAME + "searchRegistrationGenderWiseInFiscalYear";
        try {
            return getPort().searchRegistrationGenderWiseInFiscalYear(DateToXMLDate(frmFiscalYear), DateToXMLDate(toFiscalYear), genderCode, handicapped, deprived, martyrs);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchParcelsSplitFromTo(Date fromDate, Date toDate) {
        final String inputService = SERVICE_NAME + "searchParcelsSplitFromTo";
        try {
            return getPort().searchParcelsSplitFromTo(DateToXMLDate(fromDate), DateToXMLDate(toDate));
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchParcelsSplitUpTo(Date upToDate) {
        final String inputService = SERVICE_NAME + "searchParcelsSplitUpTo";
        try {
            return getPort().searchParcelsSplitUpTo(DateToXMLDate(upToDate));
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchParcelsSplitFrom(Date from) {
        final String inputService = SERVICE_NAME + "searchParcelsSplitFrom";
        try {
            return getPort().searchParcelsSplitFrom(DateToXMLDate(from));
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitSearchResultTO> searchParcelsSplitInFiscalYear(Date frmFiscalYear, Date toFiscalYear) {
        final String inputService = SERVICE_NAME + "searchParcelsSplitInFiscalYear";
        try {
            return getPort().searchParcelsSplitInFiscalYear(DateToXMLDate(frmFiscalYear), DateToXMLDate(toFiscalYear));
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<CadastreObjectSearchResultExtTO> searchPlotsByWard(String ward_no) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchPlotsByWard";
        try {
            return getPort().searchPlotsByWard(ward_no);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<CadastreObjectSearchResultExtTO> searchPlotsBySheetNo(String sheet_no) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "searchPlotsBySheetNo";
        try {
            return getPort().searchPlotsBySheetNo(sheet_no);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public String getRuleByDatasetId(String datasetId) {
        final String inputService = SERVICE_NAME + "getRuleByDatasetId";
        try {
            return getPort().getRuleByDatasetId(datasetId);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }
}
