package com.example.cxc.kotlinstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.sql.Array

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //lambda匿名函数
        val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
        sumLambda(3, 4)

        //定义变量  var 变量名:类型 = 初始化值
        var a: Int = 1
        //定义常量  类似final  val 常量名:类型 = 初始化值
        val A: Int = 2
        //变量和常量可以不进行初始化,但在引用前必须进行初始化
        a += 1

        //注释 kotlin支持单行注释 和多行注释 跟java一致

        //   字符串模板
        // $变量名
        var s = "a is $a"
        // ${}  //{}内为表达式
        var s1 = "${s.replace("is", "was")},but now is $a "
        val price = "${'$'}9.99" // $符号转义  ${'$'}
        println(price)

        //NULL检查机制
        //类型后面加？表示可空
        var age: String? = "23"
        //设置不能为空 如果为空 抛出异常
        val ages = age!!.toInt()
        //不做处理 返回null
        val ages1 = age?.toInt()
        //如果为空时 返回-1
        val ages2 = age?.toInt() ?: -1

        //类型检测 is !is 及自动类型转换
        //类型检测后会自动类型转换  !is不做自动类型转换
        if (a is Int) {
            println("int")
        }

        //区间   ..  rangeTo in !in
        for (i in 1..4) print(i)//输出1234

        for (i in 4..1) print(i) //什么都不输出

        for (i in 1..4 step 2) print(i) // 输出 "13"

        for (i in 1 until 10) { // i in [1,10) 排除了 10
            println(i)
        }

        //kotlin基本数据类型
        //Double64
        //Float 32
        //Long  64
        //Int   32
        //Short 16
        //Byte  8
        //十进制 123
        //长整型 123L
        // 16进制 0x0F
        //2进制 0b00001011
        //8进制 不支持

        //kotlin支持传统符号表示的浮点数值
        //Double 123.5  123.5e10
        //Floats f F后缀 123.5f
        //支持数字常量下拉线
        val oneMillion = 1_000_000
        val creditCardNumber = 1234_5678_9012_3456L
        val socialSecurityNumber = 999_99_9999L
        val hexBytes = 0xFF_EC_DE_5E
        val bytes = 0b11010010_01101001_10010100_10010010

        //比较两个数字
        //kotlin中没有基础数据类型,只有封装的数字类型,每定义一个变量,kotlin会帮你封装一个对象,保证不会出现空指针
        //数字类型也是一样,所有在比较两个数字的时候,就有比较数据大小和比较两个对象是否相同的区别了
        //在kotlin中,三个等号 ===表示比较对象地址 两个==表示比较两个值大小
        val b = 3
        val c = 3
        print(b == c)
        print(b === c)
        //由于不同的表示方式,较小类型并不是较大类型的子类型,不能进行隐式转换
        //我们不能将 一个Byte值赋给一个Int变量
        val byte: Byte = 1
        val i: Int = byte.toInt()
        //每种数据类型都有以下这些方法
        i.toByte()
        i.toShort()
        i.toInt()
        i.toLong()
        i.toFloat()
        i.toDouble()
        i.toChar()
        //有些情况也可以使用自动类型转化 根据上下文环境推断
        val l = 1L + 3 // Long + Int => Long

        //  位操作符,对于int和long类型 可以进行位操作
        l.shl(3) //左移
        l.shr(3) //右移
        l.ushr(3)//无符号右移
        l.and(3) //与
        l.or(3)//或
        l.xor(3) //异或
        l.inv() //反向

        // 字符 kotlin中的Char不能直接和数字操作,Char必须是单引号
        //支持转义 \t \b \n \r \' \" \\ \$  其他要Unicode转义序列语法 '\UFF00'
        //我们可以显式把字符转换为Int数字
        var char: Char = 'a'
        if (char !in '0'..'9') throw IllegalArgumentException("out of range")
        c.toInt() - '0'.toInt()
        //当需要可空引用时,数字,字符会被装箱,装箱操作不会保留同一性

        //布尔
        //Boolean  值true 和 false  布尔运算  空引用会被装箱
        var boolean: Boolean = false
        boolean || boolean
        boolean && boolean
        !boolean

        //数组
        //数组用类Array实现
        //创建两种方式 1. 使用函数arrayOf() 2.使用工厂函数
        val arr = arrayOf(1, 2, 3)

        val arr1 = Array(3, { i -> i * 2 })

        arr[0]  //1
        arr1[1] //2
        //与java不同 kotlin数组是不型变 invariant
        //  除了 Array 还有ByteArray, ShortArray ,IntArray用来标识各个类型数组,省去了装箱操作

        val x: IntArray = intArrayOf(1, 2, 3)
        x[0] = x[1] + x[2]
        //字符串
        //和java一样 String字符串不可变  []可以获取字符串中某个字符,也可以通过for循环来遍历
        for (c in "abc") {
            println(c)
        }
         //kotlin支持 三个引号  多行字符串
        val text = """
            多行字符串
            多行字符串
            """
        println(text)

        text.trimMargin()    //删除多余空格

    }

    //函数定义
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    // 表达式作为函数体
    fun sum1(a: Int, b: Int): Int = a + b

    // 自动推断返回值类型
    fun sum2(a: Int, b: Int) = a + b

    //返回值为null  可以使用Unit 或者不写
    fun sum3(a: Int, b: Int) {
        a + b
    }

    //可变参数函数
    fun sum4(vararg v: Int) {
        v.forEach { print(it) }
    }


    fun condition() {
    //条件控制  if  when
      //if   val c  = if(condition)a else b  类似于三元操作符
        var a = 3
        var b = 4

        var max: Int
        if (a < b) {
            max = b
        } else {
            max = a
        }
        print(max)

        val max1 = if(a>b) a else b

        val max2 = if(a>b)
        {   print(a)
            a
        }else{
            print(b)
            b
        }
        //使用区间
        if (a in 1..8) {
            print("a在区间内")
        }
        //when表达式  类似于 java 的switch

        when (a) {
            1 -> print("a==1")
            2 -> print("a==2")
            3, 4 -> print("a 是 3或者4")
            in 5..8-> print("a在5-8之间")
            is Int -> print("a是个int数")
            else -> print("a 不是 1 也不是 2")
        }

    }

    fun circulation() {
        //循环控制  for 可以对任何提供迭代器的对象进行遍历
        //  for (item in collection) print(item)
        val array = arrayOf(1, 2, 3)
        //无需索引
        for (item in array) print(item)
        //需要索引
        for (position in array.indices) print(array[position])
        //withIndex 可以同时获取 index 和 value
        for ((position,value) in array.withIndex()) print("position"+position + "value"+ value)


    }


}
