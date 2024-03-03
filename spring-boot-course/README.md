MariaDB database container
--------------------------

```shell
docker run --name spring-boot-course-mariadb -p 3306:3306 --env MARIADB_ROOT_PASSWORD=root -d mariadb:lts
```

### Backuping the databases

**It is necessary the container is running**

```shell
docker exec -i spring-boot-course-mariadb mysqldump -u root -proot --all-databases > all-databases.sql
```

### Restoring the databases

**It is necessary the container is running**

```shell
docker exec -i spring-boot-course-mariadb mysql -u root -proot < all-databases.sql
```
