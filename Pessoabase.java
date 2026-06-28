public abstract class PessoaBase {
    protected String nome;
    protected int idade;

    public PessoaBase(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    /** Método abstrato obrigatório para implementação das subclasses. */
    public abstract String exibirPerfil();

    // Getters concretos herdados por todas as subclasses
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
}
