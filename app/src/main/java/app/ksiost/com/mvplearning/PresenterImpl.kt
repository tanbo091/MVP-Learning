package app.ksiost.com.mvplearning

import android.widget.TextView

/**
 * Created by lenovo on 2017/7/10.
 */

class PresenterImpl(private var myView: MyView?, private val myModel: Model) : Presenter, Model.OnReadFinishedListener {
    private val message: String? = null
    private val textView: TextView? = null

    override fun readData() {
        myModel.readMessage(this)
    }

    override fun onDestroy() {
        myView = null
    }

    override fun onResume() {
        myModel.readMessage(this)
    }

    override fun OnFinished(text: String) {
        if (myView != null) {
            myView!!.setMessage(text)
        }
    }
}
