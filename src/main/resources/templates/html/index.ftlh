<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <#list products as product>
        <div style="border: green 1px solid">
            <table border="1" width="100%" cellpadding="5">
                <tr>
                    <th>Название :${product.name}</th>
                    <th>Описание :${product.description}</th>
                    <th>Количество:${product.amount}</th>
                </tr>
            </table>
        </div>
    </#list>
<a href="/pro/products?page=${pages.pageNumber+1}&size=2">==></a>


</body>
</html>