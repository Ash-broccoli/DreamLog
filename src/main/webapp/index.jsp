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
    <div class="container">

            <h1 class="sign">Wel<span class="fast-flicker">com</span>e to my D<span class="flicker">re</span>am log</h1>

        <br>

        <div id="list">
            <h2>Dreams are being loaded <small><img class="loader" width="200" height="auto" id="loading"
                                                    src="img/loading.gif"></small>
            </h2>
        </div>
    </div>
</div>
</body>
</html>