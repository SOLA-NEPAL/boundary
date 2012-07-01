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

import java.util.List;
import javax.xml.namespace.QName;
import org.sola.services.boundary.wsclients.exception.WebServiceClientException;
import org.sola.webservices.administrative.Administrative;
import org.sola.webservices.administrative.AdministrativeService;
import org.sola.webservices.transferobjects.administrative.*;

public class AdministrativeClientImpl extends AbstractWSClientImpl
        implements AdministrativeClient {

    private static final String NAMESPACE_URI = "http://webservices.sola.org/administrative";
    private static final String LOCAL_PART = "administrative-service";
    private static final String SERVICE_NAME = "Administrative.";

    public AdministrativeClientImpl(String url) {
        super(url, new QName(NAMESPACE_URI, LOCAL_PART));
    }

    private Administrative getPort() {
        return getPort(Administrative.class, AdministrativeService.class);
    }

    @Override
    public BaUnitTO CreateBaUnit(
            String serviceId, BaUnitTO baUnitTO) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "createBaUnit";
        try {
            BaUnitTO result = getPort().createBaUnit(serviceId, baUnitTO);
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public BaUnitTO SaveBaUnit(
            String serviceId, BaUnitTO baUnitTO) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "saveBaUnit";
        try {
            BaUnitTO result = getPort().saveBaUnit(serviceId, baUnitTO);
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public BaUnitTO GetBaUnitById(String id) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getBaUnitById";
        try {
            BaUnitTO result = getPort().getBaUnitById(id);
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public BaUnitTO GetBaUnitByCode(String nameFirstpart, String nameLastpart) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getBaUnitByCode";
        try {
            BaUnitTO result = getPort().getBaUnitByCode(nameFirstpart, nameLastpart);
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public boolean CheckConnection() {
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
    public List<BaUnitTO> getBaUnitsByServiceId(String serviceId) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getBaUnitsByServiceId";
        try {
            return getPort().getBaUnitsByServiceId(serviceId);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public BaUnitTO cancelBaUnitTermination(String baUnitId) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "cancelBaUnitTermination";
        try {
            return getPort().cancelBaUnitTermination(baUnitId);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public BaUnitTO terminateBaUnit(String baUnitId, String serviceId) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "terminateBaUnit";
        try {
            return getPort().terminateBaUnit(baUnitId, serviceId);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }
    //<editor-fold defaultstate="collapsed" desc="By Kumar">
    //*************************************************************************************************************

    @Override
    public MothTO saveMoth(MothTO mothTo) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "saveMoth";
        try {
            return getPort().saveMoth(mothTo);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public MothTO getMoth(String id) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getMoth";
        try {
            MothTO result = getPort().getMoth(id);
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<MothTO> getMoths(String vdcCode, String mothLuj)
            throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getMoths";
        try {
            return getPort().getMoths(vdcCode, mothLuj);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public MothTO getMothByVdcCodeMothLujAndMothLujNumber(String vdcCode, String mothLuj, String mothLujNumber) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getMothByVdcCodeMothLujAndMothLujNumber";
        try {
            MothTO result = getPort().getMothByVdcCodeMothLujAndMothLujNumber(vdcCode, mothLuj, mothLujNumber);
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public LocTO saveLoc(LocTO loc) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "saveLoc";
        try {
            return getPort().saveLoc(loc);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public LocTO getLoc(String id) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getLoc";
        try {
            LocTO result = getPort().getLoc(id);
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public LocTO getLocByPageNoAndMothId(int panaNo, String mothId) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getLocByPageNoAndMothId";
        try {
            return getPort().getLocByPageNoAndMothId(panaNo, mothId);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

       
    @Override
    public BaUnitTO saveBaUnitTest(BaUnitTO baUnitTO) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "saveBaUnitTest";
        try {
            return getPort().saveBaUnitTest(baUnitTO);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }
    @Override
    public List<LocTO> getLocList(String mothId) {
       final String inputService = SERVICE_NAME + "getLocList";
        try {
            return getPort().getLocList(mothId);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }
    
 @Override
    public List<BaUnitAsPartyTO> getBaUnitAsPartyList(String partyId) {
       final String inputService = SERVICE_NAME + "getBaUnitAsPartyList";
        try {
            return getPort().getBaUnitAsPartyList(partyId);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }
 
  @Override
    public List<BaUnitContainsSpatialUnitTO> getBaUnitContainsSpatialUnitsList(String spatiaUnitId) {
        final String inputService = SERVICE_NAME + "getBaUnitContainsSpatialUnitsList";
        try {
            return getPort().getBaUnitContainsSpatialUnitsList(spatiaUnitId);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }
    //*************************************************************************************************************
    //</editor-fold>
    
}
