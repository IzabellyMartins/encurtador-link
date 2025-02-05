# Etapa de build
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto para dentro do container
COPY . .

# Compila o projeto sem rodar testes
RUN mvn clean package -DskipTests

# Etapa de runtime (imagem menor e otimizada)
FROM eclipse-temurin:21-jdk-jammy

# Define o diretório de trabalho
WORKDIR /app

# Expõe a porta 8080
EXPOSE 8080

# Copia o .jar gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]


