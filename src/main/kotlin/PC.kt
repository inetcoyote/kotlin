open class PC (override val manufacturer: String, override val model: String) : Device {
    open fun installDocker(){
        "sudo apt-get docker".prettyPrint()
    }
}