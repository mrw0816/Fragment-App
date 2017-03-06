package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

import com.vogella.android.fragmentapp.R;

import layout.Settings;

public class Display extends Fragment {


    private String mParam1;
    private String mParam2;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    String text = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        Bundle bundle = this.getArguments();
        if(bundle != null){
            text = bundle.getString("displayText");
        }

    }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            View parentView = inflater.inflate(R.layout.fragment_settings, container, false);
            Button button = (Button) parentView.findViewById(R.id.textChangeButton);
            button.setVisibility(View.GONE);

        return inflater.inflate(R.layout.fragment_display, container, false);

    }
    @Override
    public void onStart() {
        super.onStart();
        setText(text);
    }

    public void setText(String string){
        TextView textView = (TextView) getView().findViewById(R.id.textOutput);
        textView.setText(string);
    }


}
