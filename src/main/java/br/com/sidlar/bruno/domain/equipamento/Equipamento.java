package br.com.sidlar.bruno.domain.equipamento;

import br.com.sidlar.bruno.domain.Local;
import org.joda.time.DateTime;

public class Equipamento {
    private String serial;
    private String fabricante;
    private String modelo;
    private DateTime dataAquisicao;
    private DateTime dataDesativacao;
    private Local local;

    private enum Proprietario {
        SIDLAR("Sidlar"),VIVO("Vivo");

        private String descricao;

        Proprietario(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
