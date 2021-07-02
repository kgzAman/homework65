<#--<#import "/spring.ftl" as spring>-->
<#--<#import "main.ftlh" as main>-->
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
    </nav>
</div>

<form action="/pro/filter" modelAttribute ="filter" method="get" >
        <input class="navbar-brand" type="text" name="name" placeholder="поиск  по имени " style="margin-bottom: 10px" />
    <br>
        <input class="navbar-brand" type="text" name="description" placeholder="поиск по описанию " style="margin-bottom: 10px" />
    <br>
        <input class="navbar-brand" type="number" name="minPrice" placeholder="цена от " style="margin-bottom: 10px">
        <input class="navbar-brand" type="number" name="maxPrice" placeholder="цена до " style="margin-bottom: 10px">
    <button class="btn btn-outline-success my-2 my-sm-0 navbar-brand" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="collapseExample" type="submit"> search</button>

</form >


<#if products??>
    <div style="border: green 1px solid">
        <table class="table table-striped table-dark">
            <thead>
            <tr>
                <th>Название </th>
                <th>Описание </th>
                <th>Количество</th>
                <th>цена</th>
            </tr>
            </thead>
            <#list products as product>
                <div id="id">
                    <tbody>
                <tr>
                    <th>${product.name}</th>
                    <th>${product.description}</th>
                    <th>${product.amount}</th>
                    <th>${product.price}</th>
                    <th>
                        <form action="/pro/cart/add" method="POST">
                            <input name="id" value="${product.id}" hidden>

                        <button type="submit"  >Добавить в корзину</button>
                        </form>

                    </th>
                </tr>
                    </tbody>
                </div>
            </#list>
            <br>
        </table>
    </div>
    <a href="/pro/filter?page=${pages.pageNumber+1}">==></a>
</#if>


<script>

</script>


</body>
</html>
