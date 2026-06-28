/**
 * Escolha de Design: RuntimeException (Unchecked)
 * Justificativa: Evita poluição de assinaturas com cláusulas 'throws' no fluxo da CLI
 * e simplifica a captura centralizada no loop de controle do Menu do programa.
 */
public class EntradaInvalidaException extends RuntimeException {
    public EntradaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
