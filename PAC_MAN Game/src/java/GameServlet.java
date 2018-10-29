/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hash
 */
@WebServlet(urlPatterns = {"/game", "/UpdateGame"})
public class GameServlet extends HttpServlet {

    Player player = new Player(0,0,0);
    Board board = new Board();

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
        response.setContentType("text/event-stream;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    String json = "{"+board.get_position()+","+player.currunt_position()+"}";
                   // String json = "{\"DOTS\":[[\"B\",5,6],[\"G\",23,12],[\"R\",34,7],[\"B\",25,8],[\"G\",28,1],[\"R\",42,17],[\"B\",15,36],[\"G\",22,22],[\"R\",5,37],[\"B\",25,28],[\"G\",9,39],[\"R\",10,21]],\"PLAYERS\":[" + player.toString() + ",[\"P2\",5,44,0],[\"P3\",-6,0,44],[\"P4\",10,44,44]]}";
                    out.println("data:" + json);
                    out.println();
                    out.flush();
                    wait();
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(GameServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        synchronized (this) {
            String key = request.getParameter("keypress");
            System.out.println(  key);
            player.getCurruntPosition(key);
            notifyAll();
            Logger.getGlobal().log(Level.SEVERE,key + "");
        }
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
