public class Casa {
    float valor;
    public float calcularPreco(int tamanho){
        valor = 4300 * tamanho;
        return valor;
    }
    
    public float calcularPreco(int tamanho, int qtdeQuartos) {
        valor = (4300 * tamanho) + (2500 * qtdeQuartos);
        return valor;
    }
        
    
}
