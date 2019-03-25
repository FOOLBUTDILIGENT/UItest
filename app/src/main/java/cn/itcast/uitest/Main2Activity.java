package cn.itcast.uitest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static cn.itcast.uitest.R.id.first;
import static cn.itcast.uitest.R.id.second;
public class Main2Activity extends AppCompatActivity {
    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       but1=findViewById(first);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        but2=findViewById(second);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
        but3=findViewById(R.id.third);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
        but4=findViewById(R.id.fourth);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,Main5Activity.class);
                startActivity(intent);
            }
        });

    }
}
