data class IndeksNilaiMatkul(
	val nrp: String,
	val nama: String,
	val ipk Double? = null
)

fun Int?.toAbjad(): String {
    return when {
        this == null -> "Nilai harus diisi"
        this in 80..100 -> "A"
        this in 70..79 -> "AB"
        this in 60..69 -> "B"
        this in 50..59 -> "BC"
        this in 40..49 -> "C"
        this in 30..39 -> "D"
        this in 20..29 -> "E"
        this in 101..500 -> "Nilai di luar jangkauan"
        else -> "Nilai di luar jangkauan"
    }
}

fun main() {
    val inm = IndeksNilaiMatkul(nama = "Budi", nrp = "001")
    println("NRP: ${inm.nrp}")
    println("Nama: ${inm.nama}")
    inm.ipk?.let {
        println("IPK: $it")
    }
    
    //Example of grade conversions
    val scores = listOf(77, 110, 25, 45, null)
    scores.forEach { score -> 
        val grade = score.toAbjad()
        println("Nilai $score: $grade")
    }
}
