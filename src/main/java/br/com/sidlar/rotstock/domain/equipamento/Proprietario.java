package br.com.sidlar.rotstock.domain.equipamento;

public enum Proprietario {
    SIDLAR("Sidlar"), VIVO("Vivo");

    private String descricao;

    Proprietario(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}
