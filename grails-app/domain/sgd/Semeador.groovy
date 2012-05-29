package sgd

class Semeador {

    String nomeCompleto, rg, cpf, email, profissao, apelido
	Date dataNascimento, dataCadastro, dataUltimaAlteracao

	boolean ativo, ofertaTempo
	String codigo, telefone, tipoTelefone
    boolean naoEvangelico

	// Endereco
	String logradouro, bairro, cidade, estado, cep, complemento

	Congregacao congregacao

	Usuario usuario

	static mapping = {
        id generator: 'sequence', params: [sequence:'semeador_id_seq']
		congregacao lazy:false
		usuario lazy:false
	}

	static constraints = {
		nomeCompleto(blank:false, nullable:false, i18n:[pt_BR:"Nome Completo"])
		apelido(blank:false, nullable:false, i18n:[pt_BR:"Apelido"])
		rg(blank:true, nullable:true, unique:true, i18n:[pt_BR:"RG"])
		cpf(blank:false, nullable:false, unique:true, i18n:[pt_BR:"Cpf"], cpf:true)
		profissao(blank:true, nullable:true, i18n:[pt_BR:"Profissão"])
		dataCadastro(blank:true, nullable:true, display:false, i18n:[pt_BR:"Data de Cadastro"])
		dataUltimaAlteracao(display:false, i18n:[pt_BR:"Última Alteração"])
		email(blank:true, nullable:true, email:true, i18n:[pt_BR:"Email"])
		ativo(display:false)
        ofertaTempo(i18n:[pt_BR:"Você ofertaria seu tempo para a Obra de Deus?"])
        naoEvangelico(i18n:[pt_BR:"Não Evangélico?"])
		congregacao(blank:false, nullable:true, i18n:[pt_BR:"Congregação"])
		usuario(display:false, nullable: true)
		codigo(nullable:false, blank:false, editable:false)
        telefone(nullable:false, blank:false)
        tipoTelefone(nullable:false, blank:false, inList: ["RESIDENCIAL","CELULAR","TRABALHO","RECADO"])
        estado(inList: ["CE","AC","AL","AP","AM","BA","DF","ES","GO",
                "MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS",
        "RO","RR","SC","SP","SE","TO"])
	}

	String toString(){
		nomeCompleto
	}
}
