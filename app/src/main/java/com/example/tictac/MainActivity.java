package com.example.tictac;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player =0;
    int total=0;
    int cross[]={-1,-1,-1,-1,-1,-1,-1,-1,-1} ;
    int zero[]={-1,-1,-1,-1,-1,-1,-1,-1,-1} ;
    public void reset(View view){
        androidx.gridlayout.widget.GridLayout g=findViewById(R.id.gridlayout);
    int total_images=g.getChildCount();
      for(int i=0;i<9;i++){
            if(i<total_images){
                ImageView v=(ImageView)g.getChildAt(i);
                v.setImageDrawable(null);
            }
            cross[i]=-1;
            zero[i]=-1;
        }
        total=0;            
        player=0;
    }

    public boolean check(int arr[]){
        if((arr[0]==1&&arr[1]==1&&arr[2]==1)||(arr[3]==1&&arr[4]==1&&arr[5]==1)||(arr[6]==1&&arr[7]==1&&arr[8]==1)||(arr[0]==1&&arr[3]==1&&arr[6]==1)||(arr[1]==1&&arr[4]==1&&arr[7]==1)||(arr[2]==1&&arr[5]==1&&arr[8]==1)||(arr[0]==1&&arr[4]==1&&arr[8]==1)||(arr[2]==1&&arr[4]==1&&arr[6]==1)){
            return true;
        }
        else{
            return false;
        }
    }
    public void load(View view){
        ImageView v=(ImageView) view;
        int tag=Integer.parseInt( v.getTag().toString());
        total++;
        if(total<10&&zero[tag]!=1&&cross[tag]!=1) {
            if (player == 0) {
                v.setImageResource(R.drawable.cross);
                Toast.makeText(this, tag + "" + "CROSS", Toast.LENGTH_SHORT).show();
                player = 1;
                cross[tag]=1;
                if(total>4){
                    if(check(cross)){
                        total=9;
                        Toast.makeText(this,"CROSS WON ",Toast.LENGTH_SHORT).show();
                    }
                }

            } else if(total<10&&zero[tag]!=1&&cross[tag]!=1) {
                v.setImageResource(R.drawable.zero);
                Toast.makeText(this, tag + " " + "ZERO", Toast.LENGTH_SHORT).show();
                player = 0;
                zero[tag]=1;
                if(total>4){
                    if(check(zero)){
                        total=9;
                        Toast.makeText(this,"ZERO WON ",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        }
        if(total==9){
            Toast.makeText(this,"game finished",Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("be alert").setMessage("welcome to the game").setNeutralButton("play", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"game started",Toast.LENGTH_SHORT).show();
            }
        }).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}