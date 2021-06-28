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
                <div id="id">
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
                </div>
            </#list>
            <br>
        </table>
    </div>
    <a href="/pro/filter?page=${pages.pageNumber+1}">==></a>
</#if>


<script>
    // 'use strict';
    //
    //     const form = document.getElementById("cart-form");
    //     form.addEventListener("click",addToCart)
    // async function addToCart(e) {
    //     e.preventDefault();
    //     e.stopPropagation();
    //     let elem = document.getElementById(id)
    //
    //     const options = {
    //         method : 'post',
    //         body: new FormData(elem)
    //     };
    //
    //     await fetch("/cart", options);
    //     // alert("обновите страницу для просмотра данных из сессии, или перейдите в корзину");
    // }

    // const updateElement = document.getElementById("cart-add");
    // updateElement.addEventListener('click', addToCart);
</script>


</body>
</html>
