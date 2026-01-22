![Project Banner](notification-api.png)
# Notification API

## Sobre essa API

O objetivo dessa aplicação foi implementar um endpoint exposto para inclusão de notificações. <br>
Essas notificações são recebidas pela a aplicação, salvas em um banco de dados, e enviadas para um tópico kafka. Para serem processadas e entregadas para os usuários destinatários na [notification-service](https://github.com/DaniloVolles/notification-service).

A rigor, é uma aplicação com arquitetura orientada a eventos, possui comunicação assíncrona real e um Kafka desacoplado para transporte de mensagens.

## Executing the application

- Ensure Docker is installed and running on your operating system
- Ensure Java 17 and Maven are installed and properly configured

1. Build the application JAR:
```bash
mvn clean package
 ```

2. Build the Docker image (make sure to include the dot at the end):
```bash
docker build -t notification-api:latest .
```

3. Run the Docker container:
```bash
docker run -p 8080:8080 notification-api:latest
```

4. Verify the application health:
```curl
curl --location 'localhost:8080/health/is-app-running'
```

### Important:
> The application is compiled on the host machine using Maven.<br>
> The Docker image only packages the generated JAR and runs it using a Java 17 runtime.
