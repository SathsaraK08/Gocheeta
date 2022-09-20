
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Page title -->
    <title>View Product Returns</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/datatables.net-bs/css/dataTables.bootstrap.min.css" />
 
    
   

</head>
<body class="fixed-navbar sidebar-scroll">
       <jsp:include page="dashboard.jsp"/>
       
<div id="wrapper">

<div class="small-header">
    <div class="hpanel">
        <div class="panel-body">
            <div id="hbreadcrumb" class="pull-right">
                <ol class="hbreadcrumb breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/BranchServlet.sales?branch=${sessionScope.Branch}">Dashboard</a></li>
                    
                    <li class="active">
                        <span>Product </span>
                    </li>
                </ol>
            </div>
            <h2 class="font-light m-b-xs">
                Customer Profiles
            </h2>
            
        </div>
    </div>
</div>

<div class="content">
<div>
    
 <!-- content -->

<div class="row">
    
    <!--tab component -->
    <div class="col-lg-10">
        <div class="hpanel">
            <div class="nav nav-tabs">
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#tab-8">Customers</a></li>
                    </ul>
                <div class="tab-content ">
                    <div id="tab-8" class="tab-pane active">
                        <div class="panel-body">
                            
                        <div class="row " style="padding-bottom:20px;">
                            <div class="col-md-12 text-right">
                                <button class="btn btn-primary " id="CreateCustomer" type="button"><i class="fa fa-plus"></i> New</button>
                            </div>
                        </div>
                          
                    <table id="tblTypes" class="table table-striped table-bordered table-hover" width="100%">
                        <thead>
                        <tr>
                            <th>Index</th>
                            <th>Customer</th>
                            <th>NIC</th>
                            <th>Address</th>
                            <th>Contact</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        
                        <c:forEach items="${Customers}" var="item" varStatus="loop">
                                    <tr>
                                        <td>${loop.index+1}</td>
                                        <td>${item.getName()}</td>
                                        <td>${item.getNic()}</td>
                                        <td>${item.getAddress()}</td>
                                        <td>${item.getPhone()}</td>
                                        <td>
                                            <button class="btn btn-primary btn-circle EditCustomer" type="button" data-type='${item.getJson()}'><i class="fa fa-edit"></i></button>
                                            <button class="btn btn-danger btn-circle DeleteCustomer" type="button" id="" data-type='${item.getJson()}'><i class="fa fa-times"  ></i></button>
                                            <button class="btn btn-primary btn-circle ViewCustomer" type="button" id="" data-type='${item.getJson()}'><i class="fa fa-list"  ></i></button>
                                            
                                        </td>
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
    
   <!--End of tab component -->
    </div>
    
    <!--Create Model Component -->
   <div class="modal fade" id="myModalCreateCustomer" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="color-line"></div>
                                <div class="modal-header text-center">
                                    <h4 class="modal-title">Create Customer </h4>
                                    <small class="font-bold">Customer Profiles could be defined here.!</small>
                                </div>
                                <div class="modal-body">
                                    
                                        
                                     <!--     -->
                                       <form role="form" id="form_createcustomer" class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/CustomerServlet.sales">
                                            
                                           <input type="text" value="CreateCustomer" name="action"  hidden >       
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Customer Name <span class="text-danger">(*)</span></label>
                                            <input type="text" class="form-control input-md" name="name" v-model="customerCreate.name" autocomplete="off">
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>NIC Number <span class="text-danger">(*)</span></label>
                                            <input type="text" class="form-control input-md" name="nic" v-model="customerCreate.nic" autocomplete="off">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Phone</label>
                                            <input type="text" class="form-control input-md" name="phone" v-model="customerCreate.phone" autocomplete="off">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Email <span class="text-danger">(*)</span></label>
                                            <input type="text" class="form-control input-md" name="email" v-model="customerCreate.email" autocomplete="off">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Address</label>
                                            <input type="text" class="form-control input-md" name="address" v-model="customerCreate.address" autocomplete="off">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                                <div class="col-sm-8 col-sm-offset-2">
                                                    <button class="btn btn-default" type="button" data-dismiss="modal">Cancel</button>
                                                    <button class="btn btn-primary" type="submit">Save</button>
                                                </div>
                                            </div>
                                        </form>
                                </div>
                                </div>
                                
                            </div>
                        </div>
                    </div>
   <!-- End of model -->

   <!--Edit Model Component -->
   <div class="modal fade" id="myModalEditCustomer" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="color-line"></div>
                                <div class="modal-header text-center">
                                    <h4 class="modal-title">Edit Customer Profile </h4>
                                    <small class="font-bold">Helps in Sales Management !</small>
                                </div>
                                <div class="modal-body">
                                     <form role="form" id="form_editcustomer" class="form-horizontal"  method="POST" action="${pageContext.request.contextPath}/CustomerServlet.sales">
                                            <input type="text" value="UpdateCustomer" name="action"  hidden >
                                            <input type="text" id="eid" name="id"  hidden >
                                                   
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Customer Name <span class="text-danger">(*)</span></label>
                                            <input type="text" class="form-control input-md" id="ename" name="name" v-model="customerCreate.name" autocomplete="off">
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>NIC Number <span class="text-danger">(*)</span></label>
                                            <input type="text" class="form-control input-md" id="enic" name="nic" v-model="customerCreate.nic" autocomplete="off">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Phone</label>
                                            <input type="text" class="form-control input-md" id="ephone" name="phone" v-model="customerCreate.phone" autocomplete="off">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Email <span class="text-danger">(*)</span></label>
                                            <input type="text" class="form-control input-md" id="eemail" name="email" v-model="customerCreate.email" autocomplete="off">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Address</label>
                                            <input type="text" class="form-control input-md" id="eaddress" name="address" v-model="customerCreate.address" autocomplete="off">
                                        </div>
                                    </div>
                                </div>
                                            <div class="form-group">
                                                <div class="col-sm-8 col-sm-offset-2">
                                                    <button class="btn btn-default" type="button" data-dismiss="modal">Cancel</button>
                                                    <button class="btn btn-primary" type="submit">Save</button>
                                                </div>
                                            </div>
                                        </form>
                                </div>
                                
                            </div>
                        </div>
                    </div>
   <!-- End of model -->
    
   <!--View Model Component -->
   <div class="modal fade" id="myModalViewCustomer" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="color-line"></div>
                                <div class="modal-header text-center">
                                    <h4 class="modal-title">View Customer Profile</h4>
                                    <small class="font-bold">Helps in Sales Management !</small>
                                </div>
                                <div class="modal-body">
                                    <form role="form" id="form_editcustomer" class="form-horizontal"  method="POST" action="${pageContext.request.contextPath}/CustomerServlet.sales">
                                           
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Customer Name <span class="text-danger">(*)</span></label>
                                            <input type="text" class="form-control input-md" id="vname" name="name" v-model="customerCreate.name" autocomplete="off" disabled="">
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>NIC Number <span class="text-danger">(*)</span></label>
                                            <input type="text" class="form-control input-md" id="vnic" name="nic" v-model="customerCreate.nic" autocomplete="off" disabled="">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Phone</label>
                                            <input type="text" class="form-control input-md" id="vphone" name="phone" v-model="customerCreate.phone" autocomplete="off" disabled="">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Email <span class="text-danger">(*)</span></label>
                                            <input type="text" class="form-control input-md" id="vemail" name="email" v-model="customerCreate.email" autocomplete="off" disabled="">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Address</label>
                                            <input type="text" class="form-control input-md" id="vaddress" name="address" v-model="customerCreate.address" autocomplete="off" disabled="">
                                        </div>
                                    </div>
                                </div>
                                            <div class="form-group">
                                                <div class="col-sm-8 col-sm-offset-2">
                                                    <button class="btn btn-default" type="button" data-dismiss="modal">Cancel</button>
                                                    
                                                </div>
                                            </div>
                                        </form>
                                </div>
                                
                            </div>
                        </div>
                    </div>
   <!-- End of model -->
    
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
        //$('#myModal').modal('show');
        
        
        
         
        var currentType;
        $(document).on("submit", "#form_createcustomer", function(event) {
                var $form = $(this);
                $.post($form.attr("action"), $form.serialize(), function(response) {
                    $('#myModalCreate').modal('hide');
                    
                    if(response.IsSuccess)
                    {
                        
                      swal({ title: "Created!",
                      text: "Customer profile has been created!.",
                      type: "success" }, function() {
                            window.location.href = window.location.href
                     });
                      
                    }
                    else
                    {
                       swal("Cancelled", "Something Went Wrong", "error"); 
                    }
                });

                event.preventDefault();
                 // Important! Prevents submitting the form.
        });
        
        
        $(document).on("submit", "#form_editcustomer", function(event) {
                var $form = $(this);

                $.post($form.attr("action"), $form.serialize(), function(response) {
                    $('#myModalEdit').modal('hide');
                    
                    if(response.IsSuccess)
                    {
                        
                      swal({title: "Updated!",
                      text: "Product Type has been Updated!.",
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
        
        
       
        
      
        
        
        $("#form_createcustomer").validate({
            rules: {
                name: {
                    required: true,                   
                },
                phone: {
                    required: true,
                    number:true
                },
                address: {
                    required: true,                   
                },
                nic: {
                    required: true,
                    
                },
                email: {
                    required: true, 
                    email: true
                }
            }
            
                //form.submit();
                
            
        });
      
        
        $("#form_editcustomer").validate({
            rules: {
                 name: {
                    required: true,                   
                },
                phone: {
                    required: true,
                    number:true
                },
                address: {
                    required: true,                   
                },
                nic: {
                    required: true,
                    
                },
                email: {
                    required: true, 
                    email: true
                }
            }
            
        });
    
      
        
       // Attach Button click event listener 
         $('.DeleteCustomer').click(function () {
             var imageObj = $(this).data('type');
             // set modal values
             currentType = imageObj.id;
            swal({
                        title: "Are you sure?",
                        text: "Your will not be able to recover this Customer Profile!",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "Yes, delete it!",
                        cancelButtonText: "No, cancel!",
                        closeOnConfirm: false,
                        closeOnCancel: false },
                    function (isConfirm) 
                    {
                            
                           if (isConfirm)  {
                            var form = $(this).closest('form');
                            form = form.serializeArray();
                            form = form.concat([
                                {name: "id", value:currentType } ,
                                {name: "action", value:"DeleteCustomer" }

                            ]);
                            $.post('${pageContext.request.contextPath}/CustomerServlet.sales', form, function(d) {
                                
                                if (d.IsSuccess) {
                                    swal({title: "Deleted!",
                      text: "Customer Profile has been deleted.",
                      type: "success"}, function() {
                            window.location.href = window.location.href
                     });
                                } else {
                                    swal("Cancelled", "Customer Profile has associated sales.Deletion failes!", "error");
                                }
                             });
                            
                        } else 
                        {
                            swal("Cancelled", "Product Type Saved!", "error");
                        }
                    });
        });
                    
        
        
       
        $(".ViewCustomer").click(function(){
             var imageObj = $(this).data('type');
             // set modal values
             $("#vphone").val(imageObj.phone);
             $("#vemail").val(imageObj.email);
             $("#vid").val(imageObj.id);
             $("#vaddress").val(imageObj.address);
             $("#vname").val(imageObj.name);
             $("#vnic").val(imageObj.nic);
             // show Modal
             $('#myModalViewCustomer').modal('show');
        });
        
        
        $("#CreateCustomer").click(function(){
             // show Modal
             $('#myModalCreateCustomer').modal('show');
        });
        
        $(".EditCustomer").click(function(){
             var imageObj = $(this).data('type');
             // set modal values
             
             $("#ephone").val(imageObj.phone);
             $("#eemail").val(imageObj.email);
             $("#eid").val(imageObj.id);
             $("#eaddress").val(imageObj.address);
             $("#ename").val(imageObj.name);
             $("#enic").val(imageObj.nic);
             // show Modal
             $('#myModalEditCustomer').modal('show');
        });
        
        $(function () {

      

        // Initialize Example 1
        $('#tblProducts').dataTable( {
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


          $('#tblTypes').dataTable( {
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
        // Initialize Example 2
        $('#example2').dataTable();
        
        


    });
    
        
    });
    


</script>     
       
</body>
</html>
