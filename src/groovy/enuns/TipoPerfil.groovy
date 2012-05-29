package enuns

/**
 * Created by IntelliJ IDEA.
 * User: Nois
 * Date: 19/05/12
 * Time: 14:47
 * To change this template use File | Settings | File Templates.
 */
public enum TipoPerfil {

    ADMINISTRADOR("Administrador"),
	COORDENADOR("Coordenador"),
	ATENDENTE("Atendente"),
	VISITANTE("Visitante")

	private final String tipo

	public TipoPerfil(String value){
		this.tipo = value
	}

	String toString(){
		tipo
	}

}