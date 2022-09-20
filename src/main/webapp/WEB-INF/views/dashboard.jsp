
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Page title -->
    <title>GoCheeta Cabs</title>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <!--<link rel="shortcut icon" type="image/ico" href="favicon.ico" />-->

    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fontawesome/css/font-awesome.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/metisMenu/dist/metisMenu.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css/animate.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/dist/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sweetalert/lib/sweet-alert.css" />
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/pe-icon-7-stroke/css/pe-icon-7-stroke.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/pe-icon-7-stroke/css/helper.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body class="fixed-navbar sidebar-scroll">

<!-- Simple splash screen-->
<div class="splash"> <div class="color-line"></div><div class="splash-title"><h1>Homer - Responsive Admin Theme</h1><p>Special Admin Theme for small and medium webapp with very clean and aesthetic style and feel. </p><div class="spinner"> <div class="rect1"></div> <div class="rect2"></div> <div class="rect3"></div> <div class="rect4"></div> <div class="rect5"></div> </div> </div> </div>
<!--[if lt IE 7]>
<p class="alert alert-danger">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<!-- Header -->
<div id="header">
    <div class="color-line">
    </div>
    <div id="logo" class="light-version">
        <span>
    GoCheeta
        </span>
    </div>
    <nav role="navigation">
        <div class="header-link hide-menu"><i class="fa fa-bars"></i></div>
        <div class="small-logo">
            <span class="text-primary">HOMER APP</span>
        </div>
        
        <div class="mobile-menu">
            <button type="button" class="navbar-toggle mobile-menu-toggle" data-toggle="collapse" data-target="#mobile-collapse">
                <i class="fa fa-chevron-down"></i>
            </button>
            
        </div>
        <div class="navbar-right">
            <ul class="nav navbar-nav no-borders">
                
                
                
                
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/LogoutServlet.sales">
                        <i class="pe-7s-upload pe-rotate-90"></i>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</div>

<!-- Navigation -->
<aside id="menu">
    <div id="navigation">
        <div class="profile-picture">
            <a href="index.html">
                <img src="${pageContext.request.contextPath}/images/market.png" style="width: 90px;" class="img-circle m-b" alt="logo">
            </a>

            <div class="stats-label text-color">
                <span class="font-extra-bold font-uppercase">${sessionScope.Name}</span>

                <div class="dropdown">
                    
                    <ul class="dropdown-menu animated flipInX m-t-xs">
                        <li><a href="contacts.html">Contacts</a></li>
                        <li><a href="profile.html">Profile</a></li>
                        <li><a href="analytics.html">Analytics</a></li>
                        <li class="divider"></li>
                        <li><a href="login.html">Logout</a></li>
                    </ul>
                </div>


                <div id="sparkline1" class="small-chart m-t-sm"></div>
                
            </div>
        </div>

            <% if (request.getSession().getAttribute("Type").toString().equals("Administrator") && request.getSession().getAttribute("BType").toString().equals("Head") ) { %>
                     <ul class="nav" id="side-menu">
                        <li>
                                 <a href="${pageContext.request.contextPath}/BranchServlet.sales?branch=${sessionScope.Branch}"> <span class="nav-label">Branch</span> </a>
                             </li>
                             <li>
                                 <a href="${pageContext.request.contextPath}/BranchListServlet.sales"> <span class="nav-label">Branches</span> </a>
                             </li>
                            <!--  <li>
                                 <a href="${pageContext.request.contextPath}/CustomerServlet.sales"> <span class="nav-label">Customer Profiles</span> </a>
                             </li>
                             
                             <li>
                                 <a href="${pageContext.request.contextPath}/Sales.sales"> <span class="nav-label">Sales</span> </a>
                             </li>
                             <li>
                                 <a href="${pageContext.request.contextPath}/ProductRequest.sales"> <span class="nav-label">Product Request</span> </a>
                             </li>-->
                             
                             </ul>
            <% } else if(request.getSession().getAttribute("Type").toString().equals("Administrator") && !request.getSession().getAttribute("BType").toString().equals("Head") ) { %>
                           <ul class="nav" id="side-menu">
                        <li>
                                 <a href="${pageContext.request.contextPath}/BranchServlet.sales?branch=${sessionScope.Branch}"> <span class="nav-label">Branch</span> </a>
                             </li>
                            <!-- 
                              <li>
                                 <a href="${pageContext.request.contextPath}/CustomerServlet.sales"> <span class="nav-label">Customer Profiles</span> </a>
                             </li>
                             
                             <li>
                                 <a href="${pageContext.request.contextPath}/BranchListServlet.sales"> <span class="nav-label">Branches</span> </a>
                             </li>
                             <li>
                                 <a href="${pageContext.request.contextPath}/ProductRegister.sales"> <span class="nav-label">Products</span> </a>
                             </li>-->
                             <li>
                                 <a href="${pageContext.request.contextPath}/ProductDetails.sales"> <span class="nav-label">Product Details</span> </a>
                             </li>
                             <li>
                                 <a href="${pageContext.request.contextPath}/Sales.sales"> <span class="nav-label">Sales</span> </a>
                             </li>
                             <li>
                                 <a href="${pageContext.request.contextPath}/ProductRequest.sales"> <span class="nav-label">Product Request</span> </a>
                             </li>
                             <li>
                                 <a href="index.html"> <span class="nav-label">Report</span> </a>
                                 <ul class="nav nav-second-level">
                                     <li><a href="${pageContext.request.contextPath}/RptProductServlet.sales">Products</a></li>
                                     
                                 </ul>
                             </li>
                             </ul>
            <% }  else if(!request.getSession().getAttribute("Type").toString().equals("Administrator") && !request.getSession().getAttribute("BType").toString().equals("Head") ) { %>
                            <ul class="nav" id="side-menu">                
                            <li>
                                <a href="${pageContext.request.contextPath}/Sales.sales"> <span class="nav-label">Orders</span> </a>
                            </li>
                            </ul>
            <% } %>
            
        
    </div>
</aside>

<script src="${pageContext.request.contextPath}/css/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/css/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/css/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/css/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/css/metisMenu/dist/metisMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/css/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/css/sparkline/index.js"></script>
<script src="${pageContext.request.contextPath}/css/jquery-validation/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/css/sweetalert/lib/sweet-alert.min.js"></script>
<script src="${pageContext.request.contextPath}/css/toastr/build/toastr.min.js"></script>

<!-- App scripts -->
<script src="${pageContext.request.contextPath}/scripts/homer.js"></script>

</body>
</html>
