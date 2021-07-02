<#--<#import "/spring.ftl" as spring>-->
<#--<#macro render dir="ltr">-->
<!DOCTYPE html>
<html lang="en">
<#--<html lang="${.locale}" dir="${dir}">-->
<head>
    <meta charset="UTF-8">
    <title>tittle</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        [data-href] { cursor: pointer; }
    </style>
</head>
<#--</#macro>-->
    <body style="background:aquamarine">
        <div>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="/main">Главная</a>

                <li class="nav-item">
                    <a class="btn btn-outline-success my-2 my-sm-0" data-toggle="collapse" href="/pro/filter" role="button" aria-expanded="false" aria-controls="collapseExample">Поис товара</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-outline-success my-2 my-sm-0" data-toggle="collapse" href="/pro/cart" role="button" aria-expanded="false" aria-controls="collapseExample">Посмотреть карзину</a>
                </li>
                <div class="container">
                    <div>
                        <form action="" method="get">
                            <label for="lang_select">
                                <@spring.message "label.language" />:
                            </label>
                            <select name="lang" id="lang_select">
                                <option value="ru_RU">Русский</option>
                                <option value="">Default</option>
                                <option value="en-US">American English</option>
                                <option value="ru">Русский</option>
                            </select>
                            <button type="submit">
                                <@spring.message "button.language-change.text" />
                            </button>
                        </form>
                    </div>
                    <#if user??>
                        <div id="username" style="margin-left: auto;color: #f8fafb">User: ${user.name}</div>
                        <li class="nav-item" style="margin-left: auto" >
                            <form id="icon" action="/logout" method="post">
                                <button class="btn btn-outline-success my-2 my-sm-0" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="collapseExample" type="submit">выйти</button>
                            </form>
                        </li>
                <#else>
                <li class="nav-item" style="margin-left: auto" >
                    <form id="enter" action="/login" method="get">
                        <button class="btn btn-outline-success my-2 my-sm-0" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="collapseExample" type="submit">выход</button>
                    </form>
                </li>
                <li class="nav-item" style="margin-left: 3rem">
                    <form id="enter" action="/register" method="get">
                        <button class="btn btn-outline-success my-2 my-sm-0" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="collapseExample" type="submit">регистрация</button>
                    </form>
                </li>
                </#if>
            </nav>
        </div>
<div>
    <table class="table table-striped table-dark" style="margin-top: 2rem">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Название </th>
            <th scope="col">Описание </th>
            <th scope="col">Количество</th>
            <th scope="col">цена</th>
            <th scope="col">добавить в карзину</th>
        </tr>
    <#if products??>

        <#list products as product>
            <tr data-href onclick="window.location='/pro/product/${product.id}'">
                <th>${product.id}</th>
                <th>${product.name}</th>
                <th>${product.description}</th>
                <th>${product.amount}</th>
                <th>${product.price}</th>
                <th>
                    <form id="Form1" action="/pro/cart/add" method="POST">
                        <label>
                            <input name="id" value="${product.id}" hidden>
                        </label>
                    </form>
                    <button id="add" type="submit" form="Form1" >Добавить в корзину</button>
                </th>
            </tr>
        </#list>
    </#if>
    </table>

    <#if pages??>
        <a href="/main?page=${pages.pageNumber+1}&size=2">==></a>
    </#if>
</div>
</body>
</html>

