package org.sola.services.boundary.transferobjects.security;

import org.sola.services.common.contracts.AbstractVersionedTO;

public class UserVdcTO extends AbstractVersionedTO {
    private String id;
    private String vdcCode;
    private String wardNumber;
    private String userId;
    
    public UserVdcTO(){
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVdcCode() {
        return vdcCode;
    }

    public void setVdcCode(String vdcCode) {
        this.vdcCode = vdcCode;
    }

    public String getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(String wardNumber) {
        this.wardNumber = wardNumber;
    }
}
