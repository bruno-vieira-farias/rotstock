package br.com.sidlar.rotstock.domain.equipamento;

public enum TipoConexao {
    USB("USB"),
    PS2("PS2"),
    BLUETOOH("Bluetooh"),
    WIRELESS("Wireless");

    private String descricao;

    TipoConexao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
