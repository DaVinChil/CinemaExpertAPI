FROM openjdk:17-alpine

EXPOSE 5500

COPY target/CinemaExpertAPI-0.0.1-SNAPSHOT.jar cinema_expert.jar

CMD ["java", "-jar", "cinema_expert.jar"]