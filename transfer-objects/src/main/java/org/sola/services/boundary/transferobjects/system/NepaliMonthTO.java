/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.system;

import org.sola.services.common.contracts.AbstractReadWriteTO;
import org.sola.services.common.contracts.AbstractTO;

/**
 *
 * @author KumarKhadka
 */
public class NepaliMonthTO extends AbstractReadWriteTO{    
    public NepaliMonthTO(){
        super();
    }
    private int nepYear;
    private int nepMonth;
    private int days;

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getNepMonth() {
        return nepMonth;
    }

    public void setNepMonth(int nepMonth) {
        this.nepMonth = nepMonth;
    }

    public int getNepYear() {
        return nepYear;
    }

    public void setNepYear(int nepYear) {
        this.nepYear = nepYear;
    }
    
    
}
