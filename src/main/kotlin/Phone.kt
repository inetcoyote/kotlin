class Phone(override val manufacturer: String, override val model: String, private var battery: Int = 100): Device, Portable {
    override fun work() {
        battery -= 20
        "Phone is working...".prettyPrint()
    }
    override fun charge() {
        battery = 100
        "Телефон заряжен до 100%".prettyPrint()
    }

    override fun batteryInfo() {
        "Battery level: $battery%".prettyPrint()
    }
}