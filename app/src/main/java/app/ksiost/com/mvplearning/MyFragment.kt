package app.ksiost.com.mvplearning

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by lenovo on 2017/7/10.
 */

class MyFragment : Fragment() {
    private var text1: String? = null
    private var text2: String? = null
    private var text3: String? = null
    private var textView1: TextView? = null
    private var textView2: TextView? = null
    private var textView3: TextView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment1, container, false)
        textView1 = view.findViewById(R.id.textView) as TextView
        textView2 = view.findViewById(R.id.textView2) as TextView
        textView3 = view.findViewById(R.id.textView3) as TextView
        val bundle = arguments
        if (bundle != null) {
            text1 = bundle.getString("text1", "1")
            text2 = bundle.getString("text2", "2")
            text3 = bundle.getString("text3", "3")
        }
        textView1!!.text = text1
        textView2!!.text = text2
        textView3!!.text = text3
        return view
    }

}
