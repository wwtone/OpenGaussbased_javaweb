<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Score Rankings</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
        }
        h2 {
            text-align: center;
        }
        form {
            margin-bottom: 20px;
            text-align: center;
        }
        form label {
            margin-right: 10px;
        }
        form input[type="text"] {
            padding: 8px;
            margin-right: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        form button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        form button:hover {
            background-color: #45a049;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Submit Scores</h2>
    <form action="${pageContext.request.contextPath}/ScoreServlet" method="get">
        <label for="semester">Semester:</label>
        <input type="text" id="semester" name="semester">

        <label for="courseID">Course ID:</label>
        <input type="text" id="courseID" name="courseID">

        <label for="classID">Class ID:</label>
        <input type="text" id="classID" name="classID">

        <button type="submit">Submit</button>
    </form>

    <h2>Score Rankings</h2>
    <table>
        <thead>
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Course Name</th>
            <th>Semester</th>
            <th>Score</th>
            <th>Score Rank</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="score" items="${scores}">
            <tr>
                <td>${score.studentID}</td>
                <td>${score.studentName}</td>
                <td>${score.courseName}</td>
                <td>${score.semester}</td>
                <td>${score.score}</td>
                <td>${score.scoreRank}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
