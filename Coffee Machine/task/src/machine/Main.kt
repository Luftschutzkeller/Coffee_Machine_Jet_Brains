package machine

var water = 400
var milk = 540
var beans = 120
var cups = 9
var money = 550

fun main() {
    do {
        println("\nWrite action (buy, fill, take, remaining, exit)")
        var input = readLine()!!

        when (input) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> print()
        }
    } while (input != "exit")
}

fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")

    when (readLine()!!) {
        "1" -> makeCoffee(250, 0, 16, 4)
        "2" -> makeCoffee(350, 75, 20, 7)
        "3" -> makeCoffee(200, 100, 12, 6)
    }
}

fun makeCoffee(waterNeed: Int, milkNeed: Int, beansNeed: Int, price: Int) {
    if (water >= waterNeed &&
        milk >= milkNeed &&
        beans >= beansNeed &&
        cups >= 1) {
        println("I have enough resources, making you a coffee!")
        water -= waterNeed
        milk -= milkNeed
        beans -= beansNeed
        money += price
        cups--
    } else {
        println("Sorry, not enough ingredients!")
    }
}

fun fill() {
    println("Write how many ml of water do you want to add:")
    water += readLine()!!.toInt()

    println("Write how many ml of milk do you want to add:")
    milk += readLine()!!.toInt()

    println("Write how many grams of coffee beans do you want to add:")
    beans += readLine()!!.toInt()

    println("Write how many disposable cups of coffee do you want to add:")
    cups += readLine()!!.toInt()
}

fun take() {
    println("I gave you $$money")
    money = 0
}

fun print() {
    println("""The coffee machine has:
$water of water
$milk of milk
$beans of coffee beans
$cups of disposable cups
$money of money""")
}