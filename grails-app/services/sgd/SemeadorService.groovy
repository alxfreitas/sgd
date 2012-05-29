package sgd

class SemeadorService {

    static scope = "session"

    def getCodigoSemeador(Semeador semeador) {
        def codigo

        if(!semeador.congregacao){
            codigo = "NBV-${Semeador.count() + 1}"
        }
        else {
            codigo = "${semeador.congregacao.tipo[0]}${semeador.congregacao.id}-${Semeador.count() + 1}"
        }
        if(semeador.naoEvangelico){
            codigo = "NE-${Semeador.count() + 1}"
        }

        return codigo
    }


    def listByCodigo(int codigo) {
        return Semeador.findByCodigo(codigo)
    }
}
