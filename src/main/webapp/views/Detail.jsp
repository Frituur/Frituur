<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Detail</title>
    <link rel=”stylesheet”   href="../css/main.css" />
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
<div class="detail">
    <ul>
        <li><image src=""/></li>
        <li>Frieten</li>
        <li>Aantal  <input type="number" id="quantity" name="quantity" min="1" max="5"></li>
        <li><button>Toevoegen</button></li>
    </ul>
</div>
</body>
</html>
