package es.albarregas.controllers;

import es.albarregas.beans.EdificioBean;
import es.albarregas.beans.EleccionBean;
import es.albarregas.beans.TipoConstruccion;
import es.albarregas.beans.TipoEdificio;
import es.albarregas.models.CalcularCuota;
import es.albarregas.models.EnumConverter;
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
import org.apache.commons.beanutils.ConvertUtils;

/**
 *
 * @author alberto
 */
@WebServlet(name = "EdificioController", urlPatterns = {"/EdificioController"})
public class EdificioController extends HttpServlet {

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
        // OBTENGO LA SESIÓN
        HttpSession sesion = request.getSession();
        // OBTENGO EL BEAN ELECCION DE LA SESION
        EleccionBean eleccion = (EleccionBean) sesion.getAttribute("eleccion");
        // CREO LA URL.QUE POR DEFECTO IRÁ A "/JSP/verContenido.jsp"
        String url = "/JSP/verContenido.jsp";
        // CREO EL BEAN EDIFICIO QUE ES DONDE VAMOS A ALMACENAR LOS DATOS OBTENIDOS EN EL FORMULARIO DE LA VISTA EFIFICIO
        EdificioBean edificio = new EdificioBean();
        // CREO EL MODELO CalcularCuota
        CalcularCuota calcularCuota = new CalcularCuota();

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

            ConvertUtils.register(new EnumConverter(), TipoEdificio.class);
            ConvertUtils.register(new EnumConverter(), TipoConstruccion.class);

            try {
                BeanUtils.populate(edificio, request.getParameterMap());
            } catch (IllegalAccessException | InvocationTargetException ex) {
                Logger.getLogger(EdificioController.class.getName()).log(Level.SEVERE, null, ex);
            }

            // ALMACENAMOS EL BEAN EDIFICIO EN LA SESION
            sesion.setAttribute("edificio", edificio);
        }

        // CALCULO LA CUOTA DE EDIFICIO PASANDOLE EL BEAN "edificio" POR PARAMETRO
        calcularCuota.calcularCuotaEdificio(edificio);
        // AÑADIMOS EL MODELO A LA SESIÓN
        sesion.setAttribute("calcularEdificio", calcularCuota);
       
        //sesion.setAttribute("totalCosteEdificio", calcularCuota.getTotalEdificio());
        
        // PASO EL COSTE TOTAL DEL SEGURO FORMATEADO
        sesion.setAttribute("totalCoste", calcularCuota.getTotalConjuntoFormateado());
        
        // COMPRUEBO EN EL BEAN SI CONTENIDO ES TRUE. EN CASO AFIRMATIVO REDIRECCIONAREMOS LA URL A "/JSP/contenidoVista.jsp"
        if (eleccion.isContenido()) {
            sesion.setAttribute("calcularEdificio", calcularCuota);
            url = "/JSP/contenidoVista.jsp";
        }
        
        // REQUEST DISPATCHER
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
