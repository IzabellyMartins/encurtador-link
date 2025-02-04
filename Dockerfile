# Etapa de build
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Copia os arquivos do projeto
COPY . /app

# Define o diretório de trabalho
WORKDIR /app

# Compila o projeto e gera o .jar
RUN mvn clean package -DskipTests

# Etapa de runtime
FROM eclipse-temurin:21-jdk-jammy AS runtime

# Define o diretório de trabalho
WORKDIR /app

# Expõe a porta do aplicativo
EXPOSE 8080

# Copia o .jar gerado na etapa de build
COPY --from=build /app/target/*.jar app.jar

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]

