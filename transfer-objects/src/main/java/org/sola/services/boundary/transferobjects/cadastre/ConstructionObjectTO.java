/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.cadastre;

import java.math.BigDecimal;
import org.sola.services.common.contracts.AbstractIdTO;

/**
 *
 * @author ShresthaKabin
 */
public class ConstructionObjectTO  extends AbstractIdTO{
    private int cid;
    private byte[] geomPolygon;
    private int constype;
    private BigDecimal area;

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getConstype() {
        return constype;
    }

    public void setConstype(int constype) {
        this.constype = constype;
    }

    public byte[] getGeomPolygon() {
        return geomPolygon;
    }

    public void setGeomPolygon(byte[] geomPolygon) {
        this.geomPolygon = geomPolygon;
    }
}
