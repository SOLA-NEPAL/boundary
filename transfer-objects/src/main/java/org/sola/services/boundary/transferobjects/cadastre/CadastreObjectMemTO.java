/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.boundary.transferobjects.cadastre;

import java.util.ArrayList;
import java.util.List;
import org.sola.services.common.contracts.AbstractTO;

/**
 *
 * @author ShresthaKabin
 */
public class CadastreObjectMemTO extends AbstractTO {
    List<CadastreObjectTO> cadastreObjectList = new ArrayList<CadastreObjectTO>();

    public List<CadastreObjectTO> getCadastreObjectList() {
        return cadastreObjectList;
    }

    public void setCadastreObjectList(List<CadastreObjectTO> cadastreObjectList) {
        this.cadastreObjectList = cadastreObjectList;
    }
}
