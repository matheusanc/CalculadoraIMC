public class CalculadoraRecursiva {
    
    /**
     * Calcula base^exp usando recursão pura, sem Math.pow.
     */
    public static double potencia(double base, int exp) {
        if (exp == 0) return 1; // Caso-base
        return base * potencia(base, exp - 1); // Passo recursivo
    }

    /**
     * Função utilitária estática simples para fins de separação visual na CLI.
     */
    public static void imprimirDivisor() {
        System.out.println("--------------------------------------------------");
    }
}
