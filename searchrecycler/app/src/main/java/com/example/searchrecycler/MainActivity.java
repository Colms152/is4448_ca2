package com.example.searchrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();

        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

    }

    private void filter(String text) {
        ArrayList<ExampleItem> filteredList = new ArrayList<>();

        for (ExampleItem item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }

    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "One", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "Two", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "Three", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "Four", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "Five", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "Six", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "Seven", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "Eight", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "Nine", "Line 2"));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}