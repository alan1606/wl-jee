/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Areas;
import mx.com.gm.sga.domain.EquipoDicom;

/**
 *
 * @author alanm
 */
@Local
public interface EquipoDicomService {

    public EquipoDicom encontrarEquipoDicomPorId(EquipoDicom equipo);

    public List<EquipoDicom> encontrarEquipoDicomPorArea(Areas area);

    public List<EquipoDicom> encontrarEquipoDicomPorModalidad(String modalidad);

    public List<EquipoDicom> encontrarEquipoDicomPorIdArea(Integer idArea);

public List<EquipoDicom> encontrarEquipoDicomLikeNombre(String nombre);
    public List<EquipoDicom> listarEquiposDicom();
    public void guardarEquipoDicom(EquipoDicom equipo);
    public void actualizarEquipoDicom(EquipoDicom equipo);
    
    public EquipoDicom encontrarEquipoDicomPorNombre(String nombre);

}
