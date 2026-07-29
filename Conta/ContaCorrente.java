public class ContaCorrente {
    private float saldo;
    
    public void definirSaldoInicial(float valor){
        saldo = valor;
    }
    
    public void depositar(float valor){
        saldo = saldo + valor;
    }
    
    public boolean sacar(float valor){
        if(valor > saldo){
            return false;
        } else
            saldo -= valor;
        return true;
    }
    
    public float getSaldo(){
        return saldo;
    }
    
}
