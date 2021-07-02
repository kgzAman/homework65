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