#language:pt

  @login
  Funcionalidade: Realizar Login
    Teste de Login pela API

  @loginSucesso
  Cenario: Realizar Login com sucesso
    Dado que tenha um payload valido da API de Login
    Quando envio uma requisicao do tipo Post de Login
    Entao valido que recebo status 200 no response
    E armazeno o token que recebo do response de Login

  @loginSenhaInvalida
  Cenario: Realizar Login com senha invalida
    Dado que tenha um payload da API de Login com as seguintes infromacoes
      | email      | aluno@email.com |
      | senha      | 123457             |
    Quando envio uma requisicao do tipo Post de Login
    Entao valido que recebo status 400 no response

  @LoginESenhaInvalidaEComSucesso
  Esquema do Cenario: Realizar Login com <cenario>
    Dado que tenha um payload da API de Login com as seguintes infromacoes
      | email      | <email> |
      | senha      | <senha> |
    Quando envio uma requisicao do tipo Post de Login
    Entao valido que recebo status <statusCode> no response

    Exemplos:
      | cenario         |email              | senha  | statusCode |
      | usuario invalido|invalid@email.com  | 123456 |  400       |
      | cenario valido  |aluno@email.com    | 123456 |  200       |