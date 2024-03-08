document.getElementById('mensagem').innerHTML = calcularMediaFinal();

function calcularMediaFinal() {
    let n1 = 9, n2 = 7.5, media;
    media = n1 * 0.3 + n2 * 0.7;
    return "A média final é " + media.toFixed(2);
}