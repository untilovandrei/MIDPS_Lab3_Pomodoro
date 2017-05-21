package com.android.pomodoro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class IntroActivity extends AppCompatActivity {

    private Button btnStart;
    private EditText intervalText, iterationsText;
    private static int inteval=0;
    private static int iterations=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        btnStart=(Button)findViewById(R.id.start);
        intervalText=(EditText)findViewById(R.id.input_interval);
        iterationsText=(EditText)findViewById(R.id.input_iterations);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!intervalText.getText().toString().equals("") && !iterationsText.getText().toString().equals("")){
                    inteval=Integer.parseInt(String.valueOf(intervalText.getText()));
                    iterations=Integer.parseInt(String.valueOf(iterationsText.getText()));
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"Fill both fields",Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    public static void decrementNrOfIterations(){
        iterations-=1;
    }

    public static int getNrOfIterations(){
        return iterations;
    }

    public static int getInteval(){
        return inteval;
    }
}
