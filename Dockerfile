# Etapa de build
FROM ubuntu:latest AS build

# Instalar dependências necessárias
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk maven && \
    rm -rf /var/lib/apt/lists/*

# Copiar os arquivos do projeto
COPY . .

# Compilar o projeto
RUN mvn clean install

# Etapa de execução
FROM openjdk:21-jdk-slim

# Definir o diretório de trabalho
WORKDIR /app

# Expor a porta 8080
EXPOSE 8080

# Copiar o JAR gerado para a imagem final
COPY --from=build /app/target/*.jar app.jar

# Comando para rodar o aplicativo
CMD ["java", "-jar", "app.jar"]


