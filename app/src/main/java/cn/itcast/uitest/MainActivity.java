package cn.itcast.uitest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private SimpleAdapter sim;
    private ListView list;
    String[] names=new String[]{"lion","tiger","monkey","dog","cat","elephant"};
    private List<Map<String,Object>> data = new ArrayList<Map<String, Object>>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        Map<String,Object> item0 = new HashMap<String, Object>();
        item0.put("touxiang",R.drawable.lion);
        item0.put("name","lion");
        data.add(item0);
        Map<String,Object> item = new HashMap<String, Object>();
        item.put("touxiang",R.drawable.tiger);
        item.put("name","tiger");
        data.add(item);
        Map<String,Object> item1 = new HashMap<String, Object>();
        item1.put("touxiang",R.drawable.monkey);
        item1.put("name","monkey");
        data.add(item1);
        Map<String,Object> item2 = new HashMap<String, Object>();
        item2.put("touxiang",R.drawable.dog);
        item2.put("name","dog");
        data.add(item2);
        Map<String,Object> item3 = new HashMap<String, Object>();
        item3.put("touxiang",R.drawable.cat);
        item3.put("name","cat");
        data.add(item3);
        Map<String,Object> item4 = new HashMap<String, Object>();
        item4.put("touxiang",R.drawable.elephant);
        item4.put("name","elephant");
        data.add(item4);
        list=findViewById(R.id.list_view1);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Toast toast=Toast.makeText(MainActivity.this,names[position],Toast.LENGTH_SHORT);
                toast.show();

            }
        });
        sim=new SimpleAdapter(
                this,
                data,
                R.layout.listview_item,
                new String[]{"touxiang","name"},
                new int[]{R.id.touxiang,R.id.name}
        );
        list.setAdapter(sim);


    }
}
