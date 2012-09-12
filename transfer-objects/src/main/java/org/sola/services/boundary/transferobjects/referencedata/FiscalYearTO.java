/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.referencedata;

import java.util.Date;
import org.sola.services.common.contracts.AbstractCodeTO;

/**
 *
 * @author Kumar
 */
public class FiscalYearTO extends AbstractCodeTO {

    private boolean current;
    private Date startDate;
    private Date endDate;

    public FiscalYearTO() {
        super();
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
