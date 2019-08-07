package me.djelectro.as139233;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import me.djelectro.as139233.util.Request;

public class IPInfo extends AppCompatActivity {
    Request webRequest;
    String res;
    String res2;
    String address;
    boolean response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        webRequest = new Request();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipinfo);
        //int duration = Toast.LENGTH_LONG;
        //Toast.makeText(getApplicationContext(), "Fetching, please wait.", duration).show();

        setVar();
    }


    private void setVar(){


        try {
            res = webRequest.execute("http://ip6.me/api/", "").get();
        }catch (Exception e){
            e.printStackTrace();
        }
        String[] values = res.split(",");
        TextView textViewToChange = (TextView) findViewById(R.id.textView5);
        address = values [1];
        textViewToChange.setText(address);
        check();

    }

    private void check(){
        try {
            webRequest = new Request();
            res2 = webRequest.execute("http://as139233.net/prefixes/", "").get();
        }catch (Exception e){
            e.printStackTrace();
        }
        String[] values = res2.split(",");
        for(String v : values){
            response = address.contains(v);
            if(response){break;}
        }
        if(response){
            TextView textViewToChange2 = (TextView) findViewById(R.id.textView6);
            textViewToChange2.setText("You are using an IP Powered by AS139233");
        }
        else{
            TextView textViewToChange2 = (TextView) findViewById(R.id.textView6);
            textViewToChange2.setText("You are NOT using an IP Powered by AS139233");
        }
    }
}
