
<%@ page import="sgd.Projeto" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'projeto.label', default: 'Projeto')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-projeto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/home')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-projeto" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list projeto">
			
				<g:if test="${projetoInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="projeto.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${projetoInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projetoInstance?.meta}">
				<li class="fieldcontain">
					<span id="meta-label" class="property-label"><g:message code="projeto.meta.label" default="Meta" /></span>
					
						<span class="property-value" aria-labelledby="meta-label">
                            <%--<g:fieldValue bean="${projetoInstance}" field="meta"/> --%>
                            <g:formatNumber number="${projetoInstance.meta}"  type="currency" currencyCode="BRL" />
                        </span>
					
				</li>
				</g:if>

                <g:if test="${projetoInstance?.saldo}">
                    <li class="fieldcontain">
                        <span id="saldo-label" class="property-label"><g:message code="projeto.saldo.label" default="Saldo" /></span>

                        <span class="property-value" aria-labelledby="saldo-label">
                            <%--<g:fieldValue bean="${projetoInstance}" field="saldo"/>  --%>
                            <g:formatNumber number="${projetoInstance.saldo}"  type="currency" currencyCode="BRL" />
                        </span>


                    </li>
                </g:if>
			
				<g:if test="${projetoInstance?.situacao}">
				<li class="fieldcontain">
					<span id="situacao-label" class="property-label"><g:message code="projeto.situacao.label" default="Situação (%)" /></span>
					
						<span class="property-value" aria-labelledby="situacao-label">
                            <g:fieldValue bean="${projetoInstance}" field="situacao"/>
                        </span>
					
				</li>
				</g:if>

			
				<g:if test="${projetoInstance?.dataInicio}">
				<li class="fieldcontain">
					<span id="dataInicio-label" class="property-label"><g:message code="projeto.dataInicio.label" default="Data Inicio" /></span>
					
						<span class="property-value" aria-labelledby="dataInicio-label">
                            <g:formatDate date="${projetoInstance?.dataInicio}" format="MM/yyyy"/>
                        </span>
					
				</li>
				</g:if>
			
				<g:if test="${projetoInstance?.dataFim}">
				<li class="fieldcontain">
					<span id="dataFim-label" class="property-label"><g:message code="projeto.dataFim.label" default="Data Fim" /></span>
					
						<span class="property-value" aria-labelledby="dataFim-label">
                            <g:formatDate date="${projetoInstance?.dataFim}" format="MM/yyyy"/>
                        </span>
					
				</li>
				</g:if>
			
				<g:if test="${projetoInstance?.ativo}">
				<li class="fieldcontain">
					<span id="ativo-label" class="property-label"><g:message code="projeto.ativo.label" default="Ativo" /></span>
					
						<span class="property-value" aria-labelledby="ativo-label"><g:formatBoolean boolean="${projetoInstance?.ativo}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${projetoInstance?.id}" />
					<g:link class="edit" action="edit" id="${projetoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
