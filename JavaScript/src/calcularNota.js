const identificarAlternativas = require('./identificarAlternativas');
const verificar = require('./verificarRespostas');
const lerValores = require('./lerValores');

function calcularNota(reqBody) {
    const gabarito = lerValores(reqBody, 'gabarito');
    const respostas = lerValores(reqBody, 'resposta');

    const alternativasGabarito = identificarAlternativas(gabarito);
    const alternativasResposta = identificarAlternativas(respostas);

    let notaFinal = 0;
    const valorQuestao = 6.0;

    alternativasGabarito.forEach((gabaritoQuestao, i) => {
        if (verificar(gabaritoQuestao, alternativasResposta[i])) {
            const numAlternativasCorretas = alternativasResposta[i].filter(resposta => gabaritoQuestao.includes(resposta)).length;
            const totalAlternativasCorretas = gabaritoQuestao.length;
            const notaQuestao = valorQuestao * (numAlternativasCorretas / totalAlternativasCorretas);
            notaFinal += notaQuestao;
        }
    });

    return notaFinal;
}

module.exports = calcularNota;
