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
    private String alphaCode;

    public String getAlphaCode() {
        return alphaCode;
    }

    public void setAlphaCode(String alphacode) {
        this.alphaCode = alphacode;
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
}
