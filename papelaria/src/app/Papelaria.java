
package app;

import model.ItemPedido;

public class Papelaria {

    private static final double VALOR_FRETE = 12.90;
    private static final double VALOR_MINIMO_FRETE_GRATIS = 150.00;

    public static double calcularFrete(double valorItens) {
        if (valorItens >= VALOR_MINIMO_FRETE_GRATIS) {
            return 0.0;
        }

        return VALOR_FRETE;
    }

    public static void main(String[] args) {

        System.out.println("=== PAPELARIA PONTO FINAL ===\n");

        ItemPedido item1 = new ItemPedido(
            "Caderno 10 materias", 24.90, 1, false
        );

        ItemPedido item2 = new ItemPedido(
            "Lapis grafite", 1.50, 12, false
        );

        ItemPedido item3 = new ItemPedido(
            "Kit escolar basico", 84.00, 1, true
        );

        ItemPedido item4 = new ItemPedido(
            "Caneta azul", 2.80, 10, false
        );

        // Exibe os itens e calcula a soma
        item1.exibirLinha();
        item2.exibirLinha();
        item3.exibirLinha();
        item4.exibirLinha();

        double soma =
            item1.calcularValorLiquido() +
            item2.calcularValorLiquido() +
            item3.calcularValorLiquido() +
            item4.calcularValorLiquido();

        double frete = calcularFrete(soma);

        System.out.printf("%nItens:  R$ %.2f%n", soma);
        System.out.printf("Frete:  R$ %.2f%n", frete);
        System.out.printf("Total do pedido: R$ %.2f%n", soma + frete);
    }
}
