package br.com.sidlar.bruno.domain.equipamento;

public class Impressora extends Equipamento{
    private Boolean colorida;

    private enum TipoImpressora {
        LASER("Laser"),
        JATO_TINTA("Jato de Tinta"),
        MATRICIAL_NF("Matricial Nota Fiscal"),
        MATRICIAL_CHEQUE("Matricial Cheque"),
        TERMICA("Termica");

        private String descricao;

        TipoImpressora(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    private TipoImpressora tipoImpressora;
}
