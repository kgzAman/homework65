<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

<#if orders??>
   <#list orders as order>
        <div id="product">

            <#list order.products as orderProduct>
                <table class="table table-striped table-dark">
                    <tr>
                        <th scope="col">названи</th>
                        <th scope="col">описание</th>
                        <th scope="col">цена</th>
                        <th scope="col">количество</th>
                    </tr>
                    <tr>
                        <th>${orderProduct.name}</th>
                        <th>${orderProduct.description}</th>
                        <th>${orderProduct.price}</th>
                        <th>${orderProduct.amount}</th>
                    </tr>
                </table>
            </#list>
                        <th><button id="btn" style="margin-bottom: 2rem"> review </button></th>
        </div>
        <div id="review"  style="border: 1px solid red; padding-bottom: 2rem; margin-bottom: 3rem" hidden>

            <#list order.review as review>
                  <li>${review.reviewContent}</li>

            </#list>
        </div>
                        <button id="com-btn"> add Comment </button>

       <div id="com" hidden>

       <form id="text" action="/orders/addReview" modelAttribute ="comment" method="POST">
           <p>
               <textarea  name="reviewContent" placeholder="Комментарий" required autofocus form="text"></textarea>
               <input type="number" name="orderFor" value="${order.id}" hidden>
           </p>
           <p><input type="submit" value="Отправить" form="text"></p>
       </form>
       </div>
   </#list>


</#if>
</body>
        <script>
            let btn = document.getElementById("btn");
            btn.addEventListener("click",function getReview(e) {
                e.preventDefault()

                document.getElementById("review").hidden = document.getElementById("review").hidden === false;
            })

            let com = document.getElementById("com-btn");
            com.addEventListener("click",function addCom(e) {
                e.preventDefault()
                document.getElementById("com").hidden=document.getElementById("com").hidden===false;

            })
        </script>
</html>