<h1 align=center> Gerenciamento de Estoque 🛒 </h1>

Foi passado um trabalho na faculdade, para que fizéssemos uma aplicação simples para controle de Estoque, contendo os seguintes critérios:

- Esta aplicação deverá realizar o controle de estoque de produtos, armazenando o código do produto, nome do produto e quantidade em estoque.
- Deverá ser possível realizar o cadastro de novos produtos.
- Deverá ser possível realizar a atualização de produtos, sendo permitido atualizar apenas a quantidade em estoque.
- Deverá ser possível realizar a exclusão de produtos, para o caso em que a empresa não trabalhe mais com um determinado produto.
- Deverá ser possível listar todos os produtos cadastrados, apresentando o seu código, nome e quantidade em estoque.
- Deverá ser possível listar todos os produtos que possuem menos de 10 itens em estoque, apresentando o seu código, nome e quantidade em estoque.
- Ao incluir um produto, deve ser obrigatório informar o nome do produto e a quantidade deve ser maior ou igual a zero.
- Ao atualizar um produto, a quantidade deve ser maior ou igual a zero.
- A aplicação deverá permitir realizar um backup de todos os produtos existentes para um arquivo, podendo este ser de texto ou binário.
- Obrigatoriamente, deve ser apresentada uma interface gráfica para uma melhor interação do usuário.

  E consegui cumprir todos esses requisitos, usando Java, JavaFX, DBeaver, MySQL e JDBC.

Aqui vou mostrar alguns prints e como ficou cada funcionalidade da interface gráfica:

Tela Principal:
<br>
<img src="https://github.com/LiviaBraz/gerenciamentoEstoque/assets/64878674/4fb5bd88-c88e-448c-86a4-5c20d325db0c" width="300" height="400">
<br>

Cadastrando:
<br>
<img src="https://github.com/LiviaBraz/gerenciamentoEstoque/assets/64878674/62f12fcd-3f5f-4ace-8b14-54d3cc9e5295" width="340" height="300">
<img src="https://github.com/LiviaBraz/gerenciamentoEstoque/assets/64878674/7bf61069-0d95-4c8f-9db6-3a1fee5ca143" width="300" height="300">
<br>

Para atualizar (apenas quantidade é alterada, o resto independente se a pessoa mudar, permanecerá o mesmo):
<br>
<img src="https://github.com/LiviaBraz/gerenciamentoEstoque/assets/64878674/29a218e9-054d-4ed0-a132-934f972baf44" width="300" height="400">
<br>
Selecionamos a linha que queremos alterar.
<br>
<img src="https://github.com/LiviaBraz/gerenciamentoEstoque/assets/64878674/8fbf20e0-6a41-462f-acdf-1d9f36838166" width="340" height="300">
<br>
Digitamos o novo.
<br>
<img src="https://github.com/LiviaBraz/gerenciamentoEstoque/assets/64878674/827a658a-b2dc-46e8-8b2d-fd43a400273a"  width="300" height="300">
<br>
Telinha de confirmação.
<br>
<img src="https://github.com/LiviaBraz/gerenciamentoEstoque/assets/64878674/df28bad0-a71d-4aad-804b-a5bf8e5c0ae5" width="300" height="400">
<br>
E registro atualizado :]
<br>

Para deletar, assim como anteriormente, selecionamos a linha desejada, clicamos em deletar, e vemos a telinha com os dados da linha:
<br>
<img src="https://github.com/LiviaBraz/gerenciamentoEstoque/assets/64878674/1cdfa535-613a-4092-869a-2fb64ee30153" width="300" height="400">
<br>

E clicando em ver tudo, após deletar ou alterar, temos um refresh da tabela:
<br>
<img src="https://github.com/LiviaBraz/gerenciamentoEstoque/assets/64878674/d3b74be0-bf6f-42bc-9534-2018bf0bdecb" width="300" height="400">
<br>

Temos também a opção de listar produtos em baixo estoque, o que nos restornará apenas produtos com menos de 10 unidades:
<br>
<img src="https://github.com/LiviaBraz/gerenciamentoEstoque/assets/64878674/ab2ecbae-eeea-4b87-80ab-9bb41dd75a3d" width="300" height="400">
<br>

Também temos o campo buscar, para que possamos encontrar o produto que desejamos, só ir digitando as letras (independe minúsculas ou maiúsculas) e a busca vai trazendo o que se encaixa.
<br>
<img src="https://github.com/LiviaBraz/gerenciamentoEstoque/assets/64878674/e28e142b-75e5-4ebd-80aa-23c87baf5e9f" width="300" height="400">
<br>

Clicando no botão de imprimir, é gerado um arquivo .txt, chamado ListaProdutos, que temos todos os dados da lista, incluindo ids.
<br>
<img src="https://github.com/LiviaBraz/gerenciamentoEstoque/assets/64878674/9286a0e1-4972-44c1-a85d-71936782f565" width="440" height="240">
<br>
<img src="https://github.com/LiviaBraz/gerenciamentoEstoque/assets/64878674/06ae379f-8aa1-4d2a-9aff-52235e82dd86" width="600" height="300">
