package br.com.sidlar.rotstock.domain;

public enum ItemConsumo {
    MOUSE_PAD("Mouse Pad", 10),
    CD_R("CD-R", 10),
    DVD_R("DVD-R", 10),
    EXTENSAO_ELETRICA("Extensão Elétrica", 3),
    ESTABILIZADOR("Estabilizador", 3),
    FONTE("Fonte", 4),
    HD("HD", 4),
    PLACA_VIDEO("Placa de Vídeo", 3);

    private String descricao;
    private Integer quantidadeMinima;

    ItemConsumo(String descricao, Integer quantidadeMinima) {
        this.descricao = descricao;
        this.quantidadeMinima = quantidadeMinima;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getQuantidadeMinima() {
        return quantidadeMinima;
    }
}
