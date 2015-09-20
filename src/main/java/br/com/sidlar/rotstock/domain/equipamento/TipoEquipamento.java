package br.com.sidlar.rotstock.domain.equipamento;

public enum TipoEquipamento {
    COMPUTADOR("Computador"),
    IMPRESSORA("Impressora"),
    MONITOR("Monitor"),
    TECLADO("Teclado"),
    MOUSE("Mouse"),
    LEITOR_CHEQUE("Leitor de Cheque"),
    TELEFONE("Telefone");

    private String descricao;

    TipoEquipamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}


