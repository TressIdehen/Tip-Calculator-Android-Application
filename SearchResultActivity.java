package com.example.tressidehen.tipcalculator;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SearchResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);


        Intent searchIntent = getIntent();
        String query = searchIntent.getStringExtra(SearchManager.QUERY);
        if(Intent.ACTION_SEARCH.equals(searchIntent.getAction())){
            Toast.makeText(SearchResultActivity.this,query, Toast.LENGTH_SHORT).
                    show();

        }
    }
}
