
# 🍨 Ice Cream Parlor

Sistema de pedidos interativo para uma sorveteria, com execução via terminal. Desenvolvido aplicando princípios de orientação a objetos e múltiplos padrões de projeto.

---

## 🎯 Objetivo

- Gerenciar sabores e personalizações.
- Criar, acompanhar e gerenciar pedidos.
- Aplicar diferentes tipos de descontos.
- Otimizar o fluxo de atendimento da sorveteria.

---

## 🏛️ Padrões de Projeto Aplicados

| Padrão      | Aplicação                                                                                   |
|-------------|---------------------------------------------------------------------------------------------|
| **Factory**     | Criação dos tipos de sorvetes (picolé, massa, milkshake).                                   |
| **Singleton**   | Fila de pedidos compartilhada.                                                               |
| **Strategy**    | Estratégias de desconto aplicáveis a pedidos.                                               |
| **Decorator**   | Adicionais como calda, cobertura, chantilly.                                                |
| **Observer**    | Notificações automáticas sobre o status dos pedidos.                                        |
| **Command**     | Ações encapsuladas como fazer, cancelar ou refazer pedidos.                                 |
| **State**       | Estados dos pedidos (Recebido, Preparando, Pronto, Entregue).                               |
| **Facade**      | Interface unificada para interações com o sistema.                                          |
| **Repository**  | Persistência dos dados de pedidos e clientes.                                               |

---

## 📁 Estrutura de Pastas

```plaintext
src/
└── main/
    ├── java/
    │   └── br.edu.ifpb.ice_cream_parlor/
    │       ├── cli/
    │       ├── config/
    │       ├── controller/
    │       ├── exceptions/
    │       ├── model/
    │       │   ├── entities/
    │       │   └── view/
    │       ├── patterns/
    │       │   ├── command/
    │       │   │   ├── catalog_menu/
    │       │   │   ├── history_menu/
    │       │   │   ├── main_menu/
    │       │   │   ├── order_menu/
    │       │   │   ├── register_menu/
    │       │   │   └── tracking_menu/
    │       │   ├── decorator/
    │       │   ├── facade/
    │       │   ├── factory/
    │       │   ├── observer/
    │       │   ├── repository/
    │       │   ├── singleton/
    │       │   ├── state/
    │       │   └── strategy/
    │       ├── utils/
    │       └── Main.java
    └── resources/
└── test/
```

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Maven
- JUnit
- PostgreSQL (via JDBC)

---

## 🧪 Funcionalidades

- ✅ Criação de sorvetes com diferentes tipos.
- ✅ Sistema de pedidos com múltiplos itens.
- ✅ Aplicação de diferentes tipos de desconto.
- ✅ Personalização dos pedidos.
- ✅ Gerenciamento de estados dos pedidos.
- ✅ Notificações automáticas.
- ✅ Comandos para desfazer/refazer ações.
- ✅ Interface simplificada via Facade.
- ✅ Persistência simulada dos dados.

---

## 🏃 Como Executar Localmente

### 1. Clone o projeto:

```bash
git clone https://github.com/seu-usuario/ice-cream-parlor.git
cd ice-cream-parlor
```

### 2. Compile o projeto com Maven:

```bash
mvn clean package -DskipTests
```

> Certifique-se de que o `pom.xml` está configurado com o `maven-assembly-plugin` para gerar um JAR com dependências.

### 3. Execute a aplicação:

```bash
java -jar target/ice-cream-parlor-1.0-SNAPSHOT-jar-with-dependencies.jar
```

---

## 🐳 Como Executar com Docker

### 1. Construir a imagem:

```bash
docker build -t ice-cream-parlor .
```

### 2. Executar o contêiner:

```bash
docker run -it --name ice-cream-parlor-container ice-cream-parlor
```

> Caso queira remover o contêiner após execução:
```bash
docker rm ice-cream-parlor-container
```

> Para remover a imagem:
```bash
docker rmi ice-cream-parlor
```

---

## ✍️ Autoria

Desenvolvido por **Jefter Lucas Lima da Silva, Jerfeson Gregorio Moreno e Willian de Melo Araujo**  
Instituto Federal da Paraíba — IFPB

---

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).