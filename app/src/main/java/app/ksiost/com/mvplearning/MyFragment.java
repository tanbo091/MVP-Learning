package app.ksiost.com.mvplearning;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lenovo on 2017/7/10.
 */

public class MyFragment extends Fragment {
    private String text1, text2, text3;
    private TextView textView1, textView2, textView3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container,false);
        textView1 = (TextView) view.findViewById(R.id.textView);
        textView2 = (TextView) view.findViewById(R.id.textView2);
        textView3 = (TextView) view.findViewById(R.id.textView3);
        Bundle bundle = getArguments();
        if (bundle != null) {
            text1 = bundle.getString("text1", "1");
            text2 = bundle.getString("text2", "2");
            text3 = bundle.getString("text3", "3");
        }
        textView1.setText(text1);
        textView2.setText(text2);
        textView3.setText(text3);
        return view;
    }

}
