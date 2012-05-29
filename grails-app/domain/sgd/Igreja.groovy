package sgd

class Igreja {

    String igreja

    static mapping = {
        id generator: 'sequence', params: [sequence:'igreja_id_seq']
    }

    static constraints = {
    	igreja(nullable:false, blank:false, unique:true)
    }

    String toString(){
    	igreja
    }
}
