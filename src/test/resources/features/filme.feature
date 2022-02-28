#language: pt
  @Filme
  Funcionalidade: Crud Filme

    Contexto:
      Dado que tenha realizado login com dados validos
      E que tenha um payload da API de Filme

    Cenario: Cadastro Filme
      Quando realizo uma requisicao do tipo POST de Filme
      Entao valido que recebo status 201 no response
      E valido que no campo "categorias.tipo[1]" possui o valor "Comédia"
      E armazeno o id que recebo do response de Filme

    Cenario: Consultar Filme
      Quando realizo uma requisicao do tipo GET de Filme
      Entao valido que recebo status 200 no response
      E valido que no campo "categorias[0].tipo[1]" possui o valor "Comédia"

    Cenario: Alteração Filme
      E altero o indice 1 da lista de Categotias de filme com os valores
        | tipo | Terror |
      Quando realizo uma requisicao do tipo PUT de Filme
      Entao valido que recebo status 200 no response
      E valido que no campo "categorias.tipo[1]" possui o valor "Terror"

    Cenario: Consultar Filme Alterado
      Quando realizo uma requisicao do tipo GET de Filme
      Entao valido que recebo status 200 no response
      E valido que no campo "categorias[0].tipo[1]" possui o valor "Terror"

    Cenario: Exclusao Filme
      Quando realizo uma requisicao do tipo DELETE de Filme
      Entao valido que recebo status 200 no response

    Cenario: Consultar Filme Exclusao
      Quando realizo uma requisicao do tipo GET de Filme
      Entao valido que recebo status 200 no response
      E valido que recebo uma lista vazia no response