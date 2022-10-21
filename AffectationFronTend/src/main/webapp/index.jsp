 <%@ page import="
	com.projects.affectation.backend.service.AffecterService,
	com.projects.affectation.backend.service.EmployeService,
	com.projects.affectation.backend.service.LieuService,
	java.util.List , java.text.SimpleDateFormat,
java.util.Date,
 java.util.Scanner" %>
 <%@ include file="/static/headers.jsp" %>
 
<div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
  
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
  	
	<%
				EmployeService employeService = new EmployeService();
				LieuService lieuService = new LieuService();
				AffecterService affecterService = new AffecterService();
				
				 Long countEmp= employeService.getForCount();
				 Long countLieu =  lieuService.getForCount();
				 Long countAff = affecterService.getForCount(); 
	
				
	%>
    <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
        data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full" style="background-color: #DCDCDC;">
        
        <aside class="left-sidebar" data-sidebarbg="skin6" style="background-color: #DCDCDC;">
            <!-- Sidebar scroll-->
                <h1 class="page-title" style="margin-top: -60px  ; text-align: center;color:#737373;">GDA</h1>
            
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                   
                    <ul id="sidebarnav" style="background-color: #DCDCDC;">
                        
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="/AffectationEmploye/"
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
                        <h2 class="page-title">Acceuil</h2>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <div class="d-md-flex">
                            <form role="search" class="app-search d-none d-md-block me-3">
                                <input type="hidden" placeholder="Search..." class="form-control mt-0">
                                <a href="" class="active">  
                                </a>
                            </form>
                            
                        </div>
                    </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
           
            <div class="container-fluid">
               
                <div class="row justify-content-center">
                    <div class="col-lg-4 col-md-12">
                        <div class="white-box analytics-info" style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border-radius: 5px;">
                            <h3 class="box-title">Total Employes </h3>
                            <ul class="list-inline two-part d-flex align-items-center mb-0">
                                
                                <li class="ms-auto"><span class="counter text-success"><%= countEmp %></span></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12" >
                        <div class="white-box analytics-info" style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19); border-radius: 5px;">
                            <h3 class="box-title">Totales Lieus</h3>
                            <ul class="list-inline two-part d-flex align-items-center mb-0">
                                
                                <li class="ms-auto"><span class="counter text-purple"><%= countLieu %></span></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <div class="white-box analytics-info" style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19); border-radius: 5px;">
                            <h3 class="box-title">Totales Affectations</h3>
                            <ul class="list-inline two-part d-flex align-items-center mb-0">
                                
                                <li class="ms-auto"><span class="counter text-info"><%= countAff %></span>
                                </li>
                            </ul>
                        </div>
                    </div>
                    
                      <div class="col-lg-4 col-md-12">
                        <div class="white-box analytics-info" style="width:500px;border-raduis: 15px;margin-top:70px;margin-left:-100px; text-align: center;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);  border-radius: 5px;" >
                            <h3 class="box-title" >Consignes </h3>
                            <p>Veuiller voir le tableau de bord pour la gestion </p>
                        </div>
                    </div>
                </div> 
        </div>
        
    </div>
   </div>
    <%@ include file="/static/footers.jsp" %>