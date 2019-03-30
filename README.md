# UItest
利用SimpleAdapter实现界面效果
代码:
```
java文件:
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
XML文件:
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <ListView
        android:id="@+id/list_view1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"></ListView>

</LinearLayout>


<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="50dp">

    <RelativeLayout
        android:layout_weight="1"
        android:layout_margin="10dp"
        android:layout_width="0dp"
        android:layout_height="wrap_content">
        <TextView
            android:id="@+id/name"
            android:textSize="20sp"
            android:text="Lion"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

    </RelativeLayout>

    <ImageView

        android:id="@+id/touxiang"
        android:layout_width="60dp"
        android:layout_height="wrap_content"
        android:padding="10dp"
        android:src="@drawable/lion" />
</LinearLayout>
```
截图:
![1](https://raw.githubusercontent.com/FOOLBUTDILIGENT/images/master/UItest/first.png)

创建如图所示的自定义对话框
 请创建一个如图所示的布局，
 调用 AlertDialog.Builder 对象上的 setView() 将布局添加到
AlertDialog。
代码:
```
java文件:
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
XML文件:
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Main3Activity">
   <Button
       android:id="@+id/login"
       android:text="登入"
       android:textSize="25dp"
       android:layout_width="match_parent"
       android:layout_height="50dp" />
</android.support.constraint.ConstraintLayout>

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/text1"

        android:text="ANDRIOD APP"
        android:textSize="35dp"
        android:textAlignment="center"
        android:textColor="#FFFFFF"
        android:background="#FFFF00"
        android:layout_width="match_parent"
        android:layout_height="60dp" />
    <EditText
        android:layout_marginLeft="15dp"
        android:layout_marginRight="15dp"
          app:layout_constraintTop_toBottomOf="@id/text1"
        android:id="@+id/edit_1"
        android:hint="Username"
        android:layout_width="match_parent"
        android:layout_height="60dp" />
    <EditText
        android:inputType="textPassword"
        android:layout_marginLeft="15dp"
        android:layout_marginRight="15dp"
        app:layout_constraintTop_toBottomOf="@id/edit_1"
        android:id="@+id/edit_2"
        android:hint="Password"
        android:layout_width="match_parent"
        android:layout_height="60dp" />
    <LinearLayout
        app:layout_constraintTop_toBottomOf="@+id/edit_2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        >
        <Button
            android:layout_width="wrap_content"
            android:layout_weight="1"
            android:id="@+id/but_login"
            android:text="登入"
            android:textSize="25dp"
            android:layout_height="50dp" />
        <Button
            android:layout_width="wrap_content"
            android:layout_weight="1"
            android:id="@+id/but_cancel"
            android:text="取消"
            android:textSize="25dp"
            android:layout_height="50dp" />
    </LinearLayout>
</android.support.constraint.ConstraintLayout>
```
截图:
![2](https://raw.githubusercontent.com/FOOLBUTDILIGENT/images/master/UItest/second.png)

使用XML定义菜单
 字体大小（有小，中，大这3个选项；分
别对应10号字，16号字和20号字）；
点击之后设置测试文本的字体
 普通菜单项，点击之后弹出Toast提示
 字体颜色（有红色和黑色这2个选项），
点击之后设置测试文本的字体
代码:
```
java文件:
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

XML文件
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Main4Activity">
     <TextView
         android:id="@+id/textView_test"
         android:text="这里用来测试菜单"
         android:layout_width="match_parent"
         android:layout_height="80dp" />
</android.support.constraint.ConstraintLayout>

<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:tools="http://schemas.android.com/tools"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"

    >

<item
    android:id="@+id/text_size"
    android:title="字体大小"

    >
    <menu>
        <item
            android:id="@+id/text_size_big"
            android:title="大号"></item>
        <item
            android:id="@+id/text_size_center"
            android:title="中号"></item>
        <item
            android:id="@+id/text_size_small"
            android:title="小号"></item>
    </menu>
</item>

    <item
        android:id="@+id/text_Toast"
        android:title="普通菜单"

        />
    <item
        android:id="@+id/text_color"
        android:title="字体颜色"

         >
        <menu>
            <item
                android:id="@+id/text_color_red"
                android:title="红色"></item>
            <item
                android:id="@+id/text_color_black"
                android:title="黑色"></item>
        </menu>
    </item>

</menu>
```
截图:
![3-1](https://raw.githubusercontent.com/FOOLBUTDILIGENT/images/master/UItest/third_1.png)
![3-2](https://raw.githubusercontent.com/FOOLBUTDILIGENT/images/master/UItest/third_2.png)

创建上下文操作模式 (ActionMode) 的上下文菜单
 创建如图模式的上下文菜单
 使用ListView或者ListActivity创建
List
 为List Item创建ActionMode形式
的上下文菜单
代码:
```
java文件:
public class Main5Activity extends AppCompatActivity {

    private CheckListViewAdapter mAdapter;
    private List<Integer> mItems = new ArrayList<Integer>();
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        listView=findViewById(R.id.list_view2);

        onStart();
        mAdapter = new CheckListViewAdapter(this,
                R.layout.item_with_check_box,
                mItems);
        mAdapter.notifyDataSetChanged();
        listView.setAdapter(mAdapter);
        listView.setMultiChoiceModeListener(new MultiChoiceModeListener(listView));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main5Activity.this, "点击条目", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mItems.addAll(getItems());

    }

    @Override
    protected void onStop() {
        super.onStop();
        mItems.clear();
    }

    private List<Integer> getItems() {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            items.add(i);
        }
        return items;
    }

    private class MultiChoiceModeListener implements AbsListView.MultiChoiceModeListener {

        private ListView mListView;
        private TextView mTitleTextView;
        private List<Integer> mSelectedItems = new ArrayList<>();

        private MultiChoiceModeListener(ListView listView) {
            mListView = listView;
        }

        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
            mSelectedItems.add(mAdapter.getItem(position));
            mTitleTextView.setText("已选择 " + mListView.getCheckedItemCount() + " 项");
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.check_task_priority, menu);

            @SuppressLint("InflateParams")
            View multiSelectActionBarView = LayoutInflater.from(Main5Activity.this)
                    .inflate(R.layout.action_mode_bar, null);
            mode.setCustomView(multiSelectActionBarView);
            mTitleTextView = (TextView)multiSelectActionBarView.findViewById(R.id.title);
            mTitleTextView.setText("已选择 0 项");

            mAdapter.setCheckable(true);
            mAdapter.notifyDataSetChanged();
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.cancel:
                    break;
                case R.id.up:
                    Collections.sort(mSelectedItems);
                    for (Integer selectedItem : mSelectedItems) {
                        mItems.remove(selectedItem);
                    }
                    mItems.addAll(0, mSelectedItems);
                    break;
                default:
                    break;
            }

            mode.finish();
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mSelectedItems.clear();
            mAdapter.setCheckable(false);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class CheckListViewAdapter extends ArrayAdapter<Integer> {

        private boolean mCheckable;

        private CheckListViewAdapter(@NonNull Context context,
                                     @LayoutRes int resource,
                                     @NonNull List<Integer> objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if (null == convertView) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.item_with_check_box, parent, false);
                holder = new ViewHolder();
                holder.textView = (TextView) convertView.findViewById(R.id.text_view);
                holder.checkBox = (CheckBox) convertView.findViewById(R.id.selected_check_box);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Integer item = getItem(position);
            if (item != null) {
                holder.textView.setText(item.toString());
            }

            //可见性和选中状态
            if (mCheckable) {
                holder.checkBox.setVisibility(View.VISIBLE);
            } else {
                holder.checkBox.setVisibility(View.INVISIBLE);
            }
            holder.checkBox.setChecked(((ListView) parent).isItemChecked(position));

            return convertView;
        }

        //用来设置是否CheckBox可见
        private void setCheckable(boolean checkable) {
            mCheckable = checkable;
        }

        private class ViewHolder {
            private TextView textView;
            private CheckBox checkBox;
        }
    }
}
XML文件:
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto">
   <item
       android:id="@+id/actionmenu1"
       android:title="delete"
       app:showAsAction="always"></item>
    <item
        android:id="@+id/actionmenu2"
        android:title="selected"
        app:showAsAction="always"></item>
</menu>
```
截图:
![4](https://raw.githubusercontent.com/FOOLBUTDILIGENT/images/master/UItest/fourth_1.png)
