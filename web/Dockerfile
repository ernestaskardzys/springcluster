FROM java:8
MAINTAINER Ernestas Kardzys <ernestas.kardzys@gmail.com>
VOLUME /tmp
ADD /build/libs/web.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
