<!doctype html>
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

<div class="container">
    <h1>Ваша корзина</h1>
        <#if items??>
            <table  class="table table-striped table-dark">
                <thead>
                    <tr>
                        <th  scope="col">Название </th>
                        <th  scope="col">Описание </th>
                        <th  scope="col">Тип товара</th>
                        <th  scope="col">Цена</th>
                        <th  scope="col">количество</th>
                    </tr>
                <thead>
        <#list items as item>
                <tbody>
                    <tr>
                        <th scope="row"><p>${item.name}</p></th>
                        <th><p>${item.description}</p></th>
                        <th><p>${item.type}</p></th>
                        <th><p>${item.price}</p></th>
                        <th>
                            <label>
                                <input name="amount" type="number" id="amount" value="1">
                            </label>
                        </th>
                            <form id="remove" action="/pro/remove" method="POST" hidden>
                                <label>
                                    <input name="id" value="${item.id}" hidden>
                                </label>
                            </form>
                        <th>
                            <button id="add" type="submit" form="remove">удалить</button>
                        </th>
                    </tr>
                <tbody>
        </#list>
            </table>
    <#else>
    </#if>
        <form action="/orders/ordersFor" id="send" method="post" hidden>
                <label>
                    <input name="address" type="text" placeholder="введите адрес доставки">
                    <input name="phone" type="text" placeholder="введите номер телефона">
                </label>
            <button type="submit">заказть</button>
        </form>
    <button  id="order">Оформить заказ</button>

    <a  href="/bath" style="margin-bottom: 3rem">
        <input type="button" value="Просмотреть историю карзины" />
    </a>
    <form>
        <input  type="button" value="назад" onclick="history.back()">
    </form>
</div>

<script>
    let btn = document.getElementById("order");
    btn.addEventListener("click",function (e) {
        e.preventDefault()
        document.getElementById("send").hidden = document.getElementById("send").hidden === false;
    })
</script>
</body>
</html>