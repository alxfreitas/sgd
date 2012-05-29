
<%@ page import="sgd.Doacao" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'doacao.label', default: 'Doacao')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>

        <script type="text/javascript">
        $(document).ready(function() {
          $('#doacoes').dataTable({
                //"sPaginationType": 'full_numbers'

          });
        } );
</script>
	</head>
	<body>
		<a href="#list-doacao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/home')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-doacao" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>

             <table id="doacoes" class="display">
            <thead>
                <tr>
                    <th>Valor</th>
                    <th>Data Lançamento</th>
                    <th>Semeador</th>
                    <th>Congregação</th>
                    <th>Lançada por</th>
                    <th>Forma Doação</th>
                    <th>Campanha</th>
                </tr>
            </thead>
            <tbody>
            <g:each in="${Doacao.list()}" var="d" >
               <tr >
                    <td><g:link action="show" id="${d.id}"><g:formatNumber number="${d.valor}"  type="currency" currencyCode="BRL" /></g:link></td>
                    <td><g:formatDate date="${d.dataLancamento}" format="dd/MM/yyyy"/></td>
                    <td>${d.semeador}</td>
                    <td>${d.congregacao}</td>
                    <td>${d.usuario}</td>
                    <td>${d.formaDoacao}</td>
                    <td>${d.campanha}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
<%--
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="valor" title="${message(code: 'doacao.valor.label', default: 'Valor')}" />
					
						<g:sortableColumn property="dataLancamento" title="${message(code: 'doacao.dataLancamento.label', default: 'Data Lancamento')}" />
					
						<th><g:message code="doacao.semeador.label" default="Semeador" /></th>
					
						<th><g:message code="doacao.usuario.label" default="Lançada por" /></th>

                        <th><g:message code="doacao.congregacao.label" default="Congregação" /></th>
					
						<g:sortableColumn property="formaDoacao" title="${message(code: 'doacao.formaDoacao.label', default: 'Forma Doação')}" />
					
						<th><g:message code="doacao.campanha.label" default="Campanha" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${doacaoInstanceList}" status="i" var="doacaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${doacaoInstance.id}">
                            <%--${fieldValue(bean: doacaoInstance, field: "valor")}
                        <g:formatNumber number="${doacaoInstance.valor}"  type="currency" currencyCode="BRL" />
                        </g:link></td>
					
						<td><g:formatDate date="${doacaoInstance.dataLancamento}" format="dd/MM/yyyy"/></td>
					
						<td>${fieldValue(bean: doacaoInstance, field: "semeador")}</td>
					
						<td>${fieldValue(bean: doacaoInstance, field: "usuario")}</td>

                        <td>${fieldValue(bean: doacaoInstance, field: "congregacao")}</td>
					
						<td>${fieldValue(bean: doacaoInstance, field: "formaDoacao")}</td>
					
						<td>${fieldValue(bean: doacaoInstance, field: "campanha")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${doacaoInstanceTotal}" />
			</div>
            --%>
		</div>
	</body>
</html>
