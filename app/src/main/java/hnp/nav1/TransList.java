package hnp.Want2Sgare;

import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Prabhu on 24/08/2015.
 */
public class TransList extends Activity {

    ListView listView ;
    Button btnTransList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_section);

        listView = (ListView) findViewById(R.id.list);
        String[] values = new String[] {
        };
        btnTransList = (Button) findViewById(R.id.btTransList);
        btnTransList.setVisibility(View.INVISIBLE);
        values = Global.val1;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

    }
}
