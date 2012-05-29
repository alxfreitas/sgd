package sgd

class Usuario {

    String login
	String senha

	Perfil perfil

	static mapping = {
        id generator: 'sequence', params: [sequence:'usuario_id_seq']
		perfil lazy:false
	}

    static constraints = {
    	login(nullable:false, blank:false, unique:true)
    	senha(nullable:false, blank:false, password:true)

    	perfil(nullable:false, blank:false)
    }

    String toString(){
    	login
    }
    /*
    void setSenha(String valor){
        println "Set senha: ${valor}"
		if(valor){
            println "dentr do if: ${valor.encodeAsPassword()}"
			this.senha = valor.encodeAsPassword()
            println "depois do encode: ${this.senha}"
		}
	}
	*/
}
