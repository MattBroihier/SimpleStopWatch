//var i = 1
//i++
//println("Hello World")
//println (i)

val timer = object: CountDownTimer(20000, 1000) {
    override fun onTick(millisUntilFinished: Long) {
        println("do something")
    }

    override fun onFinish() {
        println("do something else")
    }
}
timer.start()
//timer.toString()