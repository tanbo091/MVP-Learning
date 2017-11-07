package app.ksiost.com.mvplearning;

import android.os.Handler;

import java.util.Random;

/**
 * Created by lenovo on 2017/7/10.
 */

public class ModelImpl implements Model {

    private String[] texts = {"Hello", "This is MVP", "Here is Temple!", "My name is Tanbo."};
    private String errorMessage = "Out of Index!";
    private int old = -1;

    @Override
    public void readMessage(final OnReadFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.OnFinished(createMessage());
            }
        }, 1000L);
    }

    private String createMessage() {
        Random random = new Random();
        int num = random.nextInt(4);
        if (old == num) {
            return createMessage();
        }
        old = num;
        if (num < 4) {
            return texts[num];
        } else return errorMessage;
    }

}
