function calcularTempo() {
    let horas, minutos, segundos, entrada, resultado, resto;

    entrada = document.getElementById("seg").value;
    resultado = document.getElementById("resultado");

    entrada = parseInt(entrada);

    if(entrada > 0){
        horas = Math.floor(entrada/3600);
        resto = entrada%3600;
        minutos = Math.floor(resto/60);
        segundos = resto%60;
        resultado.value = entrada + " segundos são " + horas + " horas, " + minutos + " minutos e " + segundos + " segundos."
    } else {
        resultado.value = "O numero de segundos tem que ser positivo."
    }
}