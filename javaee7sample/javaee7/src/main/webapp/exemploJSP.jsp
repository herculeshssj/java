<!--
  
  	Copyright (c) 2016 Hércules S. S. José

    Este arquivo é parte do programa Java EE 7 Sample.
    

    Java EE 7 Sample é um software livre; você pode redistribui-lo e/ou 

    modificá-lo dentro dos termos da Licença Pública Geral Menor GNU como 

    publicada pela Fundação do Software Livre (FSF); na versão 2.1 da 

    Licença.
    

    Este programa é distribuído na esperança que possa ser útil, 

    mas SEM NENHUMA GARANTIA; sem uma garantia implícita de ADEQUAÇÂO a 
    
    qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública 
    
    Geral Menor GNU em português para maiores detalhes.
    

    Você deve ter recebido uma cópia da Licença Pública Geral Menor GNU sob o 

    nome de "LICENSE.TXT" junto com este programa, se não, acesse o site do
    
    projeto no endereco https://github.com/herculeshssj/javaee7sample ou escreva 
    
    para a Fundação do Software Livre(FSF) Inc., 51 Franklin St, Fifth Floor, 
    
    Boston, MA  02110-1301, USA.
    

    Para mais informações sobre o programa Orçamento Doméstico e seu autor entre  

    em contato pelo e-mail herculeshssj@outlook.com, ou ainda escreva para 

    Hércules S. S. José, Av. Ministro Lafaeyte de Andrade, 1683 - Bl. 3 Apt 404, 

    Marco II - Nova Iguaçu, RJ, Brasil.

 -->

<jsp:useBean id="teste" class="br.com.hslife.javaee7.servletjsp.ExemploJSP" scope="page"/>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exemplo JSP</title>
</head>
<body>
<% 

	out.println(teste.mensagem());
	
%>

<br/><br/>

<form action="${pageContext.request.contextPath}/ExemploServlet" method="get">

Entre com seu nome:
<input type="text" id="nomeGET" name="nomeGET"/>

<input type="submit" value="Enviar via GET">

</form>

<br/><br/>

<form action="${pageContext.request.contextPath}/ExemploServlet" method="post">

Entre com seu nome:
<input type="text" id="nomePOST" name="nomePOST"/>

<input type="submit" value="Enviar via POST">

</form>

<a href="${pageContext.request.contextPath}/faces/index.jsf">Exemplo de JSF</a>
<br/><br/>
<a href="${pageContext.request.contextPath}/faces/indexCDI.jsf">Exemplo de JSF com CDI</a>
<br/><br/>
<a href="${pageContext.request.contextPath}/faces/indexEJBCDI.jsf">Exemplo de JSF com EJB e CDI</a>

</body>
</html>