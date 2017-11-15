/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.controller;

import co.edu.ucatolica.DAOs.PersonaDAO;
import co.edu.ucatolica.DAOs.SolicitudDAO;
import co.edu.ucatolica.DTOs.Persona;
import co.edu.ucatolica.DTOs.Solicitud;
import co.edu.ucatolica.bds.MySqlDataSource;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("/")
public class SolicitudController {

    // @RequestMapping("SolicitudCrear.htm")
    @RequestMapping(method = RequestMethod.GET, value = "SolicitudCrear.htm")
    public String processSubmit1crear(HttpServletRequest req, SessionStatus status, ModelMap model) {

        PersonaDAO pDao = new PersonaDAO();
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit1...");
        Persona p = new Persona();
        List<Persona> datos = pDao.consultarPersona1(MySqlDataSource.getConexionBD());
        // List<ClienteDTO> datos =p.getDatos();
        //Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, "Consultar + " + "-" + datos.size());

        model.put("listaSolicitud", datos);
        if (datos.size() > 0) {
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!" + datos.size());
        } else {
            model.put("mensaje", "La consulta NO tiene resultados...");
        }

        return "Solicitud_crear";
    }

    //---------------------------------------------------------------------------------------------------------
    @RequestMapping(method = RequestMethod.GET, value = "SolicitudDigita.htm")
    public String processSubmit2(HttpServletRequest req, SessionStatus status, ModelMap model) {

        System.out.println("SolicitudDigita");
        model.put("mensajeSolicitud", "Pase por el controller de Solicitud:::" + req.getParameter("nombre"));
        return "Solicitud_digita";
    }

    @RequestMapping(method = RequestMethod.POST, value = "SolicitudRegistrar.htm")
    public String processSubmit3(HttpServletRequest req, SessionStatus status, ModelMap model) {

        SolicitudDAO pDao = new SolicitudDAO();
        PersonaDAO PA = new PersonaDAO();
        Logger.getLogger(SolicitudController.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
        Integer id = pDao.obtenerId(MySqlDataSource.getConexionBD());
        String clienteIdPersona = req.getParameter("identificacion");
        Integer idclient = PA.obtenerIdCliente(clienteIdPersona, MySqlDataSource.getConexionBD());
        String productoidProducto = req.getParameter("productoidProducto");
        String ingMen = req.getParameter("ingMen");
        String ocupacion = req.getParameter("ocupacion");
        String tipoSolicitud = pDao.obtenerTipo(productoidProducto, MySqlDataSource.getConexionBD());
        System.out.println(tipoSolicitud);
        String est = "pendiente";

        Solicitud s = new Solicitud();
        s.setIdSolicitud(id);
        s.setProductoidProducto(Integer.parseInt(productoidProducto));
        s.setClienteIdPersona(idclient);
        s.setIngMen(ingMen);
        s.setOcupacion(ocupacion);
        s.setTipoSolicitud(tipoSolicitud);
        s.setEstado(est);

        boolean insert = pDao.create(s, MySqlDataSource.getConexionBD());

        Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, "Registrar + " + "-" + insert);

        if (insert) {
            model.put("mensaje", "El registro fue creado satisfactoriamente!!!");
        } else {
            model.put("mensaje", "El registro NO fue creado, consulte con el administrador...");
        }

        return "Solicitud_digita";
    }

    @RequestMapping(method = RequestMethod.GET, value = "SolicitudConsultar.htm")
    public String processSubmit4(HttpServletRequest req, SessionStatus status, ModelMap model) {
        Logger.getLogger(SolicitudController.class.getName()).log(Level.INFO, "Ejecutando processSubmit4...");
        return "Solicitud_consultar";
    }

    @RequestMapping(method = RequestMethod.POST, value = "SolicitudConsultarForm.htm")
    public String processSubmit5(HttpServletRequest req, SessionStatus status, ModelMap model) {

        SolicitudDAO sDao = new SolicitudDAO();
        PersonaDAO PA = new PersonaDAO();
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit5...");

        String ident = req.getParameter("identificacion");
        Integer idclient = PA.obtenerIdCliente(ident, MySqlDataSource.getConexionBD());
        Solicitud s = new Solicitud();
        s.setClienteIdPersona(idclient);

        List<Solicitud> datos = sDao.consultarSolicitud(s, MySqlDataSource.getConexionBD());

        Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());

        model.put("listaSolicitud", datos);
        if (datos.size() > 0) {
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!" + datos.size());
        } else {
            model.put("mensaje", "La consulta NO tiene resultados...");
        }

        return "Solicitud_consultar";
    }

    @RequestMapping(method = RequestMethod.GET, value = "SolicitudEditar.htm")
    public String processSubmit6(HttpServletRequest req, SessionStatus status, ModelMap model) {
        Logger.getLogger(SolicitudController.class.getName()).log(Level.INFO, "Ejecutando processSubmit6...");
        return "Solicitud_editar";
    }

    @RequestMapping(method = RequestMethod.POST, value = "SolicitudEditarForm1.htm")
    public String processSubmit7(HttpServletRequest req, SessionStatus status, ModelMap model) {
        SolicitudDAO pDao = new SolicitudDAO();
        PersonaDAO PA = new PersonaDAO();
        Logger.getLogger(PersonaDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit7...");
        
        String ident = req.getParameter("identificacion1");
        Integer idclient = PA.obtenerIdCliente(ident, MySqlDataSource.getConexionBD());
        String idprod = req.getParameter("idprod");
        
        Solicitud s= new Solicitud();
        s.setClienteIdPersona(idclient);
        s.setProductoidProducto(Integer.parseInt(idprod));
        
        List<Solicitud> datos = pDao.consultarSolicitud1(s, MySqlDataSource.getConexionBD());
        Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());
        model.put("listaSolicitud", datos);

        return "Solicitud_editar";
    }

    @RequestMapping(method = RequestMethod.POST, value = "SolicitudEditarForm2.htm")
    public String processSubmit8(HttpServletRequest req, SessionStatus status, ModelMap model) {
        SolicitudDAO pDao = new SolicitudDAO();
        PersonaDAO PA = new PersonaDAO();
        Logger.getLogger(PersonaDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit8...");

        String clienteIdPersona = req.getParameter("identificacion");
        String ingMen = req.getParameter("ingMen");
        String ocupacion = req.getParameter("ocupacion");
        String productoidProducto = req.getParameter("productoidProducto");
        String estado = req.getParameter("estado");
        Integer idclient = PA.obtenerIdCliente(clienteIdPersona, MySqlDataSource.getConexionBD());
        Integer id = pDao.obtenerIdS(idclient, MySqlDataSource.getConexionBD());
        String tipoSolicitud = pDao.obtenerTipo(productoidProducto, MySqlDataSource.getConexionBD());
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Id Solicitud: " + id + " " + ingMen + " " + ocupacion + " " + tipoSolicitud + " " + estado);

        Solicitud p = new Solicitud();
        p.setIdSolicitud(id);
        p.setClienteIdPersona(idclient);
        p.setIngMen(ingMen);
        p.setOcupacion(ocupacion);
        p.setTipoSolicitud(tipoSolicitud);
        p.setEstado(estado);
        p.setProductoidProducto(Integer.parseInt(productoidProducto));

        boolean res = pDao.editarSolicitud(p, MySqlDataSource.getConexionBD());

        if (res) {
            model.put("mensaje", "Se edito satisfactoriamente!!!");
        } else {
            model.put("mensaje", "NO se guardaron los cambios...");
        }

        return "Solicitud_editar";
    }

    @RequestMapping(method = RequestMethod.GET, value = "SolicitudAceptada.htm")
    public String processSubmit9(HttpServletRequest req, SessionStatus status, ModelMap model) {

        SolicitudDAO sDao = new SolicitudDAO();
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit9...");
        List<Solicitud> datos = sDao.consultarAceptada(MySqlDataSource.getConexionBD());
        // List<ClienteDTO> datos =p.getDatos();
        //Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, "Consultar + " + "-" + datos.size());

        model.put("listaSolicitud", datos);
        if (datos.size() > 0) {
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!" + datos.size());
        } else {
            model.put("mensaje", "La consulta NO tiene resultados...");
        }

        return "Solicitud_aceptada";
    }

    @RequestMapping(method = RequestMethod.GET, value = "SolicitudRechazada.htm")
    public String processSubmit10(HttpServletRequest req, SessionStatus status, ModelMap model) {

        SolicitudDAO sDao = new SolicitudDAO();
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit10...");
        List<Solicitud> datos = sDao.consultarRechazada(MySqlDataSource.getConexionBD());
        // List<ClienteDTO> datos =p.getDatos();
        //Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, "Consultar + " + "-" + datos.size());

        model.put("listaSolicitud", datos);
        if (datos.size() > 0) {
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!" + datos.size());
        } else {
            model.put("mensaje", "La consulta NO tiene resultados...");
        }

        return "Solicitud_rechazada";
    }

    @RequestMapping(method = RequestMethod.GET, value = "SolicitudAprobar.htm")
    public String processSubmit11(HttpServletRequest req, SessionStatus status, ModelMap model) {
        SolicitudDAO sDao = new SolicitudDAO();
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit11...");
        List<Solicitud> datos = sDao.consultarPendiente(MySqlDataSource.getConexionBD());
        // List<ClienteDTO> datos =p.getDatos();
        //Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, "Consultar + " + "-" + datos.size());

        model.put("listaSolicitud", datos);
        if (datos.size() > 0) {
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!" + datos.size());
        } else {
            model.put("mensaje", "La consulta NO tiene resultados...");
        }

        return "Solicitud_aprobar";
    }

    @RequestMapping(method = RequestMethod.GET, value = "SolicitudAprobar1.htm")
    public String processSubmit12(HttpServletRequest req, SessionStatus status, ModelMap model) {
        PersonaDAO pDao = new PersonaDAO();

        Logger.getLogger(PersonaDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit12...");

        Integer id = pDao.obtenerId(MySqlDataSource.getConexionBD());
        String ident = req.getParameter("identificacion");
        String nombre1 = req.getParameter("nombre1");

        Persona p = new Persona();
        p.setId(id);
        p.setIdentificacion(ident);
        p.setNombre1(nombre1);

        List<Persona> datos = pDao.consultarPersona(p, MySqlDataSource.getConexionBD());

        Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());

        model.put("listaPersonas", datos);
        return "Solicitud_aprobar";
    }

    @RequestMapping(method = RequestMethod.GET, value = "SolicitudCliente.htm")
    public String processSubmit13(HttpServletRequest req, SessionStatus status, ModelMap model) {
        Logger.getLogger(SolicitudController.class.getName()).log(Level.INFO, "Ejecutando processSubmit13...");
        return "Solicitud_cliente";
    }

    @RequestMapping(method = RequestMethod.POST, value = "SolicitudClienteForm.htm")
    public String processSubmit14(HttpServletRequest req, SessionStatus status, ModelMap model) {

        SolicitudDAO sDao = new SolicitudDAO();

        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit14...");

        String ident = req.getParameter("identificacion");

        Solicitud s = new Solicitud();
        s.setIdSolicitud(Integer.parseInt(ident));

        List<Solicitud> datos = sDao.consultarSolicitudCliente(s, MySqlDataSource.getConexionBD());

        Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());

        model.put("listaSolicitud", datos);
        if (datos.size() > 0) {
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!" + datos.size());
        } else {
            model.put("mensaje", "La consulta NO tiene resultados...");
        }

        return "Solicitud_cliente";
    }

    @RequestMapping(method = RequestMethod.POST, value = "SolicitudConsultarProdForm.htm")
    public String processSubmit15(HttpServletRequest req, SessionStatus status, ModelMap model) {

        SolicitudDAO sDao = new SolicitudDAO();

        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit15...");

        String ident = req.getParameter("idproducto");

        Solicitud s = new Solicitud();
        s.setProductoidProducto(Integer.parseInt(ident));

        List<Solicitud> datos = sDao.consultarSolicitudprod(s, MySqlDataSource.getConexionBD());

        Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());

        model.put("listaSolicitud", datos);
        if (datos.size() > 0) {
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!" + datos.size());
        } else {
            model.put("mensaje", "La consulta NO tiene resultados...");
        }

        return "Solicitud_cliente";
    }

    //-----------------------------------------------------------------------------------------------------------
    @RequestMapping(method = RequestMethod.GET, value = "SolicitudAf.htm")
    public String processSubmit16(HttpServletRequest req, SessionStatus status, ModelMap model) {

        Logger.getLogger(SolicitudController.class.getName()).log(Level.INFO, "Ejecutando processo Solicitud...");
        return "Solicitud_af";
    }

    @RequestMapping(method = RequestMethod.POST, value="SolicitudEstadoUp.htm")
    public String processSubmit17(HttpServletRequest req, SessionStatus status, ModelMap model) {

        SolicitudDAO pDao = new SolicitudDAO();
        PersonaDAO PA = new PersonaDAO();
        Logger.getLogger(PersonaDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit17...");

        String clienteIdPersona = req.getParameter("idCliente");
        String ingMen = req.getParameter("ingMensual");
        String ocupacion = req.getParameter("ocupacion");
        String productoidProducto = req.getParameter("Producto");
        String estado = req.getParameter("estado");
        Integer idclient = PA.obtenerIdCliente(clienteIdPersona, MySqlDataSource.getConexionBD());
        Integer id = pDao.obtenerIdS2(idclient,Integer.parseInt(productoidProducto), MySqlDataSource.getConexionBD());
        String tipoSolicitud = pDao.obtenerTipo(productoidProducto, MySqlDataSource.getConexionBD());
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Id Solicitud: " + id + " " + ingMen + " " + ocupacion + " " + tipoSolicitud + " " + estado);

        Solicitud s = new Solicitud();
        s.setIdSolicitud(id);
        s.setClienteIdPersona(idclient);
        s.setIngMen(ingMen);
        s.setOcupacion(ocupacion);
        s.setTipoSolicitud(tipoSolicitud);
        s.setEstado(estado);
        s.setProductoidProducto(Integer.parseInt(productoidProducto));

        boolean res = pDao.editarEstado(s, MySqlDataSource.getConexionBD());

        if (res) {
            model.put("mensaje", "Se edito satisfactoriamente!!!");
        } else {
            model.put("mensaje", "NO se guardaron los cambios...");
        }


        return "Solicitud_aprobar";
    }
}
