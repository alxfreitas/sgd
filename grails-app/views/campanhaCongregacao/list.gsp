
<%@ page import="sgd.CampanhaCongregacao" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'campanhaCongregacao.label', default: 'CampanhaCongregacao')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>

        <script type="text/javascript">
        $(document).ready(function() {
          $('#campCon').dataTable({
                //"sPaginationType": 'full_numbers'
          });
        } );
</script>
	</head>
	<body>
		<a href="#list-campanhaCongregacao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/home')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-campanhaCongregacao" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>

            <table id="campCon" class="display">
            <thead>
                <tr>
                    <th>Campanha</th>
                    <th>Congregação</th>
                    <th>Meta</th>
                </tr>
            </thead>
            <tbody>
            <g:each in="${CampanhaCongregacao.list()}" var="con">
                <tr>
                    <td><g:link action="show" id="${con.id}">${con.campanha}</g:link></td>
                    <td>${con.congregacao}</td>
                    <td><g:formatNumber number="${con.meta}"  type="currency" currencyCode="BRL" /></td>
                </tr>
            </g:each>
            </tbody>
        </table>

            <%--
			<table>
				<thead>
					<tr>
					
						<th><g:message code="campanhaCongregacao.campanha.label" default="Campanha" /></th>
					
						<th><g:message code="campanhaCongregacao.congregacao.label" default="Congregacao" /></th>
					
						<g:sortableColumn property="meta" title="${message(code: 'campanhaCongregacao.meta.label', default: 'Meta')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${campanhaCongregacaoInstanceList}" status="i" var="campanhaCongregacaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${campanhaCongregacaoInstance.id}">${fieldValue(bean: campanhaCongregacaoInstance, field: "campanha")}</g:link></td>
					
						<td>${fieldValue(bean: campanhaCongregacaoInstance, field: "congregacao")}</td>

                        <td><g:formatNumber number="${campanhaCongregacaoInstance.meta}"  type="currency" currencyCode="BRL" /></td>

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${campanhaCongregacaoInstanceTotal}" />
			</div>
            --%>
		</div>
	</body>
</html>
