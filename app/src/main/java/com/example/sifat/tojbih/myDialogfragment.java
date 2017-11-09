package com.example.sifat.tojbih;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by md.asifulislam on 3/13/17.
 */

public class myDialogfragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder alertDialog=new AlertDialog.Builder(getActivity());
        alertDialog.setTitle(R.string.re_counting);
        alertDialog.setMessage(R.string.r_u_sure);
        AlertDialog.Builder ok = alertDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), R.string.toast_re_again, Toast.LENGTH_LONG).show();
                MainActivity.pu();
            }
        });

        alertDialog.setNegativeButton(R.string.cancel,new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), R.string.toast_restart_again,Toast.LENGTH_LONG).show();
            }
        });


        return alertDialog.create();
    }
}
