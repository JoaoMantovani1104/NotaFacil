function lerValores(body, prefixo) {
    const lista = [];
    for (let i = 1; i <= 50; i++) {
        const valor = body[`${prefixo}${i}`];
        lista.push(parseInt(valor) || 0);
    }
    return lista;
}

module.exports = lerValores;