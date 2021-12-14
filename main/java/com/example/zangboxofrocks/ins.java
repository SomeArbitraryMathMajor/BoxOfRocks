package com.example.zangboxofrocks;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ins extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins);
    }

    public void toGame(View view) {
        Intent i = new Intent(this, game.class);
        startActivity(i);
    }
}