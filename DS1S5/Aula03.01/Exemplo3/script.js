function calculaTempo(horas, minutos, segundos) {
    let total;
    total = horas*3600 + minutos*60 + segundos;
    return total;
}

function principal() {
    let horas = parseInt(prompt('Horas:'));
    let minutos = parseInt(prompt('Minutos:'));
    let segundos = parseInt(prompt('Segundos:'));
    let retorno = calculaTempo(horas, minutos, segundos);
    alert('Tempo em segundos = ' + retorno);
}

principal();