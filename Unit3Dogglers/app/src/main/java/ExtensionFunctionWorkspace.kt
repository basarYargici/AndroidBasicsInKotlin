import java.lang.reflect.Modifier.isAbstract

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
    shapes.customFilter { it.area() >= 2 }.forEach { println(it) }
    shapes.customGenericFilter { it.area() >= 2 }.forEach { println(it) }
    (1..5).toList().customGenericFilter { it > 2 }.forEach { println(it) }
}

fun <T> List<T>.customGenericFilter(filterFunction: (T) -> (Boolean)): MutableList<T> {
    val l = mutableListOf<T>()
    for (item in this) {
        if (filterFunction(item)) l.add(item)
    }
    return l
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
