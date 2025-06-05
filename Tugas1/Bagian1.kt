open class Shape {
    fun print() {
        
    }
}

class PersegiPanjang(val height: Double, val width: Double): Shape() {

    fun calcArea(): Double {
        return height * width
    }

    fun calcPerimeter(): Double {
        return (height + width) * 2
    }

    fun printDetails() {
        println("Panjang: $height")
        println("Lebar: $width")
        println("Luas: ${calcArea()}")
        println("Keliling: ${calcPerimeter()}")
    }
}

fun main() {
    val rectangle = PersegiPanjang(4.0, 2.0)
    rectangle.printDetails()
}
