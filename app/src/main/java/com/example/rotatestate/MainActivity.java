package com.example.rotatestate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    TextView text;

    //starts activity lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.num_count);
    }

    //Restores the state
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        text.setText(savedInstanceState.getString("count_num"));
    }

    //Preserves the state
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(Objects.requireNonNull(savedInstanceState));
        savedInstanceState.putString("count_num",(String) text.getText());
    }

    public void count(View view)
    {
        text.setText((String) Integer.toString(Integer.parseInt((String) text.getText())+1));
    }
}