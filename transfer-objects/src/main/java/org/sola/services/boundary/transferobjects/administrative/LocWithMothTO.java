package org.sola.services.boundary.transferobjects.administrative;

public class LocWithMothTO extends LocTO {
    private MothBasicTO moth;
    
    public LocWithMothTO(){
        super();
    }

    public MothBasicTO getMoth() {
        return moth;
    }

    public void setMoth(MothBasicTO moth) {
        this.moth = moth;
    }
}
