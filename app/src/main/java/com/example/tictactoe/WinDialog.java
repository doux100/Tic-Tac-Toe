package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialog extends Dialog {
    private final String message;
    private final GameStart gameStart;
    public WinDialog(@NonNull Context context,String message,GameStart gameStart) {
        super(context);
        this.message=message;
        this.gameStart=gameStart;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog);

       final TextView textMessage=findViewById(R.id.messageTxt);
       final ImageView startAgainBtn=findViewById(R.id.startAgainBtn);
       final ImageView homeBtn=findViewById(R.id.homeBtn);
       textMessage.setText(message);
       startAgainBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
            gameStart.restartMatch();
            dismiss();
           }
       });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               gameStart.home(getContext(),MainActivity.class);
            }
        });
    }
}
