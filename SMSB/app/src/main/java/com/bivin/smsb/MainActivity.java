package com.bivin.smsb;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bivin on 3/19/2018.
 */

public class MainActivity extends AppCompatActivity {
    public static final String OTP_REGEX = "[0-9]{1,6}";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtMessage=findViewById(R.id.txtmessage);
        final TextView txtsender=findViewById(R.id.txtsender);

        SmsReceiver.bindListener(new SmsListner() {
            @Override
            public void messageReceived(String messageText, String sender) {
                Log.e("message",messageText);
                txtsender.setText(sender);
                txtMessage.setText(messageText);
            }
        });

            /*@Override
            public void messageReceived(String messageText) {

                //Toast.makeText(getApplicationContext(),"Message"+messageText,Toast.LENGTH_SHORT).show();
                Pattern pattern=Pattern.compile(OTP_REGEX);
                Matcher matcher=pattern.matcher(messageText);
                /*String otp = null;
                while (matcher.find()){
                    otp=matcher.group();
                    
                }
                Toast.makeText(getApplicationContext(),"OTP:"+otp,Toast.LENGTH_SHORT).show();
            }*/

    }
}
