FROM adoptopenjdk
ARG JAR_FILE=out/artifacts/compras_main_jar/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

