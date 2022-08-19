## E-Commerce-Bot

<p>
  Bot de E-Commerce para monitorar o preço dos produtos do site da Amazon.
</p>

Link para documentação/endpoints: 
<a href="http://localhost:8080/swagger-ui/index.html" target="_blank">Swagger UI </a>

Link para banco de dados H2: 
<a href="http://localhost:8080/h2-console" target="_blank">Banco de dados H2 </a>

<p>
JDBC URL: jdbc:h2:mem:testdb
</p>

<p>
User Name: admin
</p>

<p>
Password: admin
</p>

## Instruçoes

<p>
  1) Após iniciar a aplicação, entre no link do Swagger e realiza um POST com as informações do produto a ser monitorado. Lembre-se de colocar um link do site da Amazon.
</p>

<p>
  Link de referência: https://www.amazon.com.br/Samsung-TV-Smart-Uhd-UN50AU7700GXZD/dp/B095FPX64X/ref=sr_1_6?keywords=tv+50&qid=1660877225&sr=8-6&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147
</p>

<p>
  2) Ao adicionar o produto, o bot iniciará a busca pelos dados no link informado. Foi configurado um intervalo de 1 minuto entre as buscas.
</p>

<p>
  3) Após a primeira medição, já é possível gerar o relatório. Para isso, basta utilizar o endpoint do csv-export-controller, informando o id do produto (Isso é necessário, pois é possível adicionar mais de 1 produto a ser monitorado), que um arquivo .csv será baixado.
</p>

<p>
  4) Os ids são incrementais, mas se for necessário realizar uma consulta, basta realizar um GET em /produtos, que os produtos e seus respectivos ids serão informados.
</p>
