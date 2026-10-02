package rabbitmq.demo.infraestructure.messaging;

import rabbitmq.demo.domain.pedido.Pedido;

import java.time.LocalDate;

public record PedidoMessage(
        String nome_cliente,
        LocalDate gt_hr_pedido,
        LocalDate gt_hr_pronto,
        Double valor_total,
        Integer id_status,
        Integer id_funcionario
) {
    public static PedidoMessage from(Pedido pedido) {
        return new PedidoMessage(
                pedido.getNome_cliente(),
                pedido.getGt_hr_pedido(),
                pedido.getGt_hr_pronto(),
                pedido.getValor_total(),
                pedido.getId_status(),
                pedido.getId_funcionario()
        );
    }
}
