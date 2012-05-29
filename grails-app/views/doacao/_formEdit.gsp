<%@ page import="sgd.Doacao" %>

<script>
    $(document).ready(function(){

        $('#valor').val($('#valor').val().replace(".0",",00"));
        $('#valor').priceFormat({
            prefix: '',
            centsSeparator: ',',
            thousandsSeparator: '.'
        });
    });
</script>

<div class="fieldcontain ${hasErrors(bean: doacaoInstance, field: 'campanha', 'error')} required">
    <label for="campanha">
        <g:message code="doacao.campanha.label" default="Campanha" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="campanha" name="campanha.id" from="${sgd.Campanha.list()}" optionKey="id" required="" value="${doacaoInstance?.campanha?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doacaoInstance, field: 'valor', 'error')} required">
    <label for="valor">
        <g:message code="doacao.valor.label" default="Valor" />
        <span class="required-indicator">*</span>
    </label>
    <%--<g:field type="number" name="valor" min="1.1" required="" value="${fieldValue(bean: doacaoInstance, field: 'valor')}"/>--%>
    <g:textField name="valor" id="valor" required="" value="${doacaoInstance?.valor}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doacaoInstance, field: 'semeador', 'error')} ">
    <label for="semeador">
        <g:message code="doacao.semeador.label" default="Semeador" />
    </label>
    <g:select id="semeador" name="semeador.id" from="${sgd.Semeador.list()}" optionKey="id" value="${doacaoInstance?.semeador?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doacaoInstance, field: 'congregacao', 'error')} ">
    <label for="congregacao">
        <g:message code="doacao.congregacao.label" default="Congregação" />

    </label>
    <g:select id="congregacao" name="congregacao.id" from="${sgd.Congregacao.list()}" optionKey="id" value="${doacaoInstance?.congregacao?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>
<%--
<div class="fieldcontain ${hasErrors(bean: doacaoInstance, field: 'usuario', 'error')} required">
	<label for="usuario">
		<g:message code="doacao.usuario.label" default="Usuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="usuario" name="usuario.id" from="${sgd.Usuario.list()}" optionKey="id" required="" value="${doacaoInstance?.usuario?.id}" class="many-to-one"/>
</div>
--%>
<div class="fieldcontain ${hasErrors(bean: doacaoInstance, field: 'formaDoacao', 'error')} required">
    <label for="formaDoacao">
        <g:message code="doacao.formaDoacao.label" default="Forma Doação" />
        <span class="required-indicator">*</span>
    </label>
    <g:select name="formaDoacao" from="${doacaoInstance.constraints.formaDoacao.inList}" required=""
              value="${doacaoInstance?.formaDoacao}" valueMessagePrefix="formaDoacao.formaDoacao"/>
    <%--<g:select name="formaDoacao" from="${enuns.FormaDoacao?.values()}" keys="${enuns.FormaDoacao.values()*.name()}" required="" value="${doacaoInstance?.formaDoacao?.name()}"/>--%>
</div>



