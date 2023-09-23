package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
     EditText playerOne,playerTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerOne=findViewById(R.id.playerone);
        playerTwo=findViewById(R.id.playertwo);
        final Button startButton=findViewById(R.id.start);
    }
    public void click_start(View view) {
        final String playerOneName=playerOne.getText().toString();
        final String playerTwoName=playerTwo.getText().toString();
        if (playerOneName.isEmpty()||playerTwoName.isEmpty()){
            Toast.makeText(this,"Please enter players name",Toast.LENGTH_SHORT).show();
        }else {
            Intent intent=new Intent(this, GameStart.class);
            intent.putExtra("playerOneName",playerOneName);
            intent.putExtra("playerTwoName",playerTwoName);
            startActivity(intent);
        }

    }
}