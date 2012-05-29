
<%@ page import="sgd.Semeador" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'semeador.label', default: 'Semeador')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-semeador" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/home')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-semeador" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list semeador">
			    Dados Pessoais
                <hr/>


				<g:if test="${semeadorInstance?.codigo}">
				<li class="fieldcontain">
					<span id="codigo-label" class="property-label"><g:message code="semeador.codigo.label" default="Código Semeador" /></span>

						<span class="property-value" aria-labelledby="codigo-label"><g:fieldValue bean="${semeadorInstance}" field="codigo"/></span>

				</li>
				</g:if>
				<g:if test="${semeadorInstance?.nomeCompleto}">
				<li class="fieldcontain">
					<span id="nomeCompleto-label" class="property-label"><g:message code="semeador.nomeCompleto.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nomeCompleto-label" style="text-transform: uppercase"><g:fieldValue bean="${semeadorInstance}" field="nomeCompleto" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${semeadorInstance?.rg}">
				<li class="fieldcontain">
					<span id="rg-label" class="property-label"><g:message code="semeador.rg.label" default="Rg" /></span>
					
						<span class="property-value" aria-labelledby="rg-label"><g:fieldValue bean="${semeadorInstance}" field="rg"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${semeadorInstance?.cpf}">
				<li class="fieldcontain">
					<span id="cpf-label" class="property-label"><g:message code="semeador.cpf.label" default="Cpf" /></span>
					
						<span class="property-value" aria-labelledby="cpf-label"><g:fieldValue bean="${semeadorInstance}" field="cpf"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${semeadorInstance?.profissao}">
				<li class="fieldcontain">
					<span id="profissao-label" class="property-label"><g:message code="semeador.profissao.label" default="Profissão" /></span>
					
						<span class="property-value" aria-labelledby="profissao-label" style="text-transform: uppercase"><g:fieldValue bean="${semeadorInstance}" field="profissao" /></span>
					
				</li>
				</g:if>

                <g:if test="${semeadorInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="semeador.email.label" default="Email" /></span>

						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${semeadorInstance}" field="email"/></span>

				</li>
				</g:if>

                <g:if test="${semeadorInstance?.dataNascimento}">
				<li class="fieldcontain">
					<span id="dataNascimento-label" class="property-label"><g:message code="semeador.dataNascimento.label" default="Data Nascimento" /></span>

						<span class="property-value" aria-labelledby="dataNascimento-label"><g:formatDate date="${semeadorInstance?.dataNascimento}" format="dd/MM/yyyy"/></span>

				</li>
				</g:if>
			
				<g:if test="${semeadorInstance?.dataCadastro}">
				<li class="fieldcontain">
					<span id="dataCadastro-label" class="property-label"><g:message code="semeador.dataCadastro.label" default="Data Cadastro" /></span>
					
						<span class="property-value" aria-labelledby="dataCadastro-label"><g:formatDate date="${semeadorInstance?.dataCadastro}" format="dd/MM/yyyy"/></span>
					
				</li>
				</g:if>

                Endereço
                <hr/>
                <g:if test="${semeadorInstance?.logradouro}">
				<li class="fieldcontain">
					<span id="logradouro-label" class="property-label"><g:message code="semeador.logradouro.label" default="Logradouro" /></span>

						<span class="property-value" aria-labelledby="logradouro-label" style="text-transform: uppercase"><g:fieldValue bean="${semeadorInstance}" field="logradouro" /></span>

				</li>
				</g:if>

                <g:if test="${semeadorInstance?.complemento}">
                    <li class="fieldcontain">
                        <span id="complemento-label" class="property-label"><g:message code="semeador.complemento.label" default="Complemento" /></span>

                        <span class="property-value" aria-labelledby="complemento-label" style="text-transform: uppercase"><g:fieldValue bean="${semeadorInstance}" field="complemento" /></span>

                    </li>
                </g:if>

                <g:if test="${semeadorInstance?.bairro}">
				<li class="fieldcontain">
					<span id="bairro-label" class="property-label"><g:message code="semeador.bairro.label" default="Bairro" /></span>

						<span class="property-value" aria-labelledby="bairro-label" style="text-transform: uppercase"><g:fieldValue bean="${semeadorInstance}" field="bairro" /></span>

				</li>
				</g:if>

                <g:if test="${semeadorInstance?.cidade}">
				<li class="fieldcontain">
					<span id="cidade-label" class="property-label"><g:message code="semeador.cidade.label" default="Cidade" /></span>

						<span class="property-value" aria-labelledby="cidade-label" style="text-transform: uppercase"><g:fieldValue bean="${semeadorInstance}" field="cidade" /></span>

				</li>
				</g:if>

				<g:if test="${semeadorInstance?.estado}">
				<li class="fieldcontain">
					<span id="estado-label" class="property-label"><g:message code="semeador.estado.label" default="Estado" /></span>

						<span class="property-value" aria-labelledby="estado-label"><g:fieldValue bean="${semeadorInstance}" field="estado"/></span>

				</li>
				</g:if>

                <g:if test="${semeadorInstance?.cep}">
				<li class="fieldcontain">
					<span id="cep-label" class="property-label"><g:message code="semeador.cep.label" default="Cep" /></span>

						<span class="property-value" aria-labelledby="cep-label"><g:fieldValue bean="${semeadorInstance}" field="cep"/></span>

				</li>
				</g:if>

                Outros
                <hr/>
			
				<g:if test="${semeadorInstance?.naoEvangelico}">
				<li class="fieldcontain">
					<span id="naoEvangelico-label" class="property-label"><g:message code="semeador.naoEvangelico.label" default="Evangélico" /></span>
					
					<span class="property-value" aria-labelledby="naoEvangelico-label"><g:formatBoolean boolean="${!semeadorInstance?.naoEvangelico}" />
                    </span>
					
				</li>
				</g:if>
			
				<g:if test="${semeadorInstance?.congregacao}">
				<li class="fieldcontain">
					<span id="congregacao-label" class="property-label"><g:message code="semeador.congregacao.label" default="Congregação" /></span>
					
						<span class="property-value" aria-labelledby="congregacao-label" ><g:link controller="congregacao" action="show" id="${semeadorInstance?.congregacao?.id}">${semeadorInstance?.congregacao?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${semeadorInstance?.ofertaTempo}">
				<li class="fieldcontain">
					<span id="ofertaTempo-label" class="property-label"><g:message code="semeador.ofertaTempo.label" default="Oferta tempo para a obra de Deus" /></span>
					
						<span class="property-value" aria-labelledby="ofertaTempo-label"><g:formatBoolean boolean="${semeadorInstance?.ofertaTempo}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${semeadorInstance?.id}" />
					<g:link class="edit" action="edit" id="${semeadorInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
