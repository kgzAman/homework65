<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<#--<#if _csrf??>-->
    <form id="exit" class="flex box-128" action="/logout" method="post">
        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
    </form>
        <button type="submit" class="flex box-128 logout-button" form="exit">Выйти </button>
<#--<#else>-->
<#--</#if>-->

            <table border="1" width="100%" cellpadding="5">
                <tr>
                    <th>Название </th>
                    <th>Описание </th>
                    <th>Количество</th>
                    <th>цена</th>
                </tr>
    <#list products as product>
                <tr>
                    <th>${product.name}</th>
                    <th>${product.description}</th>
                    <th>${product.amount}</th>
                    <th>${product.price}</th>

                    <th>
                        <form id="Form1" action="/pro/cart/add" method="POST" hidden>
                               <input name="id" value="${product.id}" hidden>
                            <button id="add" type="submit" form="Form1" >Добавить в корзину</button>
                        </form>

            <button id="add" type="submit" form="Form1" >Добавить в корзину</button>
        </th>
                </tr>
    </#list>
            </table>

<#if pages??>

<a href="/pro/products?page=${pages.pageNumber+1}&size=2">==></a>
</#if>

<#--<script>-->
<#--    function OnButton1()-->
<#--    {-->
<#--        document.getElementById("Form1").action = "/bath"    // First target-->
<#--        document.getElementById("Form1").submit();    // First target-->
<#--        return true;-->
<#--    }-->
<#--</script>-->


</body>
</html>