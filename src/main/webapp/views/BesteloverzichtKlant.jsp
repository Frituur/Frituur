
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Bestelling</title>
    <link rel="stylesheet" href="../css/main.css" />
    <script src="https://kit.fontawesome.com/187b41207f.js" crossorigin="anonymous"></script>
</head>

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

