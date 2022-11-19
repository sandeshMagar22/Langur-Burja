package com.icms.langurburja;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;


public class ResultDiceFragment extends Fragment {

    ImageView result1, result2, result3, result4, result5, result6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_result_dice, container, false);
        result1 = view.findViewById(R.id.result_1);
        result2 = view.findViewById(R.id.result_2);
        result3 = view.findViewById(R.id.result_3);
        result4 = view.findViewById(R.id.result_4);
        result5 = view.findViewById(R.id.result_5);
        result6 = view.findViewById(R.id.result_6);


        int dices[] = generateDice();

        result1.setImageResource(drawResourceFromValue(dices[0]));
        result2.setImageResource(drawResourceFromValue(dices[1]));
        result3.setImageResource(drawResourceFromValue(dices[2]));
        result4.setImageResource(drawResourceFromValue(dices[3]));
        result5.setImageResource(drawResourceFromValue(dices[4]));
        result6.setImageResource(drawResourceFromValue(dices[5]));

        Bundle bundle = getArguments();
        String selectedDiceValue = bundle.getString("dice");
        Log.d("gettingDiceFromActivity", selectedDiceValue);
        int diceValue = keyValue(selectedDiceValue);
        Log.d("DICEVALUETOINT", diceValue + "");

        MainActivity mainActivity = (MainActivity) getActivity();


        boolean win = checkWin(dices, diceValue);

        if (win == true) {
            Log.d("WINCONDITION", "WIN!");
            mainActivity.resultx("Win");
        } else {
            Log.d("LOOSECODITION", "LOSE!");
            mainActivity.resultx("loose");
        }


        return view;
    }


    int[] generateDice() {

        int[] dices = new int[6];
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            dices[i] = random.nextInt(6) + 1;

        }

        return dices;
    }

    int drawResourceFromValue(int value) {
        switch (value) {
            case 1:
                return R.drawable.result_clubs;

            case 2:
                return R.drawable.result_diamond;

            case 3:
                return R.drawable.result_heart;

            case 4:
                return R.drawable.result_flag;

            case 5:
                return R.drawable.result_king;

            case 6:
                return R.drawable.result_spade;
            default:
                return R.drawable.result_clubs;
        }

    }

    int keyValue(String dice) {
        switch (dice) {
            case "club":
                return 1;
            case "diamond":
                return 2;
            case "heart":
                return 3;
            case "flag":
                return 4;
            case "king":
                return 5;
            case "spade":
                return 6;
            default:
                return 1;
        }

    }

    boolean checkWin(int dices[], int SelectedDice) {
        for (int i = 0; i < dices.length; i++) {
            if (dices[i] == SelectedDice) {


                return true;
            }
        }
        return false;
    }
}

