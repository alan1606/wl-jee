/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.EquipoDicom;
import mx.com.gm.sga.domain.Areas;

/**
 *
 * @author alanm
 */
public interface EquipoDicomDao {

    public EquipoDicom findEquipoDicomById(EquipoDicom equipo);
    public List<EquipoDicom> findEquipoDicomByArea(Areas area);
    public List<EquipoDicom> findEquipoDicomByModalidad(String modalidad);
    
}
