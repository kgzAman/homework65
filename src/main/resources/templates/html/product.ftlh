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
         <table class="table table-striped table-dark" style="margin-top: 2rem">
                <tr>
                    <th scope="col">Название </th>
                    <th scope="col">Описание </th>
                    <th scope="col">Количество</th>
                    <th scope="col">цена</th>
                    <th scope="col">добавить в карзину</th>
                </tr>
                <tr>
                    <th>${product.name}</th>
                    <th>${product.description}</th>
                    <th>${product.amount}</th>
                    <th>${product.price}</th>
                    <th>
                        <form id="Form1" action="/pro/cart/add" method="POST">
                            <label>
                                <input name="id" value="${product.id}" hidden>
                            </label>
                        <button id="add" type="submit" form="Form1" >Добавить в корзину</button>
                        </form>
                    </th>
                </tr>
         </table>
</body>
</html>