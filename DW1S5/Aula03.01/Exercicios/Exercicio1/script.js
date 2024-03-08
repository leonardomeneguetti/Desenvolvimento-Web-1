document.getElementById('mensagem').innerHTML = calcularSalarioFinal();

function calcularSalarioFinal() {
    let salarioFinal = 1500 + (10000 * 0.04);
    return "O salário final é de " + salarioFinal;
}