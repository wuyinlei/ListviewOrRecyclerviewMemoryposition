package yinlei.com.listvieworrecyclerviewmemoryposition.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import yinlei.com.listvieworrecyclerviewmemoryposition.R;

public class ListViewActivity extends AppCompatActivity {

    private ListView mListView;
    private List<String> mList = new ArrayList<>();
    private ListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initData();
        initListView();
    }

    private void initListView() {
        mListView = (ListView) findViewById(R.id.list_view);
        mAdapter = new ListViewAdapter(mList, this);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mAdapter.setPosition(i);  //把当前点击的位置传递过去
                mAdapter.notifyDataSetChanged();  //通知listview刷新UI
            }
        });
    }

    private void initData() {
        for (int i = 0 ; i < 10 ; i++){
            mList.add("我是第" + i + "个item");
        }
    }
}
