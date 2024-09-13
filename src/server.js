const express = require('express');
const bodyParser = require('body-parser');
const calcularNota = require('./calcularNota');

const app = express();
const port = 3000;

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.use(express.static('public'));

app.post('/calcularNota', (req, res) => {
    try {
        const notaFinal = calcularNota(req.body);
        res.json({ notaFinal: notaFinal });
    } catch (error) {
        res.status(500).json({ error: 'Erro ao calcular a nota' });
    }
});

app.listen(port, () => {
    console.log(`Servidor ouvindo na porta ${port}`);
});