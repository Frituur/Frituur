
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
  <title>Bestellingsoverzicht</title>
  <link rel="stylesheet" href="../frituur.css" />
  <script src="https://kit.fontawesome.com/187b41207f.js" crossorigin="anonymous"></script>
</head>
<style>
  * {
    background-color: #FCF5D1;
  }
  body {
    margin: 0;
    padding: 0;
    font-family: 'Roboto', sans-serif;
    display: grid;
    grid-template-columns:20% auto ;
    grid-template-rows: 20% 30px auto;
  }
  header {
    grid-row:1;
    grid-column: 1/3;
    position: fixed;
    width: 100%;
  }
  header h1{
    background-color: #EB5757;
    padding: 2rem;
    margin-top: 0;
  }
  header i{
    background-color: #EB5757;
    padding-right:1rem ;
    padding-left: 30px;
  }

  nav {
    position: fixed;
    width: 20%;
    top: 8rem;
    left: 0;
    grid-column: 1;
  }

  nav a {
    display: block;
    padding: 20px 10px 10px 30px;
    text-decoration: none;
    color: black;
  }

  .search {
    grid-column: 2;
    grid-row: 2;

  }
  .productgrid {
    grid-column: 2;
    grid-row: 3;
  }

  @media screen and (max-height: 450px) {
    nav a {
      display: inline-block;
      text-align: center;
      padding: 14px;
      text-decoration: none;
    }
    nav {
      overflow: auto;
      white-space: nowrap;
    }

  }

</style>
<body>
<header>
  <h1><i class="fa-solid fa-drumstick-bite"></i>'T Half Kieke</h1>
</header>
<div class="Adminoverzicht">
  <h2>Bestellingen</h2>
  <div class="Bestellingcard">
    <h3>17:00</h3>
    <i class="fa-solid fa-circle-x"></i>
    <h4>Demi de Haan</h4>
    <h4>012 345 678 </h4>
    <ul>
      <li>2 Kleine friet</li>
      <li> 2 Cola</li>
      <li>1 Ketchup</li>
    </ul>
  </div>
</div>
</body>
</html>


