package br.com.sidlar.bruno.domain.equipamento;

public class Monitor extends Equipamento{
    private enum Polegadas{
        QUINZE("15"),
        DEZESSETE("17"),
        DEZOITO("15"),
        VINTE_DOIS("15");

        private String descricao;

        Polegadas(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    private Polegadas polegadas;
}
