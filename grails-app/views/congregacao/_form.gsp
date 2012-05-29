<%@ page import="sgd.Congregacao" %>



<div class="fieldcontain ${hasErrors(bean: congregacaoInstance, field: 'congregacao', 'error')} required">
	<label for="congregacao">
		<g:message code="congregacao.congregacao.label" default="Congregacao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="congregacao" required="" value="${congregacaoInstance?.congregacao}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: congregacaoInstance, field: 'igreja', 'error')} required">
	<label for="igreja">
		<g:message code="congregacao.igreja.label" default="Igreja" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="igreja" name="igreja.id" from="${sgd.Igreja.list()}" optionKey="id" required="" value="${congregacaoInstance?.igreja?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: congregacaoInstance, field: 'tipo', 'error')} required">
	<label for="tipo">
		<g:message code="congregacao.tipo.label" default="Tipo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tipo" from="${congregacaoInstance.constraints.tipo.inList}" required="" value="${congregacaoInstance?.tipo}" valueMessagePrefix="congregacao.tipo"/>
</div>

