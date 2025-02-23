FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
ADD ./target/microservice-product-0.0.1-SNAPSHOT.jar microservice-product.jar
ENTRYPOINT ["java", "-jar", "microservice-product.jar"]
