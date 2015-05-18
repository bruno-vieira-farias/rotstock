package br.com.sidlar.bruno.domain.equipamento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Monitor")
public class Monitor extends Equipamento{
    private enum Polegadas{
        QUINZE("15"),
        DEZESSETE("17"),
        DEZOITO("18"),
        VINTE_DOIS("22");

        private String descricao;

        Polegadas(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    @Enumerated(EnumType.STRING)
    private Polegadas polegadas;
}
