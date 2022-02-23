#language: pt

  Funcionalidade: Crud Filme

    Cenario: Cadastro Filme
      Dado que tenha realizado login com dados validos
      E que tenha um payload da API de Filme
      Quando realizo uma requisicao do tipo POST de Filme
      Entao valido que recebo status 201 no response
      E valido que no campo "categorias.tipo[1]" possui o valor "Comédia"
      E armazeno o id que recebo do response de Filme

    Cenario: Consultar Filme
      Dado que tenha realizado login com dados validos
      E que tenha um payload da API de Filme
      Quando realizo uma requisicao do tipo GET de Filme
      Entao valido que recebo status 201 no response
      E valido que no campo "categorias.tipo[1]" possui o valor "Comédia"