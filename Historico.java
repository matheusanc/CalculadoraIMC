import java.util.ArrayList;
import java.util.List;

public class Historico {
    private List<String> registros = new ArrayList<>();

    public void adicionar(String registro) {
        registros.add(registro);
    }

    public void exibir() {
        if (registros.isEmpty()) {
            System.out.println("\n[Histórico] Nenhum cálculo registrado nesta sessão.");
            return;
        }
        System.out.println("\n========== HISTÓRICO DE CÁLCULOS ==========");
        for (String registro : registros) {
            System.out.println(registro);
        }
        System.out.println("===========================================");
    }
}
