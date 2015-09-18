package br.com.sidlar.rotstock.domain;

public enum StatusItemEstoqueRotativo {
    EM_AVALIACAO("Em avaliação"),
    AGUARDANDO_PECA("Aguardando_Peça"),
    PRONTO("Pronto");

    private String descricao;

    StatusItemEstoqueRotativo(String descricao){
            this.descricao = descricao;
        }

    public String getDescricao() {
            return descricao;
        }
}
