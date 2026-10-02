package rabbitmq.demo.usecase.pedido;

import java.time.LocalDate;

public interface ReceivePedidoUseCase {
    void execute(Command command);

    record Command(
            String nome_cliente,
            LocalDate gt_hr_pedido,
            LocalDate gt_hr_pronto,
            Double valor_total,
            Integer id_status,
            Integer id_funcionario) {
    }
}
