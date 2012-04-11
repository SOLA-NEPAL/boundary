/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.system;

import org.sola.services.common.contracts.AbstractReadWriteTO;

/**
 *
 * @author KumarKhadka
 */
public class NepaliYearTO extends AbstractReadWriteTO{
    private int nepYear;
    public NepaliYearTO(){
        super();
    }

    public int getNepYear() {
        return nepYear;
    }

    public void setNepYear(int nepYear) {
        this.nepYear = nepYear;
    }
}
