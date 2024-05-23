# Projeto Forge

O Projeto Forge é uma aplicação Spring Boot desenvolvida para gerenciar mentores, empresas, desafios e representantes, permitindo o cadastro, atualização, listagem e exclusão desses elementos, além de associar desafios a mentores e empresas, e representantes a empresas.

## Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA
- Spring Web
- PostgreSQL
- Thymeleaf
- Bootstrap
- SweetAlert2

## Pré-requisitos

Para executar este projeto, você precisará ter instalado:

- JDK 11 ou superior
- Maven
- PostgreSQL

## Configuração do Banco de Dados

1. Crie um banco de dados no PostgreSQL com o nome `Forge`.
2. Configure as propriedades de conexão com o banco de dados no arquivo `src/main/resources/application.properties`, incluindo URL, nome de usuário e senha.

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:8080/Forge
spring.datasource.username=postgres
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

## Executando o Projeto

Para executar o projeto, siga os passos abaixo:

1. Clone o repositório para sua máquina local.
2. Abra um terminal na raiz do projeto.
3. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.
4. Acesse `http://localhost:8085` em seu navegador para visualizar a aplicação.

## Estrutura do Projeto

- `src/main/java/br/unit/forgek`: Contém os arquivos Java do projeto, incluindo modelos, repositórios, serviços e controladores.
- `src/main/resources/templates`: Contém os arquivos HTML usados pelo Thymeleaf para renderizar as páginas da aplicação.
- `src/main/resources/application.properties`: Arquivo de configuração do Spring Boot.

## Funcionalidades

- **Gerenciamento de Empresas**: Permite cadastrar, listar, atualizar e excluir empresas.
- **Gerenciamento de Mentores**: Permite cadastrar mentores associados a empresas, listar, atualizar e excluir mentores.
- **Gerenciamento de Desafios**: Permite criar e gerenciar desafios que são associados aos mentores e empresas, incluindo a capacidade de listar, atualizar e excluir desafios.
- **Cadastro e Gerenciamento de Representantes**: Permite o cadastro de representantes associados a empresas e o gerenciamento dos mesmos, incluindo listagem, atualização e exclusão.

## Licença

Este projeto está licenciado sob a Disciplina de Residência de Software II - Universidade Tiradentes - Aracaju/SE
