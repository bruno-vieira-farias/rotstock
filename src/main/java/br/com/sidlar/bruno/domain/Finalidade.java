package br.com.sidlar.bruno.domain;

public enum Finalidade {
    MAQUINA_PEDIDO      ("Maquina Pedido"       ,2),
    MAQUINA_BASE        ("Maquina Base"         ,2),
    SERVIDOR_LOJA       ("Servidor Loja"        ,1),
    IMPRESSORA_CAIXA    ("Impressora Caixa"     ,2),
    IMPRESSORA_PROJETO  ("Impressora Projeto"   ,4),
    IMPRESSORA_CHEQUE   ("Impressora Cheque"    ,2),
    LEITOR_CHEQUE       ("Leitor Cheque"        ,2),
    MONITOR_PEDIDO      ("Monitor Pedido"       ,2),
    MONITOR_PROJETO     ("Monitor Projeto"      ,2);

    private String descricao;
    private Integer quantidadeMinima;


    Finalidade(String descricao,Integer quantidadeMinima){
        this.descricao = descricao;
        this.quantidadeMinima = quantidadeMinima;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getQuantidadeMinima() {
        return quantidadeMinima;
    }
}


