package br.com.sidlar.rotstock.domain.equipamento;

public enum Hd {
    CENTO_VINTE("120GB"),
    CENTO_SESSENTA("160GB"),
    DUZENTOS_CINQUENTA("250GB"),
    QUINHENTOS("500GB"),
    MIL("1TB");

    private String descricao;

    Hd(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
