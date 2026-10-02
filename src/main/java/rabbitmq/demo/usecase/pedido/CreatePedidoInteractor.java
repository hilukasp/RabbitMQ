package rabbitmq.demo.usecase.pedido;

import rabbitmq.demo.domain.pedido.Pedido;
import rabbitmq.demo.domain.pedido.PedidoPublisher;

public class CreatePedidoInteractor implements CreatePedidoUseCase {
    private final PedidoPublisher pedidoPublisher;

    public CreatePedidoInteractor(PedidoPublisher pedidoPublisher) {
        this.pedidoPublisher = pedidoPublisher;
    }

    @Override
    public Response execute(Command command) {
        Pedido pedido = Pedido.create(
                command.nome_cliente(),
                command.gt_hr_pedido(),
                command.gt_hr_pronto(),
                command.valor_total(),
                command.id_status(),
                command.id_funcionario());

        pedidoPublisher.publish(pedido);

        return new Response(
                pedido.getNome_cliente(),
                pedido.getGt_hr_pedido(),
                pedido.getGt_hr_pronto(),
                pedido.getValor_total(),
                pedido.getId_status(),
                pedido.getId_funcionario()
        );
    }
}
