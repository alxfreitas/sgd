
<%@ page import="sgd.Congregacao" %>
<!doctype html>

<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'congregacao.label', default: 'Congregacao')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>

    <script type="text/javascript">
        $(document).ready(function() {
          $('#congregacoes').dataTable({
              "sUrl":"${resource(dir: 'js', file: 'dataTables.portuguese.txt')}"

          });
        } );
</script>
</head>
<body>
    <a href="#list-congregacao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/home')}"><g:message code="default.home.label"/></a></li>
            <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
        </ul>
    </div>
    <div id="list-congregacao" class="content scaffold-list" role="main">
        <h1><g:message code="default.list.label" args="[entityName]" /></h1>
        <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
        </g:if>

        <table id="congregacoes" class="display">
            <thead>
                <tr>
                    <th>Congregação</th>
                    <th>Igreja</th>
                    <th>Tipo</th>
                </tr>
            </thead>
            <tbody>
            <g:each in="${Congregacao.list()}" var="con">
                <tr>
                    <td><g:link action="show" id="${con.id}">${con.congregacao}</g:link></td>
                    <td>${con.igreja}</td>
                    <td>${con.tipo}</td>
                </tr>
            </g:each>
            </tbody>
            <tfoot>
                <tr>
                    <th>Congregação</th>
                    <th>Igreja</th>
                    <th>Tipo</th>
                </tr>
                </tfoot>
        </table>

        <%--
        <table>
            <thead>
                <tr>

                    <g:sortableColumn property="congregacao" title="${message(code: 'congregacao.congregacao.label', default: 'Congregacao')}" />

                    <th><g:message code="congregacao.igreja.label" default="Igreja" /></th>

                    <g:sortableColumn property="tipo" title="${message(code: 'congregacao.tipo.label', default: 'Tipo')}" />

                </tr>
            </thead>
            <tbody>
            <g:each in="${congregacaoInstanceList}" status="i" var="congregacaoInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                    <td><g:link action="show" id="${congregacaoInstance.id}">${fieldValue(bean: congregacaoInstance, field: "congregacao")}</g:link></td>

                    <td>${fieldValue(bean: congregacaoInstance, field: "igreja")}</td>

                    <td>${fieldValue(bean: congregacaoInstance, field: "tipo")}</td>

                </tr>
            </g:each>
            </tbody>
        </table>
        <div class="pagination">
            <g:paginate total="${congregacaoInstanceTotal}" />
        </div>
        --%>
    </div>

   </body>
</html>
