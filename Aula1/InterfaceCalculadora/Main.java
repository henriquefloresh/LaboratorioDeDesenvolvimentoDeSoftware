public class Main {
    public static void main(String[] args) {

        ICalculadora calc = new Calculadora();

        System.out.println("Soma: " + calc.somar(10, 5));
        System.out.println("Subtração: " + calc.subtrair(10, 5));
        System.out.println("Multiplicação: " + calc.multiplicar(10, 5));
        System.out.println("Divisão: " + calc.dividir(10, 5));
        System.out.println("Raiz quadrada de 25: " + calc.raizquadrada(25, 0));
        System.out.println("2 elevado a 3: " + calc.elevarPotencia(2, 3));
        System.out.println("Logaritmo base 10 de 100: " + calc.logaritmo10(100));
    }
}
