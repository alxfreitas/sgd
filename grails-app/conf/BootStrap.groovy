import sgd.*
import enuns.TipoPerfil

class BootStrap {

    def init = { servletContext ->
    	createCongregacao()
    	createBasicData()
    }

    private createIgreja = {
    	def igreja
    	if(Igreja.count() == 0) {
    		igreja = new Igreja(igreja:"Assembléia de Deus - Bela Vista").save()
    	}

    	return igreja
    }

    private createCongregacao = {
    	if(Igreja.count() == 0){
    		def igreja = new Igreja(igreja:"Assembléia de Deus - Bela Vista").save(flush: true)
    		loadCongregacoesCapital(igreja)
    		loadCongregacoesInterior(igreja)
    	}
    }

    private loadCongregacoesCapital(Igreja igreja){
    	def congregacoesCapital = []

        congregacoesCapital.add(new Congregacao(congregacao:'	Antenas	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Antônio Bezerra	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Apolo XI	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Aracapé	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Arvoredo	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Bela Vista II	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Bela Vista I	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Bom Jardim	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Bonsucesso	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Campus do Pici	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Campus Universitário	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Canindezinho	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Cidade dos Funcionários	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Cidade Nova	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Cidade Oeste	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Conjunto Esperança	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Creuza Roque	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Demócrito Rocha	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Edson Queiroz	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Encantada	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Galiléia	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Goiabeiras I	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Goiabeiras II	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Granja Lisboa I	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Granja Lisboa II	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Granja Portugal	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Henrique Jorge	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Industrial	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Jangurussu	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Jardim América	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Jardim Arrebol	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Jardim Castelão	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Jardim das Oliveiras	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Jardim Fluminense	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Jardim Iracema	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Jardim Jatobá	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Jardim Maraponga	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Jardim Violeta	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	João XXIII	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Joaquim Távora	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Jóquei Clube	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	José Walter	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Lagoa Redonda	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Luciano Cavalcante	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Maraponga	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Monte Moriá	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Monte Sinai	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Montese	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Morro do Ouro	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Nova Aldeota	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Nova Esperança	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Nova Maraponga	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Novo Barroso I	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Novo Barroso II	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Novo Modumbim	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Palmeiras II	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Pan Americano	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	P. Almirante Tamandaré	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Parque Betânia	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Parque Canaã	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Parque Genibaú II	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Parque Genibaú I	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Parque Mondubim	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Parque Olivanda	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Parque Santa Maria	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Parque Santana	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Parque São José	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Parque Veras	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Pedra Viva	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Pedras	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Pedreiras	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Planalto Airton Senna	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Planalto da Vitória	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Planalto Mondumbim	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Presidente Vagas	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Quarta Etapa	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Rec. Da Felicidade	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Retiro da Felicidade	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Ribeirinho	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Santa Cecília	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Santa Elisa	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	São Cristóvão I	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	São Cristóvão II	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Sede	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Serra Azul	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Siqueira	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Sítio Aratanha	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Sítio Córrego	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Sítio Estrela	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Sonho Meu	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Trancredo Neves	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Tatumundé	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Vale de Hebrom	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Vale Verde	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Vila Manoel Sátiro	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Vila Santo Antônio	', igreja:igreja, tipo:"Capital").save(flush: true))
        congregacoesCapital.add(new Congregacao(congregacao:'	Vila União	', igreja:igreja, tipo:"Capital").save(flush: true))

        print "${congregacoesCapital.size()} Congregações da capital gravadas"

        return congregacoesCapital
    }

    private loadCongregacoesInterior(Igreja igreja){
    	def congregacoesInterior = []

        congregacoesInterior.add(new Congregacao(congregacao: '	Acarape	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Acaraú	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Acopiara	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Alcobaça – Ba	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Alto Santo	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Amontada	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Antonio Diogo	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Apuiares	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Aquiraz	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Aracati	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Aurora	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Bacabeira – Ma	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Baleia	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Barreiras	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Baturité	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Beberibe	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Boa Viagem	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Boa Vista	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	C. do Moura	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Camocim	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Campos Sales	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Canaã	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Canindé	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Capistrano	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Caraucanga	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Cariré	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Cariús	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Cascavel	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Catunda	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Caucaia	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Chorozinho	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Cocal – Pi	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Crateús	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Crato	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Croatá	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Eusébio	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Forquilha	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Fortim	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Francisco Dantas	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Graça	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Granja	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Groaíras	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Guaiuba	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	G. do Norte	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Guarulhos – SP	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Horizonte	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Ibaretama	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Ibicuitinga	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Icapui	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Icó	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Ideal	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Iguatu	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Ipueiras	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Iracema	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Irapuan Pinheiro	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Irauçuba	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Itaitinga	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Itapajé	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Itapipoca	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Itapiuna	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Itarema	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Jaguaretama	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Jaguaribara	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Jaguaribe	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Jaguaruana	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Jereissati III	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Jijoca	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Juazeiro do Norte	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Lagoa do Mato	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Limoeiro do Norte	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Lins	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Madalena	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Maracanaú	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Maranguape	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Martinópole	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Massapé	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Missão Velha	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Morada Nova	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Moraujo	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Morrinhos	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Novo Oriente	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Ocara	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Pacajus	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Pacatuba	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Pacujá	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Pajuçara	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Palhano	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Palmacia	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Paracuru	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Paraipaba	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Paramoti	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Parnaiba - Pi	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Pecém	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Pentecoste	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Picos – Pi	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Pindoretama	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Pique Carneiro	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Potiretama	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Primavera 	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Quiterianópoles	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Quixadá	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Quixeramobim	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Redenção	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Reriutaba	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Russas	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Salitre	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Santa Quitéria	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Santana do Acaraú	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	São Benedito	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	S. G. Amararante	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	S. João do Aruaru	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	São José	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	São Luiz - Ma	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	São Luiz do Curu	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Senador Sá	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Sitio Alegre	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Sítios Novos	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Sobral	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Solonópoles	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Tauá	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Tejuçuoca	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Tejuçuoca – 2	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Tianguá	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Trairi	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Tururu	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Ubajara	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Umirim	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Uruburetama	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Varjota	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Viçosa do Ceará	', igreja:igreja, tipo:"Interior").save(flush: true))
        congregacoesInterior.add(new Congregacao(congregacao: '	Vila Mel	', igreja:igreja, tipo:"Interior").save(flush: true))

        println "${congregacoesInterior.size()} Congregações do interior gravadas"
        return congregacoesInterior
    }




	private createBasicData() {

		if (!Usuario.findByLogin("admin")) {
			/*def usuario1 = new Usuario(login: 'admin', senha:'admin'.encodeAsPassword())
            def usuario2 = new Usuario(login: 'admin2', senha:'123456'.encodeAsPassword())
            def usuario3 = new Usuario(login: 'admin3', senha:'123456'.encodeAsPassword())
            def usuario4 = new Usuario(login: 'admin4', senha:'123456'.encodeAsPassword())*/
            def usuario1 = new Usuario(login: 'admin', senha:'admin'.encodeAsPassword())
            def usuario2 = new Usuario(login: 'admin2', senha:'123456'.encodeAsPassword())
            def usuario3 = new Usuario(login: 'admin3', senha:'123456'.encodeAsPassword())
            def usuario4 = new Usuario(login: 'admin4', senha:'123456'.encodeAsPassword())
			def perfilAdmin = new Perfil(perfil: "Administrador", descricao: "Perfil Administrador")
			createModulos().each() { Permissao modulo ->
				perfilAdmin.addToModulos(modulo)
			}


			if (perfilAdmin.save(flush: true)) {
				println "Salvou perfil Administrador"
				usuario1.perfil = perfilAdmin
                usuario2.perfil = perfilAdmin
                usuario3.perfil = perfilAdmin
                usuario4.perfil = perfilAdmin
			}

			if (usuario1.save(flush: true)) {
				println "Salvou SUPERUSER 1"
			}

            if (usuario2.save(flush: true)) {
                println "Salvou SUPERUSER 2"
            }

            if (usuario3.save(flush: true)) {
                println "Salvou SUPERUSER 3"
            }

            if (usuario4.save(flush: true)) {
                println "Salvou SUPERUSER 4"
            }

			criaPerfilVisitante()
		}
	}


	private criaPerfilVisitante(){
		Permissao permissaoVisitante = Permissao.findByReferencia('Ver Minhas Doações')

		Perfil perfilVisitante = new Perfil(perfil:"Visitante", descricao: "Perfil Visitante")
		perfilVisitante.addToModulos(permissaoVisitante)

		if (perfilVisitante.save(flush: true)) {
				println "Salvou perfil Visitante"
			}
	}


	private createModulos() {

		def modulos = []

		if (Permissao.count() == 0) {
			modulos.add(new Permissao(referencia: 'Cadastrar Perfil').save(flush: true))
			modulos.add(new Permissao(referencia: 'Cadastrar Igreja').save(flush: true))
			modulos.add(new Permissao(referencia: 'Cadastrar Congregação').save(flush: true))
			modulos.add(new Permissao(referencia: 'Cadastrar Campanha').save(flush: true))
			modulos.add(new Permissao(referencia: 'Cadastrar Semeador').save(flush: true))
			modulos.add(new Permissao(referencia: 'Gerenciar Perfis').save(flush: true))
			modulos.add(new Permissao(referencia: 'Gerenciar Campanha').save(flush: true))
			modulos.add(new Permissao(referencia: 'Lançar Doacao').save(flush: true))
			modulos.add(new Permissao(referencia: 'Ver Minhas Doações').save(flush: true))
		}

        println "${Permissao.count()} Permissões gravadas"
		return modulos
	}

	def destroy = {
	}
}
