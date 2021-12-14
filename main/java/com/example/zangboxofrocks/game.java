package com.example.zangboxofrocks;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//Bryan Zang
//June 15 2020
//Box of Rocks

public class game extends AppCompatActivity {

    Card c;
    Deck d = new Deck();
    String que = "", display = "";
    int hc = 0, rc = 0;
    boolean tiebreaker = false, on = false;
    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView view = findViewById(R.id.name);
        try {

            FileInputStream in = openFileInput("names.txt");
            //name length
            int nameLength = in.read();
            //convert to chars
            for (int i = 0; i < nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display += letter;
            }
            in.close();
            view.setText("");
            view.setText(display.toUpperCase());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sound = MediaPlayer.create(game.this, R.raw.sound2);
        sound.setLooping(true);
        display();
    }

    //updating the pieces on each block
    public void redraw() {
        ImageView hua = findViewById(R.id.hu1);
        ImageView hub = findViewById(R.id.hu2);
        ImageView huc = findViewById(R.id.hu3);
        ImageView roa = findViewById(R.id.ro1);
        ImageView rob = findViewById(R.id.ro2);
        ImageView roc = findViewById(R.id.ro3);
        //user
        if (hc == 0) {//0 points
            clear(0, 'h');
        } else if (hc == 1) {//1 point
            clear(1, 'h');
            hua.setImageResource(R.drawable.h1);
        } else if (hc == 2){//2 points
            clear(2, 'h');
            hub.setImageResource(R.drawable.h1);
        } else if (hc == 3){//3 points
            huc.setImageResource(R.drawable.h1);
            clear(3, 'h');
        }
        //rocks
        if(rc == 0){//0 points
            clear (0, 'r');
        } else if (rc == 1) {//1 point
            clear(1, 'r');
            roa.setImageResource(R.drawable.r1);
        } else if (rc == 2){//2 points
            clear(2, 'r');
            rob.setImageResource(R.drawable.r1);
        } else if(rc == 3){//3 points
            roc.setImageResource(R.drawable.r1);
            clear(3, 'r');
        }
    }

    //to instructions
    public void toIns(View view) {
        Intent i = new Intent(this, ins.class);
        startActivity(i);
    }

    //calling the pop up card whenever "next" is clicked
    public void next(View view) {
        box();
    }

    public void reset(View view) {
        TextView ex = findViewById(R.id.ex); TextView r = findViewById(R.id.ra);
        ex.setText("Explanation..."); r.setText("The Rocks answer...");//resetting textViews
        rc = 0; hc = 0; que = ""; tiebreaker = false; on = false;//resetting global values
        while(!d.isEmpty()){//popping remaining cards
            d.pop();
        } d.shuffle();//shuffling again
        clear(0, 'h'); clear(0, 'r');//clearing icons
    }

    //card update for "next"
    public String display() {
        if (!d.isEmpty()) {//updating all the answers, explanations
            c = d.pop();
            que = c.getQuestions();
        }
        return que;//returning question for pop up box
    }

    //rocks answer
    public int rocks(){//two parts due to probability issues
        return (int)((Math.random()*1) + (Math.random()*1));
    }

    //checking answers after selection
    public void check(int a, int b) {//a for user answer, b for rock answer, c for correct answer, e for answer explanation if user gets it wrong
        TextView ex = findViewById(R.id.ex);
        TextView r = findViewById(R.id.ra);
        r.setText("The Rocks answer: " + b);
        if(!tiebreaker) {
            //for user points
            if (!c.equals(a)) {//answer wrong
                ex.setText("Your answer was:" + a + ".\nThe correct answer was " + c.getAnswers() + ".\nExplanation: " + c.getExplanation());
                if (hc == 0)
                    hc += 0;//no negatives
                else
                    hc--;
            } else {//answer right
                ex.setText("Good job! You answered correctly!");
                hc++;
            }
            //for the rock points
            if (!c.equals(b)) {//wrong
                if (rc == 0)
                    rc += 0;//no negatives
                else
                    rc--;
            } else //right
                rc++;
        } else {
            if (c.equals(a) && !c.equals(b)) {
                winner('h');
                ex.setText("Good job! You answered correctly!");
            } else if (c.equals(b) && !c.equals(a)){
                winner('r');
                ex.setText("Your answer was:" + a + ".\nThe correct answer was " + c.getAnswers() + ".\nExplanation: " + c.getExplanation());
            } else if((!c.equals(a) && !c.equals(b)) || (c.equals(b) && c.equals(b))) {
                winner('z');
                ex.setText("Both sides have the same answer!");
            }
        }
        //updating pics and checking for win
        redraw();
        if (rc == 3 || hc == 3)//if any side reaches 3 points, call win method
            win(c.compareTo(hc, rc));//sending the win situation
    }

    //win condition
    public void win(int x) {
        if (x == 1)//user win
            winner('h');
        else if (x == -1)//user lose
            winner('r');
        else if (x == 0){//tie
            Toast.makeText(this, "Sudden Death!", Toast.LENGTH_SHORT).show();
            ImageView title = findViewById(R.id.t);
            title.setImageResource(R.drawable.sd);
            TextView t = findViewById(R.id.ra);
            t.setText("Next point wins!");
            TextView t2 = findViewById(R.id.ex);
            t2.setText("If both sides get the same answer again, it will be a tie!");
            tiebreaker = true;
            hc--; rc--;
            redraw();
        }
    }

    //redirect to tie game if both got it same answer

    //pop up when someone wins
    public void winner(char a){//dialog box with pic
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("OK", null);
        builder.setMessage("Click the Reset button if you want to play again!");
        ImageView i = new ImageView(this);
        if(a == 'h') {//if user wins
            builder.setTitle(display.toUpperCase() + " is the winner!");
            i.setImageResource(R.drawable.winner);

        } else if (a == 'r'){//if user loses
            builder.setTitle("Rocks are the winner!");
            i.setImageResource(R.drawable.loser);
        } else {
            builder.setTitle("Tie Game!");
            i.setImageResource(R.drawable.tie);
        }
        builder.setView(i);
        builder.show();
    }

    //inputting a for block number, b for side
    public void clear (int a, char b){//clearing the blocks when pieces update and move
        ImageView hua = findViewById(R.id.hu1);
        ImageView hub = findViewById(R.id.hu2);
        ImageView huc = findViewById(R.id.hu3);
        ImageView roa = findViewById(R.id.ro1);
        ImageView rob = findViewById(R.id.ro2);
        ImageView roc = findViewById(R.id.ro3);
        if(b == 'h')//for user pics
            if(a == 0) {
                hua.setImageResource(R.drawable.b1);
                hub.setImageResource(R.drawable.b2);
                huc.setImageResource(R.drawable.b3);
            } else if(a == 1){
                hub.setImageResource(R.drawable.b2);
                huc.setImageResource(R.drawable.b3);
            } else if (a == 2){
                hua.setImageResource(R.drawable.b1);
                huc.setImageResource(R.drawable.b3);
            } else {
                hua.setImageResource(R.drawable.b1);
                hub.setImageResource(R.drawable.b2);
            }
        else {//for rock pics
            if(a == 0) {
                roa.setImageResource(R.drawable.b1);
                rob.setImageResource(R.drawable.b2);
                roc.setImageResource(R.drawable.b3);
            } else if(a == 1){
                rob.setImageResource(R.drawable.b2);
                roc.setImageResource(R.drawable.b3);
            } else if (a == 2){
                roa.setImageResource(R.drawable.b1);
                roc.setImageResource(R.drawable.b3);
            } else {
                roa.setImageResource(R.drawable.b1);
                rob.setImageResource(R.drawable.b2);
            }
        }
    }

    //for pop up questions box
    public void box (){
        AlertDialog.Builder select = new AlertDialog.Builder(game.this);
        select.setTitle("Question");
        select.setMessage(display());
        final String[] items = {"0","1","2"};
        select.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
            }
        });
        //button for 0
        select.setNeutralButton("0",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        check(0, rocks());
                    }
                });
        //button for 1
        select.setNegativeButton("1",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        check(1, rocks());
                    }
                });
        //button for 2
        select.setPositiveButton("2",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        check(2, rocks());
                    }
                });
        //displaying the pop up
        AlertDialog alert = select.create();
        alert.setCanceledOnTouchOutside(false);//user cannot exit pop up unless they answer
        alert.show();
    }

    public void music(View view) {
        if(!on) {
            sound.start();
            on = true;
        } else {
            sound.stop();
            on = false;
        }
    }
}