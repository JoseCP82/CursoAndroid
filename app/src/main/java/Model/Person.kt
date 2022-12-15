package Model

class Person (){

    private var id: Int = 0
    private var name: String = ""
    private var age: String = ""

    constructor(name: String, age: String) : this() {
        this.name=name
        this.age=age
    }

    fun getId():Int {
        return id;
    }

    fun getName():String {
        return name
    }

    fun getAge():String {
        return age
    }
}