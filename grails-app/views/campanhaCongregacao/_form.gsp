<%@ page import="sgd.CampanhaCongregacao" %>

<script>
    $(document).ready(function(){
        //alert('reconheceu jquery');
        $('#meta').priceFormat({
            prefix: '',
            centsSeparator: ',',
            thousandsSeparator: '.'
        });
    });
</script>

<div class="fieldcontain ${hasErrors(bean: campanhaCongregacaoInstance, field: 'campanha', 'error')} required">
	<label for="campanha">
		<g:message code="campanhaCongregacao.campanha.label" default="Campanha" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="campanha" name="campanha.id" from="${sgd.Campanha.list()}" optionKey="id" required="" value="${campanhaCongregacaoInstance?.campanha?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: campanhaCongregacaoInstance, field: 'congregacao', 'error')} required">
	<label for="congregacao">
		<g:message code="campanhaCongregacao.congregacao.label" default="Congregacao" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="congregacao" name="congregacao.id" from="${sgd.Congregacao.list()}" optionKey="id" required="" value="${campanhaCongregacaoInstance?.congregacao?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: campanhaCongregacaoInstance, field: 'meta', 'error')} required">
	<label for="meta">
		<g:message code="campanhaCongregacao.meta.label" default="Meta" />
		<span class="required-indicator">*</span>
	</label>
	<%--<g:field type="number" id="meta" name="meta" required="" value="${fieldValue(bean: campanhaCongregacaoInstance, field: 'meta')}"/>--%>
    <g:textField name="meta" id="meta" required="" value="${campanhaCongregacaoInstance?.meta}"/>
</div>

