package tw.edu.pu.s1114859.oop_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var txv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txv = findViewById(R.id.txv)
        txv.text = "物件導向實例"

        var result: String = ""
        var abap = Course("ABAP程式設計", "智慧企業")
        // abap.CourseTitle = "ABAP程式設計"
        //abap.CreditProgram = "智慧企業"
        // abap.SAP = true
        result += Course.Add() + abap.Display()
        //txv.text = result

        var app = Course("行動應用軟體開發", "人工智慧應用", false)
        //app.CourseTitle = "行動應用軟體開發"
        //app.CreditProgram = "人工智慧應用"
        //app.SAP = false
        var tcyang = Teacher("楊子青", "資管系")
        result += tcyang.Hello() + tcyang.Work()
        result += Course.Add() + app.Display()

        var George=Student("George","資管系")
        result += George.Hello()+George.Work()

        var McQueen=Car()
        var Kitty=Cat()
        result+=McQueen.Sound()+"\n"+Kitty.Sound()
        txv.text = result


    }

    class Course(
        var CourseTitle: String = "",
        var CreditProgram: String = "",
        var SAP: Boolean = true
    ) {
        init {
            this.CourseTitle = CourseTitle + "課程"
        }

        fun Display(): String {
            var info: String = CourseTitle + ":"
            info += CreditProgram + "學程"
            if (SAP) info += "(搭配SAP系統授課)"
            info += "\n\n"
            return info
        }

        companion object {
            var count: Int = 0
            fun Add(): String {
                count++
                return "第" + count.toString() + "門課程:\n"
            }
        }
    }

}

open class Person(var Name: String) {
    open fun Hello(): String {
        return Name + "，您好!\n"
    }
}

open class Teacher(Name: String, var dep: String) : Person(Name) {
    open fun Work(): String {
        return "任職於" + dep + "\n\n"
    }
}

class Student(Name: String,dep: String):Teacher(Name,dep){
    override fun Work(): String {
        return "就讀於"+dep+"\n\n"
    }
}
interface A{
    fun Sound():String{ return "~叭噗"}
}
interface B{
    fun Sound():String{ return "~嗶嗶"}
}
class Car:A,B{
    override fun Sound(): String {
        return "汽車叭叭叭"+super<A>.Sound()+super<B>.Sound()
    }
}
class Cat:A{
    override fun Sound(): String {
        return "貓咪喵喵喵"
    }
}