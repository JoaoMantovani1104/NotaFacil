function identificarAlternativas(lista) {
    const alternativas = [];
    lista.forEach(valor => {
        const alternativasQuestao = [];
        let alternativa = 1;
        while (valor > 0) {
            if (valor % 2 === 1) {
                alternativasQuestao.push(alternativa);
            }
            valor = Math.floor(valor / 2);
            alternativa *= 2;
        }
        alternativas.push(alternativasQuestao);
    });
    return alternativas;
}

module.exports = identificarAlternativas;