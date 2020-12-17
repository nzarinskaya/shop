<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <meta charset="UTF-8">
    <title>Sign in</title>
</head>
<body>

<div class="=container">
    <div class="row">
        <div class="col-4">
        </div>
        <div class="col-4">
            <form method="post" action="${pageContext.request.contextPath}/signIn">
                <div class="form-group">
                    <label for="login">Login</label>
                    <input type="text"name="login" class="form-control" id="login" name="login">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="text"name="password" class="form-control" id="password" name="password" >
                    <c:if test= "${signIn_error != null}">

                    <span class="error text-danger"> ${signIn_error} </span>
                    </c:if>
                </div>
                <button type="submit" class="btn btn-primary">Sign in</button>
                <p class="text-center"><a href="${pageContext.request.contextPath}/registration">Create an Account</a></p>
            </form>
        </div>
        <div class="col-4">
        </div>
    </div>
</div>

</body>
</html>

