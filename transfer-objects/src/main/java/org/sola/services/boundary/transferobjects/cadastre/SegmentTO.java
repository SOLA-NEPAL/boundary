/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.cadastre;

import org.sola.services.common.contracts.AbstractIdTO;

/**
 *
 * @author ShresthaKabin
 */
public class SegmentTO extends AbstractIdTO {
    private int sid;
    private int segno;
    private byte[] geomLine;
    private int boundtype;
    private int pid;
    private int mboundtype;
    private int aboundtype;
    private double shapelenth;

    public int getAboundtype() {
        return aboundtype;
    }

    public void setAboundtype(int aboundtype) {
        this.aboundtype = aboundtype;
    }

    public int getBoundtype() {
        return boundtype;
    }

    public void setBoundtype(int boundtype) {
        this.boundtype = boundtype;
    }

    public byte[] getGeomLine() {
        return geomLine;
    }

    public void setGeomLine(byte[] geomLine) {
        this.geomLine = geomLine;
    }

    public int getMboundtype() {
        return mboundtype;
    }

    public void setMboundtype(int mboundtype) {
        this.mboundtype = mboundtype;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSegno() {
        return segno;
    }

    public void setSegno(int segno) {
        this.segno = segno;
    }

    public double getShapelenth() {
        return shapelenth;
    }

    public void setShapelenth(double shapelenth) {
        this.shapelenth = shapelenth;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
