#! /bin/sh

curl -X GET localhost:8080/home
curl -X GET localhost:8080/produtos
curl -X GET localhost:8080/produtos/1

#To perform a POST request using cURL, you can use the following command structure:
#	curl -X POST -d "key=value" https://example.com
#To send JSON data, you need to set the Content-Type header:
#	curl -X POST -H "Content-Type: application/json" -d '{"title":"foo","body":"bar"}' https://example.com/posts

curl -X POST -H "Content-Type: application/json" -d '{"descricao":"teclado","preco":10.99,"estoque":10}' localhost:8080/produtos
curl -X POST -H "Content-Type: application/json" -d '{"descricao":"mouse","preco":5.99,"estoque":10}' localhost:8080/produtos
curl -X GET localhost:8080/produtos/1
curl -X PUT -H "Content-Type: application/json" -d '{"descricao":"mouse","preco":10.99,"estoque":100}' localhost:8080/produtos/2
