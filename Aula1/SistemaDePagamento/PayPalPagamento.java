public class PayPalPagamento extends MetodoPagamento {

    public PayPalPagamento() {
        super("PayPal");
    }

    @Override
    public void processaPagamento(double valor) {
        System.out.println("Pagamento de R$ " + valor +
                " processado via PayPal.");
    }

    @Override
    public void mostraDetalhesPagamento() {
        System.out.println("Método: " + nomeMetodo);
        System.out.println("ID do Pagamento: " + idPagamento);
    }
}