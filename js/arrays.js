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
frutas.splice(1,0,'abacaxi') // usa splice para inserir 'abacaxi' na posição 1 (remove 0 items)
frutas.splice(0,1) // remove 1 item a partir do elemento 0
console.log(frutas.includes('maçã')) // checar se array contém elemento

console.log(frutas)
