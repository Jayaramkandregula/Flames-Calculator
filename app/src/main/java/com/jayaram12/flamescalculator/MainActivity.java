package com.jayaram12.flamescalculator;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText p1,p2;
    Button flames_cal;
    TextView result_text;
    CardView flames_res_card;
    ImageView  imageView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1=findViewById(R.id.person1_name);
        p2=findViewById(R.id.person2_name);
        flames_cal=findViewById(R.id.cal_button);
        result_text=findViewById(R.id.result_text);
        flames_res_card=findViewById(R.id.flames_res_card);
        imageView=findViewById(R.id.result_image);
        flames_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p1_name=p1.getText().toString();
                String p2_name=p2.getText().toString();
                if (p1_name.isEmpty() || p2_name.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Fields can't be empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                flames_calculator fc=new flames_calculator();
                String result=fc.get_String(p1_name,p2_name);
                result_text.setText(result.toString());
                int img_id;
                img_id = getResources().getIdentifier(result.toLowerCase(), "drawable", getPackageName());
                imageView.setImageResource(img_id);
                flames_class flames=new flames_class(p1_name,p2_name,result,img_id);
                DataBaseHandler db=new DataBaseHandler(MainActivity.this);
                db.add_flames_data(flames);
            }
        });
        flames_res_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,FlamesResults.class);
                startActivity(i);
            }
        });
    }

}