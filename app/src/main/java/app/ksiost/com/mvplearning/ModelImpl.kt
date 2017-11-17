package app.ksiost.com.mvplearning

import android.os.Handler
import java.util.*

/**
 * Created by lenovo on 2017/7/10.
 */

class ModelImpl : Model {

    private val texts = arrayOf("Hello", "This is MVP", "Here is Temple!", "My name is Tanbo.")
    private val errorMessage = "Out of Index!"
    private var old = -1

    override fun readMessage(listener: Model.OnReadFinishedListener) {
        Handler().postDelayed({ listener.OnFinished(createMessage()) }, 1000L)
    }

    private fun createMessage(): String {
        val random = Random()
        val num = random.nextInt(4)
        if (old == num) {
            return createMessage()
        }
        old = num
        return if (num < 4) {
            texts[num]
        } else
            errorMessage
    }

}
