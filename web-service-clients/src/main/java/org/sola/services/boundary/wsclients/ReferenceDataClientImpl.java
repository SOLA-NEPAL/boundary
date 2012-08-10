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
import org.sola.webservices.referencedata.ReferenceData;
import org.sola.webservices.referencedata.ReferencedataService;
import org.sola.webservices.transferobjects.AbstractCodeTO;
import org.sola.webservices.transferobjects.referencedata.*;

/**
 * Implementation class for the {@linkplain ReferenceDataClient} interface.
 *
 * @author amcdowell
 */
public class ReferenceDataClientImpl extends AbstractWSClientImpl implements ReferenceDataClient {

    private static final String NAMESPACE_URI = "http://webservices.sola.org/referencedata";
    private static final String LOCAL_PART = "referencedata-service";
    private static final String SERVICE_NAME = "ReferenceData.";

    public ReferenceDataClientImpl(String url) {
        super(url, new QName(NAMESPACE_URI, LOCAL_PART));
    }

    private ReferenceData getPort() {
        return getPort(ReferenceData.class, ReferencedataService.class);
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
    public List<CommunicationTypeTO> getCommunicationTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getCommunicationTypes";
        try {
            List<CommunicationTypeTO> result = getPort().getCommunicationTypes(lang);
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<CommunicationTypeTO> getCommunicationTypes() throws WebServiceClientException {
        return getCommunicationTypes(this.getLanguageCode());
    }

    @Override
    public List<GenderTypeTO> getGenderTypes() throws WebServiceClientException {
        return getGenderTypes(this.getLanguageCode());
    }

    @Override
    public List<GenderTypeTO> getGenderTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getGenderTypes";
        try {
            return getPort().getGenderTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<RequestTypeTO> getRequestTypes() throws WebServiceClientException {
        return getRequestTypes(this.getLanguageCode());
    }

    @Override
    public List<RequestTypeTO> getRequestTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getRequestTypes";
        try {
            return getPort().getRequestTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<SourceTypeTO> getSourceTypes() throws WebServiceClientException {
        return getSourceTypes(this.getLanguageCode());
    }

    @Override
    public List<SourceTypeTO> getSourceTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getSourceTypes";
        try {
            return getPort().getSourceTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<ApplicationStatusTypeTO> getApplicationStatusTypes() throws WebServiceClientException {
        return getApplicationStatusTypes(getLanguageCode());
    }

    @Override
    public List<ApplicationStatusTypeTO> getApplicationStatusTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getApplicationStatusTypes";
        try {
            return getPort().getApplicationStatusTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<ServiceStatusTypeTO> getServiceStatusTypes() throws WebServiceClientException {
        return getServiceStatusTypes(getLanguageCode());
    }

    @Override
    public List<ServiceStatusTypeTO> getServiceStatusTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getServiceStatusTypes";
        try {
            return getPort().getServiceStatusTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<ServiceActionTypeTO> getServiceActionTypes() throws WebServiceClientException {
        return getServiceActionTypes(getLanguageCode());
    }

    @Override
    public List<ServiceActionTypeTO> getServiceActionTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getServiceActionTypes";
        try {
            return getPort().getServiceActionTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<ApplicationActionTypeTO> getApplicationActionTypes() throws WebServiceClientException {
        return getApplicationActionTypes(getLanguageCode());
    }

    @Override
    public List<ApplicationActionTypeTO> getApplicationActionTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getApplicationActionTypes";
        try {
            return getPort().getApplicationActionTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<PartyTypeTO> getPartyTypes() throws WebServiceClientException {
        return getPartyTypes(getLanguageCode());
    }

    @Override
    public List<PartyTypeTO> getPartyTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getPartyTypes";
        try {
            return getPort().getPartyTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<PartyRoleTypeTO> getPartyRoles() throws WebServiceClientException {
        return getPartyRoles(getLanguageCode());
    }

    @Override
    public List<PartyRoleTypeTO> getPartyRoles(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getPartyRoles";
        try {
            return getPort().getPartyRoles(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<IdTypeTO> getIdTypes() throws WebServiceClientException {
        return getIdTypes(getLanguageCode());
    }

    @Override
    public List<IdTypeTO> getIdTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getIdTypes";
        try {
            return getPort().getIdTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<ChangeStatusTypeTO> getChangeStatusTypes() throws WebServiceClientException {
        return getChangeStatusTypes(getLanguageCode());
    }

    @Override
    public List<ChangeStatusTypeTO> getChangeStatusTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getChangeStatusTypes";
        try {
            return getPort().getChangeStatuTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitTypeTO> getBaUnitTypes() throws WebServiceClientException {
        return getBaUnitTypes(this.getLanguageCode());
    }

    @Override
    public List<BaUnitTypeTO> getBaUnitTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getBaUnitTypes";
        try {
            List<BaUnitTypeTO> result = getPort().getBaUnitTypes(lang);
            return result;
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<MortgageTypeTO> getMortgageTypes() throws WebServiceClientException {
        return getMortgageTypes(getLanguageCode());
    }

    @Override
    public List<MortgageTypeTO> getMortgageTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getMortgageTypes";
        try {
            return getPort().getMortgageTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<RrrGroupTypeTO> getRrrGroupTypes() throws WebServiceClientException {
        return getRrrGroupTypes(getLanguageCode());
    }

    @Override
    public List<RrrGroupTypeTO> getRrrGroupTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getRrrGroupTypes";
        try {
            return getPort().getRRRGroupTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<RrrTypeTO> getRrrTypes() throws WebServiceClientException {
        return getRrrTypes(getLanguageCode());
    }

    @Override
    public List<RrrTypeTO> getRrrTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getRrrTypes";
        try {
            return getPort().getRRRTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<RegistrationStatusTypeTO> getRegistrationStatusTypes()
            throws WebServiceClientException {
        return getRegistrationStatusTypes(getLanguageCode());
    }

    @Override
    public List<RegistrationStatusTypeTO> getRegistrationStatusTypes(String lang)
            throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getRegistrationStatusTypes";
        try {
            return getPort().getRegistrationStatusTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<CadastreObjectTypeTO> getCadastreObjectTypes()
            throws WebServiceClientException {
        return getCadastreObjectTypes(getLanguageCode());
    }

    @Override
    public List<CadastreObjectTypeTO> getCadastreObjectTypes(String lang)
            throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getCadastreObjectTypes";
        try {
            return getPort().getCadastreObjectTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<TypeActionTO> getTypeActions() throws WebServiceClientException {
        return getTypeActions(getLanguageCode());
    }

    @Override
    public List<TypeActionTO> getTypeActions(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getTypeActions";
        try {
            return getPort().getTypeActions(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public AbstractCodeTO saveReferenceData(AbstractCodeTO refDataTO) {
        final String inputService = SERVICE_NAME + "getRrrTypeActions";
        try {
            return getPort().saveReferenceData(refDataTO);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<RequestCategoryTypeTO> getRequestCategoryTypes() throws WebServiceClientException {
        return getRequestCategoryTypes(getLanguageCode());
    }

    @Override
    public List<RequestCategoryTypeTO> getRequestCategoryTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getRequestCategoryTypes";
        try {
            return getPort().getRequestCategoryTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BrTechnicalTypeTO> getBrTechnicalTypes() throws WebServiceClientException {
        return getBrTechnicalTypes(getLanguageCode());
    }

    @Override
    public List<BrTechnicalTypeTO> getBrTechnicalTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getBrTechnicalTypes";
        try {
            return getPort().getBrTechnicalTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BrValidationTargetTypeTO> getBrValidationTargetTypes() throws WebServiceClientException {
        return getBrValidationTargetTypes(getLanguageCode());
    }

    @Override
    public List<BrValidationTargetTypeTO> getBrValidationTargetTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getBrValidationTargetTypes";
        try {
            return getPort().getBrValidationTargetTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BrSeverityTypeTO> getBrSeverityTypes() throws WebServiceClientException {
        return getBrSeverityTypes(getLanguageCode());
    }

    @Override
    public List<BrSeverityTypeTO> getBrSeverityTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getBrSeverityTypes";
        try {
            return getPort().getBrSeverityTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitRelTypeTO> getBaUnitRelTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getBaUnitRelTypes";
        try {
            return getPort().getBaUnitRelTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<BaUnitRelTypeTO> getBaUnitRelTypes() throws WebServiceClientException {
        return getBaUnitRelTypes(getLanguageCode());
    }

    @Override
    public List<OfficeTO> getOffices(String languageCode) {
        final String inputService = SERVICE_NAME + "getOffices";
        try {
            return getPort().getOffices(languageCode);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<OfficeTO> getOffices() {
        return getOffices(getLanguageCode());
    }

    @Override
    public List<OfficeTO> getOfficesByDistrict(String districtCode, String languageCode) {
        final String inputService = SERVICE_NAME + "getDepartments";
        try {
            return getPort().getOfficesByDistrict(districtCode, languageCode);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<OfficeTO> getOfficesByDistrict(String districtCode) {
        return getOfficesByDistrict(districtCode, getLanguageCode());
    }

    @Override
    public List<DistrictTO> getDistricts(String languageCode) {
        final String inputService = SERVICE_NAME + "getDistricts";
        try {
            return getPort().getDistricts(languageCode);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<DistrictTO> getDistricts() {
        return getDistricts(getLanguageCode());
    }

    @Override
    public List<DepartmentTO> getDepartments(String officeCode, String languageCode) {
        final String inputService = SERVICE_NAME + "getDepartments";
        try {
            return getPort().getDepartments(officeCode, languageCode);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<DepartmentTO> getDepartments(String officeCode) {
        return getDepartments(officeCode, getLanguageCode());
    }

    @Override
    public List<VdcTO> getVdcs(String districtCode, String languageCode) {
        final String inputService = SERVICE_NAME + "getVdcs";
        try {
            return getPort().getVdcs(districtCode, languageCode);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<VdcTO> getVdcs(String districtCode) {
        return getVdcs(districtCode, getLanguageCode());
    }

    //<editor-fold defaultstate="collapsed" desc="By Kumar">
    //************************************************************************************************
    @Override
    public List<VdcTO> getVdcList() {
        final String inputService = SERVICE_NAME + "getVdcList";
        try {
            return getPort().getVdcList();
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<VdcTO> getVdcs() {
        return getVdcList();
    }

    @Override
    public VdcTO getVdcByCode(String id) {
        final String inputService = SERVICE_NAME + "getVdcByCode";
        try {
            return getPort().getVdcByCode(id);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public VdcTO getVdcByName(String name) {
        final String inputService = SERVICE_NAME + "getVdcByName";
        try {
            return getPort().getVdcByName(name);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<OwnerTypeTO> getOwnerTypes() throws WebServiceClientException {
        return getOwnerTypes(getLanguageCode());
    }

    @Override
    public List<OwnerTypeTO> getOwnerTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getOwnerTypes";
        try {
            return getPort().getOwnerTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<ShareTypeTO> getShareTypes() throws WebServiceClientException {
        return getShareTypes(getLanguageCode());
    }

    @Override
    public List<ShareTypeTO> getShareTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getShareTypes";
        try {
            return getPort().getShareTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<TenantTypeTO> getTenantTypes() throws WebServiceClientException {
        return getTenantTypes(getLanguageCode());
    }

    @Override
    public List<TenantTypeTO> getTenantTypes(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getTenantTypes";
        try {
            return getPort().getTenantTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<ParcelTypeTO> getParcelTypes() {
        return getParcelTypes(getLanguageCode());
    }

    @Override
    public List<ParcelTypeTO> getParcelTypes(String lang) {
        final String inputService = SERVICE_NAME + "getParcelTypes";
        try {
            return getPort().getParcelTypes(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<LandClassTO> getLandClasses() throws WebServiceClientException {
        return getLandClasses(getLanguageCode());
    }

    @Override
    public List<LandClassTO> getLandClasses(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getLandClasses";
        try {
            return getPort().getLandClasses(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<LandUseTO> getLandUses() throws WebServiceClientException {
        return getLandUses(getLanguageCode());
    }

    @Override
    public List<LandUseTO> getLandUses(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getLandUses";
        try {
            return getPort().getLandUses(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<RestrictionReasonTO> getRestrictionReasons() throws WebServiceClientException {
        return getRestrictionReasons(getLanguageCode());
    }

    @Override
    public List<RestrictionReasonTO> getRestrictionReasons(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getRestrictionReasons";
        try {
            return getPort().getRestrictionReasons(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<RestrictionReleaseReasonTO> getRestrictionReleaseReasons() throws WebServiceClientException {
        return getRestrictionReleaseReasons(getLanguageCode());
    }

    @Override
    public List<RestrictionReleaseReasonTO> getRestrictionReleaseReasons(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getRestrictionReleaseReasons";
        try {
            return getPort().getRestrictionReleaseReasons(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }

    @Override
    public List<RestrictionOfficeTO> getRestrictionOffices() throws WebServiceClientException {
        return getRestrictionOffices(getLanguageCode());
    }

    @Override
    public List<RestrictionOfficeTO> getRestrictionOffices(String lang) throws WebServiceClientException {
        final String inputService = SERVICE_NAME + "getRestrictionOffices";
        try {
            return getPort().getRestrictionOffices(lang);
        } catch (Throwable e) {
            handleExceptionsMethod(inputService, e);
            return null;
        }
    }
}
