
<%@ page import="sgd.Campanha" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'campanha.label', default: 'Campanha')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-campanha" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/home')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-campanha" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list campanha">
			
				<g:if test="${campanhaInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="campanha.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${campanhaInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${campanhaInstance?.meta}">
				<li class="fieldcontain">
					<span id="meta-label" class="property-label"><g:message code="campanha.meta.label" default="Meta" /></span>
					
						<span class="property-value" aria-labelledby="meta-label">
                            <%--<g:fieldValue bean="${campanhaInstance}" field="meta"/>--%>
                            <g:formatNumber number="${campanhaInstance.meta}"  type="currency" currencyCode="BRL" />
                        </span>
					
				</li>
				</g:if>

				<g:if test="${campanhaInstance?.saldo}">
				<li class="fieldcontain">
					<span id="saldo-label" class="property-label">
                       <g:message code="campanha.saldo.label" default="Saldo" />
                    </span>
					
						<span class="property-value" aria-labelledby="saldo-label">
                            <%--<g:fieldValue bean="${campanhaInstance}" field="saldo"/>--%>
                            <g:formatNumber number="${campanhaInstance.saldo}"  type="currency" currencyCode="BRL" />
                        </span>
					
				</li>
				</g:if>

                <g:if test="${campanhaInstance?.situacao}">
                    <li class="fieldcontain">
                        <span id="situacao-label" class="property-label"><g:message code="campanha.situacao.label" default="Situação (%)" /></span>

                        <span class="property-value" aria-labelledby="situacao-label">
                            <g:fieldValue bean="${campanhaInstance}" field="situacao"/>
                        </span>

                    </li>
                </g:if>

				<g:if test="${campanhaInstance?.coordenadores}">
				<li class="fieldcontain">
					<span id="coordenadores-label" class="property-label"><g:message code="campanha.coordenadores.label" default="Coordenadores" /></span>
					
						<g:each in="${campanhaInstance.coordenadores}" var="c">
						<span class="property-value" aria-labelledby="coordenadores-label"><g:link controller="semeador" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${campanhaInstance?.dataInicio}">
				<li class="fieldcontain">
					<span id="dataInicio-label" class="property-label"><g:message code="campanha.dataInicio.label" default="Data Inicio" /></span>
					
						<span class="property-value" aria-labelledby="dataInicio-label"><g:formatDate date="${campanhaInstance?.dataInicio}" format="MM/yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${campanhaInstance?.dataFim}">
				<li class="fieldcontain">
					<span id="dataFim-label" class="property-label"><g:message code="campanha.dataFim.label" default="Data Fim" /></span>
					
						<span class="property-value" aria-labelledby="dataFim-label"><g:formatDate date="${campanhaInstance?.dataFim}" format="MM/yyyy"/></span>
					
				</li>
				</g:if>

			
				<g:if test="${campanhaInstance?.projeto}">
				<li class="fieldcontain">
					<span id="projeto-label" class="property-label"><g:message code="campanha.projeto.label" default="Projeto" /></span>
					
						<span class="property-value" aria-labelledby="projeto-label"><g:link controller="projeto" action="show" id="${campanhaInstance?.projeto?.id}">${campanhaInstance?.projeto?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${campanhaInstance?.id}" />
					<g:link class="edit" action="edit" id="${campanhaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
