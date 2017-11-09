package com.example.sifat.tojbih;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

     static Button plusOne;
    static int plusOn=0,saveplusOn=0,ps=0;
    ConstraintLayout layout;

    Vibrator v;
  static void pu(){
        plusOn=0;
        plusOne.setText("0");

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         layout=(ConstraintLayout)findViewById(R.id.background);
        plusOne=(Button)findViewById(R.id.button);
        plusOne.setText("0");

    }

    @Override
    protected void onStop() {
        super.onStop();

        saveplusOn=plusOn;

    }


    @Override
    protected void onResume() {
        super.onResume();
        plusOn=saveplusOn;
        String equalw=plusOn+"";
        plusOne.setText(equalw);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_reset) {
            DialogFragment dialogFragment=new myDialogfragment();
            dialogFragment.show(getFragmentManager(),"the dialog");

            return true;
        }else if (id == R.id.action_newBackground) {
           if (ps==0){
               int image_resid = getApplicationContext().getResources().getIdentifier("ni", "drawable", getApplicationContext().getPackageName());
               plusOne.setBackgroundResource(image_resid);
               ps=1;
           }else{
               int image_resid = getApplicationContext().getResources().getIdentifier("known", "drawable", getApplicationContext().getPackageName());
               plusOne.setBackgroundResource(image_resid);
               ps=0;
           }



            return true;
        } else if(id==R.id.action_Exit){

            plusOn=0;
            plusOne.setText("0");
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void plusOne(View view) {

        plusOn++;
        if((plusOn%33)==0||((plusOn%100)==0)){

            v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
            long[] pattern = {0, 100, 50, 300};
            // Vibrate for 500 milliseconds
            v.vibrate(pattern,-1);
        }
        String equal=plusOn+"";
        plusOne.setText(equal);
    }
}
