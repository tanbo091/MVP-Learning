package app.ksiost.com.mvplearning

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity(), MyView {

    private var mTextMessage: TextView? = null
    private var presenter: Presenter? = null
    private var transaction: FragmentTransaction? = null
    private var myFragment: MyFragment? = null
    private var clicked = -1

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                presenter!!.readData()
                clicked = 0
                //                    mTextMessage.setText(R.string.title_home);
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                presenter!!.readData()

                clicked = 1
                //                    mTextMessage.setText(R.string.title_dashboard);
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                presenter!!.readData()
                clicked = 2
                //                    mTextMessage.setText(R.string.title_notifications);
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextMessage = findViewById(R.id.message) as TextView
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        presenter = PresenterImpl(this, ModelImpl())

        myFragment = MyFragment()
        //        MyFragment2 myFragment2 = new MyFragment2();
        val bundle = Bundle()
        bundle.putString("text1", "Hello One !")
        bundle.putString("text2", "Hello Two !")
        bundle.putString("text3", "Hello Three !")
        myFragment!!.arguments = bundle
        transaction = supportFragmentManager.beginTransaction()
        transaction!!.add(R.id.fragment, myFragment)
        //        transaction.add(R.id.fragment2, myFragment2, "2");
        transaction!!.commit()
    }

    override fun setMessage(text: String) {
        mTextMessage!!.text = text
        transaction = supportFragmentManager.beginTransaction()
        if (clicked == 0) {
            val bundle = Bundle()
            bundle.putString("text1", text)
            bundle.putString("text2", "Hello Two !")
            bundle.putString("text3", "Hello Three !")
            myFragment!!.arguments = bundle
            transaction!!.replace(R.id.fragment, myFragment)
        } else {
            val myFragment2 = MyFragment2()
            transaction = supportFragmentManager.beginTransaction()
            transaction!!.replace(R.id.fragment, myFragment2)
        }
        transaction!!.commit()
    }

    override fun onResume() {
        presenter!!.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        presenter!!.onDestroy()
        super.onDestroy()
    }
}
