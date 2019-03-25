package cn.itcast.uitest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        textView=(TextView)findViewById(R.id.textView_test);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_for_test3,menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case R.id.text_size_big:textView.setTextSize(20);break;
            case R.id.text_size_center:textView.setTextSize(16);break;
            case R.id.text_size_small:textView.setTextSize(10);break;
            case R.id.text_Toast:Toast.makeText(Main4Activity.this,"普通菜单",Toast.LENGTH_SHORT).show();break;
            case R.id.text_color_red:textView.setTextColor(Color.parseColor("#FF0000"));break;
            case R.id.text_color_black:textView.setTextColor(Color.parseColor("#000000"));break;
        }
        return true;
    }
}
