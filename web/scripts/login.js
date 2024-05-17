const form = document.getElementById("formLogin");

form.addEventListener("submit", function (event) {
    const email = document.getElementById("inputE").value.trim();
    const senha = document.getElementById("inputS").value.trim();

    if (email === "" || senha === "") {
        event.preventDefault();
        alert("email ou senha estão faltando")
    } else {
        alert("Login feito com sucesso")
    }
});