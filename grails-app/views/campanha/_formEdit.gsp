<%@ page import="sgd.Campanha" %>

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

<div class="fieldcontain ${hasErrors(bean: campanhaInstance, field: 'projeto', 'error')} required">
    <label for="projeto">
        <g:message code="campanha.projeto.label" default="Projeto" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="projeto" name="projeto.id" from="${sgd.Projeto.list()}" optionKey="id" required="" value="${campanhaInstance?.projeto?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: campanhaInstance, field: 'nome', 'error')} required">
    <label for="nome">
        <g:message code="campanha.nome.label" default="Nome" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="nome" required="" value="${campanhaInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: campanhaInstance, field: 'meta', 'error')} required">
    <label for="meta">
        <g:message code="campanha.meta.label" default="Meta" />
        <span class="required-indicator">*</span>
    </label>
    <%--<g:field type="number" name="meta" step="0.01" min="1.0" id="meta" required="" value="${fieldValue(bean: campanhaInstance, field: 'meta')}"/>--%>
    <g:textField name="meta" id="meta" required="" value="${campanhaInstance?.meta}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: campanhaInstance, field: 'dataInicio', 'error')} required">
    <label for="dataInicio">
        <g:message code="campanha.dataInicio.label" default="Data Início" />
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="dataInicio" precision="month"  value="${campanhaInstance?.dataInicio}" relativeYears="[0..2]"/>
</div>

<div class="fieldcontain ${hasErrors(bean: campanhaInstance, field: 'dataFim', 'error')} required">
    <label for="dataFim">
        <g:message code="campanha.dataFim.label" default="Data Fim" />
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="dataFim" precision="month"  value="${campanhaInstance?.dataFim}"  relativeYears="[0..2]"/>
</div>



