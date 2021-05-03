## Running locally

- Install:
  
[Maven](https://maven.apache.org/)

[Docker and Docker Compose](https://docs.docker.com/engine/install/)
 

- Configure database settings - src/main/resources/application.yml

```yaml
url: 
username: 
password: 
```
- Run PostgreSQL locally with Docker Compose 

```bash
docker-compose up
```

- Run Project with maven

```bash
mvn spring-boot:run
``` 