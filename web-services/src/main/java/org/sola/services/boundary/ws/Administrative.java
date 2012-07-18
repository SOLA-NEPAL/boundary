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
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import org.sola.services.boundary.transferobjects.administrative.BaUnitAsPartyTO;
import org.sola.services.boundary.transferobjects.administrative.BaUnitTO;
import org.sola.services.boundary.transferobjects.administrative.LocTO;
import org.sola.services.boundary.transferobjects.administrative.MothTO;
import org.sola.services.common.ServiceConstants;
import org.sola.services.common.contracts.GenericTranslator;
import org.sola.services.common.faults.*;
import org.sola.services.common.webservices.AbstractWebService;
import org.sola.services.ejb.administrative.businesslogic.AdministrativeEJB;
import org.sola.services.ejb.administrative.businesslogic.AdministrativeEJBLocal;
import org.sola.services.ejb.administrative.repository.entities.*;
import org.sola.services.ejb.cadastre.businesslogic.CadastreEJBLocal;
import org.sola.services.ejb.source.businesslogic.SourceEJBLocal;
import org.sola.services.ejb.transaction.businesslogic.TransactionEJBLocal;
import org.sola.services.ejb.transaction.repository.entities.TransactionBasic;

/**
 * Boundary class to expose {@link AdministrativeEJB} methods.
 */
@WebService(serviceName = "administrative-service", targetNamespace = ServiceConstants.ADMINISTRATIVE_WS_NAMESPACE)
public class Administrative extends AbstractWebService {

    @EJB
    private AdministrativeEJBLocal administrativeEJB;
    @EJB
    private CadastreEJBLocal cadastreEJB;
    @EJB
    private SourceEJBLocal sourceEJB;
    @EJB
    private TransactionEJBLocal transactionEJB;
    @Resource
    private WebServiceContext wsContext;

    /**
     * Dummy method to check the web service instance is working
     */
    @WebMethod(operationName = "CheckConnection")
    public boolean CheckConnection() {
        return true;
    }

    @WebMethod(operationName = "CreateBaUnit")
    public BaUnitTO CreateBaUnit(
            @WebParam(name = "serviceId") String serviceId,
            @WebParam(name = "baUnitTO") BaUnitTO baUnitTO)
            throws SOLAFault, UnhandledFault {

        final String serviceIdTmp = serviceId;
        final BaUnitTO baUnitTOTmp = baUnitTO;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                BaUnit newBaUnit = administrativeEJB.createBaUnit(
                        serviceIdTmp,
                        GenericTranslator.fromTO(baUnitTOTmp, BaUnit.class,
                        administrativeEJB.getBaUnitById(baUnitTOTmp.getId())));
                result[0] = GenericTranslator.toTO(newBaUnit, BaUnitTO.class);
            }
        });

        return (BaUnitTO) result[0];
    }

    @WebMethod(operationName = "SaveBaUnit")
    public BaUnitTO SaveBaUnit(
            @WebParam(name = "serviceId") String serviceId,
            @WebParam(name = "baUnitTO") BaUnitTO baUnitTO)
            throws SOLAFault, UnhandledFault {

        final String serviceIdTmp = serviceId;
        final BaUnitTO baUnitTOTmp = baUnitTO;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                if (baUnitTOTmp != null) {
                    BaUnit newBaUnit = administrativeEJB.saveBaUnit(
                            serviceIdTmp,
                            GenericTranslator.fromTO(baUnitTOTmp, BaUnit.class,
                            administrativeEJB.getBaUnitById(baUnitTOTmp.getId())));
                    result[0] = GenericTranslator.toTO(newBaUnit, BaUnitTO.class);
                }
            }
        });

        return (BaUnitTO) result[0];
    }

    @WebMethod(operationName = "terminateBaUnit")
    public BaUnitTO terminateBaUnit(@WebParam(name = "baUnitId") String baUnitId,
            @WebParam(name = "serviceId") String serviceId)
            throws SOLAFault, UnhandledFault, SOLAAccessFault {

        final Object[] params = {baUnitId, serviceId};
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                String baUnitId = (String) params[0];
                String serviceId = (String) params[1];
                BaUnit baUnit = administrativeEJB.terminateBaUnit(baUnitId, serviceId);
                result[0] = GenericTranslator.toTO(baUnit, BaUnitTO.class);
            }
        });
        return (BaUnitTO) result[0];
    }

    @WebMethod(operationName = "cancelBaUnitTermination")
    public BaUnitTO cancelBaUnitTermination(@WebParam(name = "baUnitId") String baUnitId)
            throws SOLAFault, UnhandledFault, SOLAAccessFault {

        final Object[] params = {baUnitId};
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                String baUnitId = (String) params[0];
                BaUnit baUnit = administrativeEJB.cancelBaUnitTermination(baUnitId);
                result[0] = GenericTranslator.toTO(baUnit, BaUnitTO.class);
            }
        });
        return (BaUnitTO) result[0];
    }

    @WebMethod(operationName = "GetBaUnitById")
    public BaUnitTO GetBaUnitById(@WebParam(name = "id") String id)
            throws SOLAFault, UnhandledFault {

        final String idTmp = id;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(
                        administrativeEJB.getBaUnitById(idTmp), BaUnitTO.class);
            }
        });

        return (BaUnitTO) result[0];
    }

    @WebMethod(operationName = "getBaUnitsByServiceId")
    public List<BaUnitTO> getBaUnitsByServiceId(@WebParam(name = "serviceId") String serviceId)
            throws SOLAFault, UnhandledFault, SOLAAccessFault {

        final Object[] params = {serviceId};
        final Object[] result = {new ArrayList<BaUnitTO>()};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                String serviceId = (String) params[0];
                if (serviceId != null) {
                    TransactionBasic transaction = transactionEJB.getTransactionByServiceId(serviceId, false, TransactionBasic.class);
                    if (transaction != null) {
                        List<BaUnit> baUnits = administrativeEJB.getBaUnitsByTransactionId(transaction.getId());
                        result[0] = GenericTranslator.toTOList(baUnits, BaUnitTO.class);
                    }
                }
            }
        });
        return (List<BaUnitTO>) result[0];
    }

    @WebMethod(operationName = "GetBaUnitByCode")
    public BaUnitTO GetBaUnitByCode(
            @WebParam(name = "nameFirstpart") String nameFirstpart,
            @WebParam(name = "nameLastpart") String nameLastpart)
            throws SOLAFault, UnhandledFault {

        final String nameFirstpartTmp = nameFirstpart;
        final String nameLastpartTmp = nameLastpart;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(
                        administrativeEJB.getBaUnitByCode(nameFirstpartTmp,
                        nameLastpartTmp), BaUnitTO.class);
            }
        });

        return (BaUnitTO) result[0];
    }

    //<editor-fold defaultstate="collapsed" desc="By Kumar">
    //***********************************************************************************************************
    /**
     * save Moth
     */
    @WebMethod(operationName = "saveMoth")
    public MothTO saveMoth(@WebParam(name = "mothsTO") final MothTO mothsTO)
            throws SOLAFault, UnhandledFault, SOLAAccessFault, OptimisticLockingFault, SOLAValidationFault {

        final Object[] result = {null};
        final Object[] params = {mothsTO};
        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                MothTO mthTo = (MothTO) params[0];
                if (mthTo != null) {
                    //Moth mothEntity = partyEJB.getMoths(mthTo.getVdcSid(), mthTo.getMothLuj());
                    Moth mothEntity = administrativeEJB.getMoth(mthTo.getId());
                    mthTo = GenericTranslator.toTO(
                            administrativeEJB.saveMoth(
                            GenericTranslator.fromTO(mthTo, Moth.class, mothEntity)), MothTO.class);
                    result[0] = mthTo;
                }
            }
        });
        return (MothTO) result[0];
    }

    @WebMethod(operationName = "getMoth")
    public MothTO getMoth(@WebParam(name = "id") String id) throws SOLAFault, UnhandledFault {
        final String idTmp = id;
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(administrativeEJB.getMoth(idTmp), MothTO.class);
            }
        });
        return (MothTO) result[0];
    }

    @WebMethod(operationName = "getMoths")
    public List<MothTO> getMoths(@WebParam(name = "vdcCode") String vdcCode,
            @WebParam(name = "mothLuj") String mothLuj) throws SOLAFault, UnhandledFault {
        final String vdcCodeTmp = vdcCode;
        final String mothLujTmp = mothLuj;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(administrativeEJB.getMoths(vdcCodeTmp, mothLujTmp), MothTO.class);
            }
        });
        return (List<MothTO>) result[0];
    }

    @WebMethod(operationName = "getMothByVdcCodeMothLujAndMothLujNumber")
    public MothTO getMothByVdcCodeMothLujAndMothLujNumber(@WebParam(name = "vdcCode") String vdcCode,
            @WebParam(name = "mothLuj") String mothLuj, @WebParam(name = "mothLujNumber") String mothLujNumber) throws SOLAFault, UnhandledFault {
        final String vdcCodeTmp = vdcCode;
        final String mothLujTmp = mothLuj;
        final String mothLujNumberTmp = mothLujNumber;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(administrativeEJB.getMoth(vdcCodeTmp, mothLujTmp, mothLujNumberTmp), MothTO.class);
            }
        });
        return (MothTO) result[0];
    }

    /**
     * save Loc
     */
    @WebMethod(operationName = "saveLoc")
    public LocTO saveLoc(@WebParam(name = "locTO") final LocTO locTO)
            throws SOLAFault, UnhandledFault, SOLAAccessFault, OptimisticLockingFault, SOLAValidationFault {

        final Object[] result = {null};
        final Object[] params = {locTO};
        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                LocTO lcTo = (LocTO) params[0];
                if (lcTo != null) {
                    Loc locEntity = administrativeEJB.getLoc(lcTo.getId());
                    lcTo = GenericTranslator.toTO(
                            administrativeEJB.saveLoc(
                            GenericTranslator.fromTO(lcTo, Loc.class, locEntity)), LocTO.class);
                    result[0] = lcTo;
                }
            }
        });
        return (LocTO) result[0];
    }

    @WebMethod(operationName = "getLoc")
    public LocTO getLoc(@WebParam(name = "id") String id) throws SOLAFault, UnhandledFault {
        final String idTmp = id;
        final Object[] result = {null};
        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(administrativeEJB.getLoc(idTmp), LocTO.class);
            }
        });
        return (LocTO) result[0];
    }

    /**
     * save Loc
     */
    @WebMethod(operationName = "saveBaUnitTest")
    public BaUnitTO saveBaUnitTest(@WebParam(name = "baUnitTO") final BaUnitTO baUnitTO)
            throws SOLAFault, UnhandledFault, SOLAAccessFault, OptimisticLockingFault, SOLAValidationFault {

        final Object[] result = {null};
        final Object[] params = {baUnitTO};
        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                BaUnitTO buTo = (BaUnitTO) params[0];
                if (buTo != null) {
                    //Moth mothEntity = partyEJB.getMoths(mthTo.getVdcSid(), mthTo.getMothLuj());
                    BaUnit baUnitEntity = administrativeEJB.getBaUnitById(buTo.getId());
                    buTo = GenericTranslator.toTO(
                            administrativeEJB.saveBaUnit(
                            GenericTranslator.fromTO(buTo, BaUnit.class, baUnitEntity)), BaUnitTO.class);
                    result[0] = buTo;
                }
            }
        });
        return (BaUnitTO) result[0];
    }

    @WebMethod(operationName = "getLocByPageNoAndMothId")
    public LocTO getLocByPageNoAndMothId(@WebParam(name = "panaNo") int panaNo,
            @WebParam(name = "mothId") String mothId) throws SOLAFault, UnhandledFault {
        final int panaNoTmp = panaNo;
        final String mothIdTmp = mothId;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(administrativeEJB.getLocByPageNoAndMothId(panaNoTmp, mothIdTmp), LocTO.class);
            }
        });
        return (LocTO) result[0];
    }
     @WebMethod(operationName = "getLocList")
    public List<LocTO> getLocList(@WebParam(name = "mothId") String mothId ) throws SOLAFault, UnhandledFault {
        final String mothIdTmp = mothId;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(administrativeEJB.getLocList(mothIdTmp), LocTO.class);
            }
        });
        return (List<LocTO>) result[0];
    }
    //***********************************************************************************************************
    //</editor-fold>
}
