package org.sola.services.boundary.transferobjects.search;

import org.sola.services.common.contracts.AbstractBasicIdTO;

public class LocSearchResultTO extends AbstractBasicIdTO {
    private String panaNumber;
    private String mothNumber;
    private String tmpPanaNumber;
    private String mothLuj;
    private String owners;
    
    public LocSearchResultTO(){
        super();
    }

    public String getMothLuj() {
        return mothLuj;
    }

    public void setMothLuj(String mothLuj) {
        this.mothLuj = mothLuj;
    }

    public String getMothNumber() {
        return mothNumber;
    }

    public void setMothNumber(String mothNumber) {
        this.mothNumber = mothNumber;
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public String getPanaNumber() {
        return panaNumber;
    }

    public void setPanaNumber(String panaNumber) {
        this.panaNumber = panaNumber;
    }

    public String getTmpPanaNumber() {
        return tmpPanaNumber;
    }

    public void setTmpPanaNumber(String tmpPanaNumber) {
        this.tmpPanaNumber = tmpPanaNumber;
    }
}
