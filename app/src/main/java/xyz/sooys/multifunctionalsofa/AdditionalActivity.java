package xyz.sooys.multifunctionalsofa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdditionalActivity extends AppCompatActivity {


    private TextView func;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional);
        func = (TextView)findViewById(R.id.textView7);

        String txtFunc = getIntent().getStringExtra("func");
        func.setText(txtFunc);
    }
}
