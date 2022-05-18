
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Bestelling</title>
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
<nav>
    <a href="#">Frieten</a>
    <a href="#">Sauzen</a>
    <a href="#">Snacks</a>
    <a href="#">Dranken</a>
    <a href="#">Deserts</a>
</nav>
<div class="Bestelling">
    <h2>Bestelling</h2>
    <form>
        <p>Kleine friet- 2 - 4 euro</p>
        <p>Kleine friet- 2 - 4 euro</p>
        <p>Kleine friet- 2 - 4 euro</p>
        <input type="button" value="Aanpassen">
        <p>Totaal:12 euro</p>
        <input type="text" id="naam" name="naam" value="Naam">
        <input type="text" id="nummer" name="nummer" value="Telefoonnummer">
        <input type="button" value="Kies een afhaalmoment">
        <input type="submit" value="Bestellen">
    </form>

</div>
</body>
</html>

