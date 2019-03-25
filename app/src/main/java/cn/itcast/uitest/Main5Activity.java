package cn.itcast.uitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        TextView textView=findViewById(R.id.menutext);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActionMode(new Mycallback()    );
            }
        });
    }
    private class Mycallback implements ActionMode.Callback{
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu)
        {
            actionMode.getMenuInflater().inflate(R.menu.optionmenu,menu);
            return true;
        }
        @Override
        public boolean onPrepareActionMode(ActionMode actionMode,Menu menu)
        {
            return false;
        }
        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem)
        {
            switch (menuItem.getItemId()){
                case R.id.actionmenu2:
                    Toast.makeText(Main5Activity.this,"被选中",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.actionmenu1:
                    Toast.makeText(Main5Activity.this,"点击删除",Toast.LENGTH_SHORT).show();
                    break;
            }
           actionMode.finish();
            return true;
        }
        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    }

}
