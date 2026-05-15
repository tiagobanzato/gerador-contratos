# 📄 Gerador de Contratos com IA

Sistema web completo que gera contratos profissionais automaticamente usando Inteligência Artificial. O usuário preenche um formulário com os dados do contrato e a IA gera um documento formal completo em segundos.

---

## 🚀 Tecnologias Utilizadas

### Frontend
![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![Vite](https://img.shields.io/badge/Vite-646CFF?style=for-the-badge&logo=vite&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)

### Backend
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

### Inteligência Artificial
![Groq](https://img.shields.io/badge/Groq-F55036?style=for-the-badge&logo=groq&logoColor=white)

---

## 🗂️ Estrutura do Projeto

```
gerador-contratos/
├── frontend/          # Interface React + Vite
│   ├── src/
│   │   ├── App.jsx    # Componente principal com formulário
│   │   └── App.css    # Estilos da aplicação
│   └── package.json
└── backend/           # API Java Spring Boot
    ├── src/main/java/com/banzato/gerador_contratos_api/
    │   ├── controller/
    │   │   └── ContratoController.java   # Endpoint REST
    │   ├── service/
    │   │   └── ContratoService.java      # Lógica de negócio + Groq
    │   └── CorsConfig.java               # Configuração CORS
    └── pom.xml
```

---

## ⚙️ Como Funciona

```
Usuário preenche o formulário
        ↓
React (porta 5173) envia os dados via POST
        ↓
Java Spring Boot (porta 8080) recebe e monta o prompt
        ↓
Groq API (LLaMA 3.3 70B) gera o contrato completo
        ↓
Contrato exibido na tela em tempo real
```

---

## 📋 Tipos de Contrato Suportados

- Prestação de Serviço
- Aluguel
- Compra e Venda
- Parceria Comercial

---

## 🛠️ Como Rodar o Projeto

### Pré-requisitos
- Java 17+
- Node.js 18+
- Chave de API do [Groq](https://console.groq.com)

### Backend
```bash
cd backend
# Configure sua chave no application.properties
# groq.api.key=SUA_CHAVE_AQUI
./mvnw spring-boot:run
```

### Frontend
```bash
cd frontend
npm install
npm run dev
```

Acesse **http://localhost:5173** no navegador.

---

## 👨‍💻 Autor

**Tiago Banzato**  
Estudante de Análise e Desenvolvimento de Sistemas  
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/tiagobanzato)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/tiagobanzato)
