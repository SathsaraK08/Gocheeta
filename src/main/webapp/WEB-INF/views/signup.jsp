<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Page title -->
    <title>GoCheeta</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fontawesome/css/font-awesome.css"  type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/metisMenu/dist/metisMenu.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css/animate.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/dist/css/bootstrap.css" type="text/css"/>

    <!-- App styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/pe-icon-7-stroke/css/pe-icon-7-stroke.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/pe-icon-7-stroke/css/helper.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/> 

</head>
<body class="blank">
    
<%@ page isErrorPage="true"%>

<%@ page errorPage="error.jsp"%>

<!-- Simple splash screen-->
<div class="splash"> <div class="color-line"></div><div class="splash-title"><h1>Homer - Responsive Admin Theme</h1><p>Special Admin Theme for small and medium webapp with very clean and aesthetic style and feel. </p><div class="spinner"> <div class="rect1"></div> <div class="rect2"></div> <div class="rect3"></div> <div class="rect4"></div> <div class="rect5"></div> </div> </div> </div>
<!--[if lt IE 7]>
<p class="alert alert-danger">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<div class="color-line"></div>


<div class="login-container">
    <div class="row">
        <div class="col-md-12">
            <div class="text-center m-b-md">
                <h3>GoCheeta SIGN UP</h3>
                <small>This is the best app ever!</small>
            </div>
            <div class="hpanel">
                <div class="panel-body">
                        <form role="form" id="register" action="${pageContext.request.contextPath}/LoginServlet.sales" method="POST">
                            <input type="text" value="CreateUser" name="action"  hidden >
                            <input type="text" value="4" name="branch"  hidden >
                            <input type="text" value="Sales" name="type"  hidden >
                            <div class="form-group">
                                <label class="control-label" for="username">Username</label>
                                <input type="text" placeholder="example@gmail.com" title="Please enter you username" required="" value="" name="username" id="username" class="form-control">
                                <span class="help-block small">Your unique username to app</span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="password">Contact</label>
                                <input type="text" title="Contact" placeholder="07**123456" required="" value="" name="contact" id="contact" class="form-control">
                                <span class="help-block small">Your Contact</span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="password">Email</label>
                                <input type="email" title="Contact" placeholder="user@mail.com" required="" value="" name="email" id="email" class="form-control">
                                <span class="help-block small">Your Email</span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="password">NIC</label>
                                <input type="text" title="NIC" placeholder="9XXXXXXXXv" required="" value="" name="nic" id="nic" class="form-control">
                                <span class="help-block small">Your NIC</span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="password">Password</label>
                                <input type="password" title="Please enter your password" placeholder="******" required="" value="" name="password" id="password" class="form-control">
                                <span class="help-block small">Yur strong password</span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="password">Confirm Password</label>
                                <input type="password" title="Please enter your password" placeholder="******" required="" value="" name="confirmpassword" id="confirmpassword" class="form-control">
                                <span class="help-block small">Yur strong password</span>
                            </div>
                            <hr>
                            <button type="submit" class="btn btn-success btn-block">Sign UP</button>
                            <a class="btn btn-default btn-block" href="${pageContext.request.contextPath}/LogoutServlet.sales" hidden="">Login</a>
                        </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 text-center">
            <strong>HOMER</strong> - AngularJS Responsive WebApp <br/> 2015 Copyright Company Name
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/css/jquery-validation/jquery.validate.min.js"></script> 
 <!-- DataTables -->
<script src="${pageContext.request.contextPath}/css/datatables/media/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/css/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- DataTables buttons scripts -->
<script src="${pageContext.request.contextPath}/css/pdfmake/build/pdfmake.min.js"></script>
<script src="${pageContext.request.contextPath}/css/pdfmake/build/vfs_fonts.js"></script>
<script src="${pageContext.request.contextPath}/css/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/css/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/css/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/css/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>

<script>
     $(document).ready(function () {
     $(document).on("submit", "#register", function(event) {
                var $form = $(this);

                $.post($form.attr("action"), $form.serialize(), function(response) {
                    
                    if(response.IsSuccess)
                    {
                                          
                      swal({title: "Done!",
                      text: "User Successfully Signup!.",
                      type: "success"}, function() {
                            window.location.href = window.location.href
                     });
           
                    }
                    else
                    {
                       swal("Cancelled", "Something Went Wrong", "error"); 
                    }
                });

                event.preventDefault(); // Important! Prevents submitting the form.
        });
        
       });

</script>

</body>
</html>