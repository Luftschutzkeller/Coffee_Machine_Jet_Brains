package machine

fun main() {

    val water = readLine()!!.toInt()
    println("Write how many ml of water the coffee machine has: $water")
    val milk = readLine()!!.toInt()
    println("Write how many ml of milk the coffee machine has: $milk")
    val beans = readLine()!!.toInt()
    println("Write how many grams of coffee beans the coffee machine has: $beans")
    val cups = readLine()!!.toInt()
    println("Write how many cups of coffee you will need: $cups")
    val a = water / 200
    val b = milk / 50
    val c = beans / 15
    var amount = 0
    amount += if ((b in c..a) || (a in c..b)) {
        c
    } else if ((c in b..a) || (a in b..c) ){
        b
    } else{
        a
    }

    val min: Int = if (a <= b && a <= c) {a} else if (b <= c && b <= a) {b} else {c}
    if (amount == cups) {
        println("Yes, I can make that amount of coffee")
    } else if (amount > cups) {
        println("Yes, I can make that amount of coffee (and even ${amount - cups} more than that)")
    } else if (amount < cups) {
        println("No, I can make only $min cups of coffee")
    }
}