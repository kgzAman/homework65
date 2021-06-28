<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<#if _csrf??>
    <form class="flex box-128" action="/logout" method="post">
        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        <button class="flex box-128 logout-button">Выйти </button>
    </form>
<#else>
    <a href="/logout">Выйти</a>
</#if>

            <table border="1" width="100%" cellpadding="5">
                <tr>
                    <th>Название </th>
                    <th>Описание </th>
                    <th>Количество</th>
                    <th>цена</th>
                </tr>
    <#list products as product>
                <tr>
                    <th>${product.name}</th>
                    <th>${product.description}</th>
                    <th>${product.amount}</th>
                    <th>${product.price}</th>
        <th> <form action="/pro/cart/add" method="POST">
            <input name="id" value="${product.id}" hidden>

            <button type="submit"  >Добавить в корзину</button>
        </form>
        </th>
                </tr>

    </#list>
            </table>

<#if pages??>

<a href="/pro/products?page=${pages.pageNumber+1}&size=2">==></a>
</#if>




</body>
</html>