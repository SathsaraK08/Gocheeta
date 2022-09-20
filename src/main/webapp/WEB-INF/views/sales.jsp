

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Page title -->
    <title>Sales</title>

    <style type="text/css">
        .group{
            cursor: pointer;
        }
    </style>

    <link rel="stylesheet" href="https://unpkg.com/vue-multiselect@2.1.0/dist/vue-multiselect.min.css">
</head>
<body class="fixed-navbar sidebar-scroll">
<div id="loader" class="center"></div> 
<jsp:include page="dashboard.jsp"/>
<!-- Main Wrapper -->
<div id="wrapper">

    <div class="normalheader transition" style="display: none;">
        <div class="hpanel">
            <div class="panel-body">
                <a class="small-header-action" href="">
                    <div class="clip-header">
                        <i class="fa fa-arrow-up"></i>
                    </div>
                </a>

                <div id="hbreadcrumb" class="pull-right m-t-lg">
                    <ol class="hbreadcrumb breadcrumb">
                        <li><a href="index.html">Dashboard</a></li>
                        <li>
                            <span>Tables</span>
                        </li>
                        <li class="active">
                            <span>Project detail</span>
                        </li>
                    </ol>
                </div>
                <h2 class="font-light m-b-xs">
                    Project detail
                </h2>
                <small>Special page for project detail.</small>
            </div>
        </div>
    </div>

    <div class="content">
        <div id="app">
            <div class="row">
                <div class="col-md-5">


                    <div class="font-bold m-b-sm">
                        Vehicles
                    </div>

                    <div class="row">
                        <form role="form" id="form_editvehicle" class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/Sales.sales">
                        <div class="form-group"><label class="col-sm-2 control-label">Type:</label>

                                               <div class="col-sm-10"><select class="form-control m-b" name="type" id="vdriver">
                                                    <option value="">Select Type</option> 
                                                                                                              
                                                        <option value="Mini Car">Mini Car</option>                                                    
                                                        <option value="Sedan">Sedan</option>
                                                        <option value="Jeep">Jeep</option>
                                                        <option value="Van">Van</option>
                                                        <option value="Bus">Bus</option>
                                                </select>
                                                </div>
                                            </div>
                        <div class="form-group"><label class="col-sm-2 control-label">Pickup:</label>

                                               <div class="col-sm-10"><select class="form-control m-b" name="start" id="vdriver">
                                                    <option value="">Select Area</option> 
                                                                                                              
                                                        <option value="Colombo">Colombo</option>
                                                        <option value="Galle">Galle</option>
                                                        <option value="Kandy">Kandy</option>
                                                        <option value="Matara">Matara</option>                                                    
                                                        
                                                </select>
                                                </div>
                                            </div>
                        <div class="form-group"><label class="col-sm-2 control-label">Drop:</label>

                                               <div class="col-sm-10"><select class="form-control m-b" name="end" id="vdriver">
                                                    <option value="">Select Area</option> 
                                                                                                              
                                                        <option value="Colombo">Colombo</option>
                                                        <option value="Galle">Galle</option>
                                                        <option value="Kandy">Kandy</option>
                                                        <option value="Matara">Matara</option>
                                                        
                                                </select>
                                                </div>
                                            </div>
                            <div class="form-group"><label class="col-sm-2 control-label">Date:</label>                               
                                 <div class="col-sm-10"><input type="date" class="form-control" name="date" id="date" required></div>
                                            </div>
                        <div class="form-group">
                                                <div class="col-sm-8 col-sm-offset-2">
                                                    
                                                    <button class="btn btn-primary" type="submit">Search</button>
                                                </div>
                                            </div>
                        </form>
                    </div>
                    <div class="row">

                       <!-- <div class="col-md-12" >
                            <div class="alert alert-warning" >
                                No product were found in stock
                            </div>
                        </div> -->
                        
                        <c:forEach items="${v}" var="item">                                                                                                            
                        <div class="col-xs-6 col-sm-6 col-md-5 ">
                            <div class="hpanel group" >
                                <div class="panel-body text-center">
                                    <i class="fa fa-cab fa-3x text-primary"></i>
                                    <div class="m-t-sm">
                                        <strong>${item.getVtype()} - ${item.getDriver() }</strong>
                                        <p class="small">Contact - ${item.getDcontact()}</p>
                                        <p class="small">Contact - ${item.getCharge()} Rs.</p>
                                        <form role="form" id="form_makeo" class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/Sales.sales">
                                            <input type="text" value="morder" name="action"  hidden >
                                            <input type="text" value="${item.getDriver()}" name="driver"  hidden >
                                            <input type="text" value="${item.getVtype()}" name="type"  hidden >
                                            <input type="text" value="${item.getDest()}" name="end"  hidden >
                                            <input type="text" value="${item.getDate()}" name="date"  hidden >
                                            <input type="text" value="${item.getPick()}" name="start"  hidden >
                                            <input type="text" value="${item.getDriver()}" name="contact"  hidden >
                                            <input type="text" value="${item.getDcontact()}" name="dcon"  hidden >
                                            <input type="text" value="${item.getDid()}" name="did"  hidden >
                                            <input type="text" value="${item.getCharge()}" name="chg"  hidden >
                                            <button class="btn btn-primary" type="submit">Order</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>



                </div>

                <div class="col-md-7">
                    <div class="font-bold m-b-sm">
                        Past Order Details
                    </div>

                    <div class="hpanel">

                        <div class="panel-body">
                            <div class="table-responsive">
                                <table id="tbl" class="table table-striped table-bordered table-hover" width="100%">
                        <thead>
                        <tr>
                            <th>Date</th>
                            <th>Pick up</th>
                            <th>Drop</th>
                            <th width="15%">Vehicle</th>
                            <th width="15%">Charge (Rs.)</th>
                            
                        </tr>
                        </thead>
                        <tbody>
                        
                        <c:forEach items="${orders}" var="o">
                                    <tr>
                                        <td>${o.getDate()}</td>
                                        <td>${o.getPick()}</td>
                                        <td>${o.getDest()}</td>
                                        <td>${o.getVtype()}</td>
                                        <td><c:out value="${o.getCharge()}" /> Rs.</td>
                                    </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                            </div>   
                        </div>

                    </div>
                </div>
            </div>



<!-- comes here -->
               
        </div>
    </div>




    <!-- Footer-->
    <footer class="footer">
        <span class="pull-right">
            J.K Company (PVT) LTD
        </span>
        Developed by xxxx
    </footer>
    
    
   
    
    
    
    
    
    
    

</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/1.0.18/vue.min.js"></script>
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://unpkg.com/vue-multiselect@2.1.0"></script>
<script src="https://unpkg.com/vue-currency-filter"></script>

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
     $(document).on("submit", "#form_makeo", function(event) {
                var $form = $(this);

                $.post($form.attr("action"), $form.serialize(), function(response) {
                    
                    if(response.IsSuccess)
                    {
                                          
                      swal({title: "Done!",
                      text: "Order has been created!.",
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
        
      $('#tbl').dataTable( {
         //   "ajax": '${pageContext.request.contextPath}/api/datatables.json',
            
            dom: "<'row'<'col-sm-4'l><'col-sm-4 text-center'B><'col-sm-4'f>>tp",
            "lengthMenu": [ [10, 25, 50, -1], [10, 25, 50, "All"] ],
            buttons: [
                {extend: 'copy',className: 'btn-sm'},
                {extend: 'csv',title: 'ExampleFile', className: 'btn-sm'},
                {extend: 'pdf', title: 'ExampleFile', className: 'btn-sm'},
                {extend: 'print',className: 'btn-sm'}
            ]
           
        });
        });

</script>

</body>
</html>