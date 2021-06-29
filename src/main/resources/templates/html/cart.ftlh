<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Lesson 69. Storing data in session</title>

    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

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
                        <th><input name="amount" type="number"  id="amount" value="1"></th>

                            <form     id="remove" action="/pro/remove" method="POST" hidden>
                                <input  name="id" value="${item.id}" hidden>
                            </form>
                        <th>
                                <button id="add" type="submit" form="remove">удалить</button>
                        </th>
                    </tr>
                <tbody>
        </#list>
            </table>
    <#else>
        <p>тут ничего нет!</p>
    </#if>
        <form action="/orders/ordersFor" id="send" method="post" hidden>

                <label>
                    <input name="address" type="text" placeholder="введите адрес доставки">
                    <input name="phone" type="text" placeholder="введите номер телефона">
                </label>
            <button type="submit">заказть</button>
        </form>
    <button id="order">Оформить заказ</button>

    <a href="/bath" style="margin-bottom: 3rem">
        <input type="button" value="Просмотреть историю карзины" />
    </a>

    <form>
        <input type="button" value="назад" onclick="history.back()">
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