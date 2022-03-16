<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<div align="center">
    <h1>Login Form</h1>
    <form action="<%=request.getContextPath()%>/employee-controller?pageName=login" method="post">
        <table style="width: 100%">
            <tr>
                <td>UserName</td>
                <td><input type="text" name="userName" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName" /></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastName" /></td>
            </tr>
            <tr>
                <td>Email address</td>
                <td><input type="email" name="emailAddress" /></td>
            </tr>
            <p><i>${message}</i></p>
        </table>
        <input type="submit" value="Submit" />
        <jsp:setProperty name="pageName" property="" value="signup" />
    </form>
</div>
</body>
</html>