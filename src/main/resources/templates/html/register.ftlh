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
            <li class="nav-ite" >
                <a id="reg" class="btn btn-outline-success my-2 my-sm-0" data-toggle="collapse"  aria-expanded="false" aria-controls="collapseExample" style="color: #f8fafb"><h2>Please register</h2></a>
            </li>
        </nav>
    </div>
    <div>
    <form action="/register" method="post">

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">Имя:</p>
                <input id="nam" type="text" name="name" placeholder="ваше имя"  value="${(dto.name)!''}">
            </label>
        </div>
        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">Адрес почты:</p>
                <input type="text" name="email" placeholder="ваш адрес почты"  value="${(dto.email)!''}" >
            </label>
        </div>
        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">Пароль:</p>
                <input type="text" name="password" placeholder="пароль"  value="">
            </label>
        </div>
        <div>
            <button type="submit" class="btn btn-outline-success my-2 my-sm-0" style="background: #343a40;color: #f8fafb"  >Регистрация</button>
        </div>
        <div>
            <#if errors?? >
                <p>Входные данные с ошибками!</p>
                <#list errors as fieldError>
                    <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                </#list>
            </#if>
        </div>
    </form>
    </div>
</body>
<script>
    let d = document.getElementById('reg').addEventListener("click",function (e) {
        e.preventDefault()
        document.getElementById('nam').focus();
    })
</script>
</html>