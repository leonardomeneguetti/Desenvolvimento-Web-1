document.getElementById('mensagem').innerHTML = calcularGasto();

function calcularGasto() {
    let kml = 12, duracao = 2.5, velocidade = 95;
    let gasto = velocidade * duracao / kml;

    return "O gasto total de combustivel foi de " + gasto.toFixed(2) + " litros."
}