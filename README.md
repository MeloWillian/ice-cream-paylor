
# 🍨 Ice Cream Parlor

## 🎯 Objetivo do Projeto

Criar um sistema de pedidos para uma sorveteria, permitindo:

- Gerenciar sabores.
- Personalizar pedidos.
- Aplicar diferentes tipos de descontos.
- Acompanhar atualizações do status dos pedidos.
- Otimizar o fluxo de atendimento e operação.

---

## 🏛️ Arquitetura e Padrões de Projeto

O projeto foi desenvolvido aplicando os seguintes padrões de projeto:

| Padrão    | Aplicação                                                                                         |
|------------|---------------------------------------------------------------------------------------------------|
| **Factory** | Criação de objetos de diferentes tipos de sorvetes (Picolé, Massa, Milkshake).                   |
| **Singleton** | Gerenciamento único da fila de pedidos.                                                         |
| **Strategy** | Aplicação de diferentes estratégias de desconto (nenhum, percentual, clientes frequentes, etc). |
| **Decorator** | Personalização dos sorvetes com adicionais (calda, cobertura, chantilly, etc.).                |
| **Observer** | Notificações automáticas sobre o status dos pedidos.                                             |
| **Command** | Encapsulamento de ações dos pedidos, permitindo desfazer ou refazer (cancelar/refazer pedido).  |
| **State** | Controle dos estados dos pedidos (Recebido, Preparando, Pronto, Entregue).                        |
| **Facade** | Interface simplificada para gerenciar pedidos e pagamentos.                                        |
| **Repository** | Camada de persistência para salvar pedidos e histórico de clientes.                           |

---

## 🗂️ Estrutura de Pastas

```plaintext
src/
└── main/
    └── java/
        └── br.edu.ifpb.ice_cream_parlor/
            ├── cli/           
            ├── exceptions/    
            ├── model/         
            │   ├── entities/  
            │   ├── repository/
            │   └── service/   
            ├── patterns/      
            │   ├── command/
            │   ├── decorator/
            │   ├── facade/
            │   ├── factory/
            │   ├── observer/
            │   ├── singleton/
            │   ├── state/
            │   └── strategy/
            └── Main.java       
resources/
test/
```

---

## 🏗️ Etapas de Desenvolvimento

# 🍨 Sistema de Pedidos para Sorveteria

## 🎯 Objetivo do Projeto

Este projeto tem como objetivo desenvolver um sistema de pedidos para uma sorveteria. O sistema permite gerenciar sabores, criar e personalizar pedidos, aplicar diferentes tipos de desconto, acompanhar o status dos pedidos em tempo real e otimizar o fluxo operacional da sorveteria.

O desenvolvimento foi orientado à aplicação de diversos **padrões de projeto**, proporcionando uma arquitetura robusta, escalável e de fácil manutenção.

---

## 🗺️ Visão Geral das Fases de Desenvolvimento

O desenvolvimento do sistema foi dividido em fases bem definidas. Cada fase tem um propósito específico e contribui diretamente para a evolução estrutural e funcional do projeto.

---

## 🔧 Fase 0 — Configuração Inicial do Projeto

### ✔️ Contextualização
Nesta fase, realizamos toda a configuração do ambiente de desenvolvimento. Isso inclui a definição da estrutura de pastas, a configuração de ferramentas de automação de build (Maven), além da organização inicial dos pacotes e dependências.

### ✔️ Objetivo
- Organizar o projeto de forma modular.
- Preparar o ambiente para desenvolvimento ágil e escalável.

---

## 🍦 Fase 1 — Modelagem dos Produtos (Factory)

### ✔️ Contextualização
O produto principal da sorveteria são os diferentes tipos de sorvete. Nesta fase, foram definidos os modelos dos produtos, suas características e uma fábrica capaz de gerar instâncias desses produtos.

### ✔️ Objetivo
- Criar um catálogo de produtos (sorvetes).
- Centralizar a criação dos diferentes tipos de sorvetes usando o padrão **Factory**, facilitando sua manutenção e extensão.

---

## 🧾 Fase 2 — Pedido e Fila de Pedidos (Singleton)

### ✔️ Contextualização
Após definir os produtos, foi necessário estruturar o conceito de **Pedido**, que representa a compra feita por um cliente. Além disso, foi criada uma **Fila de Pedidos**, que garante o controle sequencial dos pedidos realizados.

### ✔️ Objetivo
- Modelar pedidos compostos por diferentes itens (sorvetes).
- Criar uma fila única, utilizando o padrão **Singleton**, que controla e organiza os pedidos em andamento.

---

## 🎯 Fase 3 — Aplicação de Descontos (Strategy)

### ✔️ Contextualização
O sistema permite aplicar diferentes regras de desconto, de acordo com a estratégia desejada. Isso inclui descontos fixos, sazonais, ou benefícios para clientes frequentes.

### ✔️ Objetivo
- Tornar o cálculo de descontos flexível e expansível, aplicando o padrão **Strategy**.
- Permitir que cada pedido utilize uma estratégia de desconto adequada.

---

## 🧪 Fase 4 — Primeira Simulação do Sistema

### ✔️ Contextualização
Com os produtos, pedidos, fila e descontos funcionando, realizamos a primeira simulação do sistema. Essa etapa foi essencial para validar o funcionamento básico dos fluxos principais.

### ✔️ Objetivo
- Realizar testes manuais simulando a criação de pedidos, aplicação de descontos e movimentação na fila de pedidos.

---

## 🍫 Fase 5 — Personalização dos Sorvetes (Decorator)

### ✔️ Contextualização
Para oferecer mais opções aos clientes, o sistema permite adicionar personalizações aos sorvetes, como cobertura, calda e chantilly.

### ✔️ Objetivo
- Implementar personalizações de forma dinâmica, sem alterar a estrutura principal dos objetos, utilizando o padrão **Decorator**.

---

## 🔄 Fase 6 — Gerenciamento de Estados do Pedido (State)

### ✔️ Contextualização
Cada pedido possui um ciclo de vida com diferentes estados, como **Recebido**, **Preparando**, **Pronto** e **Entregue**. Esta fase formaliza esses estados e suas transições.

### ✔️ Objetivo
- Gerenciar corretamente o progresso dos pedidos.
- Modelar o comportamento dos pedidos com base no seu estado atual, aplicando o padrão **State**.

---

## 🔔 Fase 7 — Notificações e Observação (Observer)

### ✔️ Contextualização
Para manter os clientes informados, foi implementado um sistema de notificações. Sempre que um pedido muda de estado, os observadores cadastrados são notificados automaticamente.

### ✔️ Objetivo
- Implementar uma comunicação eficiente sobre o status dos pedidos.
- Aplicar o padrão **Observer**, permitindo que múltiplos observadores (como clientes ou operadores) recebam atualizações em tempo real.

---

## 🧠 Fase 8 — Comandos e Controle de Ações (Command)

### ✔️ Contextualização
O sistema permite encapsular ações como **fazer**, **cancelar** ou **refazer um pedido**, possibilitando uma maior flexibilidade no controle das operações.

### ✔️ Objetivo
- Implementar comandos que encapsulam ações.
- Permitir que certas ações possam ser desfeitas ou refeitas, seguindo o padrão **Command**.

---

## 🏛️ Fase 9 — Facade (Interface Simplificada)

### ✔️ Contextualização
Com vários subsistemas funcionando, foi necessária uma interface de acesso centralizada e simplificada para interagir com o sistema, tanto para o cliente quanto para os atendentes.

### ✔️ Objetivo
- Reduzir a complexidade de uso do sistema.
- Fornecer uma API simples e direta por meio do padrão **Facade**.

---

## 💾 Fase 10 — Persistência e Histórico (Repository)

### ✔️ Contextualização
Nesta etapa, foi criada uma camada de persistência que armazena dados como pedidos e informações dos clientes. Isso garante que o histórico de compras e o controle de dados sejam mantidos mesmo após reiniciar o sistema.

### ✔️ Objetivo
- Separar a lógica de acesso a dados da lógica de negócios.
- Implementar o padrão **Repository** para facilitar o armazenamento e recuperação de informações.

---

## 🚀 Tecnologias Utilizadas

- Java (versão 17 ou superior)
- Maven (gerenciamento de dependências)
- JUnit (testes automatizados)

---

## 🏗️ Arquitetura Base

O projeto foi estruturado seguindo princípios da programação orientada a objetos e dos padrões de projeto, resultando em uma arquitetura modular, limpa e escalável.

---

## 🏃‍♂️ Execução do Projeto

1. Configure o ambiente Java e Maven.
2. Compile o projeto.
3. Execute a classe principal para simular pedidos e interações.

---

## ✍️ Autoria

Desenvolvido por **[Seu Nome]**  
Instituto Federal da Paraíba — IFPB

---

## 📜 Licença

Este projeto está sob licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais informações.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Maven
- JUnit (para testes)
- IDE: IntelliJ, Eclipse ou VSCode

---

## 🏃‍♂️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/ice-cream-parlor.git
```

2. Acesse o projeto:
```bash
cd ice-cream-parlor
```

3. Compile o projeto:
```bash
mvn clean install
```

4. Execute:
```bash
mvn exec:java -Dexec.mainClass="br.edu.ifpb.ice_cream_parlor.Main"
```

---

## 🛠️ Funcionalidades

- ✅ Criação de sorvetes com diferentes tipos.
- ✅ Sistema de pedidos com múltiplos itens.
- ✅ Aplicação de diferentes tipos de desconto.
- ✅ Personalização dos pedidos.
- ✅ Gerenciamento do fluxo de pedidos por estado.
- ✅ Notificações automáticas sobre status do pedido.
- ✅ Comandos para desfazer/refazer ações.
- ✅ Interface simplificada via Facade.
- ✅ Persistência simulada dos dados.

---

## ✍️ Autoria

Desenvolvido por **[Seu Nome]**  
Instituto Federal da Paraíba — IFPB

---

## 📜 Licença

Este projeto está sob licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais informações.
