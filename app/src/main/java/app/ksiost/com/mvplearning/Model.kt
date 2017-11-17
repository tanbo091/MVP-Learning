package app.ksiost.com.mvplearning

/**
 * Created by lenovo on 2017/7/10.
 */

interface Model {
    interface OnReadFinishedListener {
        fun OnFinished(text: String)
    }

    fun readMessage(listener: OnReadFinishedListener)
}
