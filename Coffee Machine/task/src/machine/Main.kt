package machine

fun takeMoney() {
    val moneyTotal = 550
    println("I gave you $$moneyTotal")
    println("The coffee machine has:\n" +
            "400 of water\n" +
            "540 of milk\n" +
            "120 of coffee beans\n" +
            "9 of disposable cups\n" +
            "0 of money")
}

fun fill() {
    println("Write how many ml of water do you want to add: ")
    val waterAdd = readLine()!!.toInt()
    println("Write how many ml of milk do you want to add: ")
    val milkAdd = readLine()!!.toInt()
    println("Write how many grams of coffee beans do you want to add: ")
    val beansAdd = readLine()!!.toInt()
    println("Write how many disposable cups of coffee do you want to add: ")
    val cupsAdd = readLine()!!.toInt()
    val waterTotal = 400 + waterAdd
    val milkTotal = 540 + milkAdd
    val beansTotal = 120 + beansAdd
    val cupsTotal = 9 + cupsAdd
    println("The coffee machine has:\n" +
            "$waterTotal of water\n" +
            "$milkTotal of milk\n" +
            "$beansTotal of coffee beans\n" +
            "$cupsTotal of disposable cups\n" +
            "550 of money")
}

fun buy() {
    val waterTotal = 400
    val milkTotal = 540
    val beansTotal = 120
    val cupsTotal = 9
    val moneyTotal = 550
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
    if (readLine()!!.toInt() == 1) {
        println("The coffee machine has:\n" +
                "${waterTotal - 250} of water\n" +
                "$milkTotal of milk\n" +
                "${beansTotal - 16} of coffee beans\n" +
                "${cupsTotal - 1} of disposable cups\n" +
                "554 of money")
    } else if (readLine()!!.toInt() == 2) {
        println("The coffee machine has:\n" +
                "${waterTotal - 350} of water\n" +
                "${milkTotal - 75} of milk\n" +
                "${beansTotal - 20} of coffee beans\n" +
                "${cupsTotal - 1} of disposable cups\n" +
                "557 of money")
    } else if (readLine()!!.toInt() == 3) {
        println("The coffee machine has:\n" +
                "${waterTotal - 200} of water\n" +
                "${milkTotal - 100} of milk\n" +
                "${beansTotal - 12} of coffee beans\n" +
                "${cupsTotal - 1} of disposable cups\n" +
                "556 of money")
    } else {
        println("wrong input")
    }

}

fun main() {
    println(
        "The coffee machine has:\n" +
                "400 of water\n" +
                "540 of milk\n" +
                "120 of coffee beans\n" +
                "9 of disposable cups\n" +
                "550 of money"
    )

    println("Write action (buy, fill, take): ")
    when (readLine()!!) {
        "buy" -> buy()
        "fill" -> fill()
        "take" -> takeMoney()
        else -> println("wrong input")
    }
}
