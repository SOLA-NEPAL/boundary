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
import org.sola.webservices.transferobjects.AbstractCodeTO;
import org.sola.webservices.transferobjects.referencedata.*;

public interface ReferenceDataClient extends AbstractWSClient {

    boolean checkConnection() throws WebServiceClientException;

    List<SourceTypeTO> getSourceTypes() throws WebServiceClientException;

    List<SourceTypeTO> getSourceTypes(String lang) throws WebServiceClientException;

    List<RequestCategoryTypeTO> getRequestCategoryTypes() throws WebServiceClientException;

    List<RequestCategoryTypeTO> getRequestCategoryTypes(String lang) throws WebServiceClientException;

    List<RequestTypeTO> getRequestTypes() throws WebServiceClientException;

    List<RequestTypeTO> getRequestTypes(String lang) throws WebServiceClientException;

    List<CommunicationTypeTO> getCommunicationTypes() throws WebServiceClientException;

    List<CommunicationTypeTO> getCommunicationTypes(String lang) throws WebServiceClientException;

    List<GenderTypeTO> getGenderTypes() throws WebServiceClientException;

    List<GenderTypeTO> getGenderTypes(String lang) throws WebServiceClientException;

    List<ApplicationStatusTypeTO> getApplicationStatusTypes() throws WebServiceClientException;

    List<ApplicationStatusTypeTO> getApplicationStatusTypes(String lang) throws WebServiceClientException;

    List<ApplicationActionTypeTO> getApplicationActionTypes() throws WebServiceClientException;

    List<ApplicationActionTypeTO> getApplicationActionTypes(String lang) throws WebServiceClientException;

    List<ServiceStatusTypeTO> getServiceStatusTypes() throws WebServiceClientException;

    List<ServiceStatusTypeTO> getServiceStatusTypes(String lang) throws WebServiceClientException;

    List<ServiceActionTypeTO> getServiceActionTypes() throws WebServiceClientException;

    List<ServiceActionTypeTO> getServiceActionTypes(String lang) throws WebServiceClientException;

    List<PartyTypeTO> getPartyTypes() throws WebServiceClientException;

    List<PartyTypeTO> getPartyTypes(String lang) throws WebServiceClientException;

    List<PartyRoleTypeTO> getPartyRoles() throws WebServiceClientException;

    List<PartyRoleTypeTO> getPartyRoles(String lang) throws WebServiceClientException;

    List<IdTypeTO> getIdTypes() throws WebServiceClientException;

    List<IdTypeTO> getIdTypes(String lang) throws WebServiceClientException;

    List<ChangeStatusTypeTO> getChangeStatusTypes() throws WebServiceClientException;

    List<ChangeStatusTypeTO> getChangeStatusTypes(String lang) throws WebServiceClientException;

    List<BaUnitTypeTO> getBaUnitTypes() throws WebServiceClientException;

    List<BaUnitTypeTO> getBaUnitTypes(String lang) throws WebServiceClientException;

    List<MortgageTypeTO> getMortgageTypes() throws WebServiceClientException;

    List<MortgageTypeTO> getMortgageTypes(String lang) throws WebServiceClientException;

    List<RrrGroupTypeTO> getRrrGroupTypes() throws WebServiceClientException;

    List<RrrGroupTypeTO> getRrrGroupTypes(String lang) throws WebServiceClientException;

    List<RrrTypeTO> getRrrTypes() throws WebServiceClientException;

    List<RrrTypeTO> getRrrTypes(String lang) throws WebServiceClientException;

    List<TypeActionTO> getTypeActions() throws WebServiceClientException;

    List<TypeActionTO> getTypeActions(String lang) throws WebServiceClientException;

    List<RegistrationStatusTypeTO> getRegistrationStatusTypes() throws WebServiceClientException;

    List<RegistrationStatusTypeTO> getRegistrationStatusTypes(String lang) throws WebServiceClientException;

    List<CadastreObjectTypeTO> getCadastreObjectTypes() throws WebServiceClientException;

    List<CadastreObjectTypeTO> getCadastreObjectTypes(String lang) throws WebServiceClientException;

    AbstractCodeTO saveReferenceData(AbstractCodeTO refDataTO) throws WebServiceClientException;

    List<BrTechnicalTypeTO> getBrTechnicalTypes() throws WebServiceClientException;

    List<BrTechnicalTypeTO> getBrTechnicalTypes(String lang) throws WebServiceClientException;

    List<BrValidationTargetTypeTO> getBrValidationTargetTypes() throws WebServiceClientException;

    List<BrValidationTargetTypeTO> getBrValidationTargetTypes(String lang) throws WebServiceClientException;

    List<BrSeverityTypeTO> getBrSeverityTypes() throws WebServiceClientException;

    List<BrSeverityTypeTO> getBrSeverityTypes(String lang) throws WebServiceClientException;

    List<BaUnitRelTypeTO> getBaUnitRelTypes(String lang) throws WebServiceClientException;

    List<BaUnitRelTypeTO> getBaUnitRelTypes() throws WebServiceClientException;

    List<OfficeTO> getOffices(String languageCode);

    List<OfficeTO> getOffices();

    List<OfficeTO> getOfficesByDistrict(String districtCode);

    List<OfficeTO> getOfficesByDistrict(String districtCode, String languageCode);

    List<DistrictTO> getDistricts(String languageCode);

    List<DistrictTO> getDistricts();

    List<DepartmentTO> getDepartments(String officeCode, String languageCode);

    List<DepartmentTO> getDepartments(String officeCode);

    List<VdcTO> getVdcs(String districtCode, String languageCode);

    List<VdcTO> getVdcs(String districtCode);

    List<VdcTO> getVdcList();

    VdcTO getVdcByCode(String id);

    VdcTO getVdcByCode(String languageCode, String id);

    VdcTO getVdcByName(String name);

    List<VdcTO> getVdcs();

    List<OwnerTypeTO> getOwnerTypes() throws WebServiceClientException;

    List<OwnerTypeTO> getOwnerTypes(String lang) throws WebServiceClientException;

    List<OwnershipTypeTO> getOwnershipTypes() throws WebServiceClientException;

    List<OwnershipTypeTO> getOwnershipTypes(String lang) throws WebServiceClientException;

    List<TenantTypeTO> getTenantTypes() throws WebServiceClientException;

    List<TenantTypeTO> getTenantTypes(String lang) throws WebServiceClientException;

    List<LandTypeTO> getLandTypes() throws WebServiceClientException;

    List<LandTypeTO> getLandTypes(String lang) throws WebServiceClientException;

    List<LandClassTO> getLandClasses() throws WebServiceClientException;

    List<LandClassTO> getLandClasses(String lang) throws WebServiceClientException;

    List<LandUseTO> getLandUses() throws WebServiceClientException;

    List<LandUseTO> getLandUses(String lang) throws WebServiceClientException;

    List<RestrictionReasonTO> getRestrictionReasons() throws WebServiceClientException;

    List<RestrictionReasonTO> getRestrictionReasons(String lang) throws WebServiceClientException;

    List<RestrictionReleaseReasonTO> getRestrictionReleaseReasons() throws WebServiceClientException;

    List<RestrictionReleaseReasonTO> getRestrictionReleaseReasons(String lang) throws WebServiceClientException;

    List<RestrictionOfficeTO> getRestrictionOffices() throws WebServiceClientException;

    List<RestrictionOfficeTO> getRestrictionOffices(String lang) throws WebServiceClientException;

    List<AreaUnitTypeTO> getAreaUnitTypes() throws WebServiceClientException;

    List<AreaUnitTypeTO> getAreaUnitTypes(String lang) throws WebServiceClientException;

    List<BuildingUnitTypeTO> getBuildingUnitTypes() throws WebServiceClientException;

    List<BuildingUnitTypeTO> getBuildingUnitTypes(String lang) throws WebServiceClientException;
}
