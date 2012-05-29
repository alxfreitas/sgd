<%@ page import="sgd.Perfil" %>



<div class="fieldcontain ${hasErrors(bean: perfilInstance, field: 'perfil', 'error')} required">
    <label for="perfil">
        <g:message code="perfil.perfil.label" default="Perfil"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select name="perfil" from="${perfilInstance.constraints.perfil.inList}" required=""
              value="${perfilInstance?.perfil}" valueMessagePrefix="perfil.perfil"/>
</div>

<div class="fieldcontain ${hasErrors(bean: perfilInstance, field: 'descricao', 'error')} required">
    <label for="descricao">
        <g:message code="perfil.descricao.label" default="Descricao"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="descricao" required="" value="${perfilInstance?.descricao}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: perfilInstance, field: 'modulos', 'error')} ">
    <label for="modulos">
        <g:message code="perfil.modulos.label" default="Modulos"/>

    </label>
    <g:select name="modulos" from="${sgd.Permissao.list()}" multiple="multiple" optionKey="id" size="5"
              value="${perfilInstance?.modulos*.id}" class="many-to-many"/>
</div>

