const fruits = new Map();

// Set Map Values
fruits.set("apples", 500);
fruits.set("bananas", 300);
fruits.set("oranges", 200);

strFruits = JSON.stringify(Array.from(fruits.entries()))
console.log(strFruits);

recFruits = new Map(JSON.parse(strFruits))
console.log(recFruits)
