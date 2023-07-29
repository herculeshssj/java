Concurso
========

**Build**

```shell
docker build -t concurso:latest .
```

**Run**

```shell
docker run --restart=unless-stopped --add-host=concurso-db:192.168.1.1 --name concurso -d concurso:latest
```