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
import org.sola.services.boundary.wsclients.exception.WebServiceClientException;
import org.sola.webservices.transferobjects.administrative.BaUnitAsPartyTO;
import org.sola.webservices.transferobjects.administrative.BaUnitTO;
import org.sola.webservices.transferobjects.administrative.LocTO;
import org.sola.webservices.transferobjects.administrative.MothTO;

public interface AdministrativeClient extends AbstractWSClient {

    boolean CheckConnection();

    BaUnitTO CreateBaUnit(String serviceId, BaUnitTO baUnitTO) throws WebServiceClientException;

    BaUnitTO SaveBaUnit(String serviceId, BaUnitTO baUnitTO) throws WebServiceClientException;

    BaUnitTO GetBaUnitById(String id) throws WebServiceClientException;

    BaUnitTO GetBaUnitByCode(String nameFirstpart, String nameLastpart)
            throws WebServiceClientException;

    List<BaUnitTO> getBaUnitsByServiceId(String serviceId) throws WebServiceClientException;

    BaUnitTO cancelBaUnitTermination(String baUnitId) throws WebServiceClientException;

    BaUnitTO terminateBaUnit(String baUnitId, String serviceId) throws WebServiceClientException;

    //<editor-fold defaultstate="collapsed" desc="By Kumar">
    //*****************************************************************************************************************
    MothTO saveMoth(MothTO mothTo);

    MothTO getMoth(String id);

    List<MothTO> getMoths(String vdcCode, String mothLuj);

    MothTO getMothByVdcCodeMothLujAndMothLujNumber(String vdcCode, String mothLuj, String mothLujNumber);

    LocTO saveLoc(LocTO loc);

    LocTO getLoc(String id);

    LocTO getLocByPageNoAndMothId(int panaNo, String mothId);

    BaUnitTO saveBaUnitTest(BaUnitTO baUnitTO);
    
    List<LocTO> getLocList(String mothId);

    List<BaUnitAsPartyTO> getBaUnitAsPartyList(String partyId);  
   
    //*****************************************************************************************************************
    //</editor-fold>
}
