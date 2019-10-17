# Pizzaria-uds
APIs Rest para o sistema de gerenciamento de pedido de Pizza


### Stack utilizada

	- Java 8
	- Spring Boot 2.1.7.RELEASE
	- Banco de Dados H2
	- JPA

### Geração da imagem Docker

## Via prompt de comando

1. Entre na pasta raiz do projeto
2. Digite o comando mvn clean package -DskipTests


## Via IDE Spring Tool Suite

1. Clique no nome do projeto com o botão no nome do projeto > Run As > Maven Buil...
2. Na aba Main, no campo Goals, preencher com o comando: clean package -DskipTests
3. Clique no botão Apply e depois no botão Run

Seja pelo prompt de comando, ou pela IDE, os dois comandos vão gerar os artefatos na pasta target, e nesse projeto o nome da imagem gerada é uds-pizzaria:0.0.1-SNAPSHOT


### Executar a Imagem

1. Via Docker executar o comando que executará a imagem:
	
	docker run -p 9090:9090 uds-pizzaria:0.0.1-SNAPSHOT
	

### Acesso as APIs

## Sabores

	- Listar os sabores
	
	GET http://localhost:9090/pizzaria-uds/sabores	
	
	```
	[
	    {
	        "id": 10001,
	        "descricao": "calabresa",
	        "tempoAdicional": 0
	    },
	    {
	        "id": 10002,
	        "descricao": "marguerita",
	        "tempoAdicional": 0
	    },
	    {
	        "id": 10003,
	        "descricao": "portuguesa",
	        "tempoAdicional": 5
	    }
	]
	```
	
	
	- Sabor específico
	
	GET http://localhost:9090/pizzaria-uds/sabores/10001
	
	```
	{
	    "id": 10001,
	    "descricao": "calabresa",
	    "tempoAdicional": 0
	}
	```

	
	- Cadastrar novo Sabor
	
	POST http://localhost:9090/pizzaria-uds/sabores
	
	```
	{
	    "descricao": "banana",
	    "tempoAdicional": 6
	}
	```
	
	- Remover Sabor específico
	
	DELETE http://localhost:9090/pizzaria-uds/sabores/10002
	
	```
	Status 200 OK
	```
	

## Tamanhos

	- Listar os tamanhos
	
	GET http://localhost:9090/pizzaria-uds/tamanhos	
	
	```
	[
	    {
	        "id": 10001,
	        "tamanho": "pequena",
	        "valor": 15,
	        "tempoDePrepadro": 20
	    },
	    {
	        "id": 10002,
	        "tamanho": "media",
	        "valor": 20,
	        "tempoDePrepadro": 30
	    },
	    {
	        "id": 10003,
	        "tamanho": "grande",
	        "valor": 25,
	        "tempoDePrepadro": 40
	    }
	]
	```
	
	
	- Tamanho específico
	
	GET http://localhost:9090/pizzaria-uds/tamanhos/10002	
	
	```
	{
	    "id": 10002,
	    "tamanho": "media",
	    "valor": 20,
	    "tempoDePrepadro": 30
	}
	```

	
	- Cadastrar novo Tamanho
	
	POST http://localhost:9090/pizzaria-uds/tamanhos
	
	```
	{
	    "tamanho": "gigante",
	    "valor": 50,
	    "tempoDePrepadro": 32
	}
	```	
	
	- Remover Tamanho específico
	
	DELETE http://localhost:9090/pizzaria-uds/tamanhos/10002
	
	```
	Status 200 OK
	```
	

## Personalizações

	- Listar as personalizações
	
	GET http://localhost:9090/pizzaria-uds/personalizacoes		
	
	```
	[
	    {
	        "id": 111,
	        "descricao": "extra bacon",
	        "valorAdicional": 3,
	        "tempoAdicional": 0
	    },
	    {
	        "id": 112,
	        "descricao": "sem cebola",
	        "valorAdicional": 0,
	        "tempoAdicional": 0
	    },
	    {
	        "id": 113,
	        "descricao": "borda recheada",
	        "valorAdicional": 5,
	        "tempoAdicional": 5
	    }
	]
	```
	
	
	- Tamanho específico
	
	GET http://localhost:9090/pizzaria-uds/personalizacoes/113
	
	```
	{
	    "id": 113,
	    "descricao": "borda recheada",
	    "valorAdicional": 5,
	    "tempoAdicional": 5
	}
	```

	
	- Cadastrar nova personalização Sabor
	
	POST http://localhost:9090/pizzaria-uds/sabores
	
	```
	{
	    "descricao": "extra catupiry",
	    "valorAdicional": 8,
	    "tempoAdicional": 3
	}
	```
	
	- Remover Personalização específico
	
	DELETE http://localhost:9090/pizzaria-uds/personalizacoes/112
	
	```
	Status 200 OK
	```
	

## Pizzas

	- Listar as pizzas já cadastradas
	
	GET http://localhost:9090/pizzaria-uds/pizzas	
	
	```
	[
	    {
	        "id": 10001,
	        "tamanho": "media",
	        "sabor": "calabresa",
	        "valorInicial": 30,
	        "tempoInicial": 20,
	        "valorTotal": 30,
	        "tempoTotal": 20,
	        "personalizacoes": []
	    }
	]
	```
	
	
	- Pizza específica
	
	GET http://localhost:9090/pizzaria-uds/pizzas/10001
	
	```
	{
	    "id": 10001,
	    "tamanho": "media",
	    "sabor": "calabresa",
	    "valorInicial": 30,
	    "tempoInicial": 20,
	    "valorTotal": 30,
	    "tempoTotal": 20,
	    "personalizacoes": []
	}
	```

	
	- Cadastrar nova pizza
	
	POST http://localhost:9090/pizzaria-uds/sabores
	
	```
	{
	    "tamanho": "grande",
	    "sabor": "portuguesa"
	}
	```

	- Personalizar pizza
	
	PUT http://localhost:9090/pizzaria-uds/pizzas/10001/personalizar
	
	```
	{
	    "descricao": "borda recheada"
	}
	```

	Response:
	
	```
	{
	    "id": 10001,
	    "tamanho": "media",
	    "sabor": "calabresa",
	    "valorInicial": 30,
	    "tempoInicial": 20,
	    "valorTotal": 35,
	    "tempoTotal": 25,
	    "personalizacoes": [
	        {
	            "id": 113,
	            "descricao": "borda recheada",
	            "valorAdicional": 5,
	            "tempoAdicional": 5
	        }
	    ]
	}
	```
	
	- Remover Pizza específico
	
	DELETE http://localhost:9090/pizzaria-uds/pizzas/10001
	
	```
	Status 200 OK
	```
	
	Caso haja pedido vinculado a seguinte mensagem será mostrada:
	
	```
	{
	    "timeStamp": "2019-10-17T02:29:52.840+0000",
	    "mensagem": "Pizza não pode ser removida por ter Pedido atrelado, remova antes o Pedido.",
	    "detalhes": "uri=/pizzaria-uds/pizzas/10001"
	}
	```
	

## Pedidos

	- Listar os pedidos
	
	GET http://localhost:9090/pizzaria-uds/pedidos	
	
	```
	[
	    {
	        "id": 55555,
	        "tamanho": "media",
	        "sabor": "calabresa",
	        "valorTotal": 30,
	        "tempoTotal": 20
	    }
	]
	```
	
	
	- Pedido específico
	
	GET http://localhost:9090/pizzaria-uds/pedidos/55555
	
	```
	{
	    "id": 55555,
	    "tamanho": "media",
	    "sabor": "calabresa",
	    "valorTotal": 30,
	    "tempoTotal": 20
	}
	```

	
	- Cadastrar novo pedido
	
	POST http://localhost:9090/pizzaria-uds/pedidos
	
	```
	{
		"id":1
	}
	```

	Obs: Id da Pizza previamente cadastrada e que não tenha sido utilizado em outro pedido.

