package br.com.sidlar.rotstock.domain.equipamento;

public enum Memoria {
    QUINHENTOS_MB("512MB"),
    UM_GB("1GB"),
    DOIS_GB("2GB"),
    QUATRO_GB("4GB"),
    OITO_GB("8GB");

    String descricao;

    Memoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
