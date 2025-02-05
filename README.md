# 🔗 **Encurtador de Links** 🚀

Este projeto consiste em uma API RESTFUL desenvolvida em Java + Spring Boot para encurtar URLs, seguindo o padrão MVC. O front-end foi desenvolvido separadamente utilizando HTML, CSS e JavaScript, e consome a API para fornecer uma interface amigável ao usuário.

![ImagemLIGHT](https://i.imgur.com/kjJzJ92.png)

![ImagemDARK](https://i.imgur.com/HpQVffF.png)

---

## 🛠️ **Funcionalidades**

- **Encurtar URLs**: Recebe uma URL longa e retorna uma URL encurtada.

- **Redirecionamento**:  Ao acessar a URL encurtada, o usuário é redirecionado para a URL original.

- **Interface Web**: Uma página web simples e intuitiva onde os usuários podem inserir URLs para serem encurtadas.



---

## 🖥️ **Tecnologias Utilizadas**

- **Back-end**: Java + Spring Boot.
- **Front-end**: HTML, CSS e JavaScript.
- **Banco de Dados**: PostgreSQL

---

## 🚀 **Como Executar o Projeto**

### Pré-requisitos

- Java JDK 11+ (O projeto foi feito com o 21)
- Maven 
- Garantir que o PostgreSQL esteja rodando.

### Passos para Execução

1. **Clone o repositório do projeto para o seu ambiente local.**:
2. **Execute em seu cmd**:
   ```cmd
   psql -U postgres -c "CREATE DATABASE encurtador_link;"
3. **Inicie a aplicação normalmente (Run na IDE ou mvn spring-boot:run)**.
Por fim, pode usar a url: http://localhost:8080/index.html, para acessar o projeto e agora a api está pronta para ser explorada! 🚀
