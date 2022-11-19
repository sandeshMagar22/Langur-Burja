package com.icms.langurburja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton club, king, diamond, heart, flag, spade;
    Button roll;
    TextView selectedDice, resultView;
    String selectedValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        club = findViewById(R.id.clubsBtn);
        club.setOnClickListener(this);
        king = findViewById(R.id.kingsBtn);
        king.setOnClickListener(this);
        diamond = findViewById(R.id.diamondBtn);
        diamond.setOnClickListener(this);
        heart = findViewById(R.id.heartBtn);
        heart.setOnClickListener(this);
        flag = findViewById(R.id.flagBtn);
        flag.setOnClickListener(this);
        spade = findViewById(R.id.spadeBtn);
        spade.setOnClickListener(this);

        roll = findViewById(R.id.roll_btn);
        resultView = findViewById(R.id.win_loose_msg);

        selectedDice = findViewById(R.id.selected_dice_msg);


        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ResultDiceFragment resultDiceFragment = new ResultDiceFragment();

                Bundle bundle = new Bundle();
                bundle.putString("dice", selectedValue);
                resultDiceFragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.frame, resultDiceFragment);
                fragmentTransaction.commit();

            }
        });


    }

    public void resultx(String msg) {

        resultView.setText(msg);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.clubsBtn:
                selectedValue = "club";
                break;

            case R.id.diamondBtn:
                selectedValue = "Diamond";
                break;

            case R.id.heartBtn:
                selectedValue = "Heart";
                break;

            case R.id.flagBtn:
                selectedValue = "Flag";
                break;

            case R.id.kingsBtn:
                selectedValue = "King";
                break;

            case R.id.spadeBtn:
                selectedValue = "Spade";
                break;


            default:
                selectedValue = "";
                break;
        }
        selectedDice.setText("Selected dice: " + selectedValue);
    }
}