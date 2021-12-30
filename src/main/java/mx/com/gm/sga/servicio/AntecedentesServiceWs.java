/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.AntecedenteConcepto;
import mx.com.gm.sga.domain.AntecedenteConceptoIds;
import mx.com.gm.sga.domain.AntecedenteEstudio;
import mx.com.gm.sga.domain.Antecedentes;

/**
 *
 * @author alanm
 */
@WebService
public interface AntecedentesServiceWs {

    @WebMethod
    public void registrarAntecedentes(Antecedentes antecedentes);

    @WebMethod
    public void actualizarAntecedentes(Antecedentes antecedentes);

    @WebMethod
    public List<Antecedentes> listarAntecedentes();

    @WebMethod
    public Antecedentes encontrarAntecedentesPorId(Long id);

    @WebMethod
    public List<Antecedentes> encontrarAntecedentesPorArea(Integer idArea);

    @WebMethod
    public List<Antecedentes> encontrarAntecedentesPorEstudio(Long idEstudio);

    @WebMethod
    public void registrarAntecedenteEstudio(AntecedenteEstudio antecedenteEstudio);

    @WebMethod
    public void registrarAntecedentesEstudio(List<AntecedenteEstudio> antecedenteEstudio);

    @WebMethod
    public Antecedentes encontrarAntecedentePorNombre(String nombre);

    @WebMethod
    public List<Antecedentes> encontrarAntecedentesPorConcepto(Long idConcepto);

    @WebMethod
    public void registrarAntecedenteConcepto(Long idAntecedente, Long idConcepto);

    @WebMethod
    public void eliminarAntecedentesConcepto(Long idAntecedente, Long idConcepto);

    @WebMethod
    public void registrarAntecedentesConcepto(List<AntecedenteConceptoIds> antecedentesConcepto);

    @WebMethod
     public void eliminarTodosAntecedentesConcepto(Long idConcepto);
}
