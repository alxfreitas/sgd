package enuns

/**
 * Created by IntelliJ IDEA.
 * User: Nois
 * Date: 19/05/12
 * Time: 14:46
 * To change this template use File | Settings | File Templates.
 */
public enum TipoCongregacao {

    CAPITAL("Capital"),
	INTERIOR("Interior")

	private final String tipo

	TipoCongregacao(String value){
		this.tipo = value
	}

	String toString(){
		tipo
	}

}