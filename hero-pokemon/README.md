Hero Pokémon
============

Aplicação exemplo de REST API usando Spring Boot com Groovy.

Configurando a base de dados
----------------------------

```
docker run --name hero-pokemon-db -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=hero_pokemon -d postgres
```

Executando a aplicação
----------------------

```
docker run --name hero-pokemon --link hero-pokemon-db -p 8080:8080 -u gradle -v "$PWD":/home/gradle/project -w /home/gradle/project gradle:jdk11 gradle bootRun
```