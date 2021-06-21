<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

            <table border="1" width="100%" cellpadding="5">
                <tr>
                    <th>Название </th>
                    <th>Описание </th>
                    <th>Количество</th>
                    <th>цена</th>
                </tr>
    <#list products as product>
        <div style="border: green 1px solid">
                <tr>
                    <th>${product.name}</th>
                    <th>${product.description}</th>
                    <th>${product.amount}</th>
                    <th>${product.price}</th>
                </tr>
        </div>
    </#list>
            </table>
<a href="/pro/products?page=${pages.pageNumber+1}&size=2">==></a>


</body>
</html>