package sgd

import enuns.TipoCongregacao

class Congregacao {

    String congregacao
    String tipo

	static belongsTo = [igreja : Igreja]

	static mapping = {
        id generator: 'sequence', params: [sequence:'congregacao_id_seq']
		igreja lazy:false
	}

    static constraints = {
    	congregacao(nullable:false, blank:false, unique:true)
    	igreja(nullable:false, blank:false)
        tipo(nullable:false, blank:false, inList:TipoCongregacao.values().tipo)
    }

    String toString(){
    	"${congregacao} - ${tipo}"
    }
}
