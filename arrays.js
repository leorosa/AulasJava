const prompt = require('prompt-sync')()

const frutas = ['Amora']
frutas.push('maçã')
//frutas.shift() // remove primeiro
//frutas.pop() // remove último

//let fruta = ''
while (true) {
    fruta = prompt('informe uma fruta: ')
    if (fruta=='') { break } // é mais eficiente sempre acrescentar, e depois remover o último
    frutas.push(fruta)    
}

console.log(frutas)