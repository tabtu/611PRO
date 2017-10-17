<%--
  Created by IntelliJ IDEA.
  User: Tab
  Date: 2017-10-17
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Math Game</title>
    <meta charset="utf-8">
    <meta name = "viewpoint" content="width = device-width, initial-scale = 1, user-scalable = yes">
    <link rel = "stylesheet" href = "/css/styling.css">
</head>
<body>
<div id = "container">
    <div id = "score">
        Score: <span id = "scorevalue">0</span>
    </div>

    <div id = "correct">
        Correct!
    </div>

    <div id = "wrong">
        Try again!
    </div>

    <div id = "question">

    </div>

    <div id = "instruction">
        Click on the correct answer
    </div>

    <div id = "choices">
        <div id = "box1" class = "box"> </div>
        <div id = "box2" class = "box"> </div>
        <div id = "box3" class = "box"> </div>
        <div id = "box4" class = "box"> </div>

    </div>

    <div id = "startreset">
        Start Game
    </div>

    <div id = "timeremaining">
        Time remaining: <span id = "timeremainingvalue">60</span> sec
    </div>

    <div id = "gameOver">

    </div>
</div>

<script src="/js/javascript.js">

</script>
</body>
</body>
</html>
