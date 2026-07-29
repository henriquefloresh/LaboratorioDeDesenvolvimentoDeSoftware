public class Principal {
    public static void main(String[] args) {
        Casa c = new Casa();
        float valor;
        valor = c.calcularPreco(70);
        System.out.println("Valor: "+valor);
        valor = c.calcularPreco(70, 3);
        System.out.println("Valor2: "+valor);
    }  
}
