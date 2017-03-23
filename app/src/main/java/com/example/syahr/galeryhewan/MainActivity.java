package com.example.syahr.galeryhewan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.keepSynced(true);

        ListView listView = (ListView) findViewById(R.id.myList);
        listView.setAdapter(new HewanAdapter(this, mDatabase.child("daftar")));

    }

    public void SimpanData(View view){
        EditText nama = (EditText) findViewById(R.id.name);
        String hewan = nama.getText().toString();

        String key = mDatabase.child("daftar").push().getKey();
        mDatabase.child("daftar").child(key).setValue(new Hewan(hewan));
    }

}
