<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Login</title>
</head>

<body>
    <div class="container mt-3 d-flex justify-content-center">
        <div class="wrap-login shadow-lg ">
            <form action="filter-login" class="p-3" method="post">
                <div class="title-login">
                   
                    <h1 align="center">Login</h1>
                </div>
                
                <div class="alert alert-danger alert-dismissible fade show mt-3" style="margin-bottom: 5px; display : none; ${error}">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>Sorry!</strong> Your email or password is not correct.
                  </div>
                <label for="email">Username</label>
                <div class="mb-3 mt-1 input-group">

                    <span class="input-group-text"><i class="fa fa-envelope-o" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" id="username" placeholder="Enter your username"
                        name="username">
                </div>
                <label for="email">Password</label>
                <div class="mb-3 mt-1 input-group">
                    <span class="input-group-text"><i class="fa fa-unlock-alt" aria-hidden="true"></i></span>
                    <input type="password" class="form-control" id="password" placeholder="Enter your password"
                        name="password">

                </div>
                <div class="form-check mb-3 d-flex justify-content-end">
                    
         
                </div>
                <button type="submit" id="btn-login" class="btn btn-primary mt-3 mb-3 shadow">Login</button>
                <a href="login?status=register"><button type="button" id="btn-login" class="btn btn-primary mt-3 mb-3 shadow">Register</button></a>
            </form>
        </div>

    </div>
</body>

<style>
html{
    font-family: 'Courier New', Courier, monospace;
}

body{
    background-image: url("https://colorlib.com/etc/lf/Login_v4/images/bg-01.jpg"); 
    background-image: url("./bg-01.webp"); 
    background-repeat: no-repeat;
    background-size: cover;
}

.title-login{
    position: relative;
    margin-bottom: 30px;
}

.back{
    position: absolute;
    top : 0;
    left: 0;
    display: flex;
    align-items: center;
}

.back a{
    margin: 0;
    color : rgba(0,0,0,0.6);
    text-decoration: none;
    font-size: 14.5px;
}

.back a:hover{
    color : rgb(204, 51, 255);
}

.back i{
    margin-right: 5px;
    font-size: 16px;
    
}

.title-login h1{
    font-size: 35px;
    color: #CC33FF;
}


.wrap-login{
    padding: 20px;
    background-color: #fff;
    border-radius: 20px;
    width: 500px;
}

#btn-login{
    width: 100%;
    border-radius: 20px;
    background-color: #6633FF;
}

#btn-login:hover{
    
    animation: hoverbtn 0.5s ease-in-out;
    background-color: #CC00FF;

}

@keyframes hoverbtn{
    from{
        background-color: #6633FF;
    }
    to{
        background-color: #CC00FF;
    }
}

#btn-signup{
    width: 100%;
    color : #000;
    border : none;
    background-color: #fff;
}

#text-or{
    opacity: 0.5;
}

</style>

</html>