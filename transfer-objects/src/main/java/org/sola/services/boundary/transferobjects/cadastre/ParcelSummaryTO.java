/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.cadastre;

import org.sola.services.common.contracts.AbstractBasicIdTO;

/**
 *
 * @author Kumar
 */
public class ParcelSummaryTO extends AbstractBasicIdTO {

    private String mapsheetId;
    private String firstName;
    private String lastName;
    private int parcelno;

    public ParcelSummaryTO() {
        super();
    }

    public String getMapsheetId() {
        return mapsheetId;
    }

    public void setMapsheetId(String mapsheetId) {
        this.mapsheetId = mapsheetId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getParcelno() {
        return parcelno;
    }

    public void setParcelno(int parcelno) {
        this.parcelno = parcelno;
    }
}
