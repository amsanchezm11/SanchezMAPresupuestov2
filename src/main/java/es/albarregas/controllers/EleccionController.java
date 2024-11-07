/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.albarregas.controllers;

import es.albarregas.beans.EleccionBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alberto
 */
@WebServlet(name = "EleccionController", urlPatterns = {"/EleccionController"})
public class EleccionController extends HttpServlet {

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

        // OBTENGO LOS DOS VALORES DEL FORMULARIO DE INDEX.JSP
        String edificioTexto = request.getParameter("edificio");
        String contenidoTexto = request.getParameter("contenido");
        String volver = request.getParameter("volver");
        // CREO EL BEAN ELECCIÓN
        EleccionBean eleccion = new EleccionBean();
        String url = ".";
        // CREO LA SESIÓN
        HttpSession sesion = request.getSession();

        // SI AMBOS INPUTS NO ESTÁN CHEQUEADOS REEDIRECCIONAMOS AL USUARIO AL INDEX.JSP
        if (!"edificio".equals(edificioTexto) && !"contenido".equals(contenidoTexto)) {
            url = ".";
        } else {
            // COMPRUEBO SI EL INUT DE CONTENIDO ESTÁ CHECKED
            if ("contenido".equals(contenidoTexto)) {
                url = "/JSP/contenidoVista.jsp";
                eleccion.setContenido(true);
            }
            // COMPRUEBO SI EL INUT DE EDIFICIO ESTÁ CHECKED
            if ("edificio".equals(edificioTexto)) {
                url = "/JSP/edificioVista.jsp";
                eleccion.setEdificio(true);
            }

            // AÑADO EL BEAN ELECCIÓN A LA SESIÓN
            sesion.setAttribute("eleccion", eleccion);
        }

        if (volver != null) {
            sesion.invalidate();
            url = ".";
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
