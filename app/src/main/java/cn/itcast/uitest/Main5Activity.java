package cn.itcast.uitest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


