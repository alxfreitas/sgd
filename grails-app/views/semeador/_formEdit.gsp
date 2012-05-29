<%@ page import="sgd.Semeador" %>


Dados Pessoais
<hr/>
<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'nomeCompleto', 'error')} required">
	<label for="nomeCompleto">
		<g:message code="semeador.nomeCompleto.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nomeCompleto" required="" value="${semeadorInstance?.nomeCompleto}" style="text-transform: uppercase"/>
</div>
<%--
<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'apelido', 'error')} required">
	<label for="apelido">
		<g:message code="semeador.apelido.label" default="Apelido" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apelido" required="" value="${semeadorInstance?.apelido}"/>
</div>
--%>

<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'cpf', 'error')} required">
	<label for="cpf">
		<g:message code="semeador.cpf.label" default="Cpf" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cpf" required="" value="${semeadorInstance?.cpf}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'rg', 'error')} ">
    <label for="rg">
        <g:message code="semeador.rg.label" default="Rg" />
    </label>
    <g:textField name="rg" value="${semeadorInstance?.rg}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'dataNascimento', 'error')} required">
	<label for="dataNascimento">
		<g:message code="semeador.dataNascimento.label" default="Data Nascimento" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dataNascimento" precision="day"  value="${semeadorInstance?.dataNascimento}"  />
</div>


<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'profissao', 'error')} ">
	<label for="profissao">
		<g:message code="semeador.profissao.label" default="Profissão" />
		
	</label>
	<g:textField name="profissao" value="${semeadorInstance?.profissao}" style="text-transform: uppercase"/>
</div>

<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="semeador.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${semeadorInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'telefone', 'error')} required">
    <label for="telefone">
        <g:message code="semeador.telefone.label" default="Telefone" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="telefone" id="telefone" required="" value="${semeadorInstance?.telefone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'tipoTelefone', 'error')} required">
    <label for="tipoTelefone">
        <g:message code="semeador.tipoTelefone.label" default="Tipo" />
        <span class="required-indicator">*</span>
    </label>
    <g:select name="tipoTelefone" from="${semeadorInstance.constraints.tipoTelefone.inList}" required=""
              value="${semeadorInstance?.tipoTelefone}" valueMessagePrefix="tipoTelefone.tipoTelefone"/>
</div>


<%--
<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'codigo', 'error')} required">
	<label for="codigo">
		<g:message code="semeador.codigo.label" default="Codigo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="codigo" required="" value="${semeadorInstance?.codigo}"/>
</div>
--%>


Endereço
<hr/>
<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'logradouro', 'error')} ">
	<label for="logradouro">
		<g:message code="semeador.logradouro.label" default="Logradouro (Rua/Av Nº)" />
		
	</label>
	<g:textField name="logradouro" value="${semeadorInstance?.logradouro}" style="text-transform: uppercase"/>
</div>

<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'complemento', 'error')} ">
    <label for="complemento">
        <g:message code="semeador.complemento.label" default="Complemento" />

    </label>
    <g:textField name="complemento" value="${semeadorInstance?.complemento}" style="text-transform: uppercase"/>
</div>

<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'bairro', 'error')} ">
	<label for="bairro">
		<g:message code="semeador.bairro.label" default="Bairro" />

	</label>
	<g:textField name="bairro" value="${semeadorInstance?.bairro}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'cidade', 'error')} ">
	<label for="cidade">
		<g:message code="semeador.cidade.label" default="Cidade" />

	</label>
	<g:textField name="cidade" value="${semeadorInstance?.cidade}" style="text-transform: uppercase"/>
</div>

<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'estado', 'error')} ">
	<label for="estado">
		<g:message code="semeador.estado.label" default="Estado" />

	</label>
	<g:textField name="estado" value="${semeadorInstance?.estado}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'cep', 'error')} ">
	<label for="cep">
		<g:message code="semeador.cep.label" default="Cep" />

	</label>
	<g:textField name="cep" value="${semeadorInstance?.cep}"/>
</div>

Outros
<hr/>
<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'naoEvangelico', 'error')} ">
	<label for="naoEvangelico">
		<g:message code="semeador.naoEvangelico.label" default="Não Evangélico" />

	</label>
	<g:checkBox name="naoEvangelico" value="${semeadorInstance?.naoEvangelico}" />
</div>

<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'congregacao', 'error')} ">
	<label for="congregacao">
		<g:message code="semeador.congregacao.label" default="Congregação" />

	</label>
	<g:select id="congregacao" name="congregacao.id" from="${sgd.Congregacao.list()}" optionKey="id" value="${semeadorInstance?.congregacao?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: semeadorInstance, field: 'ofertaTempo', 'error')} ">
	<label for="ofertaTempo">
		<g:message code="semeador.ofertaTempo.label" default="Você ofertaria seu tempo para a obra de Deus?" />

	</label>
	<g:checkBox name="ofertaTempo" value="${semeadorInstance?.ofertaTempo}" />
</div>

