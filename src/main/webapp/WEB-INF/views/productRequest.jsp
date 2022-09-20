


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Page title -->
    <title>Product Request</title>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <!--<link rel="shortcut icon" type="image/ico" href="favicon.ico" />-->

  
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
                        Products
                    </div>

                    <div class="row">

                        <div class="col-md-12" v-if="products.length == 0" >
                            <div class="alert alert-warning" >
                                No product were found in stock
                            </div>
                        </div>

                        <div class="col-xs-6 col-sm-6 col-md-4 " v-for="(product,key) in products" v-if="products.length > 0">
                            <div class="hpanel group" v-on:click="addProductToCart(product)">
                                <div class="panel-body text-center">
                                    <i class="fa fa-shopping-bag fa-3x text-primary"></i>
                                    <div class="m-t-sm">
                                        <strong>{{ product.ProductName }} ({{ product.Measure }})</strong>
                                        <!--<p class="small">In Stock: {{ product.AvailableQty }}</p>-->
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>



                </div>

                <div class="col-md-7">
                    <div class="font-bold m-b-sm">
                        Request details
                    </div>

                    <div class="hpanel">

                        <div class="panel-body">

                            <div class="form-group m-b-xl">
                                <label>Select A Branch To Request</label>
                                <multiselect v-model="branch" open-direction="bottom" :options="branches"  placeholder="Select A Branch" label="Name" track-by="Id" :multiple="false"></multiselect>
                            </div>

                            <div class="table-responsive">
                                <table class="table table-bordered table-hoverd m-b-xl">
                                    <thead style="background-color: #f5f5f5;">
                                    <tr class="font-extra-bold font-uppercase text-primary">
                                        <th style="padding-top: 15px;padding-bottom: 15px;">Item</th>
                                        <th style="padding-top: 15px;padding-bottom: 15px;" class="text-center">Quantity</th>
                                      <!--  <th style="padding-top: 15px;padding-bottom: 15px;">Unit Price</th>
                                        
                                        <th style="padding-top: 15px;padding-bottom: 15px;" class="text-right">Total Price</th>-->
                                        <th style="padding-top: 15px;padding-bottom: 15px;"></th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <tr>
                                        <td v-if="items.length == 0" colspan="5">
                                            <div class="alert alert-warning" >
                                                No product were added
                                            </div>
                                        </td>
                                    </tr>

                                    <tr v-for="(item,index) in items" v-if="items.length > 0">
                                        <td>
                                            <a href="#">
                                                {{ item.product_name }} ({{ item.measure }})
                                            </a>
                                        </td>
                                        
                                        <td class="text-center">
                                            <button class="btn btn-sm btn-default" type="button" :disabled="item.quantity == 1" v-on:click="decreaseQuantity(index)"><i class="fa fa-minus"></i></button>
                                            <span class="m-l-md m-r-md">{{ item.quantity }}</span>
                                            <button class="btn btn-sm btn-default" type="button" v-on:click="increaseQuantity(index)"><i class="fa fa-plus"></i></button>
                                        </td>
                                       <!-- <td>
                                            {{ item.unit_price | currency }}
                                        </td>
                                        <td class="text-right">
                                            {{ item.unit_price * item.quantity | currency }}
                                        </td> -->
                                        <td class="text-center">
                                            <button class="btn btn-sm btn-danger2" type="button" v-on:click="removeItem(index)"><i class="fa fa-times"></i></button>
                                        </td>
                                    </tr>

                                    </tbody>

                                    <!--<tfoot style="background-color: #f5f5f5;">
                                    <tr>
                                        <td colspan="5" class="text-center text-primary">
                                            <h4>Grand Total: {{ total_bill | currency }}</h4>
                                        </td>
                                    </tr>
                                    </tfoot>-->
                                </table>

                            </div>

                            <div class="row">
                                <div class="col-md-6">
                                    <button class="btn btn-lg btn-primary btn-block" type="button" v-on:click="checkoutCustomer('cash')"><i class="fa fa-plus"></i> Request </button>
                                </div>
                               <!-- <div class="col-md-6">
                                    <button class="btn btn-lg btn-warning2 btn-block" type="button" v-on:click="checkoutCustomer('card')"><i class="fa fa-credit-card"></i> Card Checkout </button>
                                </div>-->
                            </div>
                        </div>

                    </div>
                </div>
            </div>



            <div class="modal fade" id="addCustomer" tabindex="-1" role="dialog"  aria-hidden="true" data-keyboard="false" data-backdrop="static" >
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-header py-10 px-20">
                            <h4 class="modal-title">Add New Customer</h4>

                        </div>

                        <div class="modal-body px-20" style="padding-bottom: 0px;">
                            
                            <div id="editItem-content">
                                <input type="text" value="CreateCustomers" name="action"  hidden >       
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
                            </div>
                            
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success pull-leftd" v-on:click="saveAndCloseCustomerModal()">Save</button>
                            <button type="button" class="btn btn-default pull-leftd" v-on:click="discardCustomerAddModal()">Discard</button>
                        </div>
                    </div>
                </div>
            </div>



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



<script src="vendor/sweetalert/lib/sweet-alert.js"></script>
<script src="vendor/toastr/build/toastr.min.js"></script>

<!-- App scripts -->
<script src="scripts/homer.js"></script>
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://unpkg.com/vue-multiselect@2.1.0"></script>
<script src="https://unpkg.com/vue-currency-filter"></script>

<script>
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "newestOnTop": true,
        "progressBar": true,
        "positionClass": "toast-top-full-width",
        "timeOut": "1500",
        "extendedTimeOut": "1500",
        "toastClass": "animated fadeInDown",
    }

    if (VueCurrencyFilter) {
        Vue.use(VueCurrencyFilter, {
            symbol: "",
            thousandsSeparator: ",",
            fractionCount: 2,
            fractionSeparator: ".",
            symbolPosition: "back",
            symbolSpacing: true,
            // avoidEmptyDecimals: '',
        })
    }
    var app = new Vue({
        el: '#app',
        components: {
            Multiselect: window.VueMultiselect.default
        },
        data: {
            products: [
                {   Id: 1  , 
                    TypeId: 1,
                    ProductName:'Coca Cola',
                    Description:'Non Alcoholic',
                    SupplierId: 0,
                    UnitPrice: 200.00,
                    Units:0,              
                    Measure:'Botttle',
                    ProductTypeName:'Beverages'
                }
            ],

            branches: [
                {
                    Id: 1,
                    Name: 'Branch01',
                    City :'Colombo',
                    Longtitude: '',
                    Latitude: ''
                    
                }
            ],
            branch: null,

            customerCreate: {
                name: '',
                nic: '',
                phone: '',
                email: '',
                address: '',
            },


            items: []
        },
        computed: {
            total_bill: function() {
                return this.items.reduce(
                    (acc, item) => acc + item.unit_price * item.quantity,
                    0
                );
            }
        },
        methods: {

            checkoutCustomer: function(payment_mode){
                if(this.items.length == 0) {
                    toastr.error('Please add one or more item to request !.');
                } else if(!this.branch){
                    toastr.error('Please select a Branch to request !.');
                } else {
                
                 document.querySelector( 
                  "body").style.visibility = "hidden"; 
                document.querySelector( 
                  "#loader").style.visibility = "visible"; 
                var self = this;
                var arrOfObjs = [];
              /*  var newArrayProducts = this.products.filter(function (el) {
                            return el.nic == self.customer.nic
                                           
                });
    */
                var message ="Branch has requested Below Products ";
                for (var i =0; i < this.items.length; i++) {
                    arrOfObjs.push({ Id: 0, RequestId: 0,ProductId: this.items[i].productId,Qty: this.items[i].quantity });
                    message= message+ "\r\n " +this.items[i].product_name+" : "+this.items[i].quantity + " "+this.items[i].measure+"(s)";
                }
                    // perform save of sale details
                    // perform the post
                    var form = $(this).closest('form');
                            form = form.serializeArray();
                            form = form.concat([
                                
                                {name: "action", value:"CreateProductRequest" },
                                {name: "objs", value:JSON.stringify(arrOfObjs) },
                                {name: "source_branch", value:self.branch.Id },
                                {name: "content", value:message},
                                {name: "to", value:self.branch.Email}
                                
                                
                            ]);
                     $.post('${pageContext.request.contextPath}/ProductRequest.sales', form, function(data) {
                                
                                document.querySelector( 
                                  "#loader").style.display = "none"; 
                                document.querySelector( 
                                  "body").style.visibility = "visible";
                                if (data.IsSuccess) {
                                   
                                  swal({
                                        title: "Success!",
                                        text: 'Product Request Sent to Branch.',
                                        type: "success"
                                    } , function() {
                                        window.location.reload(true);
                                    });
                                                                
                                  
                                } else {
                                    swal("Cancelled", "Something Went Wrong!", "error");
                                }
                               

                             });        
                    
                 /*
                    return;

                    //you may use the following function to save checkout
                    var self = this;
                    var url = '/checkouturl';
                    $.ajax({
                        type: "post",
                        url: url,
                        data: {
                            total_bill: self.total_bill,
                            payment_mode:payment_mode,
                            customer: JSON.stringify(self.customer),  //in the server side you may check if id is empty, mean new customer or existing customer
                            items: JSON.stringify(self.items)
                        },
                        dataType : "json",
                        beforeSend:   function(){
                            //can show a loader
                        }
                    }).done(function(data) {
                        //hide loader

                        swal({
                            title: "Success!",
                            text: data,
                            type: "success"
                        });

                        //refresh the page, so customers and products data list will be updated
                        window.location.reload(true);

                    }).fail(function(data) {
                        //hideloader
                        toastr.error(data);

                    });  */
                }

            },

            fetchProductsAndCustomersData: function(){
                document.querySelector( 
                  "body").style.visibility = "hidden"; 
                document.querySelector( 
                  "#loader").style.visibility = "visible"; 
                var self = this;
                var form = $(this).closest('form');
                            form = form.serializeArray();
                            form = form.concat([
                                
                                {name: "action", value:"GetAllProductsWithBranches" }

                            ]);
           /*     $.ajax({
                    url: '/apiurl',
                    method: 'GET',
                    headers: {
                        //'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content'),
                        //'Authorization': 'Bearer {!! request()->user()->api_token !!}'
                    }
                }).done(function(data) {
                    if (data.customers) {
                        self.customers = data.customers;
                    }

                    if (data.products) {
                        self.products = data.products;
                    }
                }).fail(function(data) {
                    toastr.error(data);
                });  */
                
                
                $.post('${pageContext.request.contextPath}/ProductRequest.sales', form, function(data) {
                                
                               if (data.branches) {
                                     self.branches = data.branches;
                                 }

                              if (data.products) {
                                    self.products = data.products;
                                }
                                document.querySelector( 
                                  "#loader").style.display = "none"; 
                                document.querySelector( 
                                  "body").style.visibility = "visible";
                             });
                
                
            },

            removeItem: function(productIndex){
                if(this.items.length > 0) {
                    this.items.splice(productIndex, 1);
                }
            },

            increaseQuantity: function(productIndex){
                
                
                    this.items[productIndex].quantity++;
                
            },

            decreaseQuantity: function(productIndex){
                //don't let to go bellow 1
                if(this.items[productIndex].quantity > 1) {
                    this.items[productIndex].quantity--;
                }
            },

            addProductToCart: function(product){
                var productIndex = this.items.findIndex(function(r){ return r.productId == product.Id});
                if(productIndex === -1) {
                    this.items.push({
                        productId: product.Id,
                        product_name: product.ProductName,                     
                        quantity: 1, 
                        measure: product.Measure
                    });
                }else{
                    this.items[productIndex].quantity++;
                }

            },

            openAddNewCustomerModal: function (nic) {
                this.customerCreate.nic = nic;
                $("#addCustomer").modal('show');
            },

            saveAndCloseCustomerModal : function () {

                if(this.customerCreate.name == '' || this.customerCreate.nic == '' || this.customerCreate.email == '') {
                    toastr.error("Please fill all the required field.");
                } else {
                    //add to customer array
                    this.customers.push({
                        id: '',
                        name: this.customerCreate.name,
                        nic: this.customerCreate.nic,
                        phone: this.customerCreate.phone,
                        email: this.customerCreate.email,
                        address: this.customerCreate.address
                    });


                    // perform the post
                    var form = $(this).closest('form');
                            form = form.serializeArray();
                            form = form.concat([
                                
                                {name: "action", value:"CreateCustomer" },
                                {name: "name", value:this.customerCreate.name },
                                {name: "nic", value:this.customerCreate.nic },
                                {name: "phone", value:this.customerCreate.phone },
                                {name: "email", value:this.customerCreate.email },
                                {name: "address", value:this.customerCreate.address },
                            ]);
                    $.post('${pageContext.request.contextPath}/Sales.sales', form, function(data) {
                                
                                if (data.IsSuccess) {
                                    swal("Created!", "Customer profile has been created.", "success");
                                    
                                   //select as current customer
                                   this.customer = {
                                       id: '',
                                       name: this.customerCreate.name,
                                       nic: this.customerCreate.nic,
                                       phone: this.customerCreate.phone,
                                       email: this.customerCreate.email,
                                       address: this.customerCreate.address
                                   };
                                } else {
                                    swal("Cancelled", "Something Went Wrong!", "error");
                                }
                               

                             });
                             
                              $('#addCustomer').modal('hide');
                                  //reset the add customer modal form
                                   this.customerCreate = {
                                       name: '',
                                       nic: '',
                                       phone: '',
                                       email: '',
                                       address: '',
                                   };
                }
            },

            discardCustomerAddModal: function () {
                this.customerCreate = {
                    name: '',
                    nic: '',
                    phone: '',
                    email: '',
                    address: '',
                };
                $('#addCustomer').modal('hide');
            }

        },
        watch: {

        },

        mounted: function () {
            //call this function on page mount, so the master data available in post interface
            this.fetchProductsAndCustomersData();
        }
    });


</script>

</body>
</html>