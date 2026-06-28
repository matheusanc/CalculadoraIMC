public interface CalculadoraIMC {
    /** Contrato para calcular e retornar o valor numérico do IMC. */
    double calcularIMC(double peso, double altura);

    /** Contrato para retornar a classificação textual a partir do IMC baseado no perfil. */
    String classificarIMC(double imc);
}
