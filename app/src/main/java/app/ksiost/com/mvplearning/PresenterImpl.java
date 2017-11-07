package app.ksiost.com.mvplearning;

import android.widget.TextView;

/**
 * Created by lenovo on 2017/7/10.
 */

public class PresenterImpl implements Presenter, Model.OnReadFinishedListener {
    private String message;
    private TextView textView;
    private MyView myView;
    private Model myModel;

    public PresenterImpl(MyView myView, Model myModel) {
        this.myView = myView;
        this.myModel = myModel;
    }

    @Override
    public void readData() {
        myModel.readMessage(this);
    }

    @Override
    public void onDestroy() {
        myView = null;
    }

    @Override
    public void onResume() {
        myModel.readMessage(this);
    }

    @Override
    public void OnFinished(String text) {
        if (myView != null) {
            myView.setMessage(text);
        }
    }
}
