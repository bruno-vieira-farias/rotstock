package br.com.sidlar.bruno.domain;

public enum ItemConsumo {
    MOUSE_PAD("Mouse Pad"),
    CD_R("CD-R"),
    DVD_R("DVD-R"),
    EXTENSAO_ELETRICA("Extensão Elétrica"),
    ESTABILIZADOR("Estabilizador"),
    FONTE("Fonte"),
    HD("HD"),
    PLACA_VIDEO("Placa de Vídeo");

    private String descricao;

    ItemConsumo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
