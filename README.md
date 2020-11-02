## Trabalho final para disciplina INTEGRATIONS &amp; DEVELOPMENT TOOLS

### 1. Descrição

Nesta solução foi construída a estrutura de backend de um sistema, exposta
através de três microsserviços, cada qual com sua responsabilidade. Estes
microsserviços se integram à uma estrutura de filas usando RabbitMQ e a um
servidor de email SMTP, ambos na nuvem. Também foi construído um front-end
em HTML, emulando os envios dos drones e emulando um dashboard de
acompanhamento dos drones. Os três microsserviços possuem arquivos de
configuração com os parâmetros de configuração do RabbitMQ e do servidor
SMTP.

### 2. Detalhes

  #### a. Estrutura da Aplicação
  
  ![estrutura_trabalho_final](https://user-images.githubusercontent.com/67294168/97927097-1c50be00-1d43-11eb-910b-025192cab36e.png)

  
  #### b. Microsserviços da aplicação, como configurar e executar.
     a. DronesSensores-master → Microsserviço responsável por gerenciar a recepção das medições dos drones e inclusão das mesmas no gerenciador de filas

        Arquivo de configuração (diretório /resources): application.properties -> Neste arquivo devem ser configurados os parâmetros e credenciais do RabbitMQ, além da porta do servidor que deve ser única (ex.: 8080)
        Arquivo que inicia a aplicação Spring: DroneSensoresApplication.java (método main com a Spring Boot App)

     b. fiap-integration-microservice → Microsserviço responsável por gerenciar a recepção e tratativa das medição da fila dos drone, verificação da regra de negócio e envio de solicitações de envio de email para o gerenciador de filas

        Arquivo de configuração (diretório /resources): application.yml -> Neste arquivo devem ser configurados os parâmetros  e credenciais do SGDB H2 e os parâmetros do RabbitMQ.
        Arquivo que inicia a aplicação Spring: FiapIntegrationMicroserviceApplication.java (método main com a Spring Boot App)
        
     c. RabbitMQSpringConsumerAndMailSender-main → Microsserviço responsável por escutar a fila de solicitação de envio de email, abrir uma conexão com o SMTP e enviar um email de alerta

        Arquivo de configuração (diretório /resources): application.properties - -> Neste arquivo devem ser configurados os parâmetros e credenciais do RabbitMQ e do servidor SMTP escolhido.
        Arquivo que inicia a aplicação Spring: EmailAmqpConsumerApp.java  (método main com a Spring Boot App)
        
     d. DronePainelIntegration → Solução de front-end em Angular que invoca os microsserviços via invocações POST e padrão RESTful
     
        Observação importante: Por se tratar de uma aplicação Angular, deve-se ter o ambiente angular configurado na máquina e rodar os comandos npm install para instalar todos os componentes e dependencias, e para rodar a aplicação, rodar o npm run.
        Arquivo de configuração para configuração dos endpoints: proxy.config.js 
            Devem ser configurados dois endpoints: 
            
            {
              context: "/uri",
              target: "http://<aplicacao angular>:<porta configurada angular>/drone-app",
              pathRewrite: { "^/uri": "" },
            },
            {
              context: "/med",
              target: "http://<aplicacao angular>:<porta configurada angular>/api/v1",
              pathRewrite: { "^/med": "" },
            }
        
        URLs da aplicação Angular: 
          http://<servidor angular>:4200/monitoramento - Aplicação que consulta os drones sendo rastreados e os exibe no mapa do Google Maps
          http://<servidor angular>:4200/drone         - Aplicação que consulta e cadastra novos drones para serem rastreados
        
### 3. RabbitMQ

      a. Exchange
         Deve ser criado em um servidor RabbitMQ (em núvem em cloudamqp.com). Nome do Exchange invocado : exchange-drone-app
      
      b. Filas
         Devem serc criadas no mesmo servidor RabbitMQ (em núvem em cloudamqp.com). 
              Nome das filas: drone-queue e mail-queue
      
      c. Bindings
         Devem ser criados no mesmo servidor RabbitMQ entre as filas e o Exchange.
         Nome dos Bindings e filas respectivas: 
            1. Fila: drone-queue - Routing Key: drone_data
            2. Fila:  mail-queue - Routing Key: business_mail

### 4. Video com a execução da aplicação

      https://www.loom.com/share/886150c5a4f64a8ab8414c8733e0dcda?from_recorder=1
      Senha para acesso ao vídeo: fiapDev
      
### 5. Descrição detalhada do trabalho

      [Trabalho Final - Integrations and Dev Tools.pdf](https://github.com/AyrtonHenrique/fiap-integration-temperatura/files/5478521/Trabalho.Final.-.Integrations.and.Dev.Tools.pdf)
      
      
