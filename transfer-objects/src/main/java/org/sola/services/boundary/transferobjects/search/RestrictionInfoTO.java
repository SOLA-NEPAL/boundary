package org.sola.services.boundary.transferobjects.search;

import java.math.BigDecimal;
import java.util.List;
import org.sola.services.common.contracts.AbstractTO;

public class RestrictionInfoTO extends AbstractTO {
    private String baUnitId;
    private String vdcName;
    private String wardNumber;
    private String parcelNumber;
    private String mapNumber;
    private String areaUnitTypeCode;
    private BigDecimal officialArea;
    private List<RestrictionRrrTO> rrrs;
    private List<OwnerTO> owners;
    
    public RestrictionInfoTO(){
        super();
    }

    public String getAreaUnitTypeCode() {
        return areaUnitTypeCode;
    }

    public void setAreaUnitTypeCode(String areaUnitTypeCode) {
        this.areaUnitTypeCode = areaUnitTypeCode;
    }

    public String getBaUnitId() {
        return baUnitId;
    }

    public void setBaUnitId(String baUnitId) {
        this.baUnitId = baUnitId;
    }

    public String getMapNumber() {
        return mapNumber;
    }

    public void setMapNumber(String mapNumber) {
        this.mapNumber = mapNumber;
    }

    public BigDecimal getOfficialArea() {
        return officialArea;
    }

    public void setOfficialArea(BigDecimal officialArea) {
        this.officialArea = officialArea;
    }

    public List<OwnerTO> getOwners() {
        return owners;
    }

    public void setOwners(List<OwnerTO> owners) {
        this.owners = owners;
    }

    public String getParcelNumber() {
        return parcelNumber;
    }

    public void setParcelNumber(String parcelNumber) {
        this.parcelNumber = parcelNumber;
    }

    public List<RestrictionRrrTO> getRrrs() {
        return rrrs;
    }

    public void setRrrs(List<RestrictionRrrTO> rrrs) {
        this.rrrs = rrrs;
    }

    public String getVdcName() {
        return vdcName;
    }

    public void setVdcName(String vdcName) {
        this.vdcName = vdcName;
    }

    public String getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(String wardNumber) {
        this.wardNumber = wardNumber;
    }
}
