
<%@ page import="sgd.Campanha" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'campanha.label', default: 'Campanha')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>

        <script type="text/javascript">
        $(document).ready(function() {
          $('#campanhas').dataTable({
                //"sPaginationType": 'full_numbers'
          });
        } );
</script>
	</head>


	<body>
		<a href="#list-campanha" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/home')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-campanha" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>

            <table id="campanhas" class="display">
                <thead>
                <tr>
                    <th>Campanha</th>
                    <th>Meta</th>
                    <th>Saldo</th>
                    <th>Situação</th>
                    <th>Data Início</th>
                    <th>Data Fim</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${Campanha.list()}" var="cam">
                    <tr>
                        <td><g:link action="show" id="${cam.id}">${cam.nome}</g:link></td>
                        <td><g:formatNumber number="${cam.meta}"  type="currency" currencyCode="BRL" /></td>
                        <td><g:formatNumber number="${cam.saldo}"  type="currency" currencyCode="BRL" /></td>
                        <td>${cam.situacao}</td>
                        <td><g:formatDate date="${cam.dataInicio}" format="dd/MM/yyyy"/></td>
                        <td><g:formatDate date="${cam.dataFim}" format="dd/MM/yyyy"/></td>
                    </tr>
                </g:each>
                </tbody>
            </table>
            <%--
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'campanha.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="meta" title="${message(code: 'campanha.meta.label', default: 'Meta')}" />
					
						<g:sortableColumn property="saldo" title="${message(code: 'campanha.saldo.label', default: 'Saldo')}" />

                        <g:sortableColumn property="situacao" title="${message(code: 'campanha.situacao.label', default: 'Situação (%)')}" />
					
						<g:sortableColumn property="dataInicio" title="${message(code: 'campanha.dataInicio.label', default: 'Data Inicio')}" />
					
						<g:sortableColumn property="dataFim" title="${message(code: 'campanha.dataFim.label', default: 'Data Fim')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${campanhaInstanceList}" status="i" var="campanhaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${campanhaInstance.id}">${fieldValue(bean: campanhaInstance, field: "nome")}</g:link></td>

                        <td><g:formatNumber number="${campanhaInstance.meta}"  type="currency" currencyCode="BRL" /></td>

                        <td><g:formatNumber number="${campanhaInstance.saldo}"  type="currency" currencyCode="BRL" /></td>
					
						<td>${fieldValue(bean: campanhaInstance, field: "situacao")}</td>
					
						<td><g:formatDate date="${campanhaInstance.dataInicio}" format="dd/MM/yyyy"/></td>
					
						<td><g:formatDate date="${campanhaInstance.dataFim}" format="dd/MM/yyyy"/></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${campanhaInstanceTotal}" />
			</div>
			--%>
		</div>
	</body>
</html>
