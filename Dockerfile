# Etapa de build
FROM maven:3.8.6-openjdk-21 AS build
WORKDIR /app

# Copia os arquivos do projeto
COPY . .
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copia o JAR gerado
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Comando para rodar o Spring Boot
CMD ["java", "-jar", "app.jar"]


