interface Device {
    val manufacturer: String
    val model: String

    fun deviceInfo() = "Информация об устройстве".prettyPrint()

    fun String.prettyPrint() {
        println("Manufacturer: $manufacturer, Model: $model")
        println(this)
        println()
    }
}