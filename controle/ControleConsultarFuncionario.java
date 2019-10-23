package estacio.controle;

import estacio.negocio.Funcionario;
import estacio.dao.DAOFuncionario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControleConsultarFuncionario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
      DAOFuncionario dao = null;
      Funcionario funcionario = null;
      RequestDispatcher view = null;
      String mensagem = null;
      
      try{
      dao = new DAOFuncionario();
      funcionario = new Funcionario();      
      funcionario.setMatricula(request.getParameter("txtMatricula"));
      funcionario = dao.consultar(funcionario);     
      
      mensagem = "<div class=\"alert alert-primary\" role=\"alert\"> Consulta realizada com sucesso!</div>";
      request.setAttribute("func", funcionario);
      } 
      
      catch (Exception e){
       mensagem = "<div class=\"alert alert-danger\" role=\"alert\"> Inclusão não realizada!</div>";
      }
      
      finally{
      view = request.getRequestDispatcher("listaFuncionario.jsp");
      request.setAttribute("msg",mensagem);
      view.forward(request, response);
      }
      
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
