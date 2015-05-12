package br.com.sidlar.bruno.domain.equipamento;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Impressora")
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

    @Enumerated(EnumType.STRING)
    private TipoImpressora tipoImpressora;
}
