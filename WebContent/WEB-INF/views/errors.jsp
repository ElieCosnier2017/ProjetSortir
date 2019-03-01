<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
           prefix="fmt" %>
<html>
<head>
</head>
<body bgcolor="white">
<h1>Erreur :</h1>
<p>
    (<%=exception %>)<%=exception.getMessage() %>
</p>
</body>
</html>
