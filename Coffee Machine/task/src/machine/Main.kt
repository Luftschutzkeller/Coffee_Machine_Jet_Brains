package machine
import java.util.*

enum class Coffee(val water: Int, val milk: Int, val beans: Int, val price: Int) {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6),
}

enum class State() {
    CHOOSE_ACTION, BUY, FILL, WITHDRAW, SHOW_STATE, EXIT,
}

class CoffeeMachine(
    private var water: Int,
    private var milk: Int,
    private var beans: Int,
    private var cups: Int,
    private var money: Int,
) {
    private val scanner = Scanner(System.`in`)

    var state: State = State.CHOOSE_ACTION

    fun process() {
        state = when (state) {
            State.CHOOSE_ACTION -> chooseAction()
            State.BUY -> buy()
            State.FILL -> fill()
            State.WITHDRAW -> withdraw()
            State.SHOW_STATE -> showState()
            else -> throw RuntimeException("Unknown state")
        }
        println()
    }

    private fun chooseAction(): State {
        print("Write action (buy, fill, take, remaining, exit): ")

        return when (scanner.next()) {
            "buy" -> State.BUY
            "fill" -> State.FILL
            "take" -> State.WITHDRAW
            "remaining" -> State.SHOW_STATE
            "exit" -> State.EXIT
            else -> {
                println("Unknown action")
                State.CHOOSE_ACTION
            }
        }
    }

    private fun buy(): State {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
        when (scanner.next()) {
            "1" -> prepare(Coffee.ESPRESSO)
            "2" -> prepare(Coffee.LATTE)
            "3" -> prepare(Coffee.CAPPUCCINO)
        }

        return State.CHOOSE_ACTION
    }

    private fun prepare(drink: Coffee): State {
        if (haveEnoughSupplies(drink)) {
            --cups
            water -= drink.water
            milk -= drink.milk
            beans -= drink.beans
            money += drink.price
        }

        return State.CHOOSE_ACTION
    }

    private fun haveEnoughSupplies(drink: Coffee): Boolean {
        if (water < drink.water || milk < drink.milk || beans < drink.beans) {
            if (water < drink.water) println("Sorry, not enough water!")
            if (milk < drink.milk) println("Sorry, not enough milk!")
            if (beans < drink.beans) println("Sorry, not enough beans!")

            return false
        }

        println("I have enough resources, making you a coffee!")

        return true
    }

    private fun fill(): State {
        print("Write how many ml of water do you want to add: ")
        water += scanner.nextInt()

        print("Write how many ml of milk do you want to add: ")
        milk += scanner.nextInt()

        print("Write how many grams of coffee beans do you want to add: ")
        beans += scanner.nextInt()

        print("Write how many disposable cups of coffee do you want to add: ")
        cups += scanner.nextInt()

        return State.CHOOSE_ACTION
    }

    private fun withdraw(): State {
        println("I gave you \$$money").also { money = 0 }

        return State.CHOOSE_ACTION
    }

    private fun showState(): State {
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$beans of coffee beans")
        println("$cups of disposable cups")
        println("$money of money")
        println()

        return State.CHOOSE_ACTION
    }
}

fun main() = CoffeeMachine(400, 540, 120, 9, 550).run {
    do process() while (state != State.EXIT)
}
