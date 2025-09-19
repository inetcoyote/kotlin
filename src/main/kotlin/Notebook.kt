class Notebook(override val manufacturer: String, override val model: String, private var battery: Int = 100): PC(manufacturer, model), Portable {
 override fun installDocker(){
       "Download & install DockerDesktop".prettyPrint()
 }
    override fun work() {
        battery -= 10
        "Notebook is working...".prettyPrint()
    }
    override fun charge() {
        battery = 100
        "Ноутбук заряжен до 100%".prettyPrint()
    }

    override fun batteryInfo() {
        "Battery level: $battery%".prettyPrint()
    }
}
