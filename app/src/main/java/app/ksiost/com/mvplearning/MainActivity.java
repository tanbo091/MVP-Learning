package app.ksiost.com.mvplearning;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyView {

    private TextView mTextMessage;
    private Presenter presenter;
    private FragmentTransaction transaction;
    private MyFragment myFragment;
    private int clicked = -1;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    presenter.readData();
                    clicked = 0;
//                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    presenter.readData();

                    clicked = 1;
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    presenter.readData();
                    clicked = 2;
//                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        presenter = new PresenterImpl(this, new ModelImpl());

        myFragment = new MyFragment();
//        MyFragment2 myFragment2 = new MyFragment2();
        Bundle bundle = new Bundle();
        bundle.putString("text1", "Hello One !");
        bundle.putString("text2", "Hello Two !");
        bundle.putString("text3", "Hello Three !");
        myFragment.setArguments(bundle);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment, myFragment);
//        transaction.add(R.id.fragment2, myFragment2, "2");
        transaction.commit();
    }

    @Override
    public void setMessage(String text) {
        mTextMessage.setText(text);
        transaction = getSupportFragmentManager().beginTransaction();
        if (clicked == 0) {
            Bundle bundle = new Bundle();
            bundle.putString("text1", text);
            bundle.putString("text2", "Hello Two !");
            bundle.putString("text3", "Hello Three !");
            myFragment.setArguments(bundle);
            transaction.replace(R.id.fragment, myFragment);
        } else {
            MyFragment2 myFragment2 = new MyFragment2();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment, myFragment2);
        }
        transaction.commit();
    }

    @Override
    protected void onResume() {
        presenter.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
