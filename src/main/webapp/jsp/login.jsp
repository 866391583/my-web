<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/realm/login" method="post">
  <div class="form-group">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" placeholder="username" />
  </div>
  <div>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" placeholder="password" />
  </div>
  <input type="submit" value="submit" />
</form>

</body>
</html>