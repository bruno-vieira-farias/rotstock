package br.com.sidlar.bruno.domain.equipamento;


import org.joda.time.DateTime;

public class Equipamento {
    private String serial;
    private String fabricante;
    private String modelo;
    private DateTime dataAquisicao;
    private DateTime dataDesativacao;

    private enum Proprietario {
        SIDLAR("Sid lar"),
        VIVO("Vivo");

        private String descricao;

        Proprietario(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
