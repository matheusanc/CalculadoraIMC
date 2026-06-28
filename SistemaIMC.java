public class SistemaIMC {
    // Relação de Composição ("Tem-Um")
    private Historico historico = new Historico();

    public void processar(Pessoa pessoa) {
        // Polimorfismo em runtime no calcularIMC e classificarIMC dependendo da instância recebida
        double imc = pessoa.calcularIMC(pessoa.getPeso(), pessoa.getAltura());
        String classificacao = pessoa.classificarIMC(imc);
        
        String linhaRegistro = String.format("Nome: %-12s | Perfil: %-8s | IMC: %-6.2f | Classificação: %s", 
                pessoa.getNome(), 
                (pessoa instanceof Atleta ? "Atleta" : "Comum"),
                imc, 
                classificacao);
        
        historico.adicionar(linhaRegistro);
        
        System.out.println("\n--- RESULTADO DO CÁLCULO ---");
        System.out.println(pessoa.exibirPerfil());
        System.out.println("Resultado -> IMC: " + String.format("%.2f", imc) + " (" + classificacao + ")");
        System.out.println("----------------------------");
    }

    public void exibirHistorico() {
        historico.exibir();
    }
}
