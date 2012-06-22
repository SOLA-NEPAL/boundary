/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.cadastre;

import org.sola.services.common.contracts.AbstractIdTO;

/**
 *
 * @author KumarKhadka
 */
public class MapSheetTO extends AbstractIdTO {

    private String mapNumber;
    private int sheetType;
    private String alpha_code;
    String officeCode;

    public String getAlpha_code() {
        return alpha_code;
    }

    public void setAlpha_code(String alpha_code) {
        this.alpha_code = alpha_code;
    }

    public String getMapNumber() {
        return mapNumber;
    }

    public void setMapNumber(String mapNumber) {
        this.mapNumber = mapNumber;
    }

    public int getSheetType() {
        return sheetType;
    }

    public void setSheetType(int sheetType) {
        this.sheetType = sheetType;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }
}
