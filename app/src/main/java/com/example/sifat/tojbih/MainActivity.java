package com.example.sifat.tojbih;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Locale;
import java.util.logging.LoggingPermission;

public class MainActivity extends AppCompatActivity {

     static Button plusOne;
    static int plusOn=0, saveplusOn=0,ps=0;
    ConstraintLayout layout;

    Vibrator v;
  static void pu(){
        plusOn=0;
      String ppp=""+plusOn;


      if (Locale.getDefault().getDisplayLanguage().equals("বাংলা") ){
          ppp=ppp.replace("9","৯").replace("0","০").replace("1","১").replace("2","২").replace("3","৩").replace("4","৪").replace("5","৫").replace("6","৬").replace("7","৭").replace("8","৮");
          plusOne.setGravity(-1);
          plusOne.setText(ppp);
      }else if(Locale.getDefault().getDisplayLanguage().equals("العربية") ){
          ppp=ppp.replace("0","٠").replace("1","١").replace("2","٢").replace("3","٣").replace("4","٤").replace("5","٥").replace("6","٦").replace("7","٧").replace("8","٨").replace("9","٩");
          plusOne.setGravity(99);
          plusOne.setText(ppp);

      }else {
          plusOne.setGravity(-1);
          plusOne.setText(ppp);

      }

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         layout=(ConstraintLayout)findViewById(R.id.background);
        plusOne=(Button)findViewById(R.id.button);
        putTextONplusOne(0);




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

        putTextONplusOne(plusOn);
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
           }else if (ps==1){
               int image_resid = getApplicationContext().getResources().getIdentifier("kkk", "drawable", getApplicationContext().getPackageName());
               plusOne.setBackgroundResource(image_resid);
               ps=2;
           } else if (ps==2){
               int image_resid = getApplicationContext().getResources().getIdentifier("known", "drawable", getApplicationContext().getPackageName());
               plusOne.setBackgroundResource(image_resid);
               ps=0;
           }



            return true;
        } else if(id==R.id.action_Exit){

            plusOn=0;
            putTextONplusOne(0);
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

       putTextONplusOne(plusOn);
    }

    public void putTextONplusOne(int i){
        String ppp=""+i;



        if (Locale.getDefault().getDisplayLanguage().equals("বাংলা") ){
            ppp=ppp.replace("0","০").replace("1","১").replace("2","২").replace("3","৩").replace("4","৪").replace("5","৫").replace("6","৬").replace("7","৭").replace("8","৮").replace("9","৯");
            plusOne.setGravity(-1);
            plusOne.setText(ppp);
        }else if(Locale.getDefault().getDisplayLanguage().equals("العربية") ){
            ppp=ppp.replace("0","٠").replace("1","١").replace("2","٢").replace("3","٣").replace("4","٤").replace("5","٥").replace("6","٦").replace("7","٧").replace("8","٨").replace("9","٩");



            plusOne.setGravity(99);
            plusOne.setText(ppp);

        }else {

           plusOne.setGravity(-1);
            plusOne.setText(ppp);

        }
    }

}
