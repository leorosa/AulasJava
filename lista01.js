// 1

function exercicio01() {
    numero = 10
    console.log(numero)
}

function exercicio02() {
    nome = 'Leonardo'
    idade = 48
    altura = 1.80
    console.log(nome)
    console.log(idade)
    console.log(altura)
}

function exercicio03() {
    i1 = 2
    i2 = 1
    console.log(i1+i2)
}

function exercicio04() {
    preco = 90.90
    console.log('o preço do produto é R$'+preco)
}

// Import the readline module
const readline = require('readline');

// Create an interface for reading input and writing output
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function exercicio05() {
// Ask the user for input
    rl.question('informe seu nome: ', (name) => {
        console.log('olá ' + name);
// Close the interface
    rl.close();
  });
}

function exercicio06() {
    rl.question('informe a sua idade: ', (idade) => {
        console.log( 'você terá ' + (Number(idade) + 10) + ' anos daqui a uma década.');
    rl.close();
    });
}

function exercicio07() {
    rl.question('informe um número: ', (num1) => {
        rl.question('informe outro número: ', (num2) => {
            console.log( (Number(num1)+Number(num2)) );
            rl.close();
        });    
    });
}

function exercicio08() {
    rl.question('informe um número: ', (numero) => {
        console.log('o dobro desse número é ' + (2*Number(numero)) );
    rl.close();
    });
}

exercicio08()