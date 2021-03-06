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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import org.sola.services.boundary.transferobjects.casemanagement.*;
import org.sola.services.common.ServiceConstants;
import org.sola.services.common.br.ValidationResult;
import org.sola.services.common.contracts.GenericTranslator;
import org.sola.services.common.faults.*;
import org.sola.services.common.webservices.AbstractWebService;
import org.sola.services.ejb.address.businesslogic.AddressEJBLocal;
import org.sola.services.ejb.application.businesslogic.ApplicationEJBLocal;
import org.sola.services.ejb.application.repository.entities.*;
import org.sola.services.ejb.party.businesslogic.PartyEJBLocal;
import org.sola.services.ejb.party.repository.entities.Party;
import org.sola.services.ejb.source.businesslogic.SourceEJBLocal;
import org.sola.services.ejb.source.repository.entities.Source;
import org.sola.services.ejb.system.businesslogic.SystemEJBLocal;
/**
 *
 * @author soladev
 */
@WebService(serviceName = "casemanagement-service", targetNamespace = ServiceConstants.CASE_MAN_WS_NAMESPACE)
public class CaseManagement extends AbstractWebService {

    @EJB
    private ApplicationEJBLocal applicationEJB;
    @EJB
    private PartyEJBLocal partyEJB;
    @EJB
    private AddressEJBLocal addressEJB;
    @EJB
    private SourceEJBLocal sourceEJB;
    @EJB
    private SystemEJBLocal systemEJB;
    @Resource
    private WebServiceContext wsContext;

    /**
     * Dummy method to check the web service instance is working
     */
    @WebMethod(operationName = "CheckConnection")
    public boolean CheckConnection() {
        return true;
    }

    @WebMethod(operationName = "CreateApplication")
    public ApplicationTO CreateApplication(@WebParam(name = "application") ApplicationTO application)
            throws SOLAFault, UnhandledFault {

        final Object[] params = {application};
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                ApplicationTO application = (ApplicationTO) params[0];
                if (application != null) {
                    Application newApp = applicationEJB.createApplication(
                            GenericTranslator.fromTO(application, Application.class,
                            applicationEJB.getApplication(application.getId())));
                    result[0] = GenericTranslator.toTO(newApp, ApplicationTO.class);
                }
            }
        });

        return (ApplicationTO) result[0];
    }

    @WebMethod(operationName = "SaveApplication")
    public ApplicationTO SaveApplication(@WebParam(name = "application") ApplicationTO application)
            throws SOLAFault, UnhandledFault, OptimisticLockingFault,
            SOLAValidationFault, SOLAAccessFault {

        final Object[] params = {application};
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                ApplicationTO application = (ApplicationTO) params[0];
                if (application != null) {

                    Application newApp = applicationEJB.saveApplication(
                            GenericTranslator.fromTO(application, Application.class,
                            applicationEJB.getApplication(application.getId())));
                    result[0] = GenericTranslator.toTO(newApp, ApplicationTO.class);
                }
            }
        });

        return (ApplicationTO) result[0];
    }

    @WebMethod(operationName = "saveSource")
    public SourceTO saveSource(@WebParam(name = "sourceTO") final SourceTO sourceTO)
            throws SOLAFault, UnhandledFault, OptimisticLockingFault,
            SOLAValidationFault, SOLAAccessFault {

        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                if (sourceTO != null) {
                    Source source = sourceEJB.saveSource(
                            GenericTranslator.fromTO(sourceTO, Source.class,
                            sourceEJB.getSourceById(sourceTO.getId())));
                    result[0] = GenericTranslator.toTO(source, SourceTO.class);
                }
            }
        });

        return (SourceTO) result[0];
    }
    
    @WebMethod(operationName = "SaveParty")
    public PartyTO SaveParty(@WebParam(name = "party") PartyTO party)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final Object[] params = {party};
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                PartyTO party = (PartyTO) params[0];
                if (party != null) {
                    Party savedParty = partyEJB.saveParty(GenericTranslator
                            .fromTO(party, Party.class, partyEJB.getParty(party.getId())));
                    result[0] = GenericTranslator.toTO(savedParty, PartyTO.class);
                }
            }
        });

        return (PartyTO) result[0];
    }

    @WebMethod(operationName = "GetLodgementView")
    public List<LodgementViewTO> getLodgementView(
            @WebParam(name = "LodgementViewParamsTO") LodgementViewParamsTO paramsTO)
            throws SOLAFault, UnhandledFault {

        final LodgementViewParamsTO paramsTOTmp = paramsTO;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                LodgementViewParams params = GenericTranslator.fromTO(paramsTOTmp, LodgementViewParams.class, null);
                List<LodgementView> appList = applicationEJB.getLodgementView(params);
                result[0] = GenericTranslator.toTOList(
                        appList, LodgementViewTO.class);
            }
        });
        return (List<LodgementViewTO>) result[0];
    }

    @WebMethod(operationName = "GetLodgementTiming")
    public List<LodgementTimingTO> getLodgementTiming(
            @WebParam(name = "LodgementViewParamsTO") LodgementViewParamsTO paramsTO)
            throws SOLAFault, UnhandledFault {

        final LodgementViewParamsTO paramsTOTmp = paramsTO;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                LodgementViewParams params = GenericTranslator.fromTO(paramsTOTmp, LodgementViewParams.class, null);
                List<LodgementTiming> appList = applicationEJB.getLodgementTiming(params);
                result[0] = GenericTranslator.toTOList(
                        appList, LodgementTimingTO.class);
            }
        });
        return (List<LodgementTimingTO>) result[0];
    }

    @WebMethod(operationName = "GetAddress")
    public AddressTO GetAddress(@WebParam(name = "id") String id) throws SOLAFault, UnhandledFault {

        final String idTmp = id;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(addressEJB.getAddress(idTmp),
                        AddressTO.class);
            }
        });

        return (AddressTO) result[0];
    }

    @WebMethod(operationName = "GetApplication")
    public ApplicationTO GetApplication(@WebParam(name = "id") String id)
            throws SOLAFault, UnhandledFault {

        final String idTmp = id;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(applicationEJB.getApplication(idTmp),
                        ApplicationTO.class);
            }
        });

        return (ApplicationTO) result[0];
    }

    @WebMethod(operationName = "GetParty")
    public PartyTO GetParty(@WebParam(name = "id") String id) throws SOLAFault, UnhandledFault {

        final String idTmp = id;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(partyEJB.getParty(idTmp), PartyTO.class);
            }
        });

        return (PartyTO) result[0];
    }

    @WebMethod(operationName = "GetAgents")
    public List<PartySummaryTO> GetAgents() throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(partyEJB.getAgents(),
                        PartySummaryTO.class);
            }
        });

        return (List<PartySummaryTO>) result[0];
    }

    @WebMethod(operationName = "GetUserActions")
    public List<ApplicationLogTO> getUserActions(@WebParam(name = "userName") String user,
            @WebParam(name = "from") Date from,
            @WebParam(name = "to") Date to)
            throws SOLAFault, UnhandledFault {

        final String userTmp = user;
        final Date fromTmp = from;
        final Date toTmp = to;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        applicationEJB.getUserActions(userTmp, fromTmp, toTmp),
                        ApplicationLogTO.class);
            }
        });

        return (List<ApplicationLogTO>) result[0];
    }

    @WebMethod(operationName = "AttachSourceToTransaction")
    public SourceTO AttachSourceToTransaction(
            @WebParam(name = "serviceId") String serviceId,
            @WebParam(name = "sourceId") String sourceId,
            @WebParam(name = "languageCode") String languageCode)
            throws SOLAValidationFault, OptimisticLockingFault, SOLAFault, UnhandledFault, SOLAAccessFault {

        final String serviceIdTmp = serviceId;
        final String sourceIdTmp = sourceId;
        final String languageCodeTmp = languageCode;

        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(
                        sourceEJB.attachSourceToTransaction(serviceIdTmp, sourceIdTmp, languageCodeTmp),
                        SourceTO.class);
            }
        });

        return (SourceTO) result[0];
    }

    @WebMethod(operationName = "DettachSourceFromTransaction")
    public boolean DettachSourceFromTransaction(
            @WebParam(name = "sourceId") String sourceId)
            throws SOLAValidationFault, OptimisticLockingFault, SOLAFault, UnhandledFault {

        final String sourceIdTmp = sourceId;
        final boolean[] result = {false};

        runBooleanMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = sourceEJB.dettachSourceFromTransaction(sourceIdTmp);
            }
        });

        return result[0];
    }

    @WebMethod(operationName = "GetSourcesByServiceId")
    public List<SourceTO> GetSourcesByServiceId(
            @WebParam(name = "serviceId") String serviceId) throws SOLAFault, UnhandledFault {

        final String serviceIdTmp = serviceId;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        sourceEJB.getSourcesByServiceId(serviceIdTmp),
                        SourceTO.class);
            }
        });

        return (List<SourceTO>) result[0];
    }

    @WebMethod(operationName = "GetSourcesByIds")
    public List<SourceTO> GetSourcesByIds(
            @WebParam(name = "sourceIds") List<String> sourceIds) throws SOLAFault, UnhandledFault {

        final List<String> sourceIdsTmp = sourceIds;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        sourceEJB.getSourcesByIds(sourceIdsTmp),
                        SourceTO.class);
            }
        });

        return (List<SourceTO>) result[0];
    }

    @WebMethod(operationName = "getSourceById")
    public SourceTO getSourceById(
            @WebParam(name = "id") final String sourceId) throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(
                        sourceEJB.getSourceById(sourceId), SourceTO.class);
            }
        });

        return (SourceTO) result[0];
    }
    
    @WebMethod(operationName = "ServiceActionComplete")
    public List<ValidationResult> ServiceActionComplete(
            @WebParam(name = "serviceId") String serviceId,
            @WebParam(name = "languageCode") String languageCode,
            @WebParam(name = "rowVersion") int rowVersion)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final String serviceIdTmp = serviceId;
        final String languageCodeTmp = languageCode;
        final int rowVersionTmp = rowVersion;
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = applicationEJB.serviceActionComplete(
                        serviceIdTmp, languageCodeTmp, rowVersionTmp);
            }
        });

        return (List<ValidationResult>) result[0];
    }

    @WebMethod(operationName = "ServiceActionCancel")
    public List<ValidationResult> ServiceActionCancel(
            @WebParam(name = "serviceId") String serviceId,
            @WebParam(name = "languageCode") String languageCode,
            @WebParam(name = "rowVersion") int rowVersion)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final String serviceIdTmp = serviceId;
        final String languageCodeTmp = languageCode;
        final int rowVersionTmp = rowVersion;
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = applicationEJB.serviceActionCancel(
                        serviceIdTmp, languageCodeTmp, rowVersionTmp);
            }
        });

        return (List<ValidationResult>) result[0];
    }

    @WebMethod(operationName = "ServiceActionRevert")
    public List<ValidationResult> ServiceActionRevert(
            @WebParam(name = "serviceId") String serviceId,
            @WebParam(name = "languageCode") String languageCode,
            @WebParam(name = "rowVersion") int rowVersion)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final String serviceIdTmp = serviceId;
        final String languageCodeTmp = languageCode;
        final int rowVersionTmp = rowVersion;
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = applicationEJB.serviceActionRevert(
                        serviceIdTmp, languageCodeTmp, rowVersionTmp);
            }
        });

        return (List<ValidationResult>) result[0];
    }

    @WebMethod(operationName = "ServiceActionStart")
    public List<ValidationResult> ServiceActionStart(
            @WebParam(name = "serviceId") String serviceId,
            @WebParam(name = "languageCode") String languageCode,
            @WebParam(name = "rowVersion") int rowVersion)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final String serviceIdTmp = serviceId;
        final String languageCodeTmp = languageCode;
        final int rowVersionTmp = rowVersion;
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = applicationEJB.serviceActionStart(
                        serviceIdTmp, languageCodeTmp, rowVersionTmp);
            }
        });

        return (List<ValidationResult>) result[0];
    }

    @WebMethod(operationName = "ApplicationActionCancel")
    public List<ValidationResult> ApplicationActionCancel(
            @WebParam(name = "applicationId") String applicationId,
            @WebParam(name = "languageCode") String languageCode,
            @WebParam(name = "rowVersion") int rowVersion)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final String applicationIdTmp = applicationId;
        final String languageCodeTmp = languageCode;
        final int rowVersionTmp = rowVersion;
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = applicationEJB.applicationActionCancel(
                        applicationIdTmp, languageCodeTmp, rowVersionTmp);
            }
        });

        return (List<ValidationResult>) result[0];
    }

    @WebMethod(operationName = "ApplicationActionValidate")
    public List<ValidationResult> ApplicationActionValidate(
            @WebParam(name = "applicationId") String applicationId,
            @WebParam(name = "languageCode") String languageCode,
            @WebParam(name = "rowVersion") int rowVersion)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final String applicationIdTmp = applicationId;
        final String languageCodeTmp = languageCode;
        final int rowVersionTmp = rowVersion;
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = applicationEJB.applicationActionValidate(
                        applicationIdTmp, languageCodeTmp, rowVersionTmp);
            }
        });

        return (List<ValidationResult>) result[0];
    }

    @WebMethod(operationName = "ApplicationActionApprove")
    public List<ValidationResult> ApplicationActionApprove(
            @WebParam(name = "applicationId") String applicationId,
            @WebParam(name = "languageCode") String languageCode,
            @WebParam(name = "rowVersion") int rowVersion)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final String applicationIdTmp = applicationId;
        final String languageCodeTmp = languageCode;
        final int rowVersionTmp = rowVersion;
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = applicationEJB.applicationActionApprove(
                        applicationIdTmp, languageCodeTmp, rowVersionTmp);
            }
        });

        return (List<ValidationResult>) result[0];
    }

    @WebMethod(operationName = "ApplicationActionArchive")
    public List<ValidationResult> ApplicationActionArchive(
            @WebParam(name = "applicationId") String applicationId,
            @WebParam(name = "languageCode") String languageCode,
            @WebParam(name = "rowVersion") int rowVersion)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final String applicationIdTmp = applicationId;
        final String languageCodeTmp = languageCode;
        final int rowVersionTmp = rowVersion;
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = applicationEJB.applicationActionArchive(
                        applicationIdTmp, languageCodeTmp, rowVersionTmp);
            }
        });

        return (List<ValidationResult>) result[0];
    }

    @WebMethod(operationName = "ApplicationActionAssign")
    public List<ValidationResult> ApplicationActionAssign(
            @WebParam(name = "applicationIds") final String applicationId,
            @WebParam(name = "userId") final String userId,
            @WebParam(name = "languageCode") final String languageCode,
            @WebParam(name = "rowVersion") final int rowVersion)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = applicationEJB.applicationActionAssign(
                        applicationId, userId, languageCode, rowVersion);
            }
        });
        return (List<ValidationResult>) result[0];
    }

    @WebMethod(operationName = "ApplicationActionAssignBulk")
    public List<ValidationResult> ApplicationActionAssignBulk(
            @WebParam(name = "applicationIds") final List<ActionedApplicationTO> actionedApplications,
            @WebParam(name = "userId") final String userId,
            @WebParam(name = "languageCode") final String languageCode)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = applicationEJB.applicationActionAssignBulk(
                        GenericTranslator.fromTOList(actionedApplications, 
                        ActionedApplication.class, new ArrayList<ActionedApplication>()), 
                        userId, languageCode);
            }
        });
        return (List<ValidationResult>) result[0];
    }
    
    @WebMethod(operationName = "ApplicationActionTransfer")
    public List<ValidationResult> ApplicationActionTransfer(
            @WebParam(name = "actionedApplications") final String applicationId,
            @WebParam(name = "userId") final String userId,
            @WebParam(name = "languageCode") final String languageCode,
            @WebParam(name = "rowVersion") final int rowVersion)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = applicationEJB.applicationActionTransfer(
                        applicationId, userId, languageCode, rowVersion);
            }
        });
        return (List<ValidationResult>) result[0];
    }
    
    @WebMethod(operationName = "ApplicationActionTransferBulk")
    public List<ValidationResult> ApplicationActionTransferBulk(
            @WebParam(name = "applicationIds") final List<ActionedApplicationTO> actionedApplications,
            @WebParam(name = "userId") final String userId,
            @WebParam(name = "languageCode") final String languageCode)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = applicationEJB.applicationActionTransferBulk(
                        GenericTranslator.fromTOList(actionedApplications, 
                        ActionedApplication.class, new ArrayList<ActionedApplication>()), 
                        userId, languageCode);
            }
        });
        return (List<ValidationResult>) result[0];
    }

    @WebMethod(operationName = "GetAllBrs")
    public List<BrReportTO> GetAllBrs() throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(systemEJB.getAllBrs(),
                        BrReportTO.class);
            }
        });

        return (List<BrReportTO>) result[0];
    }

    @WebMethod(operationName = "SaveInformationService")
    public ServiceTO SaveInformationService(
            @WebParam(name = "service") ServiceTO service,
            @WebParam(name = "languageCode") String languageCode)
            throws SOLAFault, UnhandledFault, SOLAAccessFault,
            OptimisticLockingFault, SOLAValidationFault {

        final String languageCodeTmp = languageCode;
        final ServiceTO serviceTmp = service;
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                ServiceTO service = serviceTmp;
                String languageCode = languageCodeTmp;
                if (service != null) {
                    Service serverResult = applicationEJB.saveInformationService(
                            GenericTranslator.fromTO(service, Service.class, null),
                            languageCode);
                    result[0] = GenericTranslator.toTO(serverResult, ServiceTO.class);
                }
            }
        });

        return (ServiceTO) result[0];
    }
    }  
    
    

