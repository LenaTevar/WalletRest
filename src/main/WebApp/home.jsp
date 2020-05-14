<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>Wally the Wallet API</title>

<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<!--  IM NOT HERE FOR THE FRONT END, SO BEWARE MOSTERS  -->
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }
      main{
      	margin-top: 75px;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <a class="navbar-brand" href="#">Wally</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
<!-- 
  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/request">Request</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
   -->
</nav>

<main role="main" class="container card-columns">


  
  <div class="card border-success mb-3" style="max-width: 18rem;">
  <div class="card-header">GET</div>
  <div class="card-body text-secondary">
    <h5 class="card-title">All Wallets</h5>
    <p class="card-text">localhost:8080/wallets</p>
  </div>
</div>
<!--  -->
  <div class="card border-success mb-3" style="max-width: 18rem;">
  <div class="card-header">GET</div>
  <div class="card-body text-secondary">
    <h5 class="card-title">All Wallets By User</h5>
    <p class="card-text">localhost:8080/wallets/owner/id</p>
        <p class="card-text">Shows all the users wallets and their balance.</p>
  </div>
</div>  
  <!--  -->
  <div class="card border-info mb-3" style="max-width: 18rem;">
  <div class="card-header">POST</div>
  <div class="card-body text-secondary">
    <h5 class="card-title">Add new Wallet</h5>
    <p class="card-text">localhost:8080/wallets/</p>
    <p class="card-text">Body Json: {"ownerId":"LONG","balance":"DOUBLE"}</p>
  </div>
</div>  
    <!--  -->
  <div class="card border-success mb-3" style="max-width: 18rem;">
  <div class="card-header">GET</div>
  <div class="card-body text-secondary">
    <h5 class="card-title">Get Wallet data</h5>
    <p class="card-text">localhost:8080/wallet/id</p>
  </div>
</div> 
      <!--  -->
  <div class="card border-warning mb-3" style="max-width: 18rem;">
  <div class="card-header">PUT</div>
  <div class="card-body text-secondary">
    <h5 class="card-title">Update wallet</h5>
    <p class="card-text">localhost:8080/wallet/id</p>
    <p class="card-text">Body Json: {"ownerId":"LONG","balance":"DOUBLE"}</p>
  </div>
</div>
        <!--  -->
  <div class="card  border-danger mb-3" style="max-width: 18rem;">
  <div class="card-header">DELETE</div>
  <div class="card-body text-secondary">
    <h5 class="card-title">Delete a  wallet</h5>
    <p class="card-text">localhost:8080/wallet/id</p>
  </div>
</div>
 <!--  -->
  <div class="card border-success mb-3" style="max-width: 18rem;">
  <div class="card-header">GET</div>
  <div class="card-body text-secondary">
    <h5 class="card-title">Get all transactions</h5>
    <p class="card-text">localhost:8080/transactions</p>
  </div>
</div>
 <!--  -->
  <div class="card border-info mb-3" style="max-width: 18rem;">
  <div class="card-header">POST</div>
  <div class="card-body text-secondary">
    <h5 class="card-title">Add new transactions</h5>
    <p class="card-text">localhost:8080/transactions</p>
    <p class="card-text">Body Json: {"walletId": "8", "type": "D"/"C", "amount":"1"}</p>
    <p class="card-text">Use D for Debit or C for Credit</p>
  </div>
</div>  
   <!--  -->
  <div class="card border-success mb-3" style="max-width: 18rem;">
  <div class="card-header">GET</div>
  <div class="card-body text-secondary">
    <h5 class="card-title">Get transaction by id</h5>
    <p class="card-text">localhost:8080/transactions/id</p>
  </div>
</div>
   <!--  -->
  <div class="card border-success mb-3" style="max-width: 18rem;">
  <div class="card-header">GET</div>
  <div class="card-body text-secondary">
    <h5 class="card-title">Get transaction by owner id</h5>
    <p class="card-text">localhost:8080/transactions/ownerid</p>
  </div>
</div>
      <!--  -->
  <div class="card border-warning mb-3" style="max-width: 18rem;">
  <div class="card-header">PUT</div>
  <div class="card-body text-secondary">
    <h5 class="card-title">Update transactions</h5>
    <p class="card-text">localhost:8080/transactions/id</p>
    <p class="card-text">Body Json: {"walletId": "8", "type": "D"/"C", "amount":"1"}</p>
    <p class="card-text">Use D for Debit or C for Credit</p>
  </div>
</div>
        <!--  -->
  <div class="card  border-danger mb-3" style="max-width: 18rem;">
  <div class="card-header">DELETE</div>
  <div class="card-body text-secondary">
    <h5 class="card-title">Delete a  transaction</h5>
    <p class="card-text">localhost:8080/transactions/id</p>
  </div>
</div>





</main><!-- /.container -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="/docs/4.4/assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="/docs/4.4/dist/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script></body>
</html>