package rabbitmq.demo.domain.pedido;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pedido {
    public Integer id;
    public String nome_cliente;
    public LocalDate gt_hr_pedido;
    public LocalDate gt_hr_pronto;
    public Double valor_total;
    public Integer id_status;
    public Integer id_funcionario;

    public static Pedido create(
            String nome_cliente,
            LocalDate gt_hr_pedido,
            LocalDate gt_hr_pronto,
            Double valor_total,
            Integer id_status,
            Integer id_funcionario
    ) {
        return new Pedido(null, nome_cliente, gt_hr_pedido, gt_hr_pronto, valor_total, id_status, id_funcionario);
    }

    public static Pedido reconstitute(
            Integer id,
            String nome_cliente,
            LocalDate gt_hr_pedido,
            LocalDate gt_hr_pronto,
            Double valor_total,
            Integer id_status,
            Integer id_funcionario
    ) {
        return new Pedido(id,  nome_cliente, gt_hr_pedido, gt_hr_pronto, valor_total, id_status, id_funcionario);
    }

    public Pedido(Integer id, String nome_cliente, LocalDate gt_hr_pedido, LocalDate gt_hr_pronto, Double valor_total, Integer id_status, Integer id_funcionario) {
        this.id = id;
        this.nome_cliente = nome_cliente;
        this.gt_hr_pedido = gt_hr_pedido;
        this.gt_hr_pronto = gt_hr_pronto;
        this.valor_total = valor_total;
        this.id_status = id_status;
        this.id_funcionario = id_funcionario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public LocalDate getGt_hr_pedido() {
        return gt_hr_pedido;
    }

    public void setGt_hr_pedido(LocalDate gt_hr_pedido) {
        this.gt_hr_pedido = gt_hr_pedido;
    }

    public LocalDate getGt_hr_pronto() {
        return gt_hr_pronto;
    }

    public void setGt_hr_pronto(LocalDate gt_hr_pronto) {
        this.gt_hr_pronto = gt_hr_pronto;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public Integer getId_status() {
        return id_status;
    }

    public void setId_status(Integer id_status) {
        this.id_status = id_status;
    }

    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
}
