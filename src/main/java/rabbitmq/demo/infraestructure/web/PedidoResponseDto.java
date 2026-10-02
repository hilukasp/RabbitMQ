package rabbitmq.demo.infraestructure.web;

import java.time.LocalDate;

public record PedidoResponseDto(
        String nome_cliente,
        LocalDate gt_hr_pedido,
        LocalDate gt_hr_pronto,
        Double valor_total,
        Integer id_status,
        Integer id_funcionario
) {
}
