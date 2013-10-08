package slidenerd.vivz;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Vivz on 10/8/13.
 */
public class FragmentB extends Fragment {
    TextView text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("VIVZ","View was created");
        View view=inflater.inflate(R.layout.fragment_b, container, false);
        text= (TextView) view.findViewById(R.id.textView);
        return view;

    }

    public void changeData(int index)
    {
        String[] descriptions=getResources().getStringArray(R.array.description);
        Log.d("VIVZ","Descriptions retreieved");
        text.setText(descriptions[index]);
    }
}
