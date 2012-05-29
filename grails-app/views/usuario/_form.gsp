<%@ page import="sgd.Usuario" %>


<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'login', 'error')} required">
    <label for="login">
        <g:message code="usuario.login.label" default="Login"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="login" required="" value="${usuarioInstance?.login}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'senha', 'error')} required">
    <label for="senha">
        <g:message code="usuario.senha.label" default="Senha"/>
        <span class="required-indicator">*</span>
    </label>
    <g:passwordField name="senha" id="senha" required="" value="${usuarioInstance?.senha.decodePassword()}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'perfil', 'error')} required">
    <label for="perfil">
        <g:message code="usuario.perfil.label" default="Perfil"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="perfil" name="perfil.id" from="${sgd.Perfil.list()}" optionKey="id" required=""
              value="${usuarioInstance?.perfil?.id}" class="many-to-one"/>
</div>



