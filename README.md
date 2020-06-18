
# Getting started

need jdk and any springIDE.


## What is it about?


Simple Ticket-booking, which has some essential API's for booking a ticket, initially a movie has to be stored in database,
then after user can book ticket, cancel ticket and can check no tickets booked so far with seat Numbers.


## Maven dependencies

```java

spring-boot-starter-data-jpa
spring-boot-starter-web
spring-boot-devtools
mysql-connector-java

```

## API End points



-Save a movie

```java
localhost:8080/saveMovie

{
    "movieName": "hera pheri",
    "movieRunningTime": "3hr"
}
```

-Book A ticket
```java

localhost:8080/bookticket/{moviename}/{seatNo}/{email}/{name}?

moviename=hera pheri&seatNo=21&email=phoenix@g.com&name=raven
```

-Cancel ticket
```java

localhost:8080/tickets/cancelTicket/{name}?name=pranavpeddi
```



-get Ticket which are booked

```java
localhost:8080/movie/getTickets/{movieName}?movieName=hera pheri

```


##Acknwledgements

Open source community


