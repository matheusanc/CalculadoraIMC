public class Pessoa extends PessoaBase implements CalculadoraIMC {
    private double peso;
    private double altura;
    private boolean ativo;

    public Pessoa(String nome, int idade, double peso, double altura) {
        super(nome, idade);
        setPeso(peso);
        setAltura(altura);
        this.ativo = true;
    }

    // Getters e Setters com validações rígidas de encapsulamento
    public double getPeso() { return peso; }
    
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new EntradaInvalidaException("O peso deve ser um valor estritamente positivo!");
        }
        this.peso = peso;
    }

    public double getAltura() { return altura; }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new EntradaInvalidaException("A altura deve ser um valor estritamente positivo!");
        }
        this.altura = altura;
    }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    @Override
    public double calcularIMC(double peso, double altura) {
        // Uso obrigatório da recursão injetada via especificação
        return peso / CalculadoraRecursiva.potencia(altura, 2);
    }

    @Override
    public String classificarIMC(double imc) {
        if (imc < 18.5) return "Abaixo do peso";
        if (imc < 25.0) return "Peso normal";
        if (imc < 30.0) return "Sobrepeso";
        if (imc < 35.0) return "Obesidade grau I";
        if (imc < 40.0) return "Obesidade grau II";
        return "Obesidade grau III (mórbida)";
    }

    @Override
    public String exibirPerfil() {
        return "Pessoa: " + nome + " | Idade: " + idade + " anos | Peso: " + peso + "kg | Altura: " + altura + "m";
    }
}
