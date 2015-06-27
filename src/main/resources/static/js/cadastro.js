$(function (){
    validaForm();
    geraVisualizacaoFormulario();
    atualizaVisualizaoFormulario();
    removeMensagemErroFabricante();
    removeMensagemErroColorida();
    removeMensagemErroHd();
    removeMensagemErroIp();
    removeMensagemErroLocal();
    removeMensagemErroMemoria();
    removeMensagemErroModelo();
    removeMensagemErroPolegada();
    removeMensagemErroProcessador();
    removeMensagemErroProprietario();
    removeMensagemErroTipoEquipamento();
    removeMensagemErroTipoTipoConexao();
    removeMensagemErroTipoImpressora();
    removeMensagemErroSerial();
    removeMensagemErroSemFio();
});

function validaForm() {
    $('form :input:hidden').not("input[name='_csrf']").attr("disabled", true);
    return true;
};

function geraVisualizacaoFormulario(){
    var selectedContainerClass =  $("#tipo-equipamento").find("option:selected").data("container-class");
    $("." + selectedContainerClass).addClass("mostra");
    $("#msg-salvar").delay(8000).fadeOut(900);
};

function atualizaVisualizaoFormulario(){
    $("#tipo-equipamento").change(function(){
        var $tipoEquipamento = $(this);
        $tipoEquipamento.prop('disabled', true);
        var selectedContainerClass = $(this).find("option:selected").data("container-class");
        var nenhumVisivel = $("[class*='equipamento-']:visible").length == 0;
        if(nenhumVisivel) {
            $("." + selectedContainerClass).fadeIn(500);
            $tipoEquipamento.prop('disabled', false);
            $tipoEquipamento.focus();
            return;
        }
        $("[class*='equipamento-']:visible").fadeOut(1 , function(){
            $("." + selectedContainerClass).fadeIn(500);
            $tipoEquipamento.prop('disabled', false);
            $tipoEquipamento.focus();
        });
    });
};

function removeMensagemErroFabricante(){
    $("#fabricante").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-fabricante").replaceWith("");
    });
};

function removeMensagemErroProprietario() {
    $("#proprietario").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-proprietario").replaceWith("");
    });
};

function removeMensagemErroLocal() {
    $("#local").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-local").replaceWith("");
    });
};

function removeMensagemErroTipoEquipamento() {
    $("#tipo-equipamento").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-tipo-equipamento").replaceWith("");
    });
}

function removeMensagemErroTipoTipoConexao() {
    $("#tipo-conexao").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-tipo-conexao").replaceWith("");
    });
}
function removeMensagemErroPolegada() {
    $("#polegada").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-polegadas").replaceWith("");
    });
};

function removeMensagemErroProcessador() {
    $("#processador").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-processador").replaceWith("");
    });
};

function removeMensagemErroMemoria() {
    $("#memoria").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-memoria").replaceWith("");
    });
};

function removeMensagemErroHd() {
    $("#hd").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-hd").replaceWith("");
    });
};

function removeMensagemErroTipoImpressora() {
    $("#tipo-impressora").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-tipo-impressora").replaceWith("");
    });
};

function removeMensagemErroSerial() {
    $("#serial").keypress(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-serial").replaceWith("");
    });
};

function removeMensagemErroModelo() {
    $("#modelo").keypress(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-modelo").replaceWith("");
    });
};

function removeMensagemErroColorida() {
    $("[name='colorida']").change(function(){
        $(this).parents("div").removeClass("has-error");
        $("#msn-validacao-cor").replaceWith("");
    });
};

function removeMensagemErroSemFio() {
    $("[name='semFio']").change(function(){
        $(this).parents("div").removeClass("has-error");
        $("#msn-validacao-sem-fio").replaceWith("");
    })
};

function removeMensagemErroIp() {
    $("[name='ip']").change(function(){
        $(this).parents("div").removeClass("has-error");
        $("#msn-validacao-ip").replaceWith("");
    });
};