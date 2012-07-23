package org.sola.services.boundary.transferobjects.administrative;

import java.util.List;

public class MothTO extends MothBasicTO {

    private List<LocTO> locList;
   
    public List<LocTO> getLocList() {
        return locList;
    }

    public void setLocList(List<LocTO> locList) {
        this.locList = locList;
    }
}