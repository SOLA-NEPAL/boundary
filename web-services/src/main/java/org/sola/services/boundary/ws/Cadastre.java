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
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import org.sola.services.boundary.transferobjects.cadastre.CadastreObjectNodeTO;
import org.sola.services.boundary.transferobjects.cadastre.CadastreObjectTO;
import org.sola.services.boundary.transferobjects.cadastre.MapSheetTO;
import org.sola.services.boundary.transferobjects.cadastre.PropertySummaryTO;
import org.sola.services.boundary.transferobjects.transaction.TransactionCadastreChangeTO;
import org.sola.services.boundary.transferobjects.transaction.TransactionCadastreRedefinitionTO;
import org.sola.services.common.ServiceConstants;
import org.sola.services.common.br.ValidationResult;
import org.sola.services.common.contracts.GenericTranslator;
import org.sola.services.common.faults.*;
import org.sola.services.common.webservices.AbstractWebService;
import org.sola.services.ejb.cadastre.businesslogic.CadastreEJBLocal;
import org.sola.services.ejb.cadastre.repository.entities.CadastreObject;
import org.sola.services.ejb.cadastre.repository.entities.MapSheet;
import org.sola.services.ejb.transaction.businesslogic.TransactionEJBLocal;
import org.sola.services.ejb.transaction.repository.entities.TransactionCadastreChange;
import org.sola.services.ejb.transaction.repository.entities.TransactionCadastreRedefinition;
import org.sola.services.ejb.transaction.repository.entities.TransactionType;

/**
 *
 * @author soladev
 */
@WebService(serviceName = "cadastre-service", targetNamespace = ServiceConstants.CADASTRE_WS_NAMESPACE)
public class Cadastre extends AbstractWebService {

    @EJB
    private CadastreEJBLocal cadastreEJB;
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

    @WebMethod(operationName = "SearchProperty")
    public PropertySummaryTO SearchProperty(
            @WebParam(name = "nameFirstPart") String nameFirstPart,
            @WebParam(name = "nameLastPart") String nameLastPart)
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = PropertySummaryTO.class;
            }
        });

        return (PropertySummaryTO) result[0];
    }

    @WebMethod(operationName = "GetCadastreObjectByParts")
    public List<CadastreObjectTO> GetCadastreObjectByParts(
            @WebParam(name = "searchString") String searchString)
            throws SOLAFault, UnhandledFault {

        final String searchStringTmp = searchString;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        cadastreEJB.getCadastreObjectByParts(searchStringTmp),
                        CadastreObjectTO.class);
            }
        });

        return (List<CadastreObjectTO>) result[0];
    }

    @WebMethod(operationName = "GetCadastreObjectByPoint")
    public CadastreObjectTO GetCadastreObjectByPoint(
            @WebParam(name = "x") double x,
            @WebParam(name = "y") double y,
            @WebParam(name = "srid") int srid)
            throws SOLAFault, UnhandledFault {

        final double xTmp = x;
        final double yTmp = y;
        final int sridTmp = srid;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(
                        cadastreEJB.getCadastreObjectByPoint(xTmp, yTmp, sridTmp),
                        CadastreObjectTO.class);
            }
        });

        return (CadastreObjectTO) result[0];
    }

    @WebMethod(operationName = "GetCadastreObjectsByBaUnit")
    public List<CadastreObjectTO> GetCadastreObjectsByBaUnit(
            @WebParam(name = "baUnitId") String baUnitId)
            throws SOLAFault, UnhandledFault {

        final String baUnitIdTmp = baUnitId;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        cadastreEJB.getCadastreObjectsByBaUnit(baUnitIdTmp),
                        CadastreObjectTO.class);
            }
        });

        return (List<CadastreObjectTO>) result[0];
    }

    @WebMethod(operationName = "GetCadastreObjectsByService")
    public List<CadastreObjectTO> GetCadastreObjectsByService(
            @WebParam(name = "serviceId") String serviceId)
            throws SOLAFault, UnhandledFault {

        final String serviceIdTmp = serviceId;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        cadastreEJB.getCadastreObjectsByService(serviceIdTmp),
                        CadastreObjectTO.class);
            }
        });

        return (List<CadastreObjectTO>) result[0];
    }

    @WebMethod(operationName = "SaveCadastreChange")
    public List<ValidationResult> SaveTransactionCadastreChange(
            @WebParam(name = "transactionCadastreChangeTO") TransactionCadastreChangeTO transactionCadastreChangeTO,
            @WebParam(name = "languageCode") String languageCode)
            throws SOLAValidationFault, OptimisticLockingFault,
            SOLAFault, UnhandledFault, SOLAAccessFault {

        final TransactionCadastreChangeTO transactionTO = transactionCadastreChangeTO;
        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                TransactionCadastreChange transactionCadastreChange = GenericTranslator.fromTO(
                        transactionTO, TransactionCadastreChange.class, null);
                result[0] = transactionEJB.saveTransaction(
                        transactionCadastreChange, TransactionType.CADASTRE_CHANGE, languageCodeTmp);
            }
        });

        return (List<ValidationResult>) result[0];
    }

    @WebMethod(operationName = "GetCadastreChange")
    public TransactionCadastreChangeTO GetTransactionCadastreChange(
            @WebParam(name = "serviceId") String serviceId)
            throws SOLAFault, UnhandledFault {

        final String serviceIdTmp = serviceId;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(
                        transactionEJB.getTransactionByServiceId(serviceIdTmp, false, TransactionCadastreChange.class),
                        TransactionCadastreChangeTO.class);
            }
        });

        return (TransactionCadastreChangeTO) result[0];
    }

    @WebMethod(operationName = "GetCadastreObjects")
    public List<CadastreObjectTO> GetCadastreObjects(
            @WebParam(name = "ids") List<String> Ids)
            throws SOLAFault, UnhandledFault {

        final List<String> IdsTmp = Ids;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        cadastreEJB.getCadastreObjects(IdsTmp), CadastreObjectTO.class);
            }
        });

        return (List<CadastreObjectTO>) result[0];
    }

    @WebMethod(operationName = "GetCadastreObjectNode")
    public CadastreObjectNodeTO GetCadastreObjectNode(
            @WebParam(name = "xMin") double xMin,
            @WebParam(name = "yMin") double yMin,
            @WebParam(name = "xMax") double xMax,
            @WebParam(name = "yMax") double yMax,
            @WebParam(name = "srid") int srid)
            throws SOLAFault, UnhandledFault {
        final double xMinTmp = xMin;
        final double yMinTmp = yMin;
        final double xMaxTmp = xMax;
        final double yMaxTmp = yMax;
        final int sridTmp = srid;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(cadastreEJB.getCadastreObjectNode(
                        xMinTmp, yMinTmp, xMaxTmp, yMaxTmp, sridTmp),
                        CadastreObjectNodeTO.class);
            }
        });

        return (CadastreObjectNodeTO) result[0];
    }

    @WebMethod(operationName = "GetCadastreObjectNodePotential")
    public CadastreObjectNodeTO GetCadastreObjectNodePotential(
            @WebParam(name = "xMin") double xMin,
            @WebParam(name = "yMin") double yMin,
            @WebParam(name = "xMax") double xMax,
            @WebParam(name = "yMax") double yMax,
            @WebParam(name = "srid") int srid)
            throws SOLAFault, UnhandledFault {
        final double xMinTmp = xMin;
        final double yMinTmp = yMin;
        final double xMaxTmp = xMax;
        final double yMaxTmp = yMax;
        final int sridTmp = srid;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(cadastreEJB.getCadastreObjectNodePotential(
                        xMinTmp, yMinTmp, xMaxTmp, yMaxTmp, sridTmp),
                        CadastreObjectNodeTO.class);
            }
        });

        return (CadastreObjectNodeTO) result[0];
    }

    @WebMethod(operationName = "SaveCadastreRedefinition")
    public List<ValidationResult> SaveCadastreRedefinition(
            @WebParam(name = "transactionCadastreRedefinitionTO") TransactionCadastreRedefinitionTO transactionTO,
            @WebParam(name = "languageCode") String languageCode)
            throws SOLAValidationFault, OptimisticLockingFault,
            SOLAFault, UnhandledFault, SOLAAccessFault {

        final TransactionCadastreRedefinitionTO transactionTOTmp = transactionTO;
        final String languageCodeTmp = languageCode;
        final Object[] result = {null};

        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                TransactionCadastreRedefinition transactionCadastreRedefinition =
                        GenericTranslator.fromTO(
                        transactionTOTmp, TransactionCadastreRedefinition.class, null);
                result[0] = transactionEJB.saveTransaction(transactionCadastreRedefinition,
                        TransactionType.REDEFINE_CADASTRE, languageCodeTmp);
            }
        });

        return (List<ValidationResult>) result[0];
    }

    @WebMethod(operationName = "GetCadastreRedefinition")
    public TransactionCadastreRedefinitionTO GetTransactionCadastreRedefinition(
            @WebParam(name = "serviceId") String serviceId)
            throws SOLAFault, UnhandledFault {

        final String serviceIdTmp = serviceId;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(
                        transactionEJB.getTransactionByServiceId(
                        serviceIdTmp, false, TransactionCadastreRedefinition.class),
                        TransactionCadastreRedefinitionTO.class);
            }
        });

        return (TransactionCadastreRedefinitionTO) result[0];
    }

    //<editor-fold defaultstate="collapsed" desc="By Kumar">
    //********************************************************************************************************************************
    @WebMethod(operationName = "saveCadastreObject")
    public CadastreObjectTO saveCadastreObject(@WebParam(name = "cadastreObjectTO") final CadastreObjectTO cadastreObjectTO)
            throws SOLAFault, UnhandledFault, SOLAAccessFault, OptimisticLockingFault, SOLAValidationFault {
        final Object[] result = {null};
        final Object[] params = {cadastreObjectTO};
        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                CadastreObjectTO cadTo = (CadastreObjectTO) params[0];
                if (cadTo != null) {
                    CadastreObject cadastreObjectEntity = cadastreEJB.getCadastreObject(cadTo.getId());
                    cadTo = GenericTranslator.toTO(
                            cadastreEJB.saveCadastreObject(
                            GenericTranslator.fromTO(cadTo, CadastreObject.class, cadastreObjectEntity)), CadastreObjectTO.class);
                    result[0] = cadTo;
                }
            }
        });
        return (CadastreObjectTO) result[0];
    }

    @WebMethod(operationName = "getMapSheet")
    public MapSheetTO getMapSheet(
            @WebParam(name = "id") String id)
            throws SOLAFault, UnhandledFault {

        final String IdTmp = id;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(
                        cadastreEJB.getMapSheet(IdTmp), MapSheetTO.class);
            }
        });

        return (MapSheetTO) result[0];
    }

    @WebMethod(operationName = "getMapSheetList")
    public List<MapSheetTO> getMapSheetList()
            throws SOLAFault, UnhandledFault {

        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        cadastreEJB.getMapSheetList(), MapSheetTO.class);
            }
        });

        return (List<MapSheetTO>) result[0];
    }

    @WebMethod(operationName = "saveMapSheet")
    public MapSheetTO saveMapSheet(@WebParam(name = "mapSheetTO") final MapSheetTO mapSheetTO)
            throws SOLAFault, UnhandledFault, SOLAAccessFault, OptimisticLockingFault, SOLAValidationFault {
        final Object[] result = {null};
        final Object[] params = {mapSheetTO};
        runUpdateMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                MapSheetTO mapTo = (MapSheetTO) params[0];
                if (mapTo != null) {
                    MapSheet mapSheettEntity = cadastreEJB.getMapSheet(mapTo.getId());
                    mapTo = GenericTranslator.toTO(
                            cadastreEJB.saveMapSheet(
                            GenericTranslator.fromTO(mapTo, MapSheet.class, mapSheettEntity)), MapSheetTO.class);
                    result[0] = mapTo;
                }
            }
        });
        return (MapSheetTO) result[0];
    }

    @WebMethod(operationName = "loadCadastreObjectList")
    public List<CadastreObjectTO> loadCadastreObjectList(@WebParam(name = "mapSheetCode") String mapSheetCode) throws SOLAFault, UnhandledFault {
        final String mapSheetCodeTmp = mapSheetCode;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(cadastreEJB.loadCadastreObjectList(mapSheetCodeTmp), CadastreObjectTO.class);
            }
        });
        return (List<CadastreObjectTO>) result[0];
    }

    @WebMethod(operationName = "getCadastreObjectList")
    public List<CadastreObjectTO> getCadastreObjectList(@WebParam(name = "vdcCode") String vdcCode, @WebParam(name = "wardNo") String wardNo) throws SOLAFault, UnhandledFault {
        final String vdcCodeTmp = vdcCode;
        final String wardNoTmp = wardNo;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(cadastreEJB.getCadastreObjectList(vdcCodeTmp, wardNoTmp), CadastreObjectTO.class);
            }
        });
        return (List<CadastreObjectTO>) result[0];
    }

    @WebMethod(operationName = "loadMapSheet")
    public List<MapSheetTO> loadMapSheet(@WebParam(name = "mapSheetType") int mapSheetType) throws SOLAFault, UnhandledFault {
        final int mapSheetTypeTmp = mapSheetType;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(cadastreEJB.loadMapSheet(mapSheetTypeTmp), MapSheetTO.class);
            }
        });
        return (List<MapSheetTO>) result[0];
    }

    @WebMethod(operationName = "getCadastreObjectByVdcWardParcel")
    public CadastreObjectTO getCadastreObjectByVdcWardParcel(@WebParam(name = "vdcCode") String vdcCode, 
                @WebParam(name = "wardNo") String wardNo, 
                @WebParam(name = "parcelNo") int parcelNo) throws SOLAFault, UnhandledFault {
        final String vdcCodeTmp = vdcCode;
        final String wardNoTmp = wardNo;
        final int parcelNoTmp = parcelNo;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(cadastreEJB.getCadastreObject(vdcCodeTmp, wardNoTmp, parcelNoTmp), CadastreObjectTO.class);
            }
        });
        return (CadastreObjectTO) result[0];
    }

    @WebMethod(operationName = "getCadastreObjectByMapSheetParcel")
    public CadastreObjectTO getCadastreObjectByMapSheetParcel(@WebParam(name = "mapSheetCode") String mapSheetCode, @WebParam(name = "parcelNo") int parcelNo) throws SOLAFault, UnhandledFault {
        final String mapSheetCodeTmp = mapSheetCode;
        final int parcelNoTmp = parcelNo;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTO(cadastreEJB.getCadastreObject(mapSheetCodeTmp, parcelNoTmp), CadastreObjectTO.class);
            }
        });
        return (CadastreObjectTO) result[0];
    }
    //********************************************************************************************************************************
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="By Kabindra">
    //--------------------------------------------------------------------------

    @WebMethod(operationName = "GetCadastreObjectByIntersection")
    public List<CadastreObjectTO> GetCadastreObjectByIntersection(
            @WebParam(name = "geom") String geom,
            @WebParam(name = "srid") int srid)
            throws SOLAFault, UnhandledFault {

        final String geomTmp = geom;
        final int sridTmp = srid;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        cadastreEJB.getCadastreObjectBy_Intersection(geomTmp, sridTmp),
                        CadastreObjectTO.class);
            }
        });

        return (List<CadastreObjectTO>) result[0];
    }

    @WebMethod(operationName = "GetCadastreObjectByByteIntersection")
    public List<CadastreObjectTO> GetCadastreObjectByByteIntersection(
            @WebParam(name = "geom") String geom,
            @WebParam(name = "srid") int srid)
            throws SOLAFault, UnhandledFault {

        final String geomTmp = geom;
        final int sridTmp = srid;
        final Object[] result = {null};

        runGeneralMethod(wsContext, new Runnable() {

            @Override
            public void run() {
                result[0] = GenericTranslator.toTOList(
                        cadastreEJB.getCadastreObjectBy_ByteIntersection(geomTmp, sridTmp),
                        CadastreObjectTO.class);
            }
        });

        return (List<CadastreObjectTO>) result[0];
    }
    //--------------------------------------------------------------------------
    // </editor-fold>
}
