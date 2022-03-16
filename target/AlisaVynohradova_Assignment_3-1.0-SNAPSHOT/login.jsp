<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<div align="center">
    <h1>Login Form</h1>
    <form action="<%=request.getContextPath()%>/employee-controller" method="post">
        <table style="with: 100%">
            <tr>
                <td>UserName</td>
                <td><input type="text" name="userName" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
        </table>
        <input type="hidden" name="pageName" value="login" />
        <input type="submit" value="Submit" />
    </form>
    <h3>Not registered yet? <jsp:forward page="signup.jsp">Register here</jsp:forward></h3>
</div>
</body>
</html>
