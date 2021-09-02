<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
   
 
    <title>Checkout</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/checkout/">

    <!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="CSS/checkout.css" rel="stylesheet">    
       
  </head>
  
<!--  <form action="Confirm" method="POST">
 Name	<input type="text" name="email"> </br>
 Discount<input type="text" name="discount"></br>
 Addresss<input type="text" name="address"></br>
 
 <input type= "submit" value="Submit">
 </form> -->
 
 
  <body class="bg-light">
    <div class="container">
    <form action="Confirm">
  <div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="Images/Logo.jpg" alt="" width="72" height="72">
    <h2>Checkout form</h2>
    <p class="lead">
  </div>




  
  <div class="row">
 
    <div class="col-md-4 order-md-2 mb-4">
      <h4 class="d-flex justify-content-between align-items-center mb-3">
        <span class="text-muted">Your cart</span>
       
      </h4>
      <ul class="list-group mb-3">
        
        <li class="list-group-item d-flex justify-content-between bg-light">
          <div class="text-success">
            <h6 class="my-0">Promo code</h6>
           
          </div>
          
          <span class="text-success"  > 
          <input type="text" name="discount" style="width:50%">
          
          </span>
        </li>
        <li class="list-group-item d-flex justify-content-between">
          <span>Total </span>
          <strong>${cart.getAmount() }</strong>
        </li>
      </ul>

      
        <div class="input-group">
        
          <input type="text" class="form-control"   placeholder="Promo code">
          <div class="input-group-append">
            <button type="submit" class="btn btn-secondary">Redeem</button>
          </div>
          
        </div>
     
    </div>
    <div class="col-md-8 order-md-1">
      <h4 class="mb-3">Billing address</h4>
      <form class="needs-validation" novalidate>
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="Name">Name</label>
            <input type="text" name="name" class="form-control"  placeholder=""  required>
            
            <div class="invalid-feedback">
              Valid name is required.
            </div>
          </div>
          
        </div>

       <!--  <div class="mb-3">
          <label for="username">Username</label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">@</span>
            </div>
            
            
            <input type="text" name="username" class="form-control"  placeholder="Email" required>
            <div class="invalid-feedback" style="width: 100%;">
              Your username is required.
            </div>
          </div>
        </div> -->

       

        <div class="mb-3">
          <label for="address">Address</label>
          <input type="text" name="address" class="form-control"  required>
          <div class="invalid-feedback">
            Please enter your shipping address.
          </div>
        </div>

       

        
        <hr class="mb-4">
        <div class="custom-control custom-checkbox">
          <input type="checkbox" class="custom-control-input" id="same-address">
          <label class="custom-control-label" for="same-address">Shipping address is the same as my billing address</label>
        </div>
        <div class="custom-control custom-checkbox">
          <input type="checkbox" class="custom-control-input" id="save-info">
          <label class="custom-control-label" for="save-info">Save this information for next time</label>
        </div>
       
        <hr class="mb-4">
        <input type="submit" class="btn btn-primary btn-lg btn-block" value="Confirm"  ><!-- class="btn btn-primary btn-lg btn-block" --> 
        
        	
        
        	
        
        	
       
      </form>
    </div>
  </div>
 </form>
  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017-2020 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.slim.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
        <script src="CSS/form-validation.js"></script></body>
</html>
