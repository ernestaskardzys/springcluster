## Introduction
 
I have decided to play a bit with Docker and Spring Boot. The result is this project - Spring Boot application with HAProxy as load balancer.

I have used the following technologies:
* [Spring Boot](http://spring.io/projects/spring-boot)
* [Docker](https://www.docker.com/)
* [Docker Compose](https://docs.docker.com/compose/)
* [HAProxy](http://www.haproxy.org/)
* [Gradle](https://gradle.org/)

## Architecture

Project's architecture is a bit artificial, but it shows how Docker's containers can communicate with each other.

Client calls load balancer (port 80) which redirects REST call to *web* project.
*web* projects calls *number-generator* project which is REST application generating random number. This random number is returned back to *web* project and later back to the user. 

As HAProxy works as load balancer it's easy to add multiple instances of the services without no downtime.
## Testing

To test the functionality, open a terminal and run:

```bash
$ ./gradlew clean build
$ docker-compose build
$ docker-compose up --scale number-generator=5 --scale web=5
```

This will start a cluster of 1 load balancer, 5 random number generators and 5 web service endpoints (sort of wrapper for random number generators).

And then curl to the load balancer:
```bash
$ curl http://localhost/count
```

Now we have one instance of load balancer running and 5 instances of *number-generator* and *web* services.

