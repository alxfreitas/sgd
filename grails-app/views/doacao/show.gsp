
<%@ page import="sgd.Doacao" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'doacao.label', default: 'Doacao')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-doacao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/home')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-doacao" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list doacao">
			
				<g:if test="${doacaoInstance?.valor}">
				<li class="fieldcontain">
					<span id="valor-label" class="property-label"><g:message code="doacao.valor.label" default="Valor" /></span>
					
						<span class="property-value" aria-labelledby="valor-label">
                            <%--<g:fieldValue bean="${doacaoInstance}" field="valor"/>  --%>
                            <g:formatNumber number="${doacaoInstance.valor}"  type="currency" currencyCode="BRL" />
                        </span>
					
				</li>
				</g:if>
			
				<g:if test="${doacaoInstance?.dataLancamento}">
				<li class="fieldcontain">
					<span id="dataLancamento-label" class="property-label"><g:message code="doacao.dataLancamento.label" default="Data Lancamento" /></span>
					
						<span class="property-value" aria-labelledby="dataLancamento-label"><g:formatDate date="${doacaoInstance?.dataLancamento}" format="dd/MM/yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${doacaoInstance?.semeador}">
				<li class="fieldcontain">
					<span id="semeador-label" class="property-label"><g:message code="doacao.semeador.label" default="Semeador" /></span>
					
						<span class="property-value" aria-labelledby="semeador-label"><g:link controller="semeador" action="show" id="${doacaoInstance?.semeador?.id}">${doacaoInstance?.semeador?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${doacaoInstance?.usuario}">
				<li class="fieldcontain">
					<span id="usuario-label" class="property-label"><g:message code="doacao.usuario.label" default="Lançada por" /></span>
					
						<span class="property-value" aria-labelledby="usuario-label"><g:link controller="usuario" action="show" id="${doacaoInstance?.usuario?.id}">${doacaoInstance?.usuario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${doacaoInstance?.formaDoacao}">
				<li class="fieldcontain">
					<span id="formaDoacao-label" class="property-label"><g:message code="doacao.formaDoacao.label" default="Forma Doacao" /></span>
					
						<span class="property-value" aria-labelledby="formaDoacao-label"><g:fieldValue bean="${doacaoInstance}" field="formaDoacao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${doacaoInstance?.campanha}">
				<li class="fieldcontain">
					<span id="campanha-label" class="property-label"><g:message code="doacao.campanha.label" default="Campanha" /></span>
					
						<span class="property-value" aria-labelledby="campanha-label"><g:link controller="campanha" action="show" id="${doacaoInstance?.campanha?.id}">${doacaoInstance?.campanha?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${doacaoInstance?.id}" />
                    <%--<g:link class="edit" action="edit" id="${doacaoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                         <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />--%>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
