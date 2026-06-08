# 🎓 Sistema de Detecção de Burnout Acadêmico

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-BC4521?style=for-the-badge&logo=lombok&logoColor=white)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge)

> REST API desenvolvida com Java e Spring Boot para monitoramento acadêmico e detecção precoce de risco de burnout em estudantes.

---

## 📋 Sobre o Projeto

A aplicação analisa informações relacionadas à rotina de estudos, desempenho acadêmico e hábitos do aluno para gerar alertas e indicar níveis de risco, permitindo acompanhamento e possíveis intervenções antes que o problema se agrave.

Desenvolvido com foco em **arquitetura em camadas (MVC)**, **POO** e boas práticas de desenvolvimento com Spring Boot.

---

## ✅ Funcionalidades

- Cadastro de alunos e professores
- Registro de desempenho acadêmico
- Registro de rotina de estudos
- Listagem e busca de registros
- Atualização e remoção de registros
- Análise de risco de burnout

---

## 🏗️ Arquitetura

```
src/
├── controller/   → Endpoints da API
├── service/      → Regras de negócio
├── repository/   → Gerenciamento de dados
└── model/        → Entidades do sistema
```

---

## 🚀 Como Rodar

```bash
# Clone o repositório
git clone https://github.com/EdsonEmanuelReis/sistema-burnout-academico.git

# Abra no IntelliJ IDEA e rode a classe ApplicationStart
# A API estará disponível em:
http://localhost:8081
```

---

## 🔮 Planejamento Futuro

| Área | Funcionalidades |
|------|----------------|
| 🗄️ Banco de Dados | Integração MySQL, persistência, relacionamentos |
| 🤖 Inteligência Artificial | Análise de padrões, modelos preditivos, sugestões personalizadas |
| 🔐 Segurança | Login, autenticação, perfis de acesso, controle de permissões |
| 📡 API | Validações, exceções globais, Swagger/OpenAPI, testes automatizados |
| 📊 Relatórios | Dashboard, gráficos de evolução, exportação de relatórios |

---

## 🎯 Objetivo Científico

A proposta futura é transformar o sistema em uma ferramenta de apoio a pesquisas sobre saúde mental estudantil, explorando a relação entre hábitos de estudo, desempenho acadêmico e indicadores de esgotamento emocional — sempre respeitando a privacidade dos usuários.

---

## 👨‍💻 Autor

Feito por **Edson Emanuel Reis** • [GitHub](https://github.com/EdsonEmanuelReis)

---

> ⚠️ Projeto em fase de aprendizado e desenvolvimento contínuo. Novas funcionalidades e melhorias serão adicionadas ao longo do tempo.
