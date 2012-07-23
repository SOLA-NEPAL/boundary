package org.sola.services.boundary.transferobjects.administrative;

import org.sola.services.common.contracts.AbstractTO;

public class LocSearchByMothParamsTO extends AbstractTO {
    
    private MothBasicTO moth;
    private String pageNumber;
    
    public LocSearchByMothParamsTO(){
        super();
    }

    public MothBasicTO getMoth() {
        return moth;
    }

    public void setMoth(MothBasicTO moth) {
        this.moth = moth;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }
}
