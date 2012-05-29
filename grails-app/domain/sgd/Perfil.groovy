package sgd

import enuns.TipoPerfil

class Perfil {

    String perfil
	String descricao

	static hasMany = [modulos : Permissao]

	static mapping = {
        id generator: 'sequence', params: [sequence:'perfil_id_seq']
		modulos lazy:false
	}

    static constraints = {
    	perfil(nullable:false, blank:false, unique:true, inList:TipoPerfil.values().tipo)
    	descricao(nullable:false, blank:false)
    }

    String toString(){
    	perfil
    }
}
