package sgd

class ProjetoService {

    static scope = "session"

    def setSaldo(Campanha campanha) {
        def projeto = campanha.projeto
        projeto.saldo += campanha.saldo
        projeto.save()

        setSituacao(projeto)
    }

    def setSituacao(Projeto projeto){

        projeto.situacao = (projeto.saldo * 100) / projeto.meta
        projeto.save()
    }


}
