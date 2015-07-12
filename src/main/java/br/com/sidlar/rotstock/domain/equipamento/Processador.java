package br.com.sidlar.rotstock.domain.equipamento;

public enum Processador {
    CORE_2_DUO("Core 2 Duo"),
    DUAL_CORE("Dual Core"),
    I3("i3"),
    I5("i5"),
    I7("i7"),
    PENTIUM_4("Pentium 4");

    String Descricao;

    Processador(String descricao) {
        Descricao = descricao;
    }
    public String getDescricao() {
        return Descricao;
    }
}
