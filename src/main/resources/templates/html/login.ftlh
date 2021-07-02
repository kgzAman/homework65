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

       <div class="btn btn my-2 my-sm-0"  style="color: #f8fafb">Please sing in</div>

    </nav>
</div>
<div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    </nav>
</div>
<form action="/login" method="post">

    <div>
        <#if error!false >
            <p style="color:red">Неверные имя пользователя или пароль !</p>
        </#if>
    </div>

    <#if _csrf??>
        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
    </#if>

    <div>
        <label class="flex flex-v-center ">
            <span class="label-input-text">Адрес почты:</span>
            <input type="text" name="username" placeholder="ваш адрес почты"  value="${(dto.email)!''}" autofocus >
        </label>
    </div>
    <div>
        <label class="flex flex-v-center label-input-text">
            <span class="label-input-text">Пароль:</span>
            <input type="text" name="password" placeholder="пароль" value="">
        </label>
    </div>
    <div>
        <button type="submit">войти</button>
    </div>
</form>
</body>
</html>