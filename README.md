# Treinando

<h1 align="center">Backend Developer Challenge</h1>
<p align="center">
 <a href="#objetivo">Objetivo</a> •
 <a href="#Instruções">Instruções</a> •
 <a href="#tecnologias">Tecnologias</a> •
 <a href="# Features">Features</a> • 
 <a href="#autor">Autor</a>
</p>
### 🎲 Objetivo

<p align="center">Resolver um  desafio simples para testar minhas habilidades na construção de APIS.</p>

### 🚀 Instruções  🚧
<h2 align="center">Instruções</h2>
<p align="center">Para melhor entendimento vou explicar um pouco sobre os get,post,put e delete e outros métodos..</p>
<h2 align="center">Camadas</h2>
<h3 align="center">Model/Entity:</h3>
<p align="center">Responsavel por abstrair o objeto e a instanciação de cada objeto que vamos trabahar na nossa API,
vai receber e mandar dados para o cliente.</p>
<h3 align="center">Repository:</h3>
<p align="center">É onde é feita toda a manipulação que será feita na base de banco de dados, aonde se comunica com o banco.</p>
<h3 align="center">Controller:</h3>
<p align="center">Fica responsável por administrar todos os nossos URL x dispara o metodo y aqui que vai devolver as 
respostas para o cliente.(testado pelo postiman).</p>
<h3 align="center">Service:</h3>
<p align="center">Aqui fica todas as nossas regras de negócio que nesse caso não foi necessário.</p>
<p align="center">
Get: Metódo para recuperar dados de uma API.
Post: Enviar novos dados para a API.
Patch/Put:Atualiza dados existentes.
Delete:Remove dados existentes.
 
findAll:Busca e retorna tudo.
findById:Retorna o objeto daquele id.
findAllByNameContainingIgnoreCase:Retorna o name que eu pesquisar ignorando maiusculo e minusculo.

O metodo calcular serve para calcular o total de pontos de cada pessoal cadastrada.
O metodo mostrarAdicionar serve para tanto adicionar um novo item de score numa lista
para depois serem ordenados e mostrarem os 10 maiores scores junto com o nome da pessoa.
</p>
### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Java](https://www.java.com/pt-BR/)
- [SpringBoot](https://spring.io/projects/spring-boot)
- [Postman](https://www.postman.com/)
- [Banco de dados](https://www.oracle.com/br/mysql/)
- [Mysql](https://www.oracle.com/br/mysql/)

### Features

- [x] Criar um cliente
- [x] Editar um cliente
- [x] Obter um cliente especifico
- [x] Listar clientes

