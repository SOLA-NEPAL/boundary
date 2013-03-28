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
package org.sola.services.boundary.ws;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import org.sola.services.boundary.transferobjects.search.*;
import org.sola.services.common.ServiceConstants;
import org.sola.services.common.contracts.GenericTranslator;
import org.sola.services.common.faults.SOLAAccessFault;
import org.sola.services.common.faults.SOLAFault;
import org.sola.services.common.faults.UnhandledFault;
import org.sola.services.common.webservices.AbstractWebService;
import org.sola.services.ejb.search.businesslogic.SearchEJBLocal;
import org.sola.services.ejb.search.repository.entities.*;
import org.sola.services.ejb.search.spatial.QueryForSelect;
import org.sola.services.ejb.search.spatial.ResultForSelectionInfo;
import org.sola.services.ejbs.admin.businesslogic.AdminEJBLocal;
import org.sola.services.ejbs.admin.businesslogic.repository.entities.User;

@WebService(serviceName = "search-service", targetNamespace = ServiceConstants.SEARCH_WS_NAMESPACE)
public class Search extends AbstractWebService {

    @EJB
    SearchEJBLocal searchEJB;
    @EJB
    AdminEJBLocal adminEJB;
    @Resource
    private WebServiceContext wsContext;

    /**
     * Dummy method to check the web service instance is working
     */
    @WebMethod(operationName = "CheckConnection")
    public boolean CheckConnection() {
        return true;
    }

    @WebMethod(operationName = "GetAssignedApplications")
    public List<ApplicationSearchResultTO> GetAssignedApplications(@WebParam(name = "locale") String locale)
            throws SOLAFault, UnhandledFault {

        final String localeTmp = locale;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                List<ApplicationSearchResult> appList = searchEJB.getAssignedApplications(localeTmp);
                result[0] = GenericTranslator.toTOList(
                        appList, ApplicationSearchResultTO.class);
            }
        });
        List<ApplicationSearchResultTO> resultList = (List<ApplicationSearchResultTO>) result[0];
        return resultList;
    }

    @WebMethod(operationName = "SearchApplications")
    public List<ApplicationSearchResultTO> SearchApplications(
            @WebParam(name = "ApplicationSearchParamsTO") ApplicationSearchParamsTO paramsTO)
            throws SOLAFault, UnhandledFault {

        final ApplicationSearchParamsTO paramsTOTmp = paramsTO;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                ApplicationSearchParams params = GenericTranslator.fromTO(paramsTOTmp, ApplicationSearchParams.class, null);
                List<ApplicationSearchResult> appList = searchEJB.searchApplications(params);
                result[0] = GenericTranslator.toTOList(
                        appList, ApplicationSearchResultTO.class);
            }
        });

        return (List<ApplicationSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "Select")
    public List<ResultForSelectionInfo> Select(List<QueryForSelect> queries)
            throws SOLAFault, UnhandledFault {

        final List<QueryForSelect> queriesTmp = queries;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = searchEJB.getSpatialResultFromSelection(queriesTmp);
            }
        });

        return (List<ResultForSelectionInfo>) result[0];
    }

    @WebMethod(operationName = "SearchParties")
    public List<PartySearchResultTO> searchParties(
            @WebParam(name = "searchParams") PartySearchParamsTO searchParams)
            throws SOLAFault, UnhandledFault {

        final PartySearchParamsTO searchParamsTmp = searchParams;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                PartySearchParams params = GenericTranslator.fromTO(searchParamsTmp,
                        PartySearchParams.class, null);
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchParties(params), PartySearchResultTO.class);
            }
        });

        return (List<PartySearchResultTO>) result[0];
    }

    @WebMethod(operationName = "SearchSources")
    public List<SourceSearchResultTO> searchSources(
            @WebParam(name = "searchParams") SourceSearchParamsTO searchParams)
            throws SOLAFault, UnhandledFault {

        final SourceSearchParamsTO searchParamsTmp = searchParams;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                SourceSearchParams params = GenericTranslator.fromTO(searchParamsTmp,
                        SourceSearchParams.class, null);
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchSources(params), SourceSearchResultTO.class);

            }
        });

        return (List<SourceSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "getMyOfficeUsers")
    public List<UserSearchResultTO> getMyOfficeUsers()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                List<UserSearchResult> users = searchEJB.getUsersByOffice(adminEJB.getCurrentOfficeCode());
                result[0] = GenericTranslator.toTOList(users, UserSearchResultTO.class);
            }
        });

        return (List<UserSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "getUsersWithAssignRightByOffice")
    public List<UserSearchResultTO> getUsersWithAssignRightByOffice()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                List<UserSearchResult> users = searchEJB.getUsersWithAssignRightByOffice(
                        adminEJB.getCurrentOfficeCode());
                result[0] = GenericTranslator.toTOList(users, UserSearchResultTO.class);
            }
        });

        return (List<UserSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "getUsersWithAssignRightByDepartment")
    public List<UserSearchResultTO> getUsersWithAssignRightByDepartment(@WebParam(name = "departmentCode") final String departmentCode)
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                List<UserSearchResult> users = searchEJB.getUsersWithAssignRightByDepartment(departmentCode);
                result[0] = GenericTranslator.toTOList(users, UserSearchResultTO.class);
            }
        });

        return (List<UserSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "getMyDepartmentUsers")
    public List<UserSearchResultTO> getMyDepartmentUsers() throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                User user = adminEJB.getCurrentUser();
                List<UserSearchResult> activeUsers = searchEJB.getUsersByDepartment(user.getDepartmentCode());
                result[0] = GenericTranslator.toTOList(activeUsers, UserSearchResultTO.class);
            }
        });

        return (List<UserSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchUsers")
    public List<UserSearchAdvancedResultTO> searchUsers(@WebParam(name = "searchParams") UserSearchParamsTO searchParams) throws SOLAFault, UnhandledFault {

        final UserSearchParamsTO searchParamsTmp = searchParams;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                UserSearchParams params = GenericTranslator.fromTO(searchParamsTmp,
                        UserSearchParams.class, null);
                List<UserSearchResult> users = searchEJB.searchUsers(params);
                result[0] = GenericTranslator.toTOList(users, UserSearchAdvancedResultTO.class);

            }
        });

        return (List<UserSearchAdvancedResultTO>) result[0];
    }

    @WebMethod(operationName = "getApplicationLog")
    public List<ApplicationLogResultTO> getApplicationLog(@WebParam(name = "applicationId") String applicationId) throws SOLAFault, UnhandledFault {

        final String applicationIdTmp = applicationId;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                List<ApplicationLogResult> log = searchEJB.getApplicationLog(applicationIdTmp);
                result[0] = GenericTranslator.toTOList(log, ApplicationLogResultTO.class);

            }
        });

        return (List<ApplicationLogResultTO>) result[0];
    }

    @WebMethod(operationName = "SearchBr")
    public List<BrSearchResultTO> searchBr(@WebParam(name = "searchParams") BrSearchParamsTO searchParams,
            @WebParam(name = "lang") String lang)
            throws SOLAFault, UnhandledFault, SOLAAccessFault {

        final Object[] params = {searchParams, lang};
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                BrSearchParamsTO searchParams = (BrSearchParamsTO) params[0];
                String lang = params[1] == null ? null : params[1].toString();
                if (searchParams != null) {
                    result[0] = GenericTranslator.toTOList(
                            searchEJB.searchBr(GenericTranslator.fromTO(searchParams, BrSearchParams.class, null), lang),
                            BrSearchResultTO.class);
                }
            }
        });

        return (List<BrSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchBaUnit")
    public List<BaUnitSearchResultTO> searchBaUnit(@WebParam(name = "searchParams") BaUnitSearchParamsTO searchParams)
            throws SOLAFault, UnhandledFault, SOLAAccessFault {

        final Object[] params = {searchParams};
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                BaUnitSearchParamsTO searchParams = (BaUnitSearchParamsTO) params[0];
                if (searchParams != null) {
                    result[0] = GenericTranslator.toTOList(
                            searchEJB.searchBaUnits(GenericTranslator.fromTO(
                            searchParams, BaUnitSearchParams.class, null)),
                            BaUnitSearchResultTO.class);
                }
            }
        });

        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "getAllBaUnitsByService")
    public List<BaUnitSearchResultTO> getAllBaUnitsByService(@WebParam(name = "serviceId") final String serviceId)
            throws SOLAFault, UnhandledFault, SOLAAccessFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                if (serviceId != null) {
                    result[0] = GenericTranslator.toTOList(
                            searchEJB.getAllBaUnitsByService(serviceId),
                            BaUnitSearchResultTO.class);
                }
            }
        });

        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "SearchCadastreObjects")
    public List<CadastreObjectSearchResultTO> SearchCadastreObjects(
            @WebParam(name = "searchBy") String searchBy,
            @WebParam(name = "searchString") String searchString)
            throws SOLAFault, UnhandledFault, SOLAAccessFault {

        final String searchByTmp = searchBy;
        final String searchStringTmp = searchString;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchCadastreObjects(searchByTmp, searchStringTmp),
                        CadastreObjectSearchResultTO.class);
            }
        });

        return (List<CadastreObjectSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "Test")
    public GenericResult Test(@WebParam(name = "lang") String lang)
            throws SOLAFault, UnhandledFault, SOLAAccessFault {

        final String langTmp = lang;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = searchEJB.getGenericResultList("test", null);
            }
        });

        return (GenericResult) result[0];
    }

    @WebMethod(operationName = "searchCadastreObecjts")
    public List<CadastreObjectSearchResultExtTO> searchCadastreObecjts(
            @WebParam(name = "langCode") final String langCode,
            @WebParam(name = "searchParams") CadastreObjectSearchParamsTO searchParams)
            throws SOLAFault, UnhandledFault {

        final CadastreObjectSearchParamsTO searchParamsTmp = searchParams;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                CadastreObjectSearchParams params = GenericTranslator.fromTO(searchParamsTmp,
                        CadastreObjectSearchParams.class, null);
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchCadastreObjects(langCode, params), CadastreObjectSearchResultExtTO.class);
            }
        });

        return (List<CadastreObjectSearchResultExtTO>) result[0];
    }

    @WebMethod(operationName = "searchCadastreObecjtsByIds")
    public List<CadastreObjectSearchResultTO> searchCadastreObecjtsByIds(
            @WebParam(name = "ids") final List<String> ids) throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchCadastreObjects(ids), CadastreObjectSearchResultTO.class);
            }
        });

        return (List<CadastreObjectSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "getLocDetails")
    public LocDetailsTO getLocDetails(@WebParam(name = "id") final String id, @WebParam(name = "current") final boolean current,
            @WebParam(name = "lang") final String lang)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(searchEJB.getLocDetails(id, current, lang), LocDetailsTO.class);
            }
        });
        return (LocDetailsTO) result[0];
    }

    @WebMethod(operationName = "searchLocs")
    public List<LocSearchResultTO> searchLocs(@WebParam(name = "searchParams") final LocSearchParamsTO searchParams)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchLocs(
                        GenericTranslator.fromTO(searchParams, LocSearchParams.class, null)),
                        LocSearchResultTO.class);
            }
        });
        return (List<LocSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchRestrictions")
    public List<RestrictionSearchResultTO> searchRestrictions(@WebParam(name = "searchParams") final RestrictionSearchParamsTO searchParams)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchRestrictions(
                        GenericTranslator.fromTO(searchParams, RestrictionSearchParams.class, null)),
                        RestrictionSearchResultTO.class);
            }
        });
        return (List<RestrictionSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchRestrictionInfo")
    public List<RestrictionInfoTO> searchRestrictionInfo(
            @WebParam(name = "searchParams") final RestrictionInfoParamsTO searchParams)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchRestrictionInfo(
                        GenericTranslator.fromTO(searchParams, RestrictionInfoParams.class, null)),
                        RestrictionInfoTO.class);
            }
        });
        return (List<RestrictionInfoTO>) result[0];
    }

    @WebMethod(operationName = "searchLandOwnersFromTo")
    public List<PartySearchResultTO> searchLandOwnersFromTo(
            @WebParam(name = "fromDate") final Date fromDate, @WebParam(name = "toDate") final Date toDate, @WebParam(name = "lang") final String lang)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchLandOwnersFromTo(fromDate, toDate, lang), PartySearchResultTO.class);
            }
        });
        return (List<PartySearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchLandOwnersUpto")
    public List<PartySearchResultTO> searchLandOwnersUpto(
            @WebParam(name = "upToDate") final Date upToDate, @WebParam(name = "lang") final String lang)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchLandOwnersUpto(upToDate, lang), PartySearchResultTO.class);
            }
        });
        return (List<PartySearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchLandOwnersFrom")
    public List<PartySearchResultTO> searchLandOwnersFrom(
            @WebParam(name = "from") final Date from, @WebParam(name = "lang") final String lang)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchLandOwnersFrom(from, lang), PartySearchResultTO.class);
            }
        });
        return (List<PartySearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchLandOwnersInFiscalYear")
    public List<PartySearchResultTO> searchLandOwnersInFiscalYear(
            @WebParam(name = "fromFiscalYear") final Date fromFiscalYear, @WebParam(name = "toFiscalYear") final Date toFiscalYear, @WebParam(name = "lang") final String lang)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchLandOwnersInFiscalYear(fromFiscalYear, toFiscalYear, lang), PartySearchResultTO.class);
            }
        });
        return (List<PartySearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchTransactionFromTo")
    public List<BaUnitSearchResultTO> searchTransactionFromTo(
            @WebParam(name = "fromDate") final Date fromDate, @WebParam(name = "toDate") final Date toDate)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchTransactionFromTo(fromDate, toDate), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchTransactionUpTo")
    public List<BaUnitSearchResultTO> searchTransactionUpTo(
            @WebParam(name = "upToDate") final Date upToDate)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchTransactionUpTo(upToDate), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchTransactionFrom")
    public List<BaUnitSearchResultTO> searchTransactionFrom(
            @WebParam(name = "from") final Date from)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchTransactionFrom(from), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchTransactionInFiscalYear")
    public List<BaUnitSearchResultTO> searchTransactionInFiscalYear(
            @WebParam(name = "frmFiscalYear") final Date frmFiscalYear, @WebParam(name = "toFiscalYear") final Date toFiscalYear)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchTransactionInFiscalYear(frmFiscalYear, toFiscalYear), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchParcelsFromTo")
    public List<BaUnitSearchResultTO> searchParcelsFromTo(
            @WebParam(name = "fromDate") final Date fromDate, @WebParam(name = "toDate") final Date toDate)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchParcelsFromTo(fromDate, toDate), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchParcelsUpTo")
    public List<BaUnitSearchResultTO> searchParcelsUpTo(
            @WebParam(name = "upToDate") final Date upToDate)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchParcelsUpTo(upToDate), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchParcelsFrom")
    public List<BaUnitSearchResultTO> searchParcelsFrom(
            @WebParam(name = "from") final Date from)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchParcelsFrom(from), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchParcelsInFiscalYear")
    public List<BaUnitSearchResultTO> searchParcelsInFiscalYear(
            @WebParam(name = "frmFiscalYear") final Date frmFiscalYear, @WebParam(name = "toFiscalYear") final Date toFiscalYear)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchParcelsInFiscalYear(frmFiscalYear, toFiscalYear), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchRegistrationGenderWiseFromTo")
    public List<BaUnitSearchResultTO> searchRegistrationGenderWiseFromTo(
            @WebParam(name = "fromDate") final Date fromDate, @WebParam(name = "toDate") final Date toDate, @WebParam(name = "genderCode") final String genderCode, @WebParam(name = "handicapped") final String handicapped, @WebParam(name = "deprived") final String deprived, @WebParam(name = "martyrs") final String martyrs)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchRegistrationGenderWiseFromTo(fromDate, toDate, genderCode, handicapped, deprived, martyrs), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchRegistrationGenderWiseUpTo")
    public List<BaUnitSearchResultTO> searchRegistrationGenderWiseUpTo(
            @WebParam(name = "upToDate") final Date upToDate, @WebParam(name = "genderCode") final String genderCode, @WebParam(name = "handicapped") final String handicapped, @WebParam(name = "deprived") final String deprived, @WebParam(name = "martyrs") final String martyrs)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchRegistrationGenderWiseUpTo(upToDate, genderCode, handicapped, deprived, martyrs), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchRegistrationGenderWiseFrom")
    public List<BaUnitSearchResultTO> searchRegistrationGenderWiseFrom(
            @WebParam(name = "from") final Date from, @WebParam(name = "genderCode") final String genderCode, @WebParam(name = "handicapped") final String handicapped, @WebParam(name = "deprived") final String deprived, @WebParam(name = "martyrs") final String martyrs)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchRegistrationGenderWiseFrom(from, genderCode, handicapped, deprived, martyrs), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchRegistrationGenderWiseInFiscalYear")
    public List<BaUnitSearchResultTO> searchRegistrationGenderWiseInFiscalYear(
            @WebParam(name = "fromFiscalYear") final Date fromFiscalYear, @WebParam(name = "toFiscalYear") final Date toFiscalYear, @WebParam(name = "genderCode") final String genderCode, @WebParam(name = "handicapped") final String handicapped, @WebParam(name = "deprived") final String deprived, @WebParam(name = "martyrs") final String martyrs)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchRegistrationGenderWiseInFiscalYear(fromFiscalYear, toFiscalYear, genderCode, handicapped, deprived, martyrs), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchParcelsSplitFromTo")
    public List<BaUnitSearchResultTO> searchParcelsSplitFromTo(
            @WebParam(name = "fromDate") final Date fromDate, @WebParam(name = "toDate") final Date toDate)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchParcelsSplitFromTo(fromDate, toDate), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchParcelsSplitUpTo")
    public List<BaUnitSearchResultTO> searchParcelsSplitUpTo(
            @WebParam(name = "upToDate") final Date upToDate)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchParcelsSplitUpTo(upToDate), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchParcelsSplitFrom")
    public List<BaUnitSearchResultTO> searchParcelsSplitFrom(
            @WebParam(name = "from") final Date from)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchParcelsSplitFrom(from), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchParcelsSplitInFiscalYear")
    public List<BaUnitSearchResultTO> searchParcelsSplitInFiscalYear(
            @WebParam(name = "frmFiscalYear") final Date frmFiscalYear, @WebParam(name = "toFiscalYear") final Date toFiscalYear)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchParcelsSplitInFiscalYear(frmFiscalYear, toFiscalYear), BaUnitSearchResultTO.class);
            }
        });
        return (List<BaUnitSearchResultTO>) result[0];
    }

    @WebMethod(operationName = "searchPlotsByWard")
    public List<CadastreObjectSearchResultExtTO> searchPlotsByWard(
            @WebParam(name = "ward_no") final String ward_no)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchPlotsByWard(ward_no), CadastreObjectSearchResultExtTO.class);
            }
        });
        return (List<CadastreObjectSearchResultExtTO>) result[0];
    }

    @WebMethod(operationName = "searchPlotsBySheetNo")
    public List<CadastreObjectSearchResultExtTO> searchPlotsBySheetNo(
            @WebParam(name = "sheet_no") final String sheet_no)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        searchEJB.searchPlotsBySheetNo(sheet_no), CadastreObjectSearchResultExtTO.class);
            }
        });
        return (List<CadastreObjectSearchResultExtTO>) result[0];
    }

    @WebMethod(operationName = "getRuleByDatasetId")
    public String getRuleByDatasetId(
            @WebParam(name = "datasetId") final String datasetId)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = searchEJB.getRuleByDatasetId(datasetId);
            }
        });
        return (String) result[0];
    }
}