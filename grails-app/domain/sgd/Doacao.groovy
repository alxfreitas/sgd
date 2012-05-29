package sgd

import enuns.FormaDoacao

class Doacao {

    Double valor
    Campanha campanha
    Semeador semeador
    Usuario usuario
    Date dataLancamento
    String formaDoacao
    Congregacao congregacao

    static mapping = {
        id generator: 'sequence', params: [sequence:'doacao_id_seq']
        campanha lazy:false
        semeador lazy:false
        usuario lazy:false
    }

    static constraints = {
        valor(nullable: false, min:1.1D, i18n:[pt_BR:"Valor"])
        dataLancamento(display: false, i18n:[pt_BR:"Data Lançamento"])
        semeador(nullable: true, i18n:[pt_BR:"Ofertado por"])
        congregacao(nullable: true, i18n:[pt_BR:"Ofertado por Congregação"])
        usuario(nullable: false, i18n:[pt_BR:"Lançamento feito por"])
        formaDoacao(nullable: false, i18n:[pt_BR:"Forma"], inList: FormaDoacao.values().forma)

    }
}
