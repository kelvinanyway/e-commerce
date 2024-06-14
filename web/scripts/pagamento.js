const form = document.getElementById("formPagamento");

form.addEventListener("submit", function (event) {
    const numeroCartao = document.getElementById("").value.trim();
    const cvc = document.getElementById("").value.trim();
    const validade = document.getElementById("").value.trim();
    const nomeCompleto = document.getElementById("").value.trim();


    if (numeroCartao === "" || cvc === "" || validade === "" || nomeCompleto === "") {
        event.preventDefault();
        alert("dados invalidos")
    } else {
        alert("compra concluida")
    }
});
$(document).ready(function () {
    $('#nCartao').mask('0000 0000 0000 0000');
    $('#cvc').mask('000');
    $('#validade').mask('00/00');

    $('#validade').on('keyup change', function () {
        const value = $(this).val();
        const parts = value.split('/');

        if (parts.length === 2) {
            const mes = parseInt(parts[0], 10);
            const ano = parseInt(parts[1], 10);

            if (mes >= 1 && mes <= 12 && ano >= 24) {
                $(this).css('border', '');

            } else {

                $(this).css('border', '2px solid red');
                alert("sua validade está incorreta")
            }
        }
    });
});


function mostrarPix() {
    $('#chavepix').removeClass('d-none').addClass('d-flex');
    $('#cartao').removeClass('d-flex').addClass('d-none');
}
function mostrarCartao() {
    $('#cartao').removeClass('d-none').addClass('d-flex');
    $('#chavepix').removeClass('d-flex').addClass('d-none');

}

