<#--<#import "/spring.ftl" as spring>-->
<#--<#import "main.ftlh" as main>-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body style="background:aquamarine">
    <div>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="/main">Главная</a>

            <li class="nav-item">
                <a class="btn btn-outline-success my-2 my-sm-0" data-toggle="collapse" href="/pro/filter" role="button" aria-expanded="false" aria-controls="collapseExample">Поис товара</a>
            </li>
        </nav>
    </div>

    <form  action="/resetPassword" modelattribute="UserDTO" method="POST">
        <input type="text" name="email" placeholder="введите email">
    <button type="submit" value="Submit">Submit</button>
    </form>

</body>
</html>
