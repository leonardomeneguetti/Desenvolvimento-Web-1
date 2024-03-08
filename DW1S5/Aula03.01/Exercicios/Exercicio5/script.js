function calcularSegundos() {
    let horas, minutos, segundos, saida, resultado;

    horas = document.getElementById("horas").value;
    minutos = document.getElementById("min").value;
    segundos = document.getElementById("seg").value;
    resultado = document.getElementById("resultado");

    horas = parseInt(horas);
    minutos = parseInt(minutos);
    segundos = parseInt(segundos);

    saida = horas * 3600 + minutos * 60 + segundos;

    resultado.value = horas + " horas, " + minutos + " minutos e " + segundos + " segundos são " + saida + " segundos."
}