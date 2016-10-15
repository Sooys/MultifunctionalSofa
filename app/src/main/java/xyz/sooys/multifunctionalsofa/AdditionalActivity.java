package xyz.sooys.multifunctionalsofa;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;


import static xyz.sooys.multifunctionalsofa.MainActivity.APP_OPENED_FUNCTIONS_COUNTER;
import static xyz.sooys.multifunctionalsofa.MainActivity.APP_PREFERENCES;

public class AdditionalActivity extends AppCompatActivity {


    private TextView func;

    private static String[] functionsArray = {"На нем можно спать","Лежать","Сидеть","Спать","test","test2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional);
        func = (TextView)findViewById(R.id.textView7);



        String text = "";
        SharedPreferences Settings;
        Settings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

            for (int i = 0; i < functionsArray.length; i++)
                if(i < Settings.getInt(APP_OPENED_FUNCTIONS_COUNTER, 0))

                     text += functionsArray[i] +"<br>";

                else
                    text += "<font color='red'>закрыто</font> <br>";


        func.setText(Html.fromHtml(text));
        }




    public static int getSizeOfFunctionsArray (){
        return functionsArray.length;
    }
}
