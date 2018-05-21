package com.example.micha.kodiremote;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.micha.kodiremote.Dialogs.WrongIpMessageBox;
import com.example.micha.kodiremote.Utills.IPv4Matcher;
import com.example.micha.kodiremote.Utills.KodiParameters;


public class AppToControlActivity extends AppCompatActivity {
    private static final String TAG = ControlKodi_Activity.class.getSimpleName();
    EditText editIp1;
    EditText editIp2;
    EditText editIp3;
    EditText editIp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_ip_acivity);
        editIp1 = (EditText)findViewById(R.id.editIP1);
        editIp2 = (EditText)findViewById(R.id.editIP2);
        editIp3 = (EditText)findViewById(R.id.editIP3);
        editIp4 = (EditText)findViewById(R.id.editIP4);
    }


    public void onClickAction(View view){
        Log.d(TAG, "You clicked");
        String ipFirstPart=editIp1.getText().toString();
        String ipSecondPart=editIp2.getText().toString();
        String ipThirdPart=editIp3.getText().toString();
        String ipFourthPart=editIp4.getText().toString();
        String finalIP=ipFirstPart+"."+ipSecondPart+"."+ipThirdPart+"."+ipFourthPart;
        KodiParameters kodiParameters= new KodiParameters(finalIP,"8080");
        IPv4Matcher matcher = new IPv4Matcher(finalIP);
        Log.d(TAG,finalIP);
        if(matcher.isMaching()){
            Log.d(TAG,"IP is Maching");
            Intent intent = new Intent(this, ControlKodi_Activity.class);
            intent.putExtra("Kodi Parameters",kodiParameters);
            startActivity(intent);
            editIp1.setText("");
            editIp2.setText("");
            editIp3.setText("");
            editIp4.setText("");
        }
        else{
            Log.d(TAG,"IP is not matchign");

            WrongIpMessageBox dialog = new WrongIpMessageBox();
            FragmentManager fm = getSupportFragmentManager();
            dialog.show(fm, "dialog_fragment");
        }
    }



}
