package br.com.sidlar.rotstock.domain.equipamento;

public enum Polegadas {
    QUINZE("15"),
    DEZESSETE("17"),
    DEZOITO("18"),
    VINTE_DOIS("22");

    private String descricao;

    Polegadas(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}