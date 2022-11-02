## To use `rabbitmqctl`

````
docker exec -it rabbitmq bash

// sample command to show all exchanges
rabbitmqctl list_exchanges

````


<br>

## To Run Tutorial 1

```

./mvnw clean package

java -jar target/spring-rabbitmq-0.0.1-SNAPSHOT.jar --spring.profiles.
active=hello-world,receiver

java -jar target/spring-rabbitmq-0.0.1-SNAPSHOT.jar --spring.profiles.
active=hello-world,sender

```

<br>

## To Run Tutorial 2

```

./mvnw clean package

# shell 1
java -jar target/spring-rabbitmq-0.0.1-SNAPSHOT.jar --spring.profiles.active=work-queues,receiver
# shell 2
java -jar target/spring-rabbitmq-0.0.1-SNAPSHOT.jar --spring.profiles.active=work-queues,sender

```


<br>

## To Run Tutorial 3

```

./mvnw clean package

# shell 1
java -jar target/spring-rabbitmq-0.0.1-SNAPSHOT.jar --spring.profiles.active=pub-sub,receiver --tutorial.client.duration=60000
# shell 2
java -jar target/spring-rabbitmq-0.0.1-SNAPSHOT.jar --spring.profiles.active=pub-sub,sender --tutorial.client.duration=60000

```