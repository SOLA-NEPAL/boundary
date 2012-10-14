package org.sola.services.boundary.transferobjects.search;

import java.util.List;
import org.sola.services.common.contracts.AbstractTO;

public class LocDetailsTO extends AbstractTO {
    private List<PartyLocTO> parties;
    private List<RrrLocDetailsTO> rrrs;
    
    public LocDetailsTO(){
        super();
    }

    public List<PartyLocTO> getParties() {
        return parties;
    }

    public void setParties(List<PartyLocTO> parties) {
        this.parties = parties;
    }

    public List<RrrLocDetailsTO> getRrrs() {
        return rrrs;
    }

    public void setRrrs(List<RrrLocDetailsTO> rrrs) {
        this.rrrs = rrrs;
    }
}
