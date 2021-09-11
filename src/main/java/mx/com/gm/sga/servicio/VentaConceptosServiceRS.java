/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mx.com.gm.sga.domain.Institucion;
import mx.com.gm.sga.domain.OrdenVenta;
import mx.com.gm.sga.domain.Pacientes;
import mx.com.gm.sga.domain.PagoOrdenVenta;
import mx.com.gm.sga.domain.VentaConceptos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
@Path("/ventaConceptos")
@Stateless

public class VentaConceptosServiceRS {

    static Logger log = LogManager.getRootLogger();

    @Inject
    private VentaConceptosService ventaConceptosService;

    @Inject
    private PagoOrdenVentaService pagoOrdenVentaService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VentaConceptos> listarTodo() {
        return ventaConceptosService.listarTodosVentaConceptos();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("paciente/{idPaciente}/fecha/{fecha}/enWorklist/{wl}")//hace referencia a /personas/{id}
    public List<VentaConceptos> encontrarVentaConceptosPorPacienteFechaEnWorklist(@PathParam("idPaciente") Long idPaciente, @PathParam("fecha") String fecha, @PathParam("wl") boolean wl) {
        log.debug("Hay, a la vergas");
        return ventaConceptosService.encontrarVentaConceptosPorPacienteFechaEnWorklist(new Pacientes(idPaciente), fecha, wl);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("institucion/{idInstitucion}/inicio/{fechaInicio}/fin/{fechaFin}")//hace referencia a /personas/{id}
    public List<VentaConceptos> encontrarVentaConceptosPorInstitucionFechas(@PathParam("idInstitucion") Long idInstitucion, @PathParam("fechaInicio") String fechaInicio, @PathParam("fechaFin") String fechaFin) {
        return ventaConceptosService.encontrarVentaConceptosPorInstitucionFechas(new Institucion(idInstitucion), fechaInicio, fechaFin);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("idPacs/{idPacs}")//hace referencia a /personas/{id}
    public VentaConceptos encontrarVentaConceptosPorIdPacs(@PathParam("idPacs") String idPacs) {
        return ventaConceptosService.encontrarVentaConceptosPorIdPacs(idPacs);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("actualizarOrdenVenta")//hace referencia a /personas/{id}
    public boolean actualizarOrdenVenta() {
        return ventaConceptosService.actualizarIdOrdenVenta();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("idOrdenVenta/{idOrdenVenta}")//hace referencia a /personas/{id}
    public List<VentaConceptos> encontrarVentaConceptosPorIdOrdenVenta(@PathParam("idOrdenVenta") Long idOrdenVenta) {
        return ventaConceptosService.encontarVentaConceptosPorIdOrdenVenta(idOrdenVenta);
    }

    @GET
    @Path("generatePdf/{fecha}/turno/{turno}")
    @Produces({MediaType.APPLICATION_OCTET_STREAM})
    public Response generatePDF(@PathParam("fecha") String fecha, @PathParam("turno") String turno) {
        try {
            return Response.ok().entity(corte(fecha, turno)).
                    header("Content-Disposition",
                            "attachment; filename=\"Corte " + turno + " - " + fecha + ".pdf\"")
                    .header("Expires", "0")
                    .header("Cache-Control", "must-revalidate, post-check=0, pre-check=0")
                    .header("Pragma", "public")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    private ByteArrayInputStream corte(String fecha, String turno) {
        Document doc = new Document(PageSize.LETTER, 30, 30, 30, 30);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter writer;
            try {
                writer = PdfWriter.getInstance(doc, out);
            } catch (DocumentException e) {
            }
            doc.open();
            //Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            //Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC);

            doc.add(new Paragraph("Corte del " + fecha + "  En el turno " + turno));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));

            List<Object[]> conceptos = null;

            try {
                if (turno.equals("matutino")) {
                    conceptos = ventaConceptosService.findCorteMatutino(fecha);
                } else {
                    conceptos = ventaConceptosService.findCorteVespertino(fecha);
                }
            } catch (Exception e) {
            }

            PdfPTable table = new PdfPTable(6);
            addTableHeader(table);
            Object[] fila;
            
            for (int i = 0; i < conceptos.size(); i++) {
                fila = conceptos.get(i);
                Long idOv = (Long) fila[2];
                String factura = "NO";
                if((boolean)fila[4]){
                    factura = "SI";
                }
                String estudios = obtenerEstudios(idOv);
                addRows(table, new String[]{fila[0].toString(), fila[1].toString(),estudios, fila[3].toString(), factura, fila[5].toString()});
            }

            doc.add(table);

            doc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("Paciente", "Institución", "Estudios", "Total", "Factura", "RFC")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, String[] values) {
        for (String value : values) {
            table.addCell(value);
        }
    }

    /*private String[] datosPaciente(VentaConceptos concepto) {
        String factura = "NO";
        String RFC = "";
        if (concepto.getIdOrdenVenta().getRequiereFactura()) {
            factura = "SÍ";
            RFC = concepto.getIdPacienteVc().getRfcP();
        }

        return new String[]{
            concepto.getIdPacienteVc().getNombreCompletoP(),
            concepto.getIdInstitucion().getNombreInstitucion(),
            concepto.getIdOrdenVenta().getTotalEi() + "",
            factura,
            RFC
        };
    }

    private String[] datosConcepto(VentaConceptos concepto) {
        return new String[]{
            "",
            concepto.getIdConceptoEs().getIdAreaTo().getNombreA(),
            concepto.getIdConceptoEs().getConceptoTo(),
            "",
            ""
        };
    }

    private void agregarFormasPago(OrdenVenta ordenVenta, PdfPTable table) {
        List<PagoOrdenVenta> pagos = pagoOrdenVentaService.obtenerPagosDeOrdenVenta(ordenVenta);
        for (PagoOrdenVenta pago : pagos) {
            addRows(table, datosPago(pago));
        }
    }

    private String[] datosPago(PagoOrdenVenta pago) {
        return new String[]{
            "",
            pago.getIdFormaPago().getFormaPagoFp(),
            pago.getCantidad() + "",
            "",
            ""
        };
    }

    private void agregarEnNegritas(PdfPTable table, String[] values) {
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        for (String value : values) {
            Phrase line = new Phrase(value, boldFont);
            table.addCell(line);
        }
    }*/

    private String obtenerEstudios(Long idOv) {
        String estudios = "";
        for(VentaConceptos venta : ventaConceptosService.encontarVentaConceptosPorIdOrdenVenta(idOv)){
            estudios += (venta.getIdConceptoEs().getConceptoTo() + ", ");
        }
        return estudios;
    }
}

//http://localhost:8080/wl-jee/webservice/ventaConceptos/generatePdf/2021-09-10/turno/vespertino
