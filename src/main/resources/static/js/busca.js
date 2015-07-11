$(function () {
    atualizaCampo();
});
function atualizaCampo() {
    $("#serial").on("focusout", function () {
        if ($("#serial").val() == '') {
            $("#tipo-equipamento").prop("disabled", false);
            $("#local").prop("disabled", false);
        } else {
            $("#tipo-equipamento").prop("disabled", true);
            $("#tipo-equipamento option:eq(0)").prop("selected",true);
            $("#local").prop("disabled", true);
            $("#local option:eq(0)").prop("selected",true);
        }
    });
}
function preparaModel(botao) {
    var idEquipamento = (botao.closest("td").find("input")).val()
    $("#sim-modal").val(idEquipamento);
    $("#confirma-exclusao").modal();
};