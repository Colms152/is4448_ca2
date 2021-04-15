package is4447.bis.ucc.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager mLayoutManager;
    private HeroRVAdapter mAdapter;
    private ArrayList<Hero> Herolist;

    public MainActivity() {
    }

    public final Handler myCallBack = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            ArrayList<Hero> h = (ArrayList<Hero>)msg.obj;
            buildRecyclerView(h);
        }
    };

    protected boolean isBound = false;
    protected BackGroundBoundService.BackGroundBinder myBinder;

    protected ServiceConnection conn = new BackGroundServiceConnection();

    protected class BackGroundServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // TODO Auto-generated method stub
            myBinder = (BackGroundBoundService.BackGroundBinder) service;
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Binds service to call API
        Intent boundServiceIntent = new Intent(this,BackGroundBoundService.class);
        bindService(boundServiceIntent, conn, Context.BIND_AUTO_CREATE);

        //Filter Recycler View
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

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();

        // Unbind from the background service
        if (isBound) {
            unbindService(conn);
            isBound = false;
        }

    }

    public void onClickRefresh(View v)
    {
        if (isBound) {
            myBinder.getMyHeros(myCallBack);
        }
    }

    private void filter(String text) {
        ArrayList<Hero> filteredList = new ArrayList<>();

        for (Hero item : Herolist) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }
    private void buildRecyclerView(ArrayList<Hero> h) {
        Herolist = h;

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new HeroRVAdapter(Herolist);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }


}