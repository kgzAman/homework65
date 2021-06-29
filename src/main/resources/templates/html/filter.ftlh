<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
