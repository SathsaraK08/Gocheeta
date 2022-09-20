
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Page title
    <link href="https://cdn.maptiler.com/maptiler-geocoder/v1.1.0/maptiler-geocoder.css" rel="stylesheet" />
    -->
    <title>Branch Management</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/datatables.net-bs/css/dataTables.bootstrap.min.css" />
    <script src="https://cdn.maptiler.com/maptiler-geocoder/v1.1.0/maptiler-geocoder.js"></script>
    <link href="https://cdn.maptiler.com/maptiler-geocoder/v1.1.0/maptiler-geocoder.css" rel="stylesheet" />
    
    <script src="https://cdn.maptiler.com/maplibre-gl-js/v1.13.0-rc.4/mapbox-gl.js"></script>
  <link href="https://cdn.maptiler.com/maplibre-gl-js/v1.13.0-rc.4/mapbox-gl.css" rel="stylesheet" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.0.3/leaflet.js"></script>
    <script src="https://cdn.maptiler.com/mapbox-gl-js/v1.5.1/mapbox-gl.js"></script>
    <script src="https://cdn.maptiler.com/mapbox-gl-leaflet/latest/leaflet-mapbox-gl.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.0.3/leaflet.css" />
    <link rel="stylesheet" href="https://cdn.maptiler.com/mapbox-gl-js/v1.5.1/mapbox-gl.css" />
  <style>
    #map { width: 200px; height: 200px;}
    
  </style>
   

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
                        <span>Branches</span>
                    </li>
                </ol>
            </div>
            <h2 class="font-light m-b-xs">
                Branches
            </h2>
            <small>Mange Branches .</small>
        </div>
    </div>
</div>

<div class="content">
<div>
    
 <!-- content -->

<div class="row">
    
                        <div class="row " style="padding-bottom:20px;">
                            
                        </div>
                    <table id="tblBranches" class="table table-striped table-bordered table-hover" width="100%">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>City</th>
                            <th>Address</th>
                            <th width="15%">Phone</th>
                            <th width="15%">Email</th>                            
                            
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${branches}" var="item">
                                    <tr>
                                        <td>${item.getName()}</td>
                                        <td>${item.getCity()}</td>
                                        <td><c:out value="${item.getAddress()}" /></td>
                                        <td><c:out value="${item.getContact()}" /></td>
                                        <td><c:out value="${item.getEmail()}" /></td>
                                      
                                    </tr>
                            </c:forEach>
                        
                        </tbody>
                    </table>
    
</div>
 
 <!--Create Model Component -->
 <div class="modal fade" id="myModalCreate" tabindex="-1" role="dialog" aria-hidden="true" >
                        <div class="modal-dialog" >
                            <div class="modal-content" >
                                <div class="color-line"></div>
                                <div class="modal-header text-center">
                                    <h4 class="modal-title">Create Branch</h4>
                                    <small class="font-bold">Could create System Users, Vehicles, Drivers under this Branch Later!</small>
                                </div>
                                <div class="modal-body">
                                    
                                     
                                     <!--  <input type="text"  name="city"  required>   -->
                                     <form role="form" id="form_createbranch" class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/BranchServlet.sales">
                                            
                                           
                                            <input type="text" value="CreateBranch" name="action"  hidden >
                                            <input type="text" id="clong" name="long"  hidden >
                                            <input type="text"  id="clati" name="lati"  hidden >
                                            <input type="text" id="ccity"  name="city"  hidden>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Branch City<span style="color: red;">*</span></label>
                                                <div class="col-sm-10">  <input autocomplete="off"  class="form-control" id="search"  type="text"></div>
                                            </div>
                                            
                                            <div class="form-group"><label class="col-sm-2 control-label" >Name<span style="color: red;">*</span></label>
                                            <div class="col-sm-10"><input type="text" placeholder="Name" name="name" id="cname" class="form-control" required></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Address<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><textarea   class="form-control"  name="address" name="address" id="caddress" placeholder="Address" required></textarea></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Contact<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><input type="number" placeholder="Contact" name="contact" id="ccontact" class="form-control" required></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Email<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><input type="email" placeholder="Email" name="email" id="cemail" class="form-control" required></div>
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
                                    <h4 class="modal-title">Edit Branch Basic Details</h4>
                                    <small class="font-bold">Could create System Users, Vehicles, Drivers under this Branch using Info!</small>
                                </div>
                                <div class="modal-body">
                                     <form role="form" id="form_editbranch" class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/BranchServlet.sales">
                                            
                                            <input type="text" value="EditBranch" name="action"  hidden >
                                            <input type="text" name="id" id="eid" hidden >
                                            <input type="text" id="elong" name="long"  hidden >
                                            <input type="text"  id="elati" name="lati"  hidden >
                                            <input type="text" id="ecity"  name="city"  hidden>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Branch City<span style="color: red;">*</span></label>
                                            <div class="col-sm-10"><input autocomplete="off"  class="form-control" id="search2" placeholder="Branch City"  type="text"></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Name<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><input type="text" placeholder="Name" name="name" id="ename" class="form-control" required></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Address<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><textarea   class="form-control"  name="address" id="eaddress" placeholder="Address" required></textarea></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Contact<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><input type="number" placeholder="Contact" name="contact" id="econtact" class="form-control" required></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Email<span style="color: red;">*</span></label>
                                                <div class="col-sm-10"><input type="email" placeholder="Email" name="email" id="eemail" class="form-control" required></div>
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
                                    <h4 class="modal-title">View Branch Details</h4>
                                    <small class="font-bold">Could create System Users, Vehicles, Drivers under this Branch using Info!</small>
                                </div>
                                <div class="modal-body">
                                    <form role="form" id="form_viewbranch" class="form-horizontal">
                                            
                                           
                                            <div class="form-group"><label class="col-sm-2 control-label" >Branch City</label>
                                            <div class="col-sm-10"><input type="text" placeholder="Branch City" name="vcity" id="vcity" class="form-control" disabled="" required></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Name</label>
                                            <div class="col-sm-10"><input type="text" placeholder="Name" name="vname" id="vname" class="form-control" disabled="" required></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Address</label>
                                                <div class="col-sm-10"><textarea   class="form-control"  name="vaddress" id="vaddress" placeholder="Address" disabled="" required></textarea></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Contact</label>
                                                <div class="col-sm-10"><input type="number" placeholder="Contact" name="vcontact" id="vcontact" class="form-control" disabled="" required></div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-2 control-label" >Email</label>
                                                <div class="col-sm-10"><input type="email" placeholder="Email" name="vemail" id="vemail" class="form-control" disabled="" required></div>
                                            </div>
                                           
                                            <div id="map"></div>
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
        
        var geocoder = new maptiler.Geocoder({
        input: 'search',
        key: 'htrAD6aNhjgaBOvvjE6r'
        });
        geocoder.on('select', function(item) {
          console.log('Selected', item);
          
          $("#clong").val(item.center[0]);
          $("#clati").val(item.center[1]);
          $("#ccity").val(item.text);
          $("#search").val(item.text);
          
        });
        
        
        var geocoder2 = new maptiler.Geocoder({
        input: 'search2',
        key: 'htrAD6aNhjgaBOvvjE6r'
        });
        geocoder2.on('select', function(item) {
          console.log('Selected', item);
          
          $("#elong").val(item.center[0]);
          $("#elati").val(item.center[1]);
          $("#ecity").val(item.text);
          $("#search2").val(item.text);
        });
        
        // map
         // You can remove the following line if you don't need support for RTL (right-to-left) labels:
           
        var currentBranch;
        
         $("#form_createbranch").validate({
            rules: {
                city : {
                    required: true,                   
                },
                name : {
                    required: true,                   
                },
                contact : {
                    required: true,
                    number: true
                },
                email : {
                    required: true, 
                    email: true
                },
                address : {
                    required: true,                   
                }
            }//,
           // submitHandler: function(form) {
           //     form.submit();
           // }
        });
        
        
        $("#form_editbranch").validate({
            rules: {
                city : {
                    required: true,                   
                },
                name : {
                    required: true,                   
                },
                contact : {
                    required: true,
                    number: true
                },
                email : {
                    required: true, 
                    email: true
                },
                address : {
                    required: true,                   
                }
            }//,
           // submitHandler: function(form) {
           //     form.submit();
           // }
        });
        
        
        $(document).on("submit", "#form_createbranch", function(event) {
                var $form = $(this);

                $.post($form.attr("action"), $form.serialize(), function(response) {
                    $('#myModalCreate').modal('hide');
                    
                    if(response.IsSuccess)
                    {
                        
                      swal({title: "Created!",
                      text: "Branch has been created!.",
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
        
        $(document).on("submit", "#form_editbranch", function(event) {
                var $form = $(this);

                $.post($form.attr("action"), $form.serialize(), function(response) {
                    
                    $('#myModalEdit').modal('hide');
                    if(response.IsSuccess)
                    {
                        
                     swal({title: "Updated!",
                      text: "Branch has been updated!.",
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
        
        
        $('#tblBranches').dataTable();
        
        $("#CreateBranch").click(function(){
            
             // show Modal
             $('#myModalCreate').modal('show');
        });
        
        $(".EditBranch").click(function(){
             
             var imageObj = $(this).data('branch');
             // set modal values
             currentBranch = imageObj.Id;
             $("#ename").val(imageObj.Name);
             $("#search2").val(imageObj.City);
             $("#eaddress").val(imageObj.Address);
             $("#econtact").val(imageObj.Contact);
             $("#eemail").val(imageObj.Email);
             $("#eid").val(imageObj.Id);
             
             
             $('#myModalEdit').modal('show');
        });
        
        $(".ViewBranch").click(function(){
             var imageObj = $(this).data('branch');
             // set modal values
             currentBranch = imageObj.Id;
             $("#vname").val(imageObj.Name);
             $("#vcity").val(imageObj.City);
             $("#vaddress").val(imageObj.Address);
             $("#vcontact").val(imageObj.Contact);
             $("#vemail").val(imageObj.Email);
             
             
              var map = L.map('map').setView([6.058773,80.2166209], 6);
            var gl = L.mapboxGL({
              attribution: "\u003ca href=\"https://www.maptiler.com/copyright/\" target=\"_blank\"\u003e\u0026copy; MapTiler\u003c/a\u003e \u003ca href=\"https://www.openstreetmap.org/copyright\" target=\"_blank\"\u003e\u0026copy; OpenStreetMap contributors\u003c/a\u003e",
              style: 'https://api.maptiler.com/maps/streets/style.json?key=htrAD6aNhjgaBOvvjE6r'
            }).addTo(map);
            L.marker([6.058773,80.2166209]).addTo(map);
            L.marker([6.058773,75.2166209]).addTo(map);
             // show Modal
             $('#myModalView').modal('show');
        });
        
        $(".DeleteBranch").click(function () {
            var imageObj = $(this).data('branch');
             // set modal values
             currentBranch = imageObj.Id;
            swal({
                        title: "Are you sure?",
                        text: "Your will not be able to recover this Branch!",
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
                            {name: "id", value:currentBranch } ,
                            {name: "action", value:"DeleteBranch" }
        
                        ]);
                           
                              $.post('${pageContext.request.contextPath}/BranchServlet.sales', form, function(d) {
                            
                                if (d.IsSuccess) {
                                    swal({title: "Deleted!",
                      text: "Branch has been deleted.",
                      type: "success"}, function() {
                            window.location.href = window.location.href
                     });
                                } else {
                                    swal("Cancelled", "Something Went Wrong!", "error");
                                }
                        });
                             
                             
                            
                        } else 
                        {
                            swal("Cancelled", "Product Type Saved!", "error");
                        }
                    });
                            
        });

    });
</script>


</body>


</html>
