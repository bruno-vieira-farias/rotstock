package br.com.sidlar.bruno.domain;

public enum Finalidade {
    MAQUINA_PEDIDO("Maquina Pedido"),
    MAQUINA_BASE("Maquina Base"),
    SERVIDOR_LOJA("Servidor Loja"),
    IMPRESSORA_CAIXA("Impressora Caixa"),
    IMPRESSORA_PROJETO("Impressora Projeto"),
    IMPRESSORA_CHEQUE("Impressora Cheque"),
    LEITOR_CHEQUE("Leitor Cheque"),
    MONITOR_PEDIDO("Monitor Pedido"),
    MONITOR_PROJETO("Monitor Projeto");

    private String descricao;


    Finalidade(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}


