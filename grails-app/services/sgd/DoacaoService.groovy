package sgd

class DoacaoService {

    static scope = "session"

    def listaDoacoesPorCodigoSemeador(int codigo) {
        def semeador = Semeador.findByCodigo(codigo)

        return Doacao.findAllBySemeador(semeador)
    }
}
