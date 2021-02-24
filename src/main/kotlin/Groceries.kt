/* groceries */

data class Grocery(val name: String, val category: String,
                   val unit: String, val currency: String,
                   val unitPrice: Int, val quantity: Int)

fun main(args: Array<String>) {
    val groceries = listOf(
            Grocery("Tomatoe",   "Vegetable", "lb",     "$", 299, 3),
            Grocery("Mushroom",  "Vegetable", "lb",     "$", 399,  1),
            Grocery("Bagel",     "Bakery",    "Pack",   "$", 149, 1),
            Grocery("Olive Oil", "Pantry",    "Bottle", "$", 599, 1),
            Grocery("Ice Cream", "Frozen",    "Piece",  "$", 249, 4)
    )
    // and different currencies?
    // => have them have a converter (just came up in the book!)
    // (is it good to have the currency as a string?)
    // (and, in what datatype should money be stored/calculated/printed)
    // (this looks ugly, but seems to work: money=cents, print bucks+cents)
    var cents: Int=0
    var bucks: Int=0
    for (g in groceries) {
        cents = g.quantity * g.unitPrice
        bucks = cents / 100
        cents = cents - (bucks * 100)
        println("${g.quantity} ${g.unit} of ${g.name}:  ${g.currency}${bucks}.${cents}")
    }

    var centsum = groceries.sumBy{it.quantity * it .unitPrice}
    val bucksum = centsum / 100
    centsum = centsum - (bucksum * 100)
    println(
        "Together: ${groceries[0].currency}${bucksum}.${centsum}"
    )
    val num=4.239
    println("${num}")

    groceries.groupBy { it.category }.forEach {
        println(it.key)
        it.value.forEach { println("        ${it.name}")}
    }
}