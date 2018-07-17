package com.example.sifat.tojbih;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Locale;
import java.util.logging.LoggingPermission;

public class MainActivity extends AppCompatActivity {

     static Button plusOne;

    static int plusOn=0, saveplusOn=0,ps=0,saveps=0, fullscreen=0;
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
        putButtonBackground(ps);

      //  getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

    }

    @Override
    protected void onStop() {
        super.onStop();
        saveps=ps;
        saveplusOn=plusOn;

    }
    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        layout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
        fullscreen=1;


  }

    @SuppressLint("InlinedApi")
    private void show() {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.show();
        }
        // Show the system bar
    layout.setSystemUiVisibility(View.VISIBLE
           // | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    );




    }


    @Override
    protected void onResume() {
        super.onResume();
        plusOn=saveplusOn;
        ps=saveps;

        putTextONplusOne(plusOn);
        putButtonBackground(ps);
    }

    private void putButtonBackground(int ps) {

        if (ps==1){
            int image_resid = getApplicationContext().getResources().getIdentifier("ni", "drawable", getApplicationContext().getPackageName());
            plusOne.setBackgroundResource(image_resid);

        }else if (ps==2){
            int image_resid = getApplicationContext().getResources().getIdentifier("kkk", "drawable", getApplicationContext().getPackageName());
            plusOne.setBackgroundResource(image_resid);

        } else if (ps==0){
            int image_resid = getApplicationContext().getResources().getIdentifier("known", "drawable", getApplicationContext().getPackageName());
            plusOne.setBackgroundResource(image_resid);

        }else if (ps==3){
            int image_resid = getApplicationContext().getResources().getIdentifier("salam", "drawable", getApplicationContext().getPackageName());
            plusOne.setBackgroundResource(image_resid);

        }
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

            if(ps>=0&&ps<3){
                ps++;

            }else if(ps==3){
                ps=0;
            }



            putButtonBackground(ps);


            return true;
        }else if (id == R.id.action_full_screen) {

        hide();


            return true;
        }else if (id == R.id.action_lastBackground) {
            putButtonBackground(ps);
            if(ps>0&&ps<=3){
                ps--;

            }else if(ps==0){
                ps=3;
            }



            putButtonBackground(ps);

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

    @Override
    public void onBackPressed() {

      if(fullscreen==1){
          show();
          fullscreen=0;
      }else {
        super.onBackPressed();
      }
    }
}
