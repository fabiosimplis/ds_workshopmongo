# WorkShop Mongo DB
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/fabiosimplis/DEV-dscommerce-back-end/blob/main/LICENSE) 

# Sobre o projeto

DSPost é uma aplicação back end web construída em conjunto ao curso **Java Spring Reference**, da plataforma [DevSuperior](https://devsuperior.com "Site da DevSuperior"), para estudo do springboot usando o banco NoSQL MongoDB

O sistema consiste em uma API de um forum onde há posts e comnetários feitos por usuários.

## Modelo conceitual
![Modelo Conceitual](https://github.com/fabiosimplis/ds_workshopmongo/blob/main/assets/modelo_conceitual.png).

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- MongoDB
- Maven

# Como executar o projeto

## Back-end
Pré-requisitos: Java 17

```bash
# clonar repositório
git clone (https://github.com/fabiosimplis/ds_workshopmongo.git)

# entrar na pasta do projeto back end
cd ds_workshopmongo

# executar o projeto
./mvnw spring-boot:run
```
## Recursos adicionais


### Container Docker do MongoDB para desenvolvimento

```
docker run -d -p 27017:27017 -v /data/db --name mongo1 mongo:4.4.3-bionic
```

```
docker exec -it mongo1 bash
```

### Introdução NoSQL

[![Image](https://img.youtube.com/vi/c6h5eR0TvfU/mqdefault.jpg "Vídeo no Youtube")](https://youtu.be/c6h5eR0TvfU)

### Documentação MongoDB: query operators

https://docs.mongodb.com/manual/reference/operator/query

### Documentação Spring Data MongoDB

https://docs.spring.io/spring-data/mongodb/docs/current/reference/html

### Localização dos volumes Docker no Windows

https://stackoverflow.com/questions/43181654/locating-data-volumes-in-docker-desktop-windows

### Vídeo sobre tratamento de exceções

[![Image](https://img.youtube.com/vi/MAv7xgnSD-s/mqdefault.jpg "Vídeo no Youtube")](https://youtu.be/MAv7xgnSD-s)



# Autor

Fábio S. S. Júnior

https://www.linkedin.com/in/fabio-simplis/
