
<%@ page import="sgd.Projeto" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'projeto.label', default: 'Projeto')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-projeto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/home')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-projeto" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'projeto.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="meta" title="${message(code: 'projeto.meta.label', default: 'Meta')}" />
					
						<g:sortableColumn property="saldo" title="${message(code: 'projeto.saldo.label', default: 'Saldo')}" />

                        <g:sortableColumn property="situacao" title="${message(code: 'projeto.situacao.label', default: 'Situação (%)')}" />
					
						<g:sortableColumn property="dataInicio" title="${message(code: 'projeto.dataInicio.label', default: 'Data Inicio')}" />
					
						<g:sortableColumn property="dataFim" title="${message(code: 'projeto.dataFim.label', default: 'Data Fim')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${projetoInstanceList}" status="i" var="projetoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${projetoInstance.id}">${fieldValue(bean: projetoInstance, field: "nome")}</g:link></td>

                        <td><g:formatNumber number="${projetoInstance.meta}"  type="currency" currencyCode="BRL" /></td>

                        <td><g:formatNumber number="${projetoInstance.saldo}"  type="currency" currencyCode="BRL" /></td>
					
						<td>${fieldValue(bean: projetoInstance, field: "situacao")}</td>
					
						<td><g:formatDate date="${projetoInstance.dataInicio}" format="MM/yyyy"/></td>
					
						<td><g:formatDate date="${projetoInstance.dataFim}" format="MM/yyyy"/></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${projetoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
