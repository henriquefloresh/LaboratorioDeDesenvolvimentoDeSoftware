public class ProjetoConta {

    public static void main(String[] args) {

        ContaCorrente novaConta = new ContaCorrente();
        
        novaConta.definirSaldoInicial(1000);
        System.out.println("Saldo inicial: " + novaConta.getSaldo());
        
        if(novaConta.sacar(500)) {
            System.out.println("Saque efetuado");
        }else {
            System.out.println("Saque nao efetuado");
        }
        
        novaConta.depositar(50);
        System.out.println("Saldo apos deposito de 50: " + novaConta.getSaldo());
       
        if(novaConta.sacar(600)){
            System.out.println("Saque efetuado");
        }else {
            System.out.println("Saque nao efetuado");
        }
        System.out.println("Saldo apos tentativa de saque de 600: " + novaConta.getSaldo());
    }
}
