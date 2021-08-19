<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <script src="js/dreamData.js"></script>
    <script src="js/ajax_engine.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:200' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/style.css">
    <title>☾ Dream Log ☾</title>
</head>
<body onload="loadData()">
<div class="fullPageWidth">
    <header class="header">
    </header>
    <div class="container">

            <nav class="navbar navbar-expand-lg navbar-dark ">
                <a class="navbar-brand" href="index.jsp">Home ✦</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-item nav-link" href="dreams.jsp">Dreams |</a>
                        <a class="nav-item nav-link" href="addDream.jsp">Add Dream |</a>
                        <a class="nav-item nav-link " href="deleteDream.jsp">Delete Dream</a>
                    </div>
                </div>
            </nav>
        <hr class="navLine"/>

            <br>
        <h1 class="sign">Wel<span class="fast-flicker">com</span>e to my D<span class="flicker">re</span>am log</h1>
        <br>

        <h2>This months dreams:</h2>
        <div id="list">
            <h3>Dreams are being loaded <small><img alt="rocketloader" class="loader" width="200" height="auto" id="loading"
                                                    src="img/loading.gif"></small>
            </h3>
        </div>
    </div>
</div>
</body>
</html>