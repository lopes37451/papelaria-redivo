
package model;

public class ItemPedido {

    private static final double DESCONTO_KIT = 0.15;
    private static final double DESCONTO_QUANTIDADE = 0.08;
    private static final int QUANTIDADE_MINIMA = 10;

    private String descricao;
    private double valorUnitario;
    private int quantidade;
    private boolean kit;

    public ItemPedido(String descricao, double valorUnitario,
                      int quantidade, boolean kit) {
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.kit = kit;
    }

    public double calcularValorBruto() {
        return valorUnitario * quantidade;
    }

    public double calcularDesconto() {
        if (kit) {
            return calcularValorBruto() * DESCONTO_KIT;
        } else if (quantidade >= QUANTIDADE_MINIMA) {
            return calcularValorBruto() * DESCONTO_QUANTIDADE;
        }

        return 0.0;
    }

    public double calcularValorLiquido() {
        return calcularValorBruto() - calcularDesconto();
    }

    public void exibirLinha() {
        System.out.printf(
            "%-20s %3d un | bruto R$ %7.2f | desc R$ %6.2f | R$ %7.2f%n",
            descricao,
            quantidade,
            calcularValorBruto(),
            calcularDesconto(),
            calcularValorLiquido()
        );
    }
}
