package br.com.sidlar.rotstock.domain;

public enum StatusItemEstoqueRotativo {
    EM_AVALIACAO("Em avaliacao"),
    AGUARDANDO_PECA("Aguardando_Peca"),
    PRONTO("Pronto");

    private String descricao;

    StatusItemEstoqueRotativo(String descricao){
            this.descricao = descricao;
        }

    public String getDescricao() {
            return descricao;
        }
}
