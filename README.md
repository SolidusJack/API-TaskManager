# API-TaskManager

API REST para gerenciamento de tarefas, desenvolvida com **Java + Spring Boot**.

---

## 📌 Sobre o projeto

Exemplo:
> Esta API permite criar, listar, atualizar e remover tarefas, com foco em organização de atividades e produtividade.

---

## 🚀 Tecnologias utilizadas
- Java 21
- Spring Boot
- Spring Web
- Spring Validation
- Springdoc OpenAPI (Swagger UI)
- Lombok
- Maven

---

## 📂 Estrutura do projeto
```bash
src/
  main/
    java/
      ... (pacotes da aplicação)
    resources/
      application.properties
  test/
    java/
pom.xml
README.md
```

---

## ⚙️ Pré-requisitos
Antes de começar, você precisa ter instalado:
- Java 21+
- Maven (ou usar o Maven Wrapper `mvnw`)
- Git

---

## ▶️ Como executar o projeto

### 1) Clonar o repositório
```bash
git clone https://github.com/SolidusJack/API-TaskManager.git
cd API-TaskManager
```

### 2) Rodar a aplicação
Linux/macOS:
```bash
./mvnw spring-boot:run
```

Windows:
```powershell
mvnw.cmd spring-boot:run
```

A aplicação deve subir em:
`http://localhost:8080`

---

## 🧪 Como rodar os testes
```bash
./mvnw test
```

No Windows:
```powershell
mvnw.cmd test
```

---

## 📖 Documentação da API (Swagger)
Com a aplicação em execução, acesse:
- Swagger UI: `http://localhost:8080/swagger-ui.html`  
ou  
- `http://localhost:8080/swagger-ui/index.html`

---

## 🔗 Endpoints principais
> Atualize esta seção conforme os endpoints forem sendo implementados.

### Tarefas
- `GET /tasks` → listar tarefas
- `GET /tasks/{id}` → buscar tarefa por ID
- `POST /tasks` → criar tarefa
- `PUT /tasks/{id}` → atualizar tarefa
- `DELETE /tasks/{id}` → remover tarefa

---

## 🧾 Exemplo de payload
### Criar tarefa (`POST /tasks`)
```json
{
  "title": "Estudar Spring Boot",
  "description": "Revisar controllers e services",
  "status": "PENDING"
}
```

---

## 🔐 Validações e regras de negócio
Descreva aqui:
- Campos obrigatórios
- Tamanhos mínimos/máximos
- Regras de status
