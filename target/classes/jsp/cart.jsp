<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Cart</title>
</head>
<body>
<div class="container">
    <div class="row">
        <c:forEach var="goods" items="${cart}">
        <div class="card" style="width: 18rem; margin-left: 10px">
            <c:if test="${goods.id == 1}">
                <img src="${pageContext.request.contextPath}/img/el.jpg" class="card-img-top" alt="...">
            </c:if>

            <c:if test="${goods.id == 2}">
                <img src="${pageContext.request.contextPath}/img/garland.jpg" class="card-img-top" alt="...">

            </c:if>
            <div class="card-body">
                <h5 class="card-title"><c:out value="${goods.name}"/></h5>
                <p class="card-text"><c:out value="${goods.description}"/></p>
            </div>
        </div>
    </div>
    </c:forEach>
</div>
</body>
</html>
