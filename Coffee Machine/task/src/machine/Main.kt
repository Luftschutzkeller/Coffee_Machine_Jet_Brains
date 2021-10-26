package machine

import java.util.*

var money = 550
var water = 400
var milk = 540
var beans = 120
var cups = 9

fun main(args: Array<String>) {
    var choice = 0
    machineHas()
    print("Write action (buy, fill, take): ")
    val scan = Scanner(System.`in`)
    val action = scan.nextLine()
    println()
    when (action) {
        "buy" -> {
            print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
            choice = scan.nextInt()
            println()
            when (choice) {
                1 -> {
                    water -= 250
                    beans -= 16
                    money += 4
                    cups -= 1
                }
                2 -> {
                    water -= 350
                    milk -= 75
                    beans -= 20
                    money += 7
                    cups -= 1
                }
                3 -> {
                    water -= 200
                    milk -= 100
                    beans -= 12
                    money += 6
                    cups -= 1
                }
            }
            machineHas()
        }
        "fill" -> {
            print("Write how many ml of water do you want to add: ")
            water += scan.nextInt()
            println()
            print("Write how many ml of milk do you want to add: ")
            milk += scan.nextInt()
            println()
            print("Write how many grams of coffee beans do you want to add: ")
            beans += scan.nextInt()
            println()
            print("Write how many disposable cups of coffee do you want to add: ")
            cups += scan.nextInt()
            println()
            machineHas()
        }
        "take" -> {
            println("I gave you $$money")
            money = 0
            machineHas()
        }
    }
}

fun machineHas() {
    println("The coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$beans of beans")
    println("$cups of disposable cups")
    println("$money money")
}
