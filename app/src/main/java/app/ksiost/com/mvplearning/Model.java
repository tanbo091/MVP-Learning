package app.ksiost.com.mvplearning;

/**
 * Created by lenovo on 2017/7/10.
 */

public interface Model {
    interface OnReadFinishedListener {
        void OnFinished(String text);
    }

    void readMessage(OnReadFinishedListener listener);
}
