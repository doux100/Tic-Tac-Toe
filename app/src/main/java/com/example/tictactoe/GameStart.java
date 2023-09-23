package com.example.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GameStart extends AppCompatActivity {
    private final List<int[]> combinationList = new ArrayList<>();
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int totalSlectedBoxes = 1;
    private int playerTurn = 1;
    private TextView playerOneName, playerTwoName;
    private ImageView slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9;
    private LinearLayout playerOneLayout, playerTwoLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);
        Intent intent = getIntent();
        playerOneName = findViewById(R.id.text_playerone);
        playerOneName.setText(intent.getStringExtra("playerOneName"));
        playerTwoName = findViewById(R.id.text_playertwo);
        playerTwoName.setText(intent.getStringExtra("playerTwoName"));
        slot1 = findViewById(R.id.slot1);
        slot2 = findViewById(R.id.slot2);
        slot3 = findViewById(R.id.slot3);
        slot4 = findViewById(R.id.slot4);
        slot5 = findViewById(R.id.slot5);
        slot6 = findViewById(R.id.slot6);
        slot7 = findViewById(R.id.slot7);
        slot8 = findViewById(R.id.slot8);
        slot9 = findViewById(R.id.slot9);
        combinationList.add(new int[]{0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{2, 4, 6});
        combinationList.add(new int[]{0, 4, 8});
        playerOneLayout = findViewById(R.id.playerOneLayout);
        playerTwoLayout = findViewById(R.id.playerTwoLayout);

    }

    private void takeAction(ImageView imageView, int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = playerTurn;
        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.x_vector);
            if (checkWin()) {
                WinDialog winDialog = new WinDialog(GameStart.this, playerOneName.getText().toString() + " Wins", GameStart.this);
                winDialog.setCancelable(false);
                winDialog.show();
            } else if (totalSlectedBoxes == 9) {
                WinDialog winDialog = new WinDialog(GameStart.this, " Draw !", GameStart.this);
                winDialog.setCancelable(false);
                winDialog.show();
            } else {
                changePlayerTurn(2);
                totalSlectedBoxes++;
            }
        }
        else {
            imageView.setImageResource(R.drawable.o_vector);
            if (checkWin()) {
                WinDialog winDialog = new WinDialog(GameStart.this, playerTwoName.getText().toString() + " Wins", GameStart.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }else if (totalSlectedBoxes == 9) {
                WinDialog winDialog = new WinDialog(GameStart.this, " Draw !", GameStart.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }else {
                changePlayerTurn(1);
                totalSlectedBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentTurn) {
        playerTurn = currentTurn;
        if (playerTurn == 1) {
            playerOneLayout.setBackgroundResource(R.drawable.playerbackground);
            playerTwoLayout.setBackgroundColor(0);
        } else {
            playerTwoLayout.setBackgroundResource(R.drawable.playerbackground);
            playerOneLayout.setBackgroundColor(0);
        }
    }

    private boolean checkWin() {
        boolean response = false;
        for (int i = 0; i < combinationList.size(); i++) {
            final int[] combination = combinationList.get(i);
            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn) {
                response = true;
            }
        }
        return response;
    }

    public void click_sl1(View view) {
        if (isBoxSelectable(0)) {
            takeAction((ImageView) view,0);
        }
    }

    public void click_sl2(View view) {
        if (isBoxSelectable(1)) {
            takeAction((ImageView) view,1);
        }
    }

    public void click_sl3(View view) {
        if (isBoxSelectable(2)) {
            takeAction((ImageView) view,2);
        }
    }

    public void click_sl4(View view) {
        if (isBoxSelectable(3)) {
            takeAction((ImageView) view,3);
        }
    }

    public void click_sl5(View view) {
        if (isBoxSelectable(4)) {
            takeAction((ImageView) view,4);
        }
    }

    public void click_sl6(View view) {
        if (isBoxSelectable(5)) {
            takeAction((ImageView) view,5);
        }
    }

    public void click_sl7(View view) {
        if (isBoxSelectable(6)) {
            takeAction((ImageView) view,6);
        }
    }

    public void click_sl8(View view) {
        if (isBoxSelectable(7)) {
            takeAction((ImageView) view,7);
        }
    }

    public void click_sl9(View view) {
        if (isBoxSelectable(8)) {
            takeAction((ImageView) view,8);
        }
    }

    private boolean isBoxSelectable(int boxPosition) {
        boolean response = boxPositions[boxPosition] == 0;
        return response;
    }
    public void onClickHome(View view) {
        home(this,MainActivity.class);
    }
    public void onClickStartAgain(View view) {
        restartMatch();
    }
    public void restartMatch(){
        boxPositions = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
        totalSlectedBoxes=1;
        slot1.setImageResource(R.drawable.boardbackground);
        slot2.setImageResource(R.drawable.boardbackground);
        slot3.setImageResource(R.drawable.boardbackground);
        slot4.setImageResource(R.drawable.boardbackground);
        slot5.setImageResource(R.drawable.boardbackground);
        slot6.setImageResource(R.drawable.boardbackground);
        slot7.setImageResource(R.drawable.boardbackground);
        slot8.setImageResource(R.drawable.boardbackground);
        slot9.setImageResource(R.drawable.boardbackground);
    }
    public void home(Context context,Class aClass){
        Intent intent=new Intent(context,aClass);
        startActivity(intent);
    }

}