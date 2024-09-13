function verificar(alternativasGabarito, alternativasResposta) {
    return alternativasResposta.length <= alternativasGabarito.length &&
        alternativasResposta.every(resposta => alternativasGabarito.some(alt => alt.includes(resposta)));
}

module.exports = verificar;
