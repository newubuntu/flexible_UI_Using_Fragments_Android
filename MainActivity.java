package slidenerd.vivz;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity implements FragmentA.Communicator{

    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=getFragmentManager();
        FragmentA f1= (FragmentA) manager.findFragmentById(R.id.fragment);
        f1.setCommunicator(this);
    }


    @Override
    public void respond(int index) {
        Log.d("VIVZ", " Inside main activity ");
        FragmentB f2= (FragmentB) manager.findFragmentById(R.id.fragment2);
        if(f2!=null && f2.isVisible())
        {
            Log.d("VIVZ", " f2 change data ");
            f2.changeData(index);
        }
        else
        {
            Log.d("VIVZ", " calling intent ");
            Intent intent=new Intent(this, AnotherActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }

    }
}
