package sgd

import enuns.TipoPerfil
import java.text.Normalizer

class AuthService {

    static scope = "session"

    def gerarSenhaAleatoria() {
    	def pool = ['a'..'z','A'..'Z',0..9].flatten()
		Random rand = new Random(System.currentTimeMillis())

		def passChars = (0..6).collect { pool[rand.nextInt(pool.size())] }
		def password = passChars.join()
		return password.toString()
    }

    def removeAcento(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD)
        str = str.replaceAll("[^\\p{ASCII}]", "");

        return str
    }

    def geraLogin(String str) {

        return removeAcento(str.replaceAll(" ","").toLowerCase())
    }


    def criarUsuario(Semeador semeador){

    	def perfil = Perfil.findByPerfil("Visitante")
    	def usuario = new Usuario()

    	usuario.login = geraLogin(semeador.apelido)
        if(semeador.email){
            usuario.senha = gerarSenhaAleatoria().encodeAsPassword()
        }
        else {
            usuario.senha = semeador.cpf.replaceAll('[^0-9]','').encodeAsPassword()
        }

    	usuario.perfil = perfil

    	if(usuario.save(flush:true)){
            println "criou usuario"
        }
        else {
          println "falha na criação do usuário"
          println usuario.errors
        }


    	return usuario
    }
}
