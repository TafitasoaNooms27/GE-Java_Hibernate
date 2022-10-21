 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ include file="/static/headers.jsp" %>

<div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
  
    <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
        data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full" style="background-color: #DCDCDC;">
       
        <aside class="left-sidebar" data-sidebarbg="skin6" style="background-color: #DCDCDC;">
            <h1 class="page-title" style="margin-top: -60px  ; text-align: center;color:#737373;">GDA</h1>
            
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav" style="background-color: #DCDCDC; ">
                        <!-- User Profile-->
                        <li class="sidebar-item pt-2">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="/AffectationEmploye"
                                aria-expanded="false">
                                <i class="far fa-clock" aria-hidden="true"></i>
                                <span class="hide-menu">Acceuil</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="/AffectationEmploye/employe"
                                aria-expanded="false">
                                <i class="fa fa-user" aria-hidden="true"></i>
                                <span class="hide-menu">Employe</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="/AffectationEmploye/lieu"
                                aria-expanded="false">
                                <i class="fa fa-table" aria-hidden="true"></i>
                                <span class="hide-menu">Lieu</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="/AffectationEmploye/affecter"
                                aria-expanded="false">
                                <i class="fa fa-font" aria-hidden="true"></i>
                                <span class="hide-menu">Affecter</span>
                            </a>
                        </li>
                       
                       
                    </ul>

                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
       
        <div class="page-wrapper">
           
            <div class="page-breadcrumb bg-white" style="box-shadow: -15px 15px 10px -15px #111; ">
                <div class="row align-items-center">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h3 class="page-title">Gestion des Lieus</h3>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <div class="d-md-flex" >
                            <form role="search" class="app-search d-none d-md-block me-3" style="margin-left:250px;">
                                <input type="text" placeholder="Rechercher par code ou par province.. "  id="search" class="form-control mt-0" style="width: 400px;">
                               
                            </form>
                            
                        </div>
                    </div>
                </div>
                
            </div>
            
             <a href="/AffectationEmploye/lieu-add"  class="btn btn-primary" style="margin-left: 90px;margin-top:20px;" role="button"><i class="fa fa-plus"></i></a>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box" style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border-radius: 5px;">
                            <h4 class="box-title">Listes des Lieus</h4>
                           <br>
                            <div class="table-responsive">
                                <table class="table text-nowrap">
                                    <thead>
                                        <tr>
                                            <th class="border-top-0">Code Lieu</th>
                                            <th class="border-top-0">Designation</th>
                                            <th class="border-top-0">Province</th>
                                            <th class="border-top-0">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody id="lieufiltre">
                                        <c:forEach var ="lieu" items="${listesAllLieu}" >
            									<tr>
               							<td> ${lieu.codeLieu} </td>  <td> ${lieu.designation} </td> <td> ${lieu.province} </td> 
               							  <td><a href="/AffectationEmploye/li-edit?id=${lieu.idLieu}" class="btn btn-success" role="button"><i class="fas fa-edit"></i></a>
              						   <button class="btn btn-danger" onclick="supprimer(${lieu.idLieu})"  data-toggle="modal" data-target="#myModal"><i class="fa fa-trash" aria-hidden="true"></i></button></td>
           						 </tr>
          					 </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           
        </div>
      
    </div>
    
    
     <script>
     function supprimer(id) {
	   document.getElementById('myModal').style.cssText = `
  		display: block;
  		text-align: Center;
`;
	   supp = document.getElementById('btn-suppr');
	   supp.setAttribute("href", "/AffectationEmploye/li-delete?id="+id);
}
</script>


<script>
$(document).ready(function(){
  $("#search").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#lieufiltre tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
    
    <%@ include file="/static/footers.jsp" %>  