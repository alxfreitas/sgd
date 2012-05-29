<%@ page import="sgd.Projeto" %>

<script>
    $(document).ready(function(){

        $('#meta').val($('#meta').val().replace(".0",",00"));
        $('#meta').priceFormat({
            prefix: '',
            centsSeparator: ',',
            thousandsSeparator: '.'
        });


    });
</script>

<div class="fieldcontain ${hasErrors(bean: projetoInstance, field: 'nome', 'error')} required">
    <label for="nome">
        <g:message code="projeto.nome.label" default="Nome" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="nome" required="" value="${projetoInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projetoInstance, field: 'meta', 'error')} required">
    <label for="meta">
        <g:message code="projeto.meta.label" default="Meta" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="meta" id="meta" required="" value="${projetoInstance?.meta}" />

</div>

<div class="fieldcontain ${hasErrors(bean: projetoInstance, field: 'dataInicio', 'error')} required">
    <label for="dataInicio">
        <g:message code="projeto.dataInicio.label" default="Data Inicio" />
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="dataInicio" precision="month"  value="${projetoInstance?.dataInicio}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: projetoInstance, field: 'dataFim', 'error')} required">
    <label for="dataFim">
        <g:message code="projeto.dataFim.label" default="Data Fim" />
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="dataFim" precision="month"  value="${projetoInstance?.dataFim}"  />
</div>

