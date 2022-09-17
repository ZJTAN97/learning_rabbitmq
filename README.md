## Messaging Protocols Overview

-   STOMP, MQTT, AMQP

<br>
<hr>
<br>

## STOMP

-   Simple Text-Oriented Messaging Protocol
-   Provides an interoperable format so that STOMP clients can communicate with any STOMP message broker to provide easy and widespread messaging interoperability among many languages, platforms and brokers
-   Does not deal with concepts like queue and topics; uses a SEND semantic with a "destination" string for where the message to deliver.
-   However, receiever can implement queues, topics and exchanges

<br>
<hr>
<br>

## MQTT

-   Message Queue Telemetry Transport
-   Machine to Machine / IOT connectivity protocol
-   Specifically designed for resource-constrained devices and lowbandwidth, high latency networks such as dial up lines and satellite links

<br>
<hr>
<br>

## AMQP & What it solves

-   Advanced Message Queueing Protocol
-   Reliable and interoperable (use in any environments)
-   Provides a wide range of features to messaging, including reliable queueing, topic-based publish and subscribe messaging, flexible routing, transactions and security.

<br>
<hr>
<br>

## RabbitMQ: A Design Overview

Publisher --> exchange --> (binding) --> queue ---> Subscriber

-   Publishers, exchange are their starting point
-   Subscribers only listen to the queues

<br>
<hr>
<br>

## Exchanges, Queues, Topics and Bindings

<br>

4 main actors for RabbitMQ

-   Producer (Publisher) --> Exchange --> Queue --> Consumer (Subscriber)

### Exchange

-   Actual AMQP elements where messagaes are sent at first
-   Takes a message and routes it into one or more queues
-   Routing algorithm decides where to send messages from exchange
-   Routing algorithms depends on the exchange type and rules called "bindings"
-   Bindings are simply used to bind exchanges to queues for message delivery

<br>

### Four exchange Types

1. Direct Exchange (Empty String) and amq.direct
2. Fanout Exchange amq.fanout (distribute to every queue)
3. Topic Exchange amq.topic (can choose the topic you want to send)
4. Headers Exchange amq.match (and amq.headers in RabbitMQ)

<br>

### Queues

-   A core element in any MQ protocol, especially for RabbitMQ
-   Messages are routed to queues from exchanges
-   Queues are final destinations in RabbitMQ before being recieved by subscribers (consumers).
-   Routing algorithms depends on the exchange type and rules called "bindings"
-   Bindings are simply used to bind exchanges to queues for message delivery.

<br>

### Properties of queues

1. Name: Name of the queue
2. Durable: Either persist the queue to the disk or not
3. Exclusive: Delete the queue if not used anymore
4. Auto-Delete: Delete the queue when consumer unsubscribes

<br>

### Topics

-   Topics are simply the "subject" part of the messages
-   Defined as routing_key for message grouping
-   You can send and recieve messages without any topic information
-   Optional parameters for message exchange
-   Topic Exchanges are (has to be) defined using Topics for Message Delivery

<br>

### Bindings

Exchange ---> (binding) ---> Queue

-   Rules that exchanges use to route messages to queues.
-   To instruct an exchange E to route messages to a queue K, K has to be bound to E.
-   May have an optional routing key attribute used by some exchange types
-   Routing key acts like a filter.
-   If message cannot be routed to any queue, it is either dropped or returned to the publisher, depending on message attributes the publisher has set.

<br>
Binding analogy
- Queue is like your destination in Singapore
- Exchange is like one of the MRT stations in Singapore
- Bindings are routes from your current location to the destination. There can be zero or many ways to reach it.
