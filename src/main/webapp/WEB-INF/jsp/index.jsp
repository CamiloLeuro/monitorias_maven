<%-- 
    Document   : test
    Created on : 4/09/2018, 11:01:34 PM
    Author     : camilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Monitoria</title>

    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>

    <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet"/>

    <link href="resources/css/sb-admin.css" rel="stylesheet"/>

  </head>

  <body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">
      <form action="Inicio.htm" method="POST">
          <button  class="btn btn-link" name = "init" value="${var}">MONITORIAS</button>
        <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle">
        </button>
      </form>
    </nav>
    <div id="wrapper">

      <!-- Sidebar -->
      <ul class="sidebar navbar-nav">
        <li class="nav-item active">
          <form action="Create.htm" method="POST">  
            <button class="btn btn-link" name = "createVista" value="createVista">
              <i class="fas fa-fw fa-pencil-alt"></i>
              <span>SER MONITOR</span>
            </button>
          </form>
        </li>
<!--        <li class="nav-item active">
            <form action="Read.htm" method="POST">  
            <button class="btn btn-link" name = "readVista" value="readVista">
              <i class="fas fa-fw fa-pencil-alt"></i>
              <span>READ</span>
            </button>
          </form>
        </li>
            <form action="Update.htm" method="POST">  
            <button class="btn btn-link" name = "updateVista" value="updateVista">
              <i class="fas fa-fw fa-pencil-alt"></i>
              <span>UPDATE</span>
            </button>
          </form>
        </li>
        <li class="nav-item">
            <form action="Delete.htm" method="POST">  
            <button class="btn btn-link" name = "deleteVista" value="deleteVista">
              <i class="fas fa-fw fa-pencil-alt"></i>
              <span>DELETE</span>
            </button>
          </form>
        </li>-->
      </ul>
      <div id="content-wrapper">
          ${code_inyection}${code_error}
      </div>
    
    <!-- Bootstrap core JavaScript-->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="resources/vendor/chart.js/Chart.min.js"></script>
    <script src="resources/vendor/datatables/jquery.dataTables.js"></script>
    <script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="resources/js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <script src="resources/js/demo/datatables-demo.js"></script>
    <script src="resources/js/demo/chart-area-demo.js"></script>

  </body>

</html>
