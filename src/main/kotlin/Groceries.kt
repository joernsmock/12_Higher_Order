/* groceries */

data class Grocery(val name: String, val category: String,
                   val unit: String, val currency: String,
                   val unitPrice: Double, val quantity: Int)

fun main(args: Array<String>) {
    val groceries = listOf(Grocery("Tomatoe", "Vegetable", "lb","$", 3.0, 3),
            Grocery("Mushroom",  "Vegetable", "lb",     "$", 4.0,  1),
            Grocery("Bagel",     "Bakery",    "Pack",   "$", 1.49, 1),
            Grocery("Olive Oil", "Pantry",    "Bottle", "$", 5.99, 1),
            Grocery("Ice Cream", "Frozen",    "Piece",  "$", 2.49, 4)
    )
    // and different currencies?
    // => have them have a converter (just came up in the book!)
    for (g in groceries) {
        println("${g.quantity} ${g.unit} of ${g.name}:  ${g.currency}${g.unitPrice}")
    }
    println(
        "Together: ${groceries[0].currency}${groceries.sumByDouble{it.quantity * it.unitPrice}}"
    )
}