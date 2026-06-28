public class Atleta extends Pessoa {
    private String modalidade;

    public Atleta(String nome, int idade, double peso, double altura, String modalidade) {
        super(nome, idade, peso, altura);
        this.modalidade = modalidade;
    }

    public String getModalidade() { return modalidade; }

    /** Polimorfismo Dinâmico: Sobrescrita do critério de IMC para atletas. */
    @Override
    public String classificarIMC(double imc) {
        if (imc < 20.0) return "Abaixo do ideal para atleta";
        if (imc < 27.0) return "Ideal para atleta";
        return "Acima do ideal para atleta";
    }

    @Override
    public String exibirPerfil() {
        return super.exibirPerfil() + " | Modalidade: " + modalidade;
    }
}
