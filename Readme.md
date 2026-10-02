docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin rabbitmq:4-management

http://localhost:15672

{
"nome_cliente": "Nome",
"gt_hr_pedido": "2026-10-02",
"gt_hr_pronto": "2026-10-02",
"valor_total": 67.90,
"id_status": 1,
"id_funcionario": 1
}
