package com.example.pc.class_arem;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create listView
        createListView();

    } // main metod

    private void createListView() {
        Mydata objMydata = new Mydata();
        int[] intIcon = objMydata.icon();
        String[] strTitle = objMydata.title();

        MyAdapter objmyAdapter = new MyAdapter(MainActivity.this, intIcon, strTitle);
        ListView myListView = (ListView) findViewById(R.id.listView);
        myListView.setAdapter(objmyAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                myIntentToDetail(i);
            }
        });
    } // createListView

    private void myIntentToDetail(int intCilck){
        Intent objIntent = new Intent(MainActivity.this,ShowDetailActivity.class);
        objIntent.putExtra("click", intCilck);
        startActivity(objIntent);
    }
    public void clickAboutMe(View view){
        Intent objIntent = new Intent(Intent.ACTION_VIEW);
        objIntent.setData(Uri.parse("http://www.csclub.ssru.ac.th/s56122201082"));
        startActivity(objIntent);
    }
}
