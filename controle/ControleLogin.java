package estacio.controle;

import estacio.dao.DAOFuncionario;
import estacio.negocio.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControleLogin", urlPatterns = {"/ControleLogin"})
public class ControleLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
      DAOFuncionario dao = null;
      Funcionario funcionario = null;
      HttpSession sessao = request.getSession();
      
       try{
      String login = request.getParameter("txtLogin");
      String senha = request.getParameter("txtSenha");
           
      dao = new DAOFuncionario();
      funcionario = new Funcionario();      
      funcionario.setLogin(login);
      funcionario.setSenha(senha);
      funcionario = dao.autenticar(funcionario);     
     
     if(funcionario.getLogin().equals(login) && funcionario.getSenha().equals(senha)){ 
           
        sessao.setAttribute("permissao", "sim");
           response.sendRedirect("principal.jsp");}
       
     else{
        response.sendRedirect("ControleLogout");}
       }
         
       catch (Exception e){
        response.sendRedirect("ControleLogout");
       }
            
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
