window.onload = iniciarPagina;

function iniciarPagina() {
    document.getElementById("form").onsubmit = function() {
        return validarSenha();
    }
    document.getElementById("form").noValidate = true;
}

function validarSenha() {
    let senha = document.getElementById("password");
    let senhaConf = document.getElementById("passwordconf");

    if(!(senha.value == senhaConf.value)){
        alert("As senhas devem ser iguais.")
        senhaConf.setCustomValidity("Vai se fuder.")
        return false;
    }
    return true;
}