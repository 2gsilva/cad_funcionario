<% 
String p = (String) session.getAttribute("permissao");

if(p.equals("sim")){             
            
%>   

    <%@page contentType="text/html" pageEncoding="UTF-8"%>

    <!DOCTYPE html>
<html lang="pt-br">
 
  <head>
    <!-- Meta tags Obrigatórias -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Consultar Funcionario</title>
  </head>
    
    <body>
        
        <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">      
    
    <a class="navbar-brand" href="#">
    <img src="imgs/logo.png" width="35" height="35" alt=""/>
  </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado" aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navegação">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
    <ul class="navbar-nav mr-auto">
      
      <li class="nav-item active">
        <a class="nav-link" href="principal.jsp">Página Inicial <span class="sr-only">(página atual)</span></a>
      </li>

      <li class="nav-item">
        <a class="nav-link" href="incluirFuncionario.jsp">Incluir Funcionário</a>
      </li>

      <li class="nav-item">
        <a class="nav-link" href="consultarFuncionario.jsp">Consultar Funcionário</a>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Mais...
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Help</a>
          <a class="dropdown-item" href="#">Contatos</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="ControleLogout">LogOut</a>
        </div>
      </li>
     
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Guilherme S. de Azevedo</a>
      </li>

    </ul>
      </div>
</nav> 
       
        <form action="consultar.funcionario" method="post" style="width:600px">
        
            <div class="form-group">
    <label for="inputAddress"></label>
    <input type="text" name="txtMatricula" class="form-control" id="inputAddress" placeholder="Matrícula"/>
  </div> 
          <button type="submit" class="btn btn-primary">Consultar</button>
          <button type="reset" class="btn btn-primary">Limpar</button>               
        
        </form>                               
    
    </body>
    
</html>

<%
} 

else{
response.sendRedirect("ControleLogout");}
%> 