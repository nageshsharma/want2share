package hnp.Want2Sgare;


import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Date;


public class ActivityMessage extends FragmentActivity   {

private TextView mTextView;
    private EditText inpTxt;
    private Button btnSubmit ;
    private Spinner sprTran;
    private TextView lblTran;
@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_section2);



        sprTran = (Spinner) findViewById(R.id.TranSpinner);
        sprTran.setVisibility(View.VISIBLE);
        //sprTran.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        /*ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprTran.setAdapter(dataAdapter); */

        TextView lblTran = (TextView) findViewById(R.id.lblNewItem);
        lblTran.setVisibility(View.VISIBLE);

        final TextView mTextView = (TextView) findViewById(R.id.txtResult);
        mTextView.setTextColor(Color.rgb(19, 135, 62));
        mTextView.setTypeface(null, Typeface.ITALIC);

        inpTxt = (EditText) findViewById(R.id.txtTransactionName);
        inpTxt.setHint("Transaction Detail");
        inpTxt.setVisibility(View.VISIBLE);

        btnSubmit = (Button) findViewById(R.id.image_activity);
        btnSubmit.setText("Add to List");
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                Global.arrRec = Global.arrRec+1;
                mTextView.setText("'"+ inpTxt.getText().toString() + "' Added  to List");
                Global.val1[Global.arrRec] = currentDateTimeString + ": " + "\n" + sprTran.getSelectedItem().toString() + ">> " + inpTxt.getText().toString();
                //mTextView.setText(sprTran.getSelectedItem().toString());
                inpTxt.setText("");
            }
        });

    }

}


