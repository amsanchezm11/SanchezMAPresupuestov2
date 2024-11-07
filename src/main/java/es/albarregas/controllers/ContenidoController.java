package es.albarregas.controllers;

import es.albarregas.beans.ContenidoBean;
import es.albarregas.beans.EleccionBean;
import es.albarregas.models.CalcularCuota;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author alberto
 */
@WebServlet(name = "ContenidoController", urlPatterns = {"/ContenidoController"})
public class ContenidoController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // REDIRIGIMOS A INDEX.JSP
        request.getRequestDispatcher(".").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // POR COMO HEMOS DISEÑADO EL CÓDIGO EN EL CONTROLADOR DE CONTENIDO NO COMPROBAMOS SI EL ATRIBUTO DEL BEAN
        // ELECCION "edificio" ES TRUE/FALSE YA QUE CONTENIDO SE EJECUTA DEPUÉS DE EDIFICIO. POR TANTO, EN CASO DE QUE EDIFICIO
        // NO HAYA SIDO SELECCIONADO EL PROGRAMA VENDRÁ AL CONTROLADOR DE CONTENIDO DIRECTAMENTE Y REDIRECCIONAREMOS A LA VISTA
        // DE RESUMEN LLAMADA "verContenido.jsp"
        // OBTENGO LA SESIÓN
        HttpSession sesion = request.getSession();
        String url = "/JSP/verContenido.jsp";
        // CREO EL BEAN EDIFICIO QUE ES DONDE VAMOS A ALMACENAR LOS DATOS OBTENIDOS EN EL FORMULARIO DE LA VISTA EFIFICIO
        ContenidoBean contenido = new ContenidoBean();
        // CREO EL MODELO CalcularCuota PARA CONTENIDO EN CASO DE QUE NO PUEDA RECUPERAR EL YA CREADO EN EL CONTROLADOR
        // DE EDIFICIO
        CalcularCuota calcularContenido = new CalcularCuota();

        // ALMACENAMOS LOS CAMPOS OBTENIDOS EN CASO DE QUE UNO ESTÉ VACIO SE PARA Y NO ALMACENA MÁS CAMPOS
        Enumeration<String> campos = request.getParameterNames();
        Boolean error = false;
        while (campos.hasMoreElements() && !error) {
            String nombre = campos.nextElement();
            if (request.getParameter(nombre).length() == 0) {
                error = true;
            }
        }

        // EN CASO DE QUE TODOS LOS CAMPOS ESTÉN RELLENOS ALMACENAMOS LOS VALORES EN EL BEAN EDIFICIO
        if (!error) {

            try {
                BeanUtils.populate(contenido, request.getParameterMap());
            } catch (IllegalAccessException | InvocationTargetException ex) {
                Logger.getLogger(EdificioController.class.getName()).log(Level.SEVERE, null, ex);
            }

            // ALMACENAMOS EL BEAN EDIFICIO EN LA SESION
            sesion.setAttribute("contenido", contenido);
        }

        // CALCULAMOS LA CUOTA DE CONTENIDO
        calcularContenido.calcularCuotaContenido(contenido);
        // AÑADIMOS EL MODELO A LA SESIÓN
        sesion.setAttribute("calcularContenido", calcularContenido);

        CalcularCuota calcularCuota = (CalcularCuota) sesion.getAttribute("calcularEdificio");

        // RECUPERO EL BEAN ELECCION PARA SABER SI EDIFICIO HA SIDO SELECCIONADO PREVIAMENTE
        EleccionBean eleccion = (EleccionBean) sesion.getAttribute("eleccion");

        // PRIMERO PASO EL TOTAL DE CONTENIDO
        sesion.setAttribute("totalCoste", calcularContenido.getTotalConjuntoFormateado());

        // COMPRUEBO SI EDIFICIO HA SIDO SELECCIONADO
        if (eleccion.isEdificio()) {
            // CALCULAMOS LA CUOTA DE CONTENIDO
            calcularCuota.calcularCuotaContenido(contenido);
            // Y PISAMOS EL VALOR DE TOTAL COSTE
            sesion.setAttribute("totalCoste", calcularCuota.getTotalConjuntoFormateado());
        }
     
        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
