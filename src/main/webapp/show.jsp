<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息展示</title>
    <style>
        table{border-collapse: collapse;width: 500px;margin: 50px auto;}
        td,th{border: 1px solid #999;padding: 10px;text-align: center;}
    </style>
</head>
<body>
<h2 align="center">教师详情信息</h2>
<table>
    <tr>
        <th>教师编号id</th>
        <td>${teacher.id}</td>
    </tr>
    <tr>
        <th>姓名</th>
        <td>${teacher.name}</td>
    </tr>
    <tr>
        <th>性别</th>
        <td>${teacher.sex}</td>
    </tr>
    <tr>
        <th>手机号</th>
        <td>${teacher.phonenumber}</td>
    </tr>
    <tr>
        <th>所属学院</th>
        <td>${teacher.college}</td>
    </tr>
    <tr>
        <th>授课课程</th>
        <td>${teacher.course}</td>
    </tr>
</table>
</body>
</html>
