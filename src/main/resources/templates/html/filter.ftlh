<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/pro/filter" modelAttribute ="filter" method="get" >
        <input type="text" name="name" placeholder="поиск  по имени " style="margin-bottom: 10px" />
        <input type="text" name="name" placeholder="поиск по описанию " style="margin-bottom: 10px" />
    <br>
        <input type="number" name="minPrice" placeholder="цена от " style="margin-bottom: 10px">
        <input type="number" name="maxPrice" placeholder="цена до " style="margin-bottom: 10px">
    <button type="submit"> search</button>

</form >
<#if products??>

<#list products as product>
    <div style="border: green 1px solid">
        <table border="1" width="100%" cellpadding="5">
            <tr>
                <th>Название :${product.name}</th>
                <th>Описание :${product.description}</th>
                <th>Количество:${product.amount}</th>
                <th>Количество:${product.price}</th>

            </tr>

        </table>
    </div>
</#list>
      <a href="/pro/filter?page=${pages.getPageNumber()+1}&size=2">==></a>
</#if>

</body>
</html>