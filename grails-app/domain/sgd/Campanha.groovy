package sgd



class Campanha {

    String nome
    Double meta
    Float situacao
    Double saldo
    Date dataInicio
    Date dataFim
    boolean ativa

    static hasMany = [coordenadores : Semeador]
    static belongsTo = [projeto : Projeto]

    static mapping = {
        id generator: 'sequence', params: [sequence:'campanha_id_seq']
        coordenadores lazy: false
        projeto lazy: false
    }

    static constraints = {
        nome(nullable: false, blank:false, unique:true, i18n:[pt_BR:"Nome"])
        meta(nullable: false, i18n:[pt_BR:"Meta"])
        situacao(nullable: false, display:false, i18n:[pt_BR:"Situação (%)"])
        saldo(nullable: false, display:false, i18n:[pt_BR:"Saldo Atual"])
        coordenadores(nullable: true, display:false, i18n:[pt_BR:"Coordenadores"])
        dataInicio(nullable: false, i18n:[pt_BR:"Início"])
        dataFim(nullable: false, i18n:[pt_BR:"Fim"])
        ativa(display: false, i18n:[pt_BR:"Ativa"])
        projeto(nullable: false, i18n:[pt_BR:"Projeto"])
    }

    String toString(){
        nome
    }
}
