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
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package org.sola.services.boundary.wsclients;

import java.util.List;
import org.sola.services.boundary.wsclients.exception.WebServiceClientException;
import org.sola.webservices.transferobjects.ValidationResult;
import org.sola.webservices.transferobjects.cadastre.*;
import org.sola.webservices.transferobjects.transaction.TransactionCadastreChangeTO;
import org.sola.webservices.transferobjects.transaction.TransactionCadastreRedefinitionTO;

/**
 *
 * @author Manoku
 */
public interface CadastreClient extends AbstractWSClient {

    boolean checkConnection() throws WebServiceClientException;

    List<CadastreObjectTO> getCadastreObjectByParts(String searchString)
            throws WebServiceClientException;

    CadastreObjectTO getCadastreObjectByPoint(double x, double y, int srid)
            throws WebServiceClientException;

    CadastreObjectTO getCadastreObjectByBaUnit(String baUnitId);

    List<CadastreObjectTO> getCadastreObjectsByService(String serviceId);

    List<ValidationResult> saveTransactionCadastreChange(TransactionCadastreChangeTO cadastreChangeTO);

    TransactionCadastreChangeTO getTransactionCadastreChange(String serviceId);

    List<CadastreObjectTO> getCadastreObjects(List<String> Ids);

    CadastreObjectNodeTO getCadastreObjectNode(
            double xMin, double yMin, double xMax, double yMax, int srid);

    CadastreObjectNodeTO getCadastreObjectNodePotential(
            double xMin, double yMin, double xMax, double yMax, int srid);

    List<ValidationResult> saveTransactionCadastreRedefinition(TransactionCadastreRedefinitionTO transactionTO);

    TransactionCadastreRedefinitionTO getTransactionCadastreRedefinition(String serviceId);

    //CadastreObjectSummaryTO saveCadastreObject(CadastreObjectSummaryTO cadastreObject);
    CadastreObjectTO saveCadastreObject(CadastreObjectTO cadastreObject);

    MapSheetTO getMapSheet(String id);

    MapSheetTO saveMapSheet(MapSheetTO mapSheet);

    List<MapSheetTO> getMapSheetsByOffice(String officeCode);

    List<MapSheetTO> getMapSheetsByOffice();

    List<CadastreObjectTO> loadCadastreObjectList(String mapSheetCode);

    List<CadastreObjectTO> getCadastreObjectList(String vdcCode, String wardNo);

    List<MapSheetTO> loadMapSheet(int mapSheetType);

    CadastreObjectTO getCadastreObjectByVdcWardParcel(String vdcCode, String wardNo, int parcelNo);

    CadastreObjectTO getCadastreObjectByMapSheetParcel(String mapSheetCode, int parcelNo);

    CadastreObjectTO getCadastreObject(String id);

    List<CadastreObjectTO> getCadastreObjectByIntersection(String geom, int srid)
            throws WebServiceClientException;

    List<CadastreObjectTO> getCadastreObjectByByteIntersection(String geom, int srid)
            throws WebServiceClientException;

    List<CadastreObjectTO> getPendingParcelsByParts(String searchString)
            throws WebServiceClientException;

    List<CadastreObjectTO> getCadastreObjectListMem(List<String> mapSheetCode);

    List<ConstructionObjectTO> getConstructionObjectListMem(List<String> mapSheetCode);

    List<CadastreObjectTO> getCadastreObjectByExactParts(String firstpart, String lastpart)
            throws WebServiceClientException;

    List<MapSheetTO> loadWardMapSheet(int mapSheetType, String vdccode, String wardno);

    List<MapSheetTO> loadVDCMapSheet(int mapSheetType, String vdccode);

    List<String> getWardlist(String vdccode);

    List<DatasetTO> getDatasetsByCurrentOffice() throws WebServiceClientException;

    List<DatasetTO> getDatasetsByCurrentUser() throws WebServiceClientException;

    List<DatasetTO> getDatasetsByVdc(String vdcCode) throws WebServiceClientException;

    DatasetTO getDataset(String id) throws WebServiceClientException;

    List<CadastreObjectTO> getCadastreObjectsByTransaction(String transactionId);
    
    List<CadastreObjectTargetTO> getCadastreObjectTargetsByCadastreObject(String cadastreObjectId);
    
}