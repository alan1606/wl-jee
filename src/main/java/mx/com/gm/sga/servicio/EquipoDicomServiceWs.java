/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Areas;
import mx.com.gm.sga.domain.EquipoDicom;

/**
 *
 * @author alanm
 */
@WebService
public interface EquipoDicomServiceWs {

    @WebMethod
    public EquipoDicom encontrarEquipoDicomPorId(EquipoDicom equipo);

    @WebMethod
    public List<EquipoDicom> encontrarEquipoDicomPorArea(Areas area);

    @WebMethod
    public List<EquipoDicom> encontrarEquipoDicomPorModalidad(String modalidad);

    @WebMethod
        public List<EquipoDicom> encontrarEquipoDicomPorIdArea(Integer idArea);

}
