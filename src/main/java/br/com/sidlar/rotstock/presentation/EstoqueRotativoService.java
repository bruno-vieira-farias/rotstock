package br.com.sidlar.rotstock.presentation;

import br.com.sidlar.rotstock.domain.ItemEstoqueRotativo;
import br.com.sidlar.rotstock.domain.equipamento.EquipamentoModel;
import br.com.sidlar.rotstock.domain.equipamento.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstoqueRotativoService {
    @Autowired
    private EquipamentoService equipamentoService;

    public ItemEstoqueRotativoForm buscaPorSerialEquipamento(String serial) {
        EquipamentoModel equipamentoModel = equipamentoService.buscaPorSerial(serial);
        if (equipamentoModel != null) {
            return null;
        }
        return null;
    }








}
