package rabbitmq.demo.infraestructure.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rabbitmq.demo.usecase.pedido.CreatePedidoUseCase;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final CreatePedidoUseCase createPedidoUseCase;

    public PedidoController(CreatePedidoUseCase createPedidoUseCase) {
        this.createPedidoUseCase = createPedidoUseCase;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> post(@RequestBody PedidoRequestDto dto) {
        CreatePedidoUseCase.Response response = createPedidoUseCase.execute(
                new CreatePedidoUseCase.Command(
                        dto.nome_cliente(),
                        dto.gt_hr_pedido(),
                        dto.gt_hr_pronto(),
                        dto.valor_total(),
                        dto.id_status(),
                        dto.id_funcionario()));

        PedidoResponseDto pedidoResponseDto = new PedidoResponseDto(
                response.nome_cliente(),
                response.gt_hr_pedido(),
                response.gt_hr_pronto(),
                response.valor_total(),
                response.id_status(),
                response.id_funcionario()
        );

        return ResponseEntity.accepted().body(pedidoResponseDto);
    }
}
