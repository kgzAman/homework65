<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Lesson 69. Storing data in session</title>

    <link rel="stylesheet" href="../css/main.css">
</head>
<body>

<div class="container">
    <h1>Ваша корзина</h1>
        <#if items??>
            <table border="1" width="100%" cellpadding="5">
            <tr>
                <th>Название </th>
                <th>Описание </th>
                <th>Тип товара</th>
                <th>Цена</th>
                <th>Количество</th>
            </tr>
        <#list items as item>
            <tr>
                <th><p>${item.name}</p></th>
                <th><p>${item.description}</p></th>
                <th><p>${item.type}</p></th>
                <th><p>${item.price}</p></th>
                <th>
                    <label>
                        <input type="number"  id="amount" value="1">
                    </label>
                </th>
                <th>
                    <form id="remove" action="/pro/remove" method="POST" hidden>
                        <input  name="id" value="${item.id}" hidden>
                    </form>
                        <button id="add" type="submit" form="remove">удалить</button>
                </th>
            </tr>

        </#list>
            </tr>
            </table>
        <form action="/pro/cart/empty" method="post">
            <button>Очистить корзину</button>
        </form>
    <#else>
        <p>тут ничего нет!</p>
    </#if>

    <form>
        <input type="button" value="назад" onclick="history.back()">
    </form>
</div>
<script>
    let click = document.getElementById("click");
    click.addEventListener("click",function plus (e) {
        e.preventDefault();
     // document.getElementById("amount").valueOf()+1;
    })
</script>

</body>
</html>