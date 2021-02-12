# Desafio delivery everis
## everis Beca de Java 2021.1

Projeto desenvolvido dentro da empresa everis, como um desafio após 2 semanas de treinamneto na beca de Java. 

O desafio era criar uma aplicação utilizando Spring Boot, pensando no contexto de delivery de produtos, com cadastro de pessoas, contatos (telefone, endereço e e-mail, formas de pagamento (Cartão de crédito, cartão de débito ou dinheiro)) e produtos.
A ideia foi conseguir cadastrar pessoas, seus dados de contato e criar uma dinâmica de seleção de produtos para entrega, indicando um dos meios de pagamento previamente indicados.

Foi utilizado como SGBD (Sistema Gerenciador de Banco de Dados) o *`PostgreSql`*. 

Para gerar um projeto com as dependencias já incluidas utilizei o site *`https://start.spring.io/`* e em dependencies adicionei a dependencia web que utiliza *`Spring MVC`*, a dependencia JPA que utiliza *`Spring Data JPA`* e a dependencia *`PostgreSQL Driver`* que faz a conexão com o banco de dados através do JDBC. Além dessas adicionei a dependencia do *`Bean Validation`* para validar os campos antes de inserir no banco.

Para realizar a conexão com o banco é necessário criar um DATABASE no PostgreSQL e em seguida ir no arquivo *`application.properties`* e modificar a URL, o username e a senha.

Para testar a API utilizei a ferramenta *`Postman`* [Baixar Postman](https://www.postman.com/downloads/), e passei as URL de cada método HTTP (get, post, put, delete).

O cadastro dos endereços é feito junto com cadastro de clientes assim como a atualização(put), remoção(delete) e visualização(get). Na parte do carrinho de compras não consegui implementar a parte de atualização, e na parte de pagamento não implementei a remoção e atualização pois, dentro da minha regra de negócio, não faz sentido.

Para fazer alguma atualização é necessário informar todos os campos e mudar somente o que é necessário.
------------------------------------
##Autor
-Yuri Ranieri
-yurifranieri@gmail.com
