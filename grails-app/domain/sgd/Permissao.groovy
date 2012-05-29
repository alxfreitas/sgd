package sgd

class Permissao {

    String referencia

    static mapping = {
        id generator: 'sequence', params: [sequence:'permissao_id_seq']
    }

    static constraints = {
    	referencia(nullable:false, blank:false, unique:true)
    }

    String toString(){
    	referencia
    }
}
