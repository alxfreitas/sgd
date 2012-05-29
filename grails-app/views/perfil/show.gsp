<%@ page import="sgd.Perfil" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'perfil.label', default: 'Perfil')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-perfil" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/home')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-perfil" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list perfil">

        <g:if test="${perfilInstance?.perfil}">
            <li class="fieldcontain">
                <span id="perfil-label" class="property-label"><g:message code="perfil.perfil.label"
                                                                          default="Perfil"/></span>

                <span class="property-value" aria-labelledby="perfil-label"><g:fieldValue bean="${perfilInstance}"
                                                                                          field="perfil"/></span>

            </li>
        </g:if>

        <g:if test="${perfilInstance?.descricao}">
            <li class="fieldcontain">
                <span id="descricao-label" class="property-label"><g:message code="perfil.descricao.label"
                                                                             default="Descrição"/></span>

                <span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${perfilInstance}"
                                                                                             field="descricao"/></span>

            </li>
        </g:if>

        <g:if test="${perfilInstance?.modulos}">
            <li class="fieldcontain">
                <span id="modulos-label" class="property-label"><g:message code="perfil.modulos.label"
                                                                           default="Módulos"/></span>

                <g:each in="${perfilInstance.modulos}" var="m">
                    <span class="property-value" aria-labelledby="modulos-label">
                        <%--<g:link controller="permissao" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link>--%>
                        ${m?.encodeAsHTML()}
                    </span>
                </g:each>

            </li>
        </g:if>

    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${perfilInstance?.id}"/>
            <g:link class="edit" action="edit" id="${perfilInstance?.id}"><g:message code="default.button.edit.label"
                                                                                     default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
