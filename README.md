[![Build Status]

# Crud Produto Imagem

Aplicação Spring Bot para CRUD de Produtos e Imagens. 

Projeto desenvolvido, executado e testado na IDE Spring Tool Suit, no Linux e Windows (64 bits).

**Para rodar a aplicação use o comando:**
` mvn spring-boot:run `

**Para rodar os testes unitários use o comando:**
` mvn test `

**URL base:**
```
 http://localhost:8080/
 [HEADER] Content-Type: application/json
```

**Resposta**
```
[RESPONSE] {
    "data": Data,
    "errors": [ ] Error
}
```


### CRUD Produtos

- Adicionar produto
```
[POST] api/produtos
[BODY] {
  "nome": string,
  "descricao": string,
  "produtoPai": {      // opcional
    "idProduto": int
  }
}
```

- **Listar produtos**
```
[GET] api/produtos
```

- **Listar produtos incluindo imagens**
```
[GET] api/produtos/imagens
```

- **Listar produtos incluindo produto pai**
```
[GET] api/produtos/pais
```

- **Pesquisar produto**
```
[GET] api/{int produtoId}
```

- **Pesquisar produto incluindo imagens**
```
[GET] api/{int produtoId}/imagens
```

- **Pesquisar produto inlucindo produto pai**
```
[GET] api/{int produtoId}/pais
```

- **Listar produtos filhos por id de produto pai**
```
[GET] api/produtos/{int produtoPaiId}/filhos
```

- **Atualizar produto**
```
[PUT] api/produtos/{int produtoId}
[BODY] {
  "nome": string,
  "descricao": string,
  "produtoPai": {      // opcional
    "idProduto": int
  }
}
```

- **Deletar produto**
```
[DELETE] api/produtos/{int produtoId}
```

### CRUD Imagens

- **Adicionar imagem**
```
[POST] api/imagens
[BODY] {
  "tipo": string,
  "produto": {
    "idProduto": int
  }
}
```

- **Listar imagens**
```
[GET] api/imagens
```

- **Listar imagens de um produto**
```
[] api/imagens?produto={int produtoId}
```

- **Atualizar imagem**
```
[PUT] api/imagens/{int imagemId}
[BODY] {
  "tipo": string,
  "produto": {
    "idProduto": int
  }
}
```

- **Deletar imagem**
```
[DELETE] api/imagens/{int imagemId}
```


Autoria :neckbeard: [FJedi](https://www.linkedin.com/in/felipevmleitao/)
