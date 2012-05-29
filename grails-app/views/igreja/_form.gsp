<%@ page import="sgd.Igreja" %>



<div class="fieldcontain ${hasErrors(bean: igrejaInstance, field: 'igreja', 'error')} required">
	<label for="igreja">
		<g:message code="igreja.igreja.label" default="Igreja" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="igreja" required="" value="${igrejaInstance?.igreja}"/>
</div>

