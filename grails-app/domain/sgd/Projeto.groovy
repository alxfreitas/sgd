package sgd

class Projeto {

    String nome
    Double meta
    Float situacao
    Double saldo
    Date dataInicio
    Date dataFim
    boolean ativo

    static mapping = {
        id generator: 'sequence', params: [sequence:'projeto_id_seq']
    }

    static constraints = {
        nome(nullable: false, blank:false, unique:true, i18n:[pt_BR:"Nome"])
        meta(nullable: false, i18n:[pt_BR:"Meta"])
        situacao(nullable: false, display:false, i18n:[pt_BR:"Situação (%)"])
        saldo(nullable: false, display:false, i18n:[pt_BR:"Saldo Atual"])
        dataInicio(nullable: false, i18n:[pt_BR:"Início"])
        dataFim(nullable: false, i18n:[pt_BR:"Fim"])
        ativo(display: false, i18n:[pt_BR:"Ativa"])
    }

    String toString(){
        nome
    }
}
