Java EE 7 Sample
================

#### Aplicação exemplo para testar os recursos disponíveis no Java EE 7.

Tutorial Java EE 7 - Oracle: https://docs.oracle.com/javaee/7/tutorial/index.html

**Exemplos:** http://crunchify.com/create-very-simple-jersey-rest-service-and-send-json-data-from-java-client/

## Configuração do projeto

Instalação das ferramentas
==========================

O projeto de exemplo trabalha usando as seguintes tecnologias e ferramentas:

- [Java SE 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html "Java SE 8");
- [Eclipse Mars](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars1 "Eclipse Mars")
- [MySQL Community](https://dev.mysql.com/downloads/mysql/ "MySQL Community");
- [Apache TomEE](http://tomee.apache.org/downloads.html "Apache TomEE")

### Instalação do Java 8

Basicamente a instalação para ambiente Windows e Mac se resume a baixar o pacote .exe e .dmg, respectivamente. Ambos possuem assistente de instalação.

Para Linux, mas especificamente Ubuntu 12.04 em diante, usa-se os pacotes disponíveis no repositório do PPA. Abaixo segue o comando de instalação via terminal.

```
sudo add-apt-repository ppa:webupd8team/java && sudo apt-get update sudo apt-get install oracle-java8-installer
```

### Instalação do Eclipse Mars

A instalação do Eclipse Mars é tranquila para os ambientes Windows, Linux e Mac. Basta descompactar o arquivo .zip ou .tar.gz. No diretório **eclipse**, basta executar o arquivo **eclipse**.

### Instalação do MySQL Community

A instalação do MySQL no Windows é facilitada usando o pacote de instalação MSI, onde é aberto um assistente de instalação para selecionar os componentes e as configurações necessárias após a instalação.

O pacote DMG do MySQL possui as configurações padrão para a instalação, portanto não tem dificuldades. A senha do usuário **root** é definida em branco após a instalação. A inicialização do MySQL pode ser feita pelo System Preferences através de painel próprio.

A instalação do MySQL no Ubuntu Linux podem ser feita pelo terminal através do seguinte comando:

```
sudo apt-get install mysql-server mysql-workbench
```

Durante a instalação tem a opção de definir a senha do usuário **root** do MySQL.

### Apache TomEE

A instalação do TomEE é semelhante ao do Eclipse Mars. Basta baixar o pacote .zip ou .tar.gz. 

No Eclipse abra a view Server, botão direito em uma área vazia e selecione New -> Server.

Na tela seguinte, selecione a opção Apache -> Tomcat 7.0. Clique em Next. Na próxima tela, clique no botão Browse e selecione a pasta do TomEE e clique em Finnish.

Criação do projeto
==================

O projeto foi criado usando o Maven. Foi selecionado um novo projeto Maven Project onde foi usado o archetype org.apache.maven.archetypes.maven-archetype-webapp. Este archetype permite criar um projeto com o facelet do Dynamic Web Project.

Para a execução do projeto, clique com botão direito no projeto, selecione Run As -> Maven Build. Na primeira vez que se executa o projeto, aparece a tela de configurações de execução. No item Goal, escreva **clean install** e depois clique no botão Run. Não havendo nenhum problema com as classes, o build será bem sucedido. Nas próximas execuções o Run As -> Maven Build não pede novas configurações.

Após o build pelo Maven, execute o servidor TomEE e acesse a URL do projeto (http://localhost:8080/javaee7).

Base de dados
=============

Antes de iniciar a configuração do projeto, deve-se criar a base de dados de testes. O usuário utilizado nos testes é **root**. Use os seguintes comandos no MySQL.

```
create database javaee7;
use javaee7;
create table pessoa(
	id bigint not null auto_increment,
	nome varchar(50) not null,
	idade int not null,
	dataNascimento datetime not null,
	primary key(id)
);
```

Estrutura do projeto
====================

Foram definidos quatro diretórios Java Resources a saber:

**src/main/java** - diretório onde abriga as classes principais do projeto.
**src/main/resources** - diretório onde ficam arquivos de configuração do projeto, como o persistence.xml.
**src/test/java** - diretório onde abriga as classes de testes do projeto.
**src/test/resousrces** - diretório onde ficam arquivos de configuração usados pelo ambiente de teste.

As páginas JSP ficam no diretório comum **src/main/webapp**.

As páginas JSF ficam no diretório faces/. Atualmente o projeto resolve todas as páginas XHTML com Facelets através da URL *.jsf

No diretório **WEB-INF** existem três arquivos de configuração a saber:

_beans.xml_ - arquivo de configuração que ativa os recursos do CDI para injeção de dependência.
_faces-config.xml_ - arquivo de configuração para abrigar parâmetros adicionais do Java Server Faces.
_web.xml_ - arquivos principal de configuração de aplicações Java Web.

No diretório **src/main/resources** fica a pasta META-INF. Esta pasta é necessária para abrigar os arquivos de configuração a saber:

_resources.xml_ - configuração do datasource para acesso a base.
_persistence.xml_ - arquivo de configuração do JPA.

**Obs**: É necessário aguardar o lançamento do TomEE 7 com suporte ao JavaEE 7, assim poder habilitar os recursos do Hibernate 4.3.x e 5.x, e do JPA 2.1.

### Consumo de WebService

https://xanadu1010.wordpress.com/2013/11/16/consumir-webservices-soap-com-requisicoes-xml/
http://www.javaeenacaixa.com/2015/03/criando-um-cliente-java-para-web.html
http://www.devmedia.com.br/wsdl-simplifique-a-integracao-de-dados-via-web-service/30066
http://www.javatips.net/blog/2013/11/consume-simple-jax-ws-web-service-using-eclipse
https://dzone.com/articles/step-step-web-service-guide
http://memorynotfound.com/jax-ws-soap-web-service-example/
http://vhost3.cs.rit.edu/project_web_page/documentations/Consuming%20a%20Service%20In%20Java.pdf
http://wehavescience.com/2013/03/16/criando-e-consumindo-um-webservice-utilizando-java-7-e-axis/