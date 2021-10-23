package machine

fun main() {
    val cups = readLine()!!.toInt()
    println("Write how many cups of coffee you will need: $cups")
    println("For $cups cups of coffee you will need:")
    println("${cups * 200} ml of water")
    println("${cups * 50} ml of milk")
    println("${cups * 15} g of coffee beans")
}
