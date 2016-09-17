package yinlei.com.listvieworrecyclerviewmemoryposition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import yinlei.com.listvieworrecyclerviewmemoryposition.listview.ListViewActivity;
import yinlei.com.listvieworrecyclerviewmemoryposition.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void list_view_memory_position(View view) {
        startActivity(new Intent(this, ListViewActivity.class));
    }

    public void recycler_view_memory_position(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }
}
