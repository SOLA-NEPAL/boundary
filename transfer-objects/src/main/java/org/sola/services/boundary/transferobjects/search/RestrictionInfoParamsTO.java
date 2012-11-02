package org.sola.services.boundary.transferobjects.search;

import org.sola.services.common.contracts.AbstractTO;

public class RestrictionInfoParamsTO extends AbstractTO {
    private String langCode;
    private String refNumber;
    private Integer refDate;
    
    public RestrictionInfoParamsTO(){
        super();
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public Integer getRefDate() {
        return refDate;
    }

    public void setRefDate(Integer refDate) {
        this.refDate = refDate;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }
}
