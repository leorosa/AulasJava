const prompt = require('prompt-sync')()

function exercicio01() {
    numero = prompt('informe um número: ')
    if (numero%2==0) {
        console.log('número par');
    } else {
        console.log('número ímpar');
    }
}

function exercicio02() {
    num1 = prompt('informe um número: ')
    num2 = prompt('informe outro número: ')
    if (num1>num2) {
        console.log( num1 + ' é o maior número' );
    } else {
        console.log( num2 + ' é o maior número' );
    }
}

function exercicio03() {
    numero = prompt('informe um número: ')
    if (numero==0) {
        console.log('número nulo');
    } else if (numero%2==0) {
        console.log('número par');
    } else {
        console.log('número ímpar');
    }
}

function exercicio04() {
    numero = prompt('informe a nota: ')
    if (numero>=6) {
        console.log('Aprovado');
    } else {
        console.log('Reprovado');
    }
}

function exercicio05() {
    idade = prompt('informe a idade: ')
    if (idade>=16) {
        console.log('já pode votar');
    } else { 
        console.log('dsa');
    }
}

function max3(valor1, valor2, valor3) {
    if (valor1>valor2) {
        if (valor1>valor3) return valor1
        else return valor3
    } else {
        if (valor2>valor3) return valor2
        else return valor3
    }
}

function exercicio06() {
    v1 = prompt('informe um número: ')
    v2 = prompt('informe outro número: ')
    v3 = prompt('informe mais um número: ')
    console.log( max3(Number(v1), Number(v2), Number(v3)) )
}

exercicio06()