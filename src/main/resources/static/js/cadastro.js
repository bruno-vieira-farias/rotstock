function validaForm() {
    $('form :input:hidden').not("input[name='_csrf']").attr("disabled", true);
    return true;
}
$(window).load(function() {
    var selectedContainerClass =  $("#tipo-equipamento").find("option:selected").data("container-class");
    $("." + selectedContainerClass).addClass("mostra");
    $("#msg-salvar").delay(8000).fadeOut(900);
});
$(function () {
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
});

$(function () {
    $("#fabricante").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-fabricante").replaceWith("");
    });
});

$(function () {
    $("#proprietario").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-proprietario").replaceWith("");
    });
});

$(function () {
    $("#local").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-local").replaceWith("");
    });
});

$(function () {
    $("#tipo-equipamento").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-tipo-equipamento").replaceWith("");
    });
});

$(function () {
    $("#tipo-conexao").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-tipo-conexao").replaceWith("");
    });
});

$(function () {
    $("#polegada").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-polegadas").replaceWith("");
    });
});

$(function () {
    $("#processador").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-processador").replaceWith("");
    });
});

$(function () {
    $("#memoria").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-memoria").replaceWith("");
    });
});
$(function () {
    $("#hd").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-hd").replaceWith("");
    });
});
$(function () {
    $("#tipo-impressora").change(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-tipo-impressora").replaceWith("");
    });
});

$(function () {
    $("#serial").keypress(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-serial").replaceWith("");
    });
});
$(function () {
    $("#modelo").keypress(function(){
        $(this).closest("div").removeClass("has-error");
        $("#msn-validacao-modelo").replaceWith("");
    });
});

$(function () {
    $("[name='colorida']").change(function(){
        $(this).parents("div").removeClass("has-error");
        $("#msn-validacao-cor").replaceWith("");
    });
});
$(function () {
    $("[name='semFio']").change(function(){
        $(this).parents("div").removeClass("has-error");
        $("#msn-validacao-sem-fio").replaceWith("");
    });
});

$(function () {
    $("[name='ip']").change(function(){
        $(this).parents("div").removeClass("has-error");
        $("#msn-validacao-ip").replaceWith("");
    });
});
