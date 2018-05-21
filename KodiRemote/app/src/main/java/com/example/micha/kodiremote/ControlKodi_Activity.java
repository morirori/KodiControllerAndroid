package com.example.micha.kodiremote;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.micha.kodiremote.Dialogs.EnableWiFIMessageBox;
import com.example.micha.kodiremote.Kodi.KodiController;
import com.example.micha.kodiremote.Utills.KodiParameters;

import org.w3c.dom.Text;

public class ControlKodi_Activity extends AppCompatActivity {

    private KodiParameters kodiParameter;
    private KodiController kc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_kodi_);
        Intent intent = getIntent();
        this.kodiParameter = (KodiParameters) intent.getSerializableExtra("Kodi Parameters");
        WifiManager wifi = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        kc = new KodiController(kodiParameter);
        TextView volume = (TextView)findViewById(R.id.volume);
        Log.d("Volume",volume.getText().toString());
        kc.setVolume(volume.getText().toString());
        if (!wifi.isWifiEnabled()){
            EnableWiFIMessageBox mb = new EnableWiFIMessageBox();
            FragmentManager fm = getSupportFragmentManager();
            mb.show(fm, "enable wifi");
        }
    }

    public void selectOnClick(View view){
        Button button = (Button)findViewById(R.id.selectBtn);
        kc.select();
    }

    public void backOnClick(View view){
        Button button = (Button)findViewById(R.id.backBtn);
        kc.back();

    }

    public  void playPauseOnClick(View view){
        Button button = (Button)findViewById(R.id.playPauseBtn);
        kc.playPause();
        Log.d("Background String", button.getBackground().getConstantState().toString());
        Log.d("PLay string", getResources().getDrawable(R.drawable.play).getConstantState().toString());
        Log.d("PLay string", getResources().getDrawable(R.drawable.pause).getConstantState().toString());
        if (button.getBackground().getCurrent().getConstantState().equals(getResources().getDrawable(R.drawable.play).getConstantState())){
            Log.d("playPaueseOnClick","tu");
            button.setBackground(getResources().getDrawable(R.drawable.pause));
        }
        if (button.getBackground().getCurrent().equals(getResources().getDrawable(R.drawable.pause).getConstantState())){
            Log.d("playPaueseOnClick","tam");
            button.setBackground(getResources().getDrawable(R.drawable.play));
        }

    }

    public void upOnClick(View view){
        Button button = (Button)findViewById(R.id.upBtn);
        kc.moveUp();

    }

    public void downOnClick(View view){
        Button button = (Button)findViewById(R.id.downBtn);
        kc.moveDown();

    }

    public void leftOnClick(View view){
        Button button = (Button)findViewById(R.id.selectBtn);
        kc.moveLeft();

    }

    public void rightOnClick(View view){
        Button button = (Button)findViewById(R.id.selectBtn);
        kc.moveRight();

    }

    public void volUpOnClick(View view){
        TextView volume = (TextView)findViewById(R.id.volume);
        int volumeValue= Integer.parseInt(volume.getText().toString());
        if (volumeValue<100){
            String valueToSet=Integer.toString(volumeValue+1);
            kc.setVolume(valueToSet);
            volume.setText(valueToSet);
        }
    }

    public void volDownOnClick(View view){
        TextView volume = (TextView)findViewById(R.id.volume);
        int volumeValue= Integer.parseInt(volume.getText().toString());
        if (volumeValue>1){
            String valueToSet=Integer.toString(volumeValue-1);
            kc.setVolume(valueToSet);
            volume.setText(valueToSet);
        }
    }

}
