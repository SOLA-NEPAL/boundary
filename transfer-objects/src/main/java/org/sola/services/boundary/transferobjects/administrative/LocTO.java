/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.administrative;

import java.util.List;
import org.sola.services.common.contracts.AbstractIdTO;

/**
 *
 * @author KumarKhadka
 */
public class LocTO extends AbstractIdTO {

    private String mothId;
    private int panaNo;
    private int tmpPanaNo;
    private int propertyType;
    private int oshpType;
    private int transactionNo;
    private List<BaUnitTO> baUnits;

    public List<BaUnitTO> getBaUnits() {
        return baUnits;
    }

    public void setBaUnits(List<BaUnitTO> baUnits) {
        this.baUnits = baUnits;
    }

    public String getMothId() {
        return mothId;
    }

    public void setMothId(String mothId) {
        this.mothId = mothId;
    }

    public int getOshpType() {
        return oshpType;
    }

    public void setOshpType(int oshpType) {
        this.oshpType = oshpType;
    }

    public int getPanaNo() {
        return panaNo;
    }

    public void setPanaNo(int panaNo) {
        this.panaNo = panaNo;
    }

    public int getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(int propertyType) {
        this.propertyType = propertyType;
    }

    public int getTmpPanaNo() {
        return tmpPanaNo;
    }

    public void setTmpPanaNo(int tmpPanaNo) {
        this.tmpPanaNo = tmpPanaNo;
    }

    public int getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(int transactionNo) {
        this.transactionNo = transactionNo;
    }
}