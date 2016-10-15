package xyz.sooys.multifunctionalsofa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES = "settings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    private SharedPreferences Settings;

    private TextView func;
    private static Intent intent;

    public int scount = 51;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Settings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        intent = new Intent(MainActivity.this, AdditionalActivity.class);
        func = (TextView)findViewById(R.id.textView7);
    }

    public void onClick(View view){
        startActivity(intent);
    }

    public void sClick(View view){
        //Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        //vibrator.vibrate(400);
        TextView clicker = (TextView)findViewById(R.id.textView3);
        clicker.setText(Integer.toString(--scount));
        if ((scount <= 0)) {
            scount = 51;
            Toast toast = Toast.makeText(getApplicationContext(), "Вы открыли новую функцию!", Toast.LENGTH_SHORT);
            toast.show();
            intent.putExtra("func", "На нем можно спать");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Запоминаем данные
        SharedPreferences.Editor editor = Settings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, scount);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (Settings.contains(APP_PREFERENCES_COUNTER)) {
            // Получаем число из настроек
            scount = Settings.getInt(APP_PREFERENCES_COUNTER, 0);
            // Выводим на экран данные из настроек
            TextView clicker = (TextView)findViewById(R.id.textView3);
            clicker.setText(Integer.toString(scount));
        }
    }

}
