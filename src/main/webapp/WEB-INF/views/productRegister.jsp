
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Page title -->
    <title>Product Management</title>

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
                        <span>Product Management </span>
                    </li>
                </ol>
            </div>
            <h2 class="font-light m-b-xs">
                Product Management
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
                    <li class="active"><a data-toggle="tab" href="#tab-8">Product Types</a></li>
                    <li class=""><a data-toggle="tab" href="#tab-9">Products</a></li>
                    <li class=""><a data-toggle="tab" href="#tab-10">Product Returns</a></li>
                </ul>
                <div class="tab-content ">
                    <div id="tab-8" class="tab-pane active">
                        <div class="panel-body">
                            
                        <div class="row " style="padding-bottom:20px;">
                            <div class="col-md-12 text-right">
                                <button class="btn btn-primary " id="CreateType" type="button"><i class="fa fa-plus"></i> New</button>
                            </div>
                        </div>
                          
                    <table id="tblTypes" class="table table-striped table-bordered table-hover" width="100%">
                        <thead>
                        <tr>
                            <th>Index</th>
                            <th>Position</th>
                            <th>Description</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        
                        <c:forEach items="${types}" var="item" varStatus="loop">
                                    <tr>
                                        <td>${loop.index+1}</td>
                                        <td>${item.getType()}</td>
                                        <td>${item.getDescription()}</td>
                                        <td>
                                            <button class="btn btn-primary btn-circle EditType" type="button" data-type='${item.getJson()}'><i class="fa fa-edit"></i></button>
                                            <button class="btn btn-danger btn-circle DeleteType" type="button" id="" data-type='${item.getJson()}'><i class="fa fa-times"  ></i></button>
                                            <button class="btn btn-primary btn-circle ViewType" type="button" id="" data-type='${item.getJson()}'><i class="fa fa-list"  ></i></button>
                                            
                                        </td>
                                    </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                     
                        </div>
                    </div>
                    <div id="tab-10" class="tab-pane ">
                        <div class="panel-body">
                            
                        
                          
                    <table id="tblReturns" class="table table-striped table-bordered table-hover" width="100%">
                        <thead>
                        <tr>
                            <th>Index</th>
                            <th>Product</th>
                            <th># of Returns</th>
                            
                        </tr>
                        </thead>
                        <tbody>
                        
                        <c:forEach items="${returns}" var="item" varStatus="loop">
                                    <tr>
                                        <td>${loop.index+1}</td>
                                        <td>${item.getProductName()}</td>
                                        <td>${item.getQty()}</td>
                                        
                                    </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                     
                        </div>
                    </div>
                    <div id="tab-9" class="tab-pane">
                        <div class="panel-body">
                              <div class="row " style="padding-bottom:20px;">
                            <div class="col-md-12 text-right">
                                <button class="btn btn-primary " id="CreateProduct" type="button"><i class="fa fa-plus"></i> New</button>
                            </div>
                        </div>
                          
                    <table id="tblProducts" class="table table-striped table-bordered table-hover" width="100%">
                        <thead>
                        <tr>
                            <th>Index</th>
                            <th>Name</th>
                            <th>Product Type</th>
                            <th>Unit Price</th>                     
                            <th>Measure</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        
                        <c:forEach items="${products}" var="item" varStatus="loop">
                                    <tr>
                                        <td>${loop.index+1}</td>
                                        <td>${item.getProductName()}</td>
                                        <td>${item.getProductTypeName()}</td>
                                        <td>${item.getUnitPrice()}</td>                                       
                                        <td>${item.getMeasure()}</td>
                                        
                                        <td>
                                            <button class="btn btn-primary btn-circle EditProduct" type="button" data-product='${item.getJson()}'><i class="fa fa-edit"></i></button>
                                            <button class="btn btn-danger btn-circle DeleteProduct" type="button" id="" data-product='${item.getJson()}'><i class="fa fa-times"  ></i></button>
                                            <button class="btn btn-primary btn-circle ViewProduct" type="button" id="" data-product='${item.getJson()}'><i class="fa fa-list"  ></i></button>
                                            
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
   <div class="modal fade" id="myModalCreate" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="color-line"></div>
                                <div class="modal-header text-center">
                                    <h4 class="modal-title">Create Product Type</h4>
                                    <small class="font-bold">Could create Product under this Type Later!</small>
                                </div>
                                <div class="modal-body">
                                    
                                        
                                     <!--     -->
                                       <form role="form" id="form_createtype" class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/ProductRegister.sales">
                                           <input type="text" value="CreateType" name="action"  hidden >
                                            <div class="form-group"><label class="col-sm-2 control-label" >Type<span style="color: red;">*</span></label>
                                            <div class="col-sm-10"><input type="text" placeholder="Item Type" name="type" class="form-control" required></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Description<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><textarea   class="form-control"  name="description" placeholder="Description" required></textarea></div>
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

   <!--Edit Model Component -->
   <div class="modal fade" id="myModalEdit" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="color-line"></div>
                                <div class="modal-header text-center">
                                    <h4 class="modal-title">Edit Product Type</h4>
                                    <small class="font-bold">Could create Product under this Type Later!</small>
                                </div>
                                <div class="modal-body">
                                     <form role="form" id="form_edittype" class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/ProductRegister.sales">
                                            <input type="text" value="EditType" name="action"  hidden >
                                            <input type="text"  name="id" id="eid" hidden >
                                            <div class="form-group"><label class="col-sm-2 control-label" >Type<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><input type="text" placeholder="Item Type" name="type" id="etype" class="form-control" required></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Description<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><textarea   class="form-control"  name="description" id="edescription" placeholder="Description" required></textarea></div>
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
   <div class="modal fade" id="myModalView" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="color-line"></div>
                                <div class="modal-header text-center">
                                    <h4 class="modal-title">View Product Type</h4>
                                    <small class="font-bold">Could create Product using Product Tab!</small>
                                </div>
                                <div class="modal-body">
                                    <form role="form" id="form_viewtype" class="form-horizontal">
                                            <div class="form-group"><label class="col-sm-2 control-label" >Type</label>
                                            <div class="col-sm-10"><input type="text" placeholder="Item Type" disabled="" name="typename" id="vtype" class="form-control" required></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Description</label>
                                                <div class="col-sm-10"><textarea   class="form-control" disabled=""  name="description" id="vdescription" placeholder="Description" required></textarea></div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-8 col-sm-offset-2">
                                                    <button class="btn btn-default" type="button" data-dismiss="modal">Close</button>
                                                    
                                                </div>
                                            </div>
                                        </form>
                                </div>
                                
                            </div>
                        </div>
                    </div>
   <!-- End of model -->
   
   
   <!-- start of product models -->
    <!--Create Model Component -->
   <div class="modal fade" id="myModalCreateProduct" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="color-line"></div>
                                <div class="modal-header text-center">
                                    <h4 class="modal-title">Create Product </h4>
                                    <small class="font-bold">Product Price , Stock availability could be defined here.!</small>
                                </div>
                                <div class="modal-body">
                                    
                                        
                                     <!--     -->
                                       <form role="form" id="form_createproduct" class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/ProductRegister.sales">
                                            
                                            <input type="text" value="CreateProduct" name="action"  hidden >
                                           <div class="form-group"><label class="col-sm-2 control-label">Product Type<span style="color: red;">*</span></label>

                                               <div class="col-sm-10"><select class="form-control m-b" id="type1" name="type">
                                                    <option value="1">option 1</option>
                                                </select>
                                                </div>
                                            </div>
                                           
                                            <div class="form-group"><label class="col-sm-2 control-label" >Product Name<span style="color: red;">*</span></label>
                                            <div class="col-sm-10"><input type="text" placeholder="Product Name" name="product" class="form-control" required></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Description<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><textarea   class="form-control"  name="description" placeholder="Description" required></textarea></div>
                                            </div>
                                           <div class="form-group"><label class="col-sm-2 control-label" >Unit Price<span style="color: red;">*</span></label>
                                               <div class="col-sm-10"><div class="input-group m-b"><span class="input-group-addon">Rs.</span> <input type="number" class="form-control" name="price"> <span class="input-group-addon">.00</span></div></div>
                                            </div>
                                           
                                           <div class="form-group"><label class="col-sm-2 control-label">Measure<span style="color: red;">*</span></label>

                                                <div class="col-sm-10"><select class="form-control m-b" name="measure">
                                                    <option></option>
                                                    <option>Liter</option>
                                                    <option>Kg</option>
                                                    <option>Bottle</option>
                                                    <option>Box</option>
                                                </select>
                                                </div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" ># Available Units<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><input type="number" placeholder="# Units" name="stock" class="form-control" name="units" required></div>
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

   <!--Edit Model Component -->
   <div class="modal fade" id="myModalEditProduct" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="color-line"></div>
                                <div class="modal-header text-center">
                                    <h4 class="modal-title">Edit Product </h4>
                                    <small class="font-bold">Could update Stock details & Price details!</small>
                                </div>
                                <div class="modal-body">
                                     <form role="form" id="form_editproduct" class="form-horizontal"  method="POST" action="${pageContext.request.contextPath}/ProductRegister.sales">
                                            <input type="text" value="EditProduct" name="action"  hidden >
                                            <input type="text" id="eid1" name="id"  hidden >
                                           <div class="form-group"><label class="col-sm-2 control-label">Product Type<span style="color: red;">*</span></label>

                                                <div class="col-sm-10"><select class="form-control m-b" id="etype1" name="type">
                                                       <option value=""></option>
                                                       <option value="1">option 1</option>
                                                       <option value="9">option 9</option>
                                                    
                                                </select>
                                                </div>
                                            </div>
                                           
                                            <div class="form-group"><label class="col-sm-2 control-label" >Product Name<span style="color: red;">*</span></label>
                                            <div class="col-sm-10"><input type="text" placeholder="Product Name" id="eproduct" name="product" class="form-control" required></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Description<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><textarea   class="form-control" id="edescription1"  name="description" placeholder="Description" required></textarea></div>
                                            </div>
                                           <div class="form-group"><label class="col-sm-2 control-label" >Unit Price<span style="color: red;">*</span></label>
                                               <div class="col-sm-10"><div class="input-group m-b"><span class="input-group-addon">Rs.</span> <input type="number" class="form-control" id="eprice" name="price"> <span class="input-group-addon">.00</span></div></div>
                                            </div>
                                           
                                           <div class="form-group"><label class="col-sm-2 control-label">Measure<span style="color: red;">*</span></label>

                                               <div class="col-sm-10"><select class="form-control m-b" id="emeasure" name="measure">
                                                    <option></option>
                                                    <option>Liter</option>
                                                    <option>Kg</option>
                                                    <option>Bottle</option>
                                                    <option>Box</option>
                                                </select>
                                                </div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" ># Available Units<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><input type="number" placeholder="# Units" id="estock" name="stock" class="form-control" name="units" required></div>
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
   <div class="modal fade" id="myModalViewProduct" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="color-line"></div>
                                <div class="modal-header text-center">
                                    <h4 class="modal-title">View Product Details</h4>
                                    <small class="font-bold">Stock details & Price details</small>
                                </div>
                                <div class="modal-body">
                                    <form role="form" id="form_viewproduct" class="form-horizontal">
                                            
                                           <div class="form-group"><label class="col-sm-2 control-label">Product Type</label>

                                               <div class="col-sm-10"><select class="form-control m-b" id="vtype1" name="type" disabled="">
                                                       <option value=""></option>
                                                       <option value="1">option 1</option>
                                                       <option value="9">option 9</option>
                                                </select>
                                                </div>
                                            </div>
                                           
                                            <div class="form-group"><label class="col-sm-2 control-label" >Product Name</label>
                                                <div class="col-sm-10"><input type="text" disabled="" placeholder="Product Name" id="vproduct" name="product" class="form-control" required></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Description</label>
                                                <div class="col-sm-10"><textarea disabled=""  class="form-control" id="vdescription1" name="description" placeholder="Description" required></textarea></div>
                                            </div>
                                           <div class="form-group"><label class="col-sm-2 control-label" >Unit Price</label>
                                               <div class="col-sm-10"><div class="input-group m-b"><span class="input-group-addon">Rs.</span> <input type="number" class="form-control" disabled="" id="vprice" name="price"> <span class="input-group-addon">.00</span></div></div>
                                            </div>
                                           
                                           <div class="form-group"><label class="col-sm-2 control-label">Measure</label>

                                               <div class="col-sm-10"><select class="form-control m-b" id="vmeasure" name="measure" disabled="">
                                                    <option></option>
                                                    <option>Liter</option>
                                                    <option>Kg</option>
                                                    <option>Bottle</option>
                                                    <option>Box</option>
                                                </select>
                                                </div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" ># Available Units</label>
                                                <div class="col-sm-10"><input type="number" placeholder="# Units" id="vstock" name="stock" class="form-control" name="units" disabled="" required></div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-8 col-sm-offset-2">
                                                    <button class="btn btn-default" type="button" data-dismiss="modal">Close</button>
                                                    
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
        $(document).on("submit", "#form_createtype", function(event) {
                var $form = $(this);
                $.post($form.attr("action"), $form.serialize(), function(response) {
                    $('#myModalCreate').modal('hide');
                    
                    if(response.IsSuccess)
                    {
                        
                      swal({ title: "Created!",
                      text: "Product Type has been created!.",
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
        
        
        $(document).on("submit", "#form_edittype", function(event) {
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
        
        
        $(document).on("submit", "#form_createproduct", function(event) {
                var $form = $(this);
                $.post($form.attr("action"), $form.serialize(), function(response) {
                    $('#myModalCreateProduct').modal('hide');
                    
                    if(response.IsSuccess)
                    {
                        
                      swal({title: "Created!",
                      text: "Product has been created!.",
                      type: "success"}, function() {
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
        
        
        $(document).on("submit", "#form_editproduct", function(event) {
                var $form = $(this);
                $.post($form.attr("action"), $form.serialize(), function(response) {
                    $('#myModalEditProduct').modal('hide');
                    
                    if(response.IsSuccess)
                    {
                        
                      swal({title: "Updated!",
                      text: "Product has been updated!.",
                      type: "success"}, function() {
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
        
        
        
        
        $("#form_createtype").validate({
            rules: {
                typename: {
                    required: true,                   
                }
            }
            
                //form.submit();
                
            
        });
      
        
        $("#form_edittype").validate({
            rules: {
                typename: {
                    required: true,                   
                }
            }
            
        });
    
        $("#form_createproduct").validate({
            rules: {
                type : {
                    required: true,                   
                },
                product : {
                    required: true,                   
                },
                description : {
                    required: true,                   
                },
                price : {
                    required: true, 
                    number: true
                },
                measure : {
                    required: true,                   
                },
                units : {
                    required: true,
                    number: true
                }
            }
           // submitHandler: function(form) {
              //  form.submit();
           // }
        });
        
        $("#form_editproduct").validate({
            rules: {
                type : {
                    required: true,                   
                },
                product : {
                    required: true,                   
                },
                description : {
                    required: true,                   
                },
                price : {
                    required: true, 
                    number: true
                },
                measure : {
                    required: true,                   
                },
                units : {
                    required: true,
                    number: true
                }
            }//,
           // submitHandler: function(form) {
           //     form.submit();
           // }
        });
        
        
        
       // Attach Button click event listener 
         $('.DeleteType').click(function () {
             var imageObj = $(this).data('type');
             // set modal values
             currentType = imageObj.Id;
            swal({
                        title: "Are you sure?",
                        text: "Your will not be able to recover this Product Type Details!",
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
                                {name: "action", value:"DeleteType" }

                            ]);
                            $.post('${pageContext.request.contextPath}/ProductRegister.sales', form, function(d) {
                                
                                if (d.IsSuccess) {
                                    swal({title: "Deleted!",
                      text: "Your Product Type has been deleted.",
                      type: "success"}, function() {
                            window.location.href = window.location.href
                     });
                                } else {
                                    swal("Cancelled", "Type has associated products.Deletion failes!", "error");
                                }
                             });
                            
                        } else 
                        {
                            swal("Cancelled", "Product Type Saved!", "error");
                        }
                    });
        });
                    
        
         $('.DeleteProduct').click(function () {
             var imageObj = $(this).data('product');
             // set modal values
             var productId = imageObj.Id;
            swal({
                        title: "Are you sure?",
                        text: "Your will not be able to recover this Product Details!",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "Yes, delete it!",
                        cancelButtonText: "No, cancel!",
                        closeOnConfirm: false,
                        closeOnCancel: false },
                    function (isConfirm) {
                            
                         if (isConfirm) {   
                            var form = $(this).closest('form');
                            form = form.serializeArray();
                            form = form.concat([
                                {name: "id", value:productId } ,
                                {name: "action", value:"DeleteProduct" }

                            ]);
                            $.post('${pageContext.request.contextPath}/ProductRegister.sales', form, function(d) {
                                
                                if (d.IsSuccess) {
                                    swal({title: "Deleted!",
                      text: "Your Product has been deleted.",
                      type: "success"}, function() {
                            window.location.href = window.location.href
                     });
                                } else {
                                    swal("Cancelled", "Product has associated sales or product requests.Deletion failes!", "error");
                                }
                             });
                            
                        } else 
                        {
                            swal("Cancelled", "Product Profile Saved!", "error");
                        }
                    });
        });
       
        $("#CreateProduct").click(function(){
            
             var form = $(this).closest('form');
                            form = form.serializeArray();
                            form = form.concat([
                                
                                {name: "action", value:"GetAllProductTypes" }

                            ]);
                            $.post('${pageContext.request.contextPath}/ProductRegister.sales', form, function(result) {
                                
                                $("#type1").children().remove();
                                $("#type1").append('<option value=""></option>');
                                $.each(result, function (i, item) {
                                    $("#type1").append("<option value='"+item.Id+"'>"+item.Type+"</option>");
                                });
                             });
             // show Modal
             $('#myModalCreateProduct').modal('show');
        });
        
        $(".EditProduct").click(function(){
            var imageObj = $(this).data('product');
            var form = $(this).closest('form');
                            form = form.serializeArray();
                            form = form.concat([
                                
                                {name: "action", value:"GetAllProductTypes" }

                            ]);
                            $.post('${pageContext.request.contextPath}/ProductRegister.sales', form, function(result) {
                                
                                $("#etype1").children().remove();
                                $("#etype1").append('<option value=""></option>');
                                $.each(result, function (i, item) {
                                    $("#etype1").append('<option value="'+item.Id+'">'+item.Type+'</option>');
                                });
                                
                                 
                                    $("#etype1").val(imageObj.TypeId.toString());
                                    $("#edescription1").val(imageObj.Description);         
                                    $("#eid1").val(imageObj.Id);
                                    $("#emeasure").val(imageObj.Measure);
                                    $("#eproduct").val(imageObj.ProductName);
                                    $("#estock").val(imageObj.AvailbleUnits);
                                    $("#eprice").val(imageObj.UnitPrice);

                                    // show Modal
                                    $('#myModalEditProduct').modal('show');
                                
                                
                             });
        });
        
        $(".ViewProduct").click(function(){
            var imageObj = $(this).data('product');
             
            var form = $(this).closest('form');
                            form = form.serializeArray();
                            form = form.concat([
                                
                                {name: "action", value:"GetAllProductTypes" }

                            ]);
                            $.post('${pageContext.request.contextPath}/ProductRegister.sales', form, function(result) {
                                
                                $("#vtype1").children().remove();
                                $("#vtype1").append('<option value=""></option>');
                                $.each(result, function (i, item) {
                                    $("#vtype1").append("<option value='"+item.Id+"'>"+item.Type+"</option>");
                                });
                                $("#vtype1").val(imageObj.TypeId);
                                $("#vdescription1").val(imageObj.Description);
                                $("#vid").val(imageObj.Id);
                                $("#vmeasure").val(imageObj.Measure);
                                $("#vproduct").val(imageObj.ProductName);
                                $("#vstock").val(imageObj.AvailbleUnits);
                                $("#vprice").val(imageObj.UnitPrice);

                                // show Modal
                                $('#myModalViewProduct').modal('show');
                             });    
        });
        
        
        $(".ViewType").click(function(){
             var imageObj = $(this).data('type');
             // set modal values
             
             $("#vtype").val(imageObj.Type);
             $("#vdescription").val(imageObj.Description);
             // show Modal
             $('#myModalView').modal('show');
        });
        
        
        $("#CreateType").click(function(){
             // show Modal
             $('#myModalCreate').modal('show');
        });
        
        $(".EditType").click(function(){
             var imageObj = $(this).data('type');
             // set modal values
             
             $("#etype").val(imageObj.Type);
             $("#edescription").val(imageObj.Description);
             $("#eid").val(imageObj.Id);
             // show Modal
             $('#myModalEdit').modal('show');
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
        $('#tblReturns').dataTable();
        


    });
    
        
    });
    


</script>     
       
</body>
</html>
