package br.com.sidlar.rotstock.domain.equipamento;

public enum TipoImpressora {
    LASER("Laser"),
    JATO_TINTA("Jato de Tinta"),
    MATRICIAL_NF("Matricial Nota Fiscal"),
    MATRICIAL_CHEQUE("Matricial Cheque"),
    TERMICA("Termica");

    private String descricao;

    TipoImpressora(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}