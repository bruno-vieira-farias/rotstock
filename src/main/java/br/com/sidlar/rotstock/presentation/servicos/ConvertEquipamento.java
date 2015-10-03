package br.com.sidlar.rotstock.presentation.servicos;

import br.com.sidlar.rotstock.domain.equipamento.EquipamentoEspecificacao;
import br.com.sidlar.rotstock.presentation.formularios.EquipamentoForm;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável pela conversão do objeto EquipamentoForm e EquipamentoEspecificacao, possibilitando a transiçãoo
 * deste objeto entre as camadas de dominio e apresentação
 */

@Component
class ConvertEquipamento {
    protected EquipamentoEspecificacao toEquipamentoModel(EquipamentoForm equipamentoForm) {
        return new EquipamentoEspecificacao(
                equipamentoForm.getEquipamentoEspecificacao().getId(),
                equipamentoForm.getEquipamentoEspecificacao().getSerial(),
                equipamentoForm.getEquipamentoEspecificacao().getFabricante(),
                equipamentoForm.getEquipamentoEspecificacao().getModelo(),
                equipamentoForm.getEquipamentoEspecificacao().getProprietario(),
                equipamentoForm.getEquipamentoEspecificacao().getIdLocal(),
                equipamentoForm.getEquipamentoEspecificacao().getLocal(),
                equipamentoForm.getEquipamentoEspecificacao().getTipoEquipamento(),
                equipamentoForm.getEquipamentoEspecificacao().getProcessador(),
                equipamentoForm.getEquipamentoEspecificacao().getMemoria(),
                equipamentoForm.getEquipamentoEspecificacao().getHd(),
                equipamentoForm.getEquipamentoEspecificacao().getColorida(),
                equipamentoForm.getEquipamentoEspecificacao().getTipoImpressora(),
                equipamentoForm.getEquipamentoEspecificacao().getPolegadas(),
                equipamentoForm.getEquipamentoEspecificacao().getTipoConexao(),
                equipamentoForm.getEquipamentoEspecificacao().getSemFio(),
                equipamentoForm.getEquipamentoEspecificacao().getIp()
        );
    }

    protected EquipamentoForm toEquipamentoForm(EquipamentoEspecificacao equipamentoEspecificacao) {
//        return new EquipamentoForm(
//                equipamentoEspecificacao.getId(),
//                equipamentoEspecificacao.getSerial(),
//                equipamentoEspecificacao.getFabricante(),
//                equipamentoEspecificacao.getModelo(),
//                equipamentoEspecificacao.getProprietario(),
//                equipamentoEspecificacao.getIdLocal(),
//                equipamentoEspecificacao.getLocal(),
//                equipamentoEspecificacao.getTipoEquipamento(),
//                equipamentoEspecificacao.getProcessador(),
//                equipamentoEspecificacao.getMemoria(),
//                equipamentoEspecificacao.getHd(),
//                equipamentoEspecificacao.getColorida(),
//                equipamentoEspecificacao.getTipoImpressora(),
//                equipamentoEspecificacao.getPolegadas(),
//                equipamentoEspecificacao.getTipoConexao(),
//                equipamentoEspecificacao.getSemFio(),
//                equipamentoEspecificacao.getIp(),
//                equipamentoEspecificacao.getInformacoesEspecificas()
//        );
        return null;
    }

    protected List<EquipamentoForm> toListOfEquipamentoForm(List<EquipamentoEspecificacao> listaEquipamentoEspecificacao) {
        List<EquipamentoForm> listaEquipamanentoForm =
                listaEquipamentoEspecificacao.stream()
                        .map(this::toEquipamentoForm)
                        .collect(Collectors.toList());
        return listaEquipamanentoForm;
    }
}
