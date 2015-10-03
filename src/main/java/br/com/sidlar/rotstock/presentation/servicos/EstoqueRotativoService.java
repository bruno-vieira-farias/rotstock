package br.com.sidlar.rotstock.presentation.servicos;

import br.com.sidlar.rotstock.domain.equipamento.EquipamentoEspecificacao;
import br.com.sidlar.rotstock.domain.equipamento.EquipamentoService;
import br.com.sidlar.rotstock.presentation.formularios.ItemEstoqueRotativoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstoqueRotativoService {
    @Autowired
    private EquipamentoService equipamentoService;

    public ItemEstoqueRotativoForm buscaPorSerialEquipamento(String serial) {
        EquipamentoEspecificacao equipamentoEspecificacao = equipamentoService.buscaPorSerial(serial);
        if (equipamentoEspecificacao != null) {
            return null;
        }
        return null;
    }








}
