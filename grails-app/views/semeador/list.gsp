
<%@ page import="sgd.Semeador" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'semeador.label', default: 'Semeador')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>

        <script type="text/javascript">
        $(document).ready(function() {
          $('#semeadores').dataTable({
                //"sPaginationType": 'full_numbers'
          });
        } );
</script>

	</head>
	<body>
		<a href="#list-semeador" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/home')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-semeador" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>

             <table id="semeadores" class="display">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome Completo</th>
                    <th>Cpf</th>
                    <th>Congregação</th>
                    <th>Data Cadastro</th>
                </tr>
            </thead>
            <tbody>
            <g:each in="${Semeador.list()}" var="s">
                <tr>
                    <td><g:link action="show" id="${s.id}">${s.codigo}</g:link></td>
                    <td>${s.nomeCompleto}</td>
                    <td>${s.cpf}</td>
                    <td>${s.congregacao}</td>
                    <td><g:formatDate date="${s.dataCadastro}" format="dd/MM/yyyy"/></td>
                </tr>
            </g:each>
            </tbody>
        </table>

            <%--
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nomeCompleto" title="${message(code: 'semeador.nomeCompleto.label', default: 'Nome')}" />
					
						<g:sortableColumn property="cpf" title="${message(code: 'semeador.cpf.label', default: 'Cpf')}" />
					
						<g:sortableColumn property="profissao" title="${message(code: 'semeador.congregacao.label', default: 'Congregação')}" />
					
						<g:sortableColumn property="dataCadastro" title="${message(code: 'semeador.dataCadastro.label', default: 'Data Cadastro')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${semeadorInstanceList}" status="i" var="semeadorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${semeadorInstance.id}" style="text-transform: uppercase">${fieldValue(bean: semeadorInstance, field: "nomeCompleto")}</g:link></td>
					
						<td>${fieldValue(bean: semeadorInstance, field: "cpf")}</td>
					
						<td>${fieldValue(bean: semeadorInstance, field: "congregacao")}</td>
					
						<td><g:formatDate date="${semeadorInstance.dataCadastro}" format="dd/MM/yyyy"/></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${semeadorInstanceTotal}" />
			</div>
			--%>
		</div>
	</body>
</html>
