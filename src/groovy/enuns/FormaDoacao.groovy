package enuns

/**
 * Created with IntelliJ IDEA.
 * User: lsfreitas
 * Date: 22/05/12
 * Time: 08:32
 * To change this template use File | Settings | File Templates.
 */
public enum FormaDoacao {

    COFRE("Cofre"),
    ENVELOPE("Envelope"),
    DEPOSITO("Depósito"),
    OUTRA("Outra"),
    CHEQUE("Cheque"),
    CARNE("Carnê")

    private final String forma

    public FormaDoacao(String value){
        this.forma = value
    }

    String toString(){
        forma
    }
}