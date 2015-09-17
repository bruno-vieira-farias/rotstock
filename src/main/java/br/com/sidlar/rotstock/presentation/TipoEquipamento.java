package br.com.sidlar.rotstock.presentation;

public enum TipoEquipamento {
    COMPUTADOR("Computador","equipamento-computador"),
    IMPRESSORA("Impressora","equipamento-impressora"),
    MONITOR("Monitor","equipamento-monitor"),
    TECLADO("Teclado","equipamento-teclado"),
    MOUSE("Mouse","equipamento-mouse"),
    LEITOR_CHEQUE("Leitor de Cheque","equipamento-leitor_cheque"),
    TELEFONE("Telefone","equipamento-telefone");

    private String descricao;
    private String categoria;

    TipoEquipamento(String descricao,String categoria) {
        this.categoria = categoria;
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getCategoria() {
        return categoria;
    }
}

