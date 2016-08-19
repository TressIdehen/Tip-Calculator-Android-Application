package com.example.tressidehen.tipcalculator;


import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button entry_way = (Button) findViewById(R.id.entranceBtn);

        entry_way.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent begin_application = new Intent(getApplicationContext(), TipCalculatorActivity.class);
                startActivity(begin_application);
            }
        });

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);

        getSupportActionBar().setTitle(R.string.My_App_Title);
        getSupportActionBar().setIcon(R.drawable.toolbar_clipart);
        getSupportActionBar().setSubtitle(R.string.My_App_Subtitle);



    }

















    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return super.onCreateOptionsMenu(menu);
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.menu_one:
                Toast.makeText(MainActivity.this,"You Selected Option One", Toast.LENGTH_SHORT).
                        show();
                break;
            case R.id.menu_two:
                Toast.makeText(MainActivity.this,"You Selected Option two", Toast.LENGTH_SHORT).
                        show();
                break;
            case R.id.menu_three:
                Toast.makeText(MainActivity.this,"You Selected Option three", Toast.LENGTH_SHORT).
                        show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }






}














