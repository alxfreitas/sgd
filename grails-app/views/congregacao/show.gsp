
<%@ page import="sgd.Congregacao" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'congregacao.label', default: 'Congregacao')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-congregacao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/home')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-congregacao" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list congregacao">
			
				<g:if test="${congregacaoInstance?.congregacao}">
				<li class="fieldcontain">
					<span id="congregacao-label" class="property-label"><g:message code="congregacao.congregacao.label" default="Congregacao" /></span>
					
						<span class="property-value" aria-labelledby="congregacao-label"><g:fieldValue bean="${congregacaoInstance}" field="congregacao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${congregacaoInstance?.igreja}">
				<li class="fieldcontain">
					<span id="igreja-label" class="property-label"><g:message code="congregacao.igreja.label" default="Igreja" /></span>
					
						<span class="property-value" aria-labelledby="igreja-label"><g:link controller="igreja" action="show" id="${congregacaoInstance?.igreja?.id}">${congregacaoInstance?.igreja?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${congregacaoInstance?.tipo}">
				<li class="fieldcontain">
					<span id="tipo-label" class="property-label"><g:message code="congregacao.tipo.label" default="Tipo" /></span>
					
						<span class="property-value" aria-labelledby="tipo-label"><g:fieldValue bean="${congregacaoInstance}" field="tipo"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${congregacaoInstance?.id}" />
					<g:link class="edit" action="edit" id="${congregacaoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
