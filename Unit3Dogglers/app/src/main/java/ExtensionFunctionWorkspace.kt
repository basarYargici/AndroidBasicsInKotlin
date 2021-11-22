class Square(private val a: Int, private val b: Int) {
    fun area() = a * b
    override fun toString(): String {
        return "Square(a=$a, b=$b) and area=${area()}"
    }

}

fun main() {

    val shapes = listOf<Square>(Square(1, 1), Square(1, 2), Square(1, 3))

//    val bigShapes: List<Square> = shapes.filter { square -> square.area() >= 2 }
//
//    bigShapes.forEach { it -> println(it.area()) }

    shapes.areaFilter { it.area() >= 2 }
}

fun List<Square>.customFilter(filterFunction: (Square) -> (Boolean)): MutableList<Square> {
    val l = mutableListOf<Square>()
    for (square in this) {
        if (filterFunction(square)) l.add(square)
    }
    return l
}

fun List<Square>.areaFilter(areaFunction: (Square) -> (Boolean)) {
    customFilter(areaFunction).forEach { square -> println(square.toString()) }
}
