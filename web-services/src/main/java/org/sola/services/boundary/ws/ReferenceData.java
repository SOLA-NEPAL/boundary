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

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import org.sola.common.RolesConstants;
import org.sola.services.boundary.transferobjects.referencedata.*;
import org.sola.services.common.ServiceConstants;
import org.sola.services.common.contracts.AbstractCodeTO;
import org.sola.services.common.contracts.GenericTranslator;
import org.sola.services.common.faults.FaultUtility;
import org.sola.services.common.faults.SOLAFault;
import org.sola.services.common.faults.UnhandledFault;
import org.sola.services.common.repository.entities.AbstractCodeEntity;
import org.sola.services.common.webservices.AbstractWebService;
import org.sola.services.ejb.administrative.businesslogic.AdministrativeEJBLocal;
import org.sola.services.ejb.administrative.repository.entities.*;
import org.sola.services.ejb.application.businesslogic.ApplicationEJBLocal;
import org.sola.services.ejb.application.repository.entities.*;
import org.sola.services.ejb.cadastre.businesslogic.CadastreEJBLocal;
import org.sola.services.ejb.cadastre.repository.entities.CadastreObjectType;
import org.sola.services.ejb.party.businesslogic.PartyEJBLocal;
import org.sola.services.ejb.party.repository.entities.*;
import org.sola.services.ejb.source.businesslogic.SourceEJBLocal;
import org.sola.services.ejb.source.repository.entities.AvailabilityStatus;
import org.sola.services.ejb.source.repository.entities.PresentationFormType;
import org.sola.services.ejb.source.repository.entities.SourceType;
import org.sola.services.ejb.system.businesslogic.SystemEJBLocal;
import org.sola.services.ejb.system.repository.entities.BrSeverityType;
import org.sola.services.ejb.system.repository.entities.BrTechnicalType;
import org.sola.services.ejb.system.repository.entities.BrValidationTargetType;
import org.sola.services.ejb.transaction.businesslogic.TransactionEJBLocal;
import org.sola.services.ejb.transaction.repository.entities.RegistrationStatusType;
import org.sola.services.ejbs.admin.businesslogic.AdminEJBLocal;
import org.sola.services.ejbs.admin.businesslogic.repository.entities.Department;
import org.sola.services.ejbs.admin.businesslogic.repository.entities.District;
import org.sola.services.ejbs.admin.businesslogic.repository.entities.Office;
import org.sola.services.ejbs.admin.businesslogic.repository.entities.Vdc;

@WebService(serviceName = "referencedata-service", targetNamespace = ServiceConstants.REF_DATA_WS_NAMESPACE)
public class ReferenceData extends AbstractWebService {

    @EJB
    ApplicationEJBLocal applicationEJB;
    @EJB
    PartyEJBLocal partyEJB;
    @EJB
    SourceEJBLocal sourceEJB;
    @EJB
    AdministrativeEJBLocal administrativeEJB;
    @EJB
    CadastreEJBLocal cadastreEJB;
    @EJB
    TransactionEJBLocal transactionEJB;
    @EJB
    SystemEJBLocal systemEJB;
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

    @WebMethod(operationName = "GetCommunicationTypes")
    public List<CommunicationTypeTO> GetCommunicationTypes(String languageCode)
            throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        partyEJB.getCommunicationTypes(languageCodeTmp),
                        CommunicationTypeTO.class);
            }
        });

        return (List<CommunicationTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetGenderTypes")
    public List<GenderTypeTO> GetGenderTypes(String languageCode)
            throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        partyEJB.getGenderTypes(languageCodeTmp),
                        GenderTypeTO.class);
            }
        });

        return (List<GenderTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetAvailabilityStatusList")
    public List<AvailabilityStatusTO> GetAvailabilityStatusList(String languageCode)
            throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        sourceEJB.getAvailabilityStatusList(languageCodeTmp),
                        AvailabilityStatusTO.class);
            }
        });

        return (List<AvailabilityStatusTO>) result[0];
    }

    @WebMethod(operationName = "GetPresentationFormTypes")
    public List<PresentationFormTypeTO> GetPresentationFormTypes(String languageCode) throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        sourceEJB.getPresentationFormTypes(languageCodeTmp),
                        PresentationFormTypeTO.class);
            }
        });

        return (List<PresentationFormTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetRequestTypes")
    public List<RequestTypeTO> GetRequestTypes(String languageCode) throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        applicationEJB.getRequestTypes(languageCodeTmp), RequestTypeTO.class);
            }
        });

        return (List<RequestTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetRequestCategoryTypes")
    public List<RequestCategoryTypeTO> GetRequestCategoryTypes(String languageCode)
            throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        applicationEJB.getRequestCategoryTypes(languageCodeTmp), RequestCategoryTypeTO.class);
            }
        });

        return (List<RequestCategoryTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetSourceTypes")
    public List<SourceTypeTO> GetSourceTypes(String languageCode) throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        sourceEJB.getSourceTypes(languageCodeTmp), SourceTypeTO.class);
            }
        });

        return (List<SourceTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetApplicationStatusTypes")
    public List<ApplicationStatusTypeTO> GetApplicationStatusTypes(String languageCode)
            throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        applicationEJB.getApplicationStatusTypes(languageCodeTmp),
                        ApplicationStatusTypeTO.class);
            }
        });

        return (List<ApplicationStatusTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetApplicationActionTypes")
    public List<ApplicationActionTypeTO> GetApplicationActionTypes(String languageCode)
            throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        applicationEJB.getApplicationActionTypes(languageCodeTmp),
                        ApplicationActionTypeTO.class);
            }
        });

        return (List<ApplicationActionTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetServiceStatusTypes")
    public List<ServiceStatusTypeTO> GetServiceStatusTypes(String languageCode)
            throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        applicationEJB.getServiceStatusTypes(languageCodeTmp),
                        ServiceStatusTypeTO.class);
            }
        });

        return (List<ServiceStatusTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetServiceActionTypes")
    public List<ServiceActionTypeTO> GetServiceActionTypes(String languageCode)
            throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        applicationEJB.getServiceActionTypes(languageCodeTmp),
                        ServiceActionTypeTO.class);
            }
        });

        return (List<ServiceActionTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetPartyTypes")
    public List<PartyTypeTO> GetPartyTypes(String languageCode) throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        partyEJB.getPartyTypes(languageCodeTmp), PartyTypeTO.class);
            }
        });

        return (List<PartyTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetPartyRoles")
    public List<PartyRoleTypeTO> GetPartyRoles(String languageCode) throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        partyEJB.getPartyRoles(languageCodeTmp), PartyRoleTypeTO.class);
            }
        });

        return (List<PartyRoleTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetIdTypes")
    public List<IdTypeTO> GetIdTypes(String languageCode) throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        partyEJB.getIdTypes(languageCodeTmp), IdTypeTO.class);
            }
        });

        return (List<IdTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetBaUnitTypes")
    public List<BaUnitTypeTO> GetBaUnitTypes(String languageCode) throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        administrativeEJB.getBaUnitTypes(languageCodeTmp), BaUnitTypeTO.class);
            }
        });

        return (List<BaUnitTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetChangeStatuTypes")
    public List<ChangeStatusTypeTO> GetChangeStatuTypes(String languageCode) throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        administrativeEJB.getChangeStatusTypes(languageCodeTmp),
                        ChangeStatusTypeTO.class);
            }
        });

        return (List<ChangeStatusTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetMortgageTypes")
    public List<MortgageTypeTO> GetMortgageTypes(String languageCode) throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        administrativeEJB.getMortgageTypes(languageCodeTmp), MortgageTypeTO.class);
            }
        });

        return (List<MortgageTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetRRRGroupTypes")
    public List<RrrGroupTypeTO> GetRRRGroupTypes(String languageCode) throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        administrativeEJB.getRRRGroupTypes(languageCodeTmp), RrrGroupTypeTO.class);
            }
        });

        return (List<RrrGroupTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetRRRTypes")
    public List<RrrTypeTO> GetRRRTypes(String languageCode) throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        administrativeEJB.getRRRTypes(languageCodeTmp), RrrTypeTO.class);
            }
        });

        return (List<RrrTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetRegistrationStatusTypes")
    public List<RegistrationStatusTypeTO> GetRegistrationStatusTypes(String languageCode)
            throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        transactionEJB.getRegistrationStatusTypes(languageCodeTmp),
                        RegistrationStatusTypeTO.class);
            }
        });

        return (List<RegistrationStatusTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetCadastreObjectTypes")
    public List<CadastreObjectTypeTO> GetCadastreObjectTypes(String languageCode)
            throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        cadastreEJB.getCadastreObjectTypes(languageCodeTmp),
                        CadastreObjectTypeTO.class);
            }
        });

        return (List<CadastreObjectTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetTypeActions")
    public List<TypeActionTO> GetTypeActions(String languageCode)
            throws SOLAFault, UnhandledFault {

        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        applicationEJB.getTypeActions(languageCodeTmp),
                        TypeActionTO.class);
            }
        });

        return (List<TypeActionTO>) result[0];
    }

    @WebMethod(operationName = "GetBrTechnicalTypes")
    public List<BrTechnicalTypeTO> GetBrTechnicalTypes(@WebParam(name = "languageCode") String languageCode)
            throws SOLAFault, UnhandledFault {
        final Object[] params = {languageCode};
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                String languageCode = params[0] == null ? null : params[0].toString();
                result[0] = GenericTranslator.toTOList(systemEJB.getCodeEntityList(
                        BrTechnicalType.class, languageCode), BrTechnicalTypeTO.class);
            }
        });

        return (List<BrTechnicalTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetBrValidationTargetTypes")
    public List<BrValidationTargetTypeTO> GetBrValidationTargetTypes(@WebParam(name = "languageCode") String languageCode)
            throws SOLAFault, UnhandledFault {
        final Object[] params = {languageCode};
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                String languageCode = params[0] == null ? null : params[0].toString();
                result[0] = GenericTranslator.toTOList(systemEJB.getCodeEntityList(
                        BrValidationTargetType.class, languageCode), BrValidationTargetTypeTO.class);
            }
        });

        return (List<BrValidationTargetTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetBrSeverityTypes")
    public List<BrSeverityTypeTO> GetBrSeverityTypes(@WebParam(name = "languageCode") String languageCode)
            throws SOLAFault, UnhandledFault {
        final Object[] params = {languageCode};
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                String languageCode = params[0] == null ? null : params[0].toString();
                result[0] = GenericTranslator.toTOList(systemEJB.getCodeEntityList(
                        BrSeverityType.class, languageCode), BrSeverityTypeTO.class);
            }
        });

        return (List<BrSeverityTypeTO>) result[0];
    }

    @WebMethod(operationName = "GetBaUnitRelTypes")
    public List<BaUnitRelTypeTO> GetBaUnitRelTypes(@WebParam(name = "languageCode") String languageCode)
            throws SOLAFault, UnhandledFault {
        final Object[] params = {languageCode};
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                String languageCode = params[0] == null ? null : params[0].toString();
                result[0] = GenericTranslator.toTOList(administrativeEJB.getCodeEntityList(
                        BaUnitRelType.class, languageCode), BaUnitRelTypeTO.class);
            }
        });

        return (List<BaUnitRelTypeTO>) result[0];
    }

    @WebMethod(operationName = "getOffices")
    public List<OfficeTO> getOffices(@WebParam(name = "languageCode") String languageCode)
            throws SOLAFault, UnhandledFault {
        final Object[] params = {languageCode};
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                String languageCode = params[0] == null ? null : params[0].toString();
                result[0] = GenericTranslator.toTOList(adminEJB.getCodeEntityList(
                        Office.class, languageCode), OfficeTO.class);
            }
        });

        return (List<OfficeTO>) result[0];
    }

    @WebMethod(operationName = "getDistricts")
    public List<DistrictTO> getDistricts(@WebParam(name = "languageCode") String languageCode)
            throws SOLAFault, UnhandledFault {
        final Object[] params = {languageCode};
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                String languageCode = params[0] == null ? null : params[0].toString();
                result[0] = GenericTranslator.toTOList(adminEJB.getCodeEntityList(
                        District.class, languageCode), DistrictTO.class);
            }
        });

        return (List<DistrictTO>) result[0];
    }

    @WebMethod(operationName = "getDepartments")
    public List<DepartmentTO> getDepartments(@WebParam(name = "officeCode") final String officeCode,
            @WebParam(name = "languageCode") final String languageCode)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(adminEJB.getDepartments(officeCode, languageCode), DepartmentTO.class);
            }
        });

        return (List<DepartmentTO>) result[0];
    }

    @WebMethod(operationName = "getVdcs")
    public List<VdcTO> getVdcs(@WebParam(name = "districtCode") final String districtCode,
            @WebParam(name = "languageCode") final String languageCode)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(adminEJB.getVdcs(districtCode, languageCode), VdcTO.class);
            }
        });

        return (List<VdcTO>) result[0];
    }

    @WebMethod(operationName = "getOfficeCode")
    public List<Integer> getOfficeCode()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {

                result[0] = adminEJB.getOfficeCode();
            }
        });

        return (List<Integer>) result[0];
    }

    @WebMethod(operationName = "getOfficeNames")
    public List<String> getOfficeNames()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {

                result[0] = adminEJB.getOfficeNames();
            }
        });

        return (List<String>) result[0];
    }

    @WebMethod(operationName = "getDistrictNames")
    public List<String> getDistrictNames()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {

                result[0] = adminEJB.getDistrictNames();
            }
        });

        return (List<String>) result[0];
    }

    @WebMethod(operationName = "getDistrictCodes")
    public List<Integer> getDistrictCodes()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {

                result[0] = adminEJB.getDistrictCodes();
            }
        });

        return (List<Integer>) result[0];
    }

    @WebMethod(operationName = "getVdcList")
    public List<VdcTO> getVdcList()
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(adminEJB.getVdcList(), VdcTO.class);
            }
        });
        return (List<VdcTO>) result[0];
    }

    @WebMethod(operationName = "getVdcByCode")
    public VdcTO getVdcByCode(@WebParam(name = "id") final String id)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(adminEJB.getVdcByCode(
                        id), VdcTO.class);
            }
        });

        return (VdcTO) result[0];
    }
    @WebMethod(operationName = "getVdcByName")
    public VdcTO getVdcByName(@WebParam(name = "name") final String name)
            throws SOLAFault, UnhandledFault {
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(adminEJB.getVdcByName(
                        name), VdcTO.class);
            }
        });

        return (VdcTO) result[0];
    }

    @RolesAllowed(RolesConstants.ADMIN_MANAGE_REFDATA)
    @WebMethod(operationName = "saveReferenceData")
    public AbstractCodeTO saveReferenceData(AbstractCodeTO refDataTO)
            throws SOLAFault, UnhandledFault {

        try {
            try {
                beginTransaction();
                AbstractCodeTO result = null;
                AbstractCodeEntity codeEntity = null;

                if (refDataTO instanceof CommunicationTypeTO) {
                    codeEntity = partyEJB.getCodeEntity(CommunicationType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, CommunicationType.class, codeEntity);
                    partyEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof GenderTypeTO) {
                    codeEntity = partyEJB.getCodeEntity(GenderType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, GenderType.class, codeEntity);
                    partyEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof IdTypeTO) {
                    codeEntity = partyEJB.getCodeEntity(IdType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, IdType.class, codeEntity);
                    partyEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof PartyRoleTypeTO) {
                    codeEntity = partyEJB.getCodeEntity(PartyRoleType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, PartyRoleType.class, codeEntity);
                    partyEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof PartyTypeTO) {
                    codeEntity = partyEJB.getCodeEntity(PartyType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, PartyType.class, codeEntity);
                    partyEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof BaUnitTypeTO) {
                    codeEntity = administrativeEJB.getCodeEntity(BaUnitType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, BaUnitType.class, codeEntity);
                    administrativeEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof MortgageTypeTO) {
                    codeEntity = administrativeEJB.getCodeEntity(MortgageType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, MortgageType.class, codeEntity);
                    administrativeEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof RrrGroupTypeTO) {
                    codeEntity = administrativeEJB.getCodeEntity(RrrGroupType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, RrrGroupType.class, codeEntity);
                    administrativeEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof RrrTypeTO) {
                    codeEntity = administrativeEJB.getCodeEntity(RrrType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, RrrType.class, codeEntity);
                    administrativeEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof ApplicationActionTypeTO) {
                    codeEntity = applicationEJB.getCodeEntity(ApplicationActionType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, ApplicationActionType.class, codeEntity);
                    applicationEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof ApplicationStatusTypeTO) {
                    codeEntity = applicationEJB.getCodeEntity(ApplicationStatusType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, ApplicationStatusType.class, codeEntity);
                    applicationEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof RequestCategoryTypeTO) {
                    codeEntity = applicationEJB.getCodeEntity(RequestCategoryType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, RequestCategoryType.class, codeEntity);
                    applicationEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof RequestTypeTO) {
                    codeEntity = applicationEJB.getCodeEntity(RequestType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, RequestType.class, codeEntity);
                    applicationEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof TypeActionTO) {
                    codeEntity = applicationEJB.getCodeEntity(TypeAction.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, TypeAction.class, codeEntity);
                    applicationEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof ServiceActionTypeTO) {
                    codeEntity = applicationEJB.getCodeEntity(ServiceActionType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, ServiceActionType.class, codeEntity);
                    applicationEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof ServiceStatusTypeTO) {
                    codeEntity = applicationEJB.getCodeEntity(ServiceStatusType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, ServiceStatusType.class, codeEntity);
                    applicationEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof CadastreObjectTypeTO) {
                    codeEntity = cadastreEJB.getCodeEntity(CadastreObjectType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, CadastreObjectType.class, codeEntity);
                    cadastreEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof SourceTypeTO) {
                    codeEntity = sourceEJB.getCodeEntity(SourceType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, SourceType.class, codeEntity);
                    sourceEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof AvailabilityStatusTO) {
                    codeEntity = sourceEJB.getCodeEntity(AvailabilityStatus.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, AvailabilityStatus.class, codeEntity);
                    sourceEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof PresentationFormTypeTO) {
                    codeEntity = sourceEJB.getCodeEntity(PresentationFormType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, PresentationFormType.class, codeEntity);
                    sourceEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof RegistrationStatusTypeTO) {
                    codeEntity = transactionEJB.getCodeEntity(RegistrationStatusType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, RegistrationStatusType.class, codeEntity);
                    transactionEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof BrSeverityTypeTO) {
                    codeEntity = systemEJB.getCodeEntity(BrSeverityType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, BrSeverityType.class, codeEntity);
                    systemEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof BrTechnicalTypeTO) {
                    codeEntity = systemEJB.getCodeEntity(BrTechnicalType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, BrTechnicalType.class, codeEntity);
                    systemEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof BrValidationTargetTypeTO) {
                    codeEntity = systemEJB.getCodeEntity(BrValidationTargetType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, BrValidationTargetType.class, codeEntity);
                    systemEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof BaUnitRelTypeTO) {
                    codeEntity = administrativeEJB.getCodeEntity(BaUnitRelType.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, BaUnitRelType.class, codeEntity);
                    administrativeEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof VdcTO) {
                    codeEntity = adminEJB.getCodeEntity(Vdc.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, Vdc.class, codeEntity);
                    adminEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof OfficeTO) {
                    codeEntity = adminEJB.getCodeEntity(Office.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, Office.class, codeEntity);
                    adminEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof DistrictTO) {
                    codeEntity = adminEJB.getCodeEntity(District.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, District.class, codeEntity);
                    adminEJB.saveCodeEntity(codeEntity);
                } else if (refDataTO instanceof DepartmentTO) {
                    codeEntity = adminEJB.getCodeEntity(Department.class, refDataTO.getCode());
                    codeEntity = GenericTranslator.fromTO(refDataTO, Department.class, codeEntity);
                    adminEJB.saveCodeEntity(codeEntity);
                }

                result = GenericTranslator.toTO(codeEntity, refDataTO.getClass());
                commitTransaction();
                return result;

            } finally {
                rollbackTransaction();
            }
        } catch (Throwable t) {
            Throwable fault = FaultUtility.ProcessException(t);
            if (fault.getClass() == SOLAFault.class) {
                throw (SOLAFault) fault;
            }
            throw (UnhandledFault) fault;
        } finally {
            cleanUp();
        }
    }
}
