package br.com.sidlar.rotstock.domain;

public enum StatusItemEstoqueRotativo {
    EM_AVALIACAO("Em avalia��o"),
    AGUARDANDO_PECA("Aguardando_Pe�a"),
    PRONTO("Pronto");

    private String descricao;

    StatusItemEstoqueRotativo(String descricao){
            this.descricao = descricao;
        }

    public String getDescricao() {
            return descricao;
        }
}
