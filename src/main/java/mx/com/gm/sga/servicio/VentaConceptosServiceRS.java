/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
import mx.com.gm.sga.domain.MovimientoCorte;
import mx.com.gm.sga.domain.Pacientes;
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

    @Inject
    private MovimientoCorteService movimientoCorteService;

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

            doc.add(new Paragraph("Corte del " + dateToNaturalDate(fecha) + " en el turno " + turno));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));

            List<Object[]> conceptos = null;
            List<Object[]> formasPago = null;
            List<Object[]> instituciones = null;
            List<Object[]> institucionesAreas = null;
            List<MovimientoCorte> entradasYSalidas = null;
            List<Object[]> cortesias = null;

            Double caja = 0d;

            try {
                if (turno.equals("MATUTINO")) {
                    conceptos = ventaConceptosService.findCorteMatutino(fecha);
                    formasPago = ventaConceptosService.obtenerTotalesCorteMatutinoPorFormaDePago(fecha);
                    instituciones = ventaConceptosService.obtenerTotalesCorteMatutinoPorInstitucion(fecha);
                    institucionesAreas = ventaConceptosService.obtenerTotalesCorteMatutinoPorInstitucionArea(fecha);
                    entradasYSalidas = movimientoCorteService.obtenerMovimientosDeCorteMatutino(fecha);
                    cortesias = ventaConceptosService.findCortesiasMatutinas(fecha);
                } else {
                    conceptos = ventaConceptosService.findCorteVespertino(fecha);
                    formasPago = ventaConceptosService.obtenerTotalesCorteVespertinoPorFormaDePago(fecha);
                    instituciones = ventaConceptosService.obtenerTotalesCorteVespertinoPorInstitucion(fecha);
                    institucionesAreas = ventaConceptosService.obtenerTotalesCorteVespertinoPorInstitucionArea(fecha);
                    entradasYSalidas = movimientoCorteService.obtenerMovimientosDeCorteVespertino(fecha);
                    cortesias = ventaConceptosService.findCortesiasVesperinas(fecha);
                }
            } catch (Exception e) {
            }

            caja = obtenerEfectivo(formasPago);
            caja = caja + calcularEfectivoEntradasSalidas(entradasYSalidas);

            doc.add(tablaPrincipal(conceptos));

            doc.add(tablaPagos(formasPago));

            doc.add(tablaCortesias(cortesias));

            doc.add(tablaInstituciones(instituciones));

            doc.add(tablaEntradasYSalidas(entradasYSalidas));

            doc.add(tablaInstitucionesAreas(institucionesAreas));

            doc.add(new Paragraph("\n"));

            doc.add(new Paragraph("Caja = " + caja));

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

    private String obtenerEstudios(Long idOv) {
        String estudios = "";
        for (VentaConceptos venta : ventaConceptosService.encontarVentaConceptosPorIdOrdenVenta(idOv)) {
            estudios += ("*" + venta.getIdConceptoEs().getConceptoTo() + ",\n\n");
        }
        return estudios.substring(0, estudios.length() - 3);
    }

    private void addTableHeaderTotales(PdfPTable tableTotales) {
        Stream.of("Forma de pago", "Total")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    tableTotales.addCell(header);
                });
    }

    private void addTableHeaderTotalesInstitucion(PdfPTable tableTotalesInstitucion) {
        Stream.of("Institución", "Estudios")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    tableTotalesInstitucion.addCell(header);
                });
    }

    private Element tablaPrincipal(List<Object[]> conceptos) throws DocumentException {
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(new float[]{22.5f, 14.5f, 29.5f, 7.5f, 8.5f, 17.5f}, new Rectangle(100, 100));

        addTableHeader(table);
        Object[] fila;

        for (int i = 0; i < conceptos.size(); i++) {
            fila = conceptos.get(i);
            Long idOv = (Long) fila[2];
            String factura = "NO";
            if ((boolean) fila[4]) {
                factura = "SI";
            }
            String estudios = obtenerEstudios(idOv);
            //addRows(table, new String[]{fila[0].toString(), fila[1].toString(), estudios, fila[3].toString(), factura, fila[5].toString()});
            addRows(table, new String[]{fila[0] + "", fila[1] + "", estudios, fila[3] + "", factura, fila[5] + ""});

        }
        return table;
    }

    private Element tablaPagos(List<Object[]> formasPago) throws DocumentException {
        PdfPTable tableTotales = new PdfPTable(2);
        tableTotales.setWidthPercentage(new float[]{50, 50}, new Rectangle(100, 100));
        addTableHeaderTotales(tableTotales);
        Object[] fila;

        for (int i = 0; i < formasPago.size(); i++) {
            fila = formasPago.get(i);
            addRows(tableTotales, new String[]{fila[0] + "", fila[1] + ""});
        }

        return tableTotales;

    }

    private Element tablaInstituciones(List<Object[]> instituciones) throws DocumentException {
        PdfPTable tableTotalesInstitucion = new PdfPTable(2);
        tableTotalesInstitucion.setWidthPercentage(new float[]{50, 50}, new Rectangle(100, 100));
        addTableHeaderTotalesInstitucion(tableTotalesInstitucion);
        Object[] fila;

        for (int i = 0; i < instituciones.size(); i++) {
            fila = instituciones.get(i);
            addRows(tableTotalesInstitucion, new String[]{fila[0] + "", fila[1] + ""});
        }
        return tableTotalesInstitucion;
    }

    private Element tablaInstitucionesAreas(List<Object[]> institucionesAreas) throws DocumentException {
        PdfPTable tableTotalesInstitucionAreas = new PdfPTable(3);
        tableTotalesInstitucionAreas.setWidthPercentage(new float[]{33, 33, 34}, new Rectangle(100, 100));
        addTableHeaderTotalesInstitucionAreas(tableTotalesInstitucionAreas);
        Object[] fila;

        for (int i = 0; i < institucionesAreas.size(); i++) {
            fila = institucionesAreas.get(i);
            addRows(tableTotalesInstitucionAreas, new String[]{fila[0] + "", fila[1] + "", fila[2] + ""});
        }
        return tableTotalesInstitucionAreas;
    }

    private void addTableHeaderTotalesInstitucionAreas(PdfPTable tableTotalesInstitucionAreas) {
        Stream.of("Institución", "Área", "Total")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    tableTotalesInstitucionAreas.addCell(header);
                });
    }

    private Element tablaEntradasYSalidas(List<MovimientoCorte> entradasYSalidas) throws DocumentException {
        PdfPTable tableEntradasSalidas = new PdfPTable(3);
        tableEntradasSalidas.setWidthPercentage(new float[]{33, 33, 34}, new Rectangle(100, 100));
        addTableHeaderEntradasSalidas(tableEntradasSalidas);
        MovimientoCorte fila;
        String tipo = "";

        for (int i = 0; i < entradasYSalidas.size(); i++) {
            fila = entradasYSalidas.get(i);
            if (fila.getEntrada()) {
                tipo = "ENTRADA";
            } else {
                tipo = "SALIDA";
            }
            addRows(tableEntradasSalidas, new String[]{tipo, fila.getDescripcion(), fila.getCantidad() + ""});
        }
        return tableEntradasSalidas;
    }

    private Element tablaCortesias(List<Object[]> cortesias) throws DocumentException {
        PdfPTable tableCortesias = new PdfPTable(4);
        tableCortesias.setWidthPercentage(new float[]{34, 35, 15, 15}, new Rectangle(100, 100));
        addTableHeaderCortesias(tableCortesias);
        Object[] fila;
        String tipo = "";

        for (int i = 0; i < cortesias.size(); i++) {
            fila = cortesias.get(i);
            addRows(tableCortesias, new String[]{fila[0] + "", fila[1] + "", fila[2] + "", fila[3] + ""});
        }
        return tableCortesias;
    }

    private void addTableHeaderEntradasSalidas(PdfPTable tableEntradasSalidas) {
        Stream.of("Tipo", "Descripción", "Cantidad")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    tableEntradasSalidas.addCell(header);
                });
    }

    private Double obtenerEfectivo(List<Object[]> formasPago) {

        for (Object[] fila : formasPago) {
            if (fila[0].toString().equals("EFECTIVO")) {
                return Double.parseDouble(fila[1] + "");
            }
        }
        return 0d;

    }

    private Double calcularEfectivoEntradasSalidas(List<MovimientoCorte> entradasYSalidas) {
        Double total = 0d;
        for (MovimientoCorte movimiento : entradasYSalidas) {
            if (movimiento.getEntrada()) {
                total += movimiento.getCantidad();
            } else {
                total -= movimiento.getCantidad();
            }
        }
        return total;
    }

    private String dateToNaturalDate(String date) {
        String dia = "";
        String mes = "";
        String anio = "";
        for (int i = 0; i < 4; i++) {
            anio += date.charAt(i);
        }
        for (int i = 5; i < 7; i++) {
            mes += date.charAt(i);
        }
        for (int i = 8; i < 10; i++) {
            dia += date.charAt(i);
        }

        switch (mes) {
            case "01":
                mes = "enero";
                break;
            case "02":
                mes = "febrero";
                break;
            case "03":
                mes = "marzo";
                break;
            case "04":
                mes = "abril";
                break;
            case "05":
                mes = "mayo";
                break;
            case "06":
                mes = "junio";
                break;
            case "07":
                mes = "julio";
                break;
            case "08":
                mes = "agosto";
                break;
            case "09":
                mes = "septiembre";
                break;
            case "10":
                mes = "octubre";
                break;
            case "11":
                mes = "noviembre";
                break;
            default:
                mes = "diciembre";
                break;
        }

        return dia + " de " + mes + " del " + anio;
    }

    private void addTableHeaderCortesias(PdfPTable tableCortesias) {
        Stream.of("Nombre", "Estudio", "Total", "Cobrado")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    tableCortesias.addCell(header);
                });
    }
}

//http://localhost:8080/wl-jee/webservice/ventaConceptos/generatePdf/2021-09-10/turno/vespertino
