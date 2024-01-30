package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

//    Player and their numbers
//    X -> 0
//    O -> 1

    int activePlayer = 0;

    boolean activeGame = true;

//    Winning Positions
    int [][] winningPositions = {
        {0,1,2}, {3,4,5}, {6,7,8},
        {0,3,6}, {1,4,7}, {2,5,8},
        {0,4,8}, {2,4,6}
};
    int [] gameState = {2,2,2,2,2,2,2,2,2};
//    2 -> empty
//    0 -> X filled
//    1 -> O filled

    TextView status;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = findViewById(R.id.statusText);
        status.setText("It's X's turn");
    }
    public void onTap(View view){
        ImageView img = (ImageView) view;
        int imageNumber = Integer.parseInt(img.getTag().toString());

        if (!activeGame){
            resetGame(view);
        }
        if (gameState[imageNumber] == 2){

            if (activePlayer == 0){
                img.setImageResource(R.drawable.o_image);
                activePlayer = 1;
                gameState[imageNumber] = 0;
                status = findViewById(R.id.statusText);
                status.setText("It's Y's turn");
            }else{
                img.setImageResource(R.drawable.x_image);
                activePlayer = 0;
                gameState[imageNumber] = 1;
                status = findViewById(R.id.statusText);
                status.setText("It's X's turn");
            }

        }

//        Check for the winning game
        for (int [] winPos : winningPositions){
            if (gameState[winPos[0]] != 2 && gameState[winPos[0]] == gameState[winPos[1]] && gameState[winPos[1]] == gameState[winPos[2]]){
                activeGame= false;
                status = findViewById(R.id.statusText);
                if (activePlayer == 0){
                    status.setText("O has won in life");
                }else{
                    status.setText("X has won in life");
                }
            }
        }
//        Check for the tie
        boolean flag = true;
        for (int i = 0; i < gameState.length; i++){
            if (gameState[i] == 2){
                flag = false;
            }
        }
        if (flag){
            status = findViewById(R.id.statusText);
            status.setText("There is a tie here");
            resetGame(view);
        }
    }

    public void resetGame(View view){
        Arrays.fill(gameState, 2);

        activeGame = true;
        ImageView i0 = findViewById(R.id.imageView0);
        i0.setImageResource(0);
        ImageView i1 = findViewById(R.id.imageView1);
        i1.setImageResource(0);
        ImageView i2 = findViewById(R.id.imageView2);
        i2.setImageResource(0);
        ImageView i3 = findViewById(R.id.imageView3);
        i3.setImageResource(0);
        ImageView i4 = findViewById(R.id.imageView4);
        i4.setImageResource(0);
        ImageView i5 = findViewById(R.id.imageView5);
        i5.setImageResource(0);
        ImageView i6 = findViewById(R.id.imageView6);
        i6.setImageResource(0);
        ImageView i7 = findViewById(R.id.imageView7);
        i7.setImageResource(0);
        ImageView i8 = findViewById(R.id.imageView8);
        i8.setImageResource(0);
    }
}