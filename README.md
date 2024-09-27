# Gerenciador de RH API

![Logo do Gerenciador de RH](http://rpsrh.com.br/site/wp-content/uploads/2016/05/rh.png)  <!-- Substitua pelo caminho da sua logo -->

## Descrição
O Gerenciador de RH é uma API desenvolvida em Java com Spring Boot, que facilita a administração de informações de recursos humanos. Esta aplicação implementa um CRUD completo para gerenciar candidatos, vagas e suas informações de forma simples e eficiente.

## Funcionalidades
- **Cadastro de Vagas**: Crie novas vagas que podem ser associadas a múltiplos candidatos.
- **Cadastro de Candidatos**: Adicione candidatos com informações como nome, RG e e-mail, garantindo que cada candidato seja cadastrado uma única vez com base no RG único.
- **Alteração de Vagas**: Atualize as informações de uma vaga existente.
- **Listagem de Vagas**: Liste todas as vagas cadastradas no sistema.
- **Deleção de Vagas**: Deletar vagas que não são mais necessárias.
- **Deleção de Candidatos**: Remova candidatos do sistema conforme necessário.

## Tecnologias Utilizadas
- **Linguagem**: Java 17
- **Framework**: Spring Boot 3.3.4
- **Gerenciador de Dependências**: Maven
- **Banco de Dados**: MySQL
- **Template Engine**: Thymeleaf
- **Estilização**: Bootstrap

## Como Executar o Projeto

### Pré-requisitos:
- Instale o JDK 17 ou superior.
- Instale o MySQL e crie um banco de dados para a aplicação.

### Clone o Repositório:
```bash
git clone https://github.com/CaioEmannuelDiniz/AppRh-Java.git

### Crie um arquivo .env
Na pasta resources do projeto, crie um arquivo chamado .env com as seguintes informações:
```bash
DB_URL=jdbc:mysql://localhost:3306/seu_banco
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha

## Compile e Execute:
```bash
cd gerenciador-rh
mvn spring-boot:run

## Contribuição

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nome-da-feature`).
3. Faça commit das suas mudanças (`git commit -m 'Adiciona nova feature'`).
4. Envie para o repositório remoto (`git push origin feature/nome-da-feature`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT.

## Contato

Se você tiver dúvidas ou sugestões, entre em contato:

- **LinkedIn**: [Caio Emannuel](https://www.linkedin.com/in/caio-emannuel-diniz/)

## Agradecimento
Agradeço por conferir o `Gerenciador de Biblioteca!` Espero que você encontre este projeto útil e inspirador. Boa leitura! 📚

