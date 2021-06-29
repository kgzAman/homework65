<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<table border="1" width="100%" cellpadding="5">
    <tr>

        <th  scope="col">Название </th>
        <th  scope="col">Описание </th>
        <th  scope="col">Количество</th>
        <th  scope="col">цена</th>
    </tr>
    <#list products as product>
        <tr>
            <th>${product.name}</th>
            <th>${product.description}</th>
            <th>${product.amount}</th>
            <th>${product.price}</th>
        </tr>
    </#list>
</table>

    <form action="/bath/removeAll" method="get">
    <button>Очистить корзину</button>
    </form>
    <form>
    <input type="button" value="назад" onclick="history.back()">
    </form>

<script>


</script>


</body>
</html>