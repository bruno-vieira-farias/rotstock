package br.com.sidlar.rotstock.domain.equipamento;

public enum Fabricante {
    AOC("AOC"),
    DELL("Dell"),
    ELGIN("Elgin"),
    EPSON("Epson"),
    HP("Hp"),
    INTELBRAS("Intelbras"),
    LENOVO("Lenovo"),
    SANSUNG("Sansung"),
    SIEMENS("Siemens"),
    TOSHIBA("Semp Toshiba"),
    GENERICO("Generico");

    private String descricao;

    Fabricante(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
