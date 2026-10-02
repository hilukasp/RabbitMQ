package rabbitmq.demo.usecase.pedido;

import rabbitmq.demo.domain.pedido.Pedido;

public class ReceivePedidoInteractor implements ReceivePedidoUseCase {

    @Override
    public void execute(Command command) {
        Pedido pedido = Pedido.create(
                command.nome_cliente(),
                command.gt_hr_pedido(),
                command.gt_hr_pronto(),
                command.valor_total(),
                command.id_status(),
                command.id_funcionario());

        System.out.println(
                """
                    Pedido Recebido!
                        cliente: %s
                        pedido em: %s
                        pronto em: %s
                        valor total: %s
                        status: %d
                        funcionario: %d
                    """.formatted(
                        pedido.getNome_cliente(),
                        pedido.getGt_hr_pedido(),
                        pedido.getGt_hr_pronto(),
                        pedido.getValor_total(),
                        pedido.getId_status(),
                        pedido.getId_funcionario())
        );
    }
}
