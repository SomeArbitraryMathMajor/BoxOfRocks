package com.example.zangboxofrocks;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void toIns(View view) {
        Intent n = new Intent(this, ins.class);
        startActivity(n);
    }

    public void nam(View view) {
        final EditText writer = new EditText(this);
        AlertDialog.Builder in = new AlertDialog.Builder(this);
        in.setTitle("Who's this?");
        in.setMessage("Enter your name:");
        in.setView(writer);
        in.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = String.valueOf(writer.getText());
                try {
                    FileOutputStream out = openFileOutput("names.txt", Activity.MODE_PRIVATE);
                    out.write(name.length());
                    for(int i = 0; i < name.length(); i++)
                        out.write((name.charAt(i)));
                    out.flush();
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Button b = findViewById(R.id.next);
                Button a = findViewById(R.id.mak);
                a.setVisibility(View.GONE);
                b.setVisibility(View.VISIBLE);
            }
        });
        in.setNegativeButton("Cancel", null);
        in.create();
        in.show();
    }
}
