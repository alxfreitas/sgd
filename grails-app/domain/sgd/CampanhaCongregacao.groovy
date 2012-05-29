package sgd

class CampanhaCongregacao {

    Campanha campanha
    Congregacao congregacao
    Double meta

    static mapping = {
        id generator: 'sequence', params: [sequence:'camp_cong_id_seq']
        campanha lazy: false
        congregacao lazy: false
    }

    static constraints = {
        campanha(nullable: false, i18n:[pt_BR:"Campanha"])
        congregacao(nullable: false, i18n:[pt_BR:"Congregação"])
        meta(nullable: false, i18n:[pt_BR:"Meta"])
    }
}
