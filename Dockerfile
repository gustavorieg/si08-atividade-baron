FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/banco-facil-api-0.0.1-SNAPSHOT.jar app.jar

RUN useradd --system --create-home --uid 1000 appuser
USER appuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
