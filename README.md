# Order Service

Este microserviço é responsável por criar, listar e atualizar pedidos de um ecommerce. Ele persiste os dados em um banco de dados relacional MySQL e envia eventos de criação de pedidos via mensageria utilizando Kafka.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.5
- Spring Web
- Spring Data JPA
- Apache Kafka 
- MySQL
- Docker

## Como Rodar

Para rodar basta ter configurado o docker do kafka, criar o banco mysql local e configurar as portas conforme o application.yaml

## Collection para testes locais

{
	"info": {
		"_postman_id": "1af008ac-563a-4984-a4ab-bba6742fb19e",
		"name": "EcommerceOrders",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "40982328"
	},
	"item": [
		{
			"name": "CreateOrder",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n  \"product\": \"Notebook Gamer\",\r\n  \"quantity\": 2,\r\n  \"price\": 5500.00\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/orders",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"orders"
					]
				}
			},
			"response": []
		},
		{
			"name": "PaymentConfirmation",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "http://localhost:8081/payments/confirm/14",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"payments",
						"confirm",
						"14"
					]
				}
			},
			"response": []
		},
		{
			"name": "PaymentCancel",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "http://localhost:8081/payments/cancel/15",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"payments",
						"cancel",
						"15"
					]
				}
			},
			"response": []
		},
		{
			"name": "GetOrders",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/orders",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"orders"
					]
				}
			},
			"response": []
		}
	]
}




