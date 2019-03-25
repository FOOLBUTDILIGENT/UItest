package cn.itcast.uitest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static cn.itcast.uitest.R.id.login;


public class Main3Activity extends AppCompatActivity {
    private Button btn_1;
    private Button button_1;
    private Button button_2;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mContext=Main3Activity.this;
        btn_1=(Button) findViewById(login);
        btn_1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                 AlertDialog.Builder builder=new AlertDialog.Builder(Main3Activity.this);
                 View view2=View.inflate(Main3Activity.this,R.layout.log,null);
                 final EditText username=(EditText)view2.findViewById(R.id.edit_1);
                 final EditText password=(EditText)view2.findViewById(R.id.edit_2);
                 final Button button_login=(Button)view2.findViewById(R.id.but_login);
                 final Button button_cancel=(Button)view2.findViewById(R.id.but_cancel);
                 builder.setTitle("登入").setView(view2);
                 final AlertDialog alertDialog=builder.create();
                 button_login.setOnClickListener(new OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         String name=username.getText().toString().trim();
                         String pass=password.getText().toString().trim();
                         if(name==null||pass==null)
                         {
                             Toast.makeText(Main3Activity.this,"不能为空",Toast.LENGTH_SHORT).show();
                             alertDialog.dismiss();
                         }
                         else
                         {
                             Toast.makeText(Main3Activity.this,"登入成功",Toast.LENGTH_SHORT).show();
                             alertDialog.dismiss();
                         }
                     }
                 });
                 button_cancel.setOnClickListener(new OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         alertDialog.dismiss();
                     }
                 });
                 alertDialog.show();


            }
        });
    }

}
