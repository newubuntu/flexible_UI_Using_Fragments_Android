package slidenerd.vivz;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Vivz on 10/8/13.
 */
public class FragmentA extends Fragment implements AdapterView.OnItemClickListener{
    ListView list;
    Communicator communicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a, container, false);
        list= (ListView) view.findViewById(R.id.listView);
        ArrayAdapter adapter= ArrayAdapter.createFromResource(getActivity(),R.array.chapters,android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        return view;
    }
    public void setCommunicator(Communicator communicator)
    {
        this.communicator=communicator;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("VIVZ",(communicator==null)+"");
        communicator.respond(i);
    }

    public interface Communicator
    {
        public void respond(int index);
    }

}
