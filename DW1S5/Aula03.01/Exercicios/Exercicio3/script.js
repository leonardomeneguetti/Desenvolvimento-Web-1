document.getElementById('mensagem').innerHTML = calcularIdade();

function calcularIdade() {
    let nasc = 2008, atual = 2024, anos, meses, dias, semanas;
    anos = atual - nasc;
    meses = anos * 12;
    dias = anos * 365;
    semanas = anos * 52;
    return "A pessoa tem " + anos + " anos, ou " + meses + " meses, ou " + dias + " dias ou " + semanas + " semanas";
}