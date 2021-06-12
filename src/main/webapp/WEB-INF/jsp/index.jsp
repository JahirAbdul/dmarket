<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<%--

    <spring:url value="/resources/js/MainFormValidate.js" var="mainJs" />
    <script src="${mainJs}"></script>

--%>
<body>
<form action="add" method="post" onsubmit="formValidate()">
    <table>
        <tr>
            <td>Name</td>
            <td> <input type="text" name="userName"/> </td>
        </tr>
        <tr>
            <td>Nick-Name</td>
            <td> <input type="password" name="password"/> </td>
        </tr>
        <%--<tr>
            <td>Gender</td>
            <td><select name="gender">
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select></td>
        </tr>
        <tr>
            <td>E-Mail ID</td>
            <td><input type= "email" name="email" onblur="validate(email,this.value())"/>
                <div id="rsp_email"><!-- --></div></td>
        </tr>
        <tr>
            <td>Followers(in numbers)</td>
            <td> <input type="text" name="followers"/> </td>
            <td> <select name="scale">
                <option value="-">NA</option>
                <option value="K">K</option>
                <option value="M">M</option>
            </select></td>
        </tr>--%>
        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>
</form>
<div align="centre"> <h1>OR</h1> </div>
<form method="POST" action="upload" method = "post" enctype="multipart/form-data">
    <input type="file" name="file" /><br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>