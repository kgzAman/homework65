<#import "/spring.ftl" as spring>
<#import "main.ftlh" as main>

<@main.render>
    <div style="background-color:darkred; padding: 10px 0; color: white;font-size: 24px; text-align: center">★★★ ☭☭☭ Привет товарищ! ☭☭☭ ★★★</div>
    <h1><@spring.message "title" /></h1>
    <p><@spring.message "welcome" /></p>
    <p><@spring.message "text" /></p>
</@main.render>