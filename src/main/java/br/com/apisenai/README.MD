## PARA FACILITAR OS TESTES, PODERÁ IMPORTAR O ARQUIVO ABAIXO NO POSTMAN


{
"info": {
"_postman_id": "1b5bbd08-07f6-4084-b297-974da2604094",
"name": "ArthurFaculdade",
"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
},
"item": [
{
"name": "localhost:8080/registro/5",
"request": {
"method": "POST",
"header": [],
"body": {
"mode": "raw",
"raw": "{\r\n    \"nome\": \"Aleffzao\",\r\n    \"sobrenome\": \"Mela\",\r\n    \"apelido\":\"Arthurzito\",\r\n    \"email\":\"Julito@hotmail.com\",\r\n    \"senha\":\"54321\",\r\n    \"foto\":\"3x4\"\r\n}",
"options": {
"raw": {
"language": "json"
}
}
},
"url": {
"raw": "localhost:8080/registro/5",
"host": [
"localhost"
],
"port": "8080",
"path": [
"registro",
"5"
]
}
},
"response": []
},
{
"name": "localhost:8080/registro/5",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "localhost:8080/registro/5",
"host": [
"localhost"
],
"port": "8080",
"path": [
"registro",
"5"
]
}
},
"response": []
},
{
"name": "localhost:8080/registro/",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "localhost:8080/registro/",
"host": [
"localhost"
],
"port": "8080",
"path": [
"registro",
""
]
}
},
"response": []
},
{
"name": "localhost:8080/registro/nome/Alf",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "localhost:8080/registro/nome/Alf",
"host": [
"localhost"
],
"port": "8080",
"path": [
"registro",
"nome",
"Alf"
]
}
},
"response": []
},
{
"name": "localhost:8080/registro/7",
"request": {
"method": "DELETE",
"header": [],
"url": {
"raw": "localhost:8080/registro/7",
"host": [
"localhost"
],
"port": "8080",
"path": [
"registro",
"7"
]
}
},
"response": []
},
{
"name": "localhost:8080/registro/aleffzito@hotmail.com/2",
"request": {
"method": "PATCH",
"header": [],
"url": {
"raw": "localhost:8080/registro/aleffzito@hotmail.com/2",
"host": [
"localhost"
],
"port": "8080",
"path": [
"registro",
"aleffzito@hotmail.com",
"2"
]
}
},
"response": []
},
{
"name": "localhost:8080/registro/5",
"request": {
"method": "PUT",
"header": [],
"body": {
"mode": "raw",
"raw": "{\r\n    \"nome\": \"Aleffzao\",\r\n    \"sobrenome\": \"Mela\",\r\n    \"apelido\":\"Arthurzito\",\r\n    \"email\":\"Julito@hotmail.com\",\r\n    \"senha\":\"54321\",\r\n    \"foto\":\"3x4\"\r\n}",
"options": {
"raw": {
"language": "json"
}
}
},
"url": {
"raw": "localhost:8080/registro/5",
"host": [
"localhost"
],
"port": "8080",
"path": [
"registro",
"5"
]
}
},
"response": []
}
]
}
