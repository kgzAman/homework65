<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/pro/filter" modelAttribute ="filter" method="get" >
        <input type="text" name="name" placeholder="поиск  по имени " style="margin-bottom: 10px" />
    <br>
        <input type="text" name="description" placeholder="поиск по описанию " style="margin-bottom: 10px" />
    <br>
        <input type="number" name="minPrice" placeholder="цена от " style="margin-bottom: 10px">
        <input type="number" name="maxPrice" placeholder="цена до " style="margin-bottom: 10px">
    <button type="submit"> search</button>

</form >
<#if products??>

    <div style="border: green 1px solid">
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
                </tr>
            </#list>
            <br>
        </table>
    </div>
    <a href="/pro/products?page=${pages.pageNumber+1}&size=2">==></a>
</#if>

<#if _csrf??>
    <form class="flex box-128" action="/logout" method="post">
        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        <button class="flex box-128 logout-button">Выйти </button>
    </form>
<#else>
    <a href="/logout">Выйти</a>
</#if>

</body>
</html>