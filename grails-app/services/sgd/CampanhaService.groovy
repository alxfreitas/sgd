package sgd

class CampanhaService {

    static scope = "session"
    def projetoService

    def setSaldo(Doacao doacao) {
        def campanha = doacao.campanha
        campanha.saldo += doacao.valor
        campanha.save()

        setSituacao(campanha)
    }

    def setSituacao(Campanha campanha){
        campanha.situacao = (campanha.saldo * 100) / campanha.meta
        campanha.save()

        projetoService.setSaldo(campanha)
    }

}
