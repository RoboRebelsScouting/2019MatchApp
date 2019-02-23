package com.example.matchapp2019;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.matchapp2019.MainActivity.myAppVariables;


public class FourthActivity extends AppCompatActivity {
    public int climb = 0;
    public boolean broke = false;
    public boolean playedDefense = false;
    public boolean tipped = false;
    //public boolean robotCarried = false;

    public boolean useBluetoothActivity = false;
    public boolean saveFileOnly = false;

    @Override
    public void onBackPressed() {
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        getSupportActionBar().setTitle(Integer.toString(MainActivity.myAppVariables.robotNumber));
        if (MainActivity.myAppVariables.isBlue == true) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        } else {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
        }
    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        startMainActivity();
    }
    public void startMainActivity() {
        Intent intent = new Intent(this,  MainActivity.class) ;
        String eventInfo =  MainActivity.myAppVariables.event;
        String scouterNameInfo =  MainActivity.myAppVariables.scouterName;
        Integer matchNumberInfo =  MainActivity.myAppVariables.matchNumber;
        Boolean isBlue =  MainActivity.myAppVariables.isBlue;
         MainActivity.myAppVariables.reset();
         MainActivity.myAppVariables.event = eventInfo;
         MainActivity.myAppVariables.scouterName = scouterNameInfo;
         MainActivity.myAppVariables.matchNumber = matchNumberInfo + 1;
         MainActivity.myAppVariables.isBlue = isBlue;
        startActivity(intent);
    }

    public void climbed (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.climbNo:
                if (checked == true) {
                    climb = 0;
                } else {

                }
                break;
            case R.id.climb1:
                if (checked == true) {
                    climb = 1;
                }
                break;
            case R.id.climb2:
                if (checked == true) {
                    climb = 2;
                } else {

                }
                break;
            case R.id.climb3:
                if (checked == true) {
                    climb = 3;
                }
                break;
        }

    }

    public void broken (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.brokeNo:
                if(checked == true) {
                    broke = false;
                } else {

                }
                break;
            case R.id.brokeYes:
                if(checked == true) {
                    broke = true;
                }
                break;

        }

    }
    public void defense (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.defenseNo:
                if (checked == true) {
                    playedDefense = false;
                }
                break;
            case R.id.defenseYes:
                if (checked == true) {
                    playedDefense = true;
                }
                break;
        }
    }

    public void tipped (View view ) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.tipNo:
                if(checked == true) {
                    tipped = true;
                }
                break;
            case R.id.tipYes:
                if(checked == true) {
                    tipped = true;
                }
                break;
        }
    }

//    public void carried(View view) {
//        boolean checked = ((RadioButton) view).isChecked();
//        switch (view.getId()) {
//            case R.id.carriedNo:
//                if(checked == false) {
//                    robotCarried = false;
//                }
//                break;
//            case R.id.carriedYes:
//                if(checked == true) {
//                    robotCarried = true;
//                }
//                break;
//        }
//    }
    public void submitNew (View view) {
        useBluetoothActivity = false;
        saveFileOnly = false;
        this.createCSV(view);

        myAppVariables.autoGroundCargo = 0;
        myAppVariables.autoGroundHatch = 0;
        myAppVariables.autoDropCargo = 0;
        myAppVariables.autoDropHatch = 0;
        myAppVariables.autoStationCargo = 0;
        myAppVariables.autoStationHatch = 0;
        myAppVariables.autoScoreHatchCS = 0;
        myAppVariables.autoScoreHatchR1 = 0;
        myAppVariables.autoScoreHatchR2 = 0;
        myAppVariables.autoScoreHatchR3 = 0;
        myAppVariables.autoScoreCargoCS = 0;
        myAppVariables.autoScoreCargoR1 = 0;
        myAppVariables.autoScoreCargoR2 = 0;
        myAppVariables.autoScoreCargoR3 = 0;
        myAppVariables.teleopGroundCargo = 0;
        myAppVariables.teleopGroundHatch = 0;
        myAppVariables.teleopDropCargo = 0;
        myAppVariables.teleopDropHatch = 0;
        myAppVariables.teleopStationCargo = 0;
        myAppVariables.teleopStationHatch = 0;
        myAppVariables.teleopScoreHatchCS = 0;
        myAppVariables.teleopScoreHatchR1 = 0;
        myAppVariables.teleopScoreHatchR2 = 0;
        myAppVariables.teleopScoreHatchR3 = 0;
        myAppVariables.teleopScoreCargoCS = 0;
        myAppVariables.teleopScoreCargoR1 = 0;
        myAppVariables.teleopScoreCargoR2 = 0;
        myAppVariables.teleopScoreCargoR3 = 0;
        //zeroes out all values when submitted
        //myAppVariables.scouterName = "";
        //myAppVariables.matchNumber = 0;
        //myAppVariables.robotNumber = 0;


        //EditText editText = (EditText) findViewById(R.id.enterPenalty);
//        if(editText.getText().toString().equals("")) {
//            Toast.makeText(getApplicationContext(), "Enter number of penalties", Toast.LENGTH_LONG).show();
//            return;
//        }
    }


    public void submitOld (View view) {
        useBluetoothActivity = true;
        saveFileOnly = false;
        this.createCSV(view);
    }

    public void saveFile (View view) {
        useBluetoothActivity = false;
        saveFileOnly = true;
        this.createCSV(view);

        //EditText editText = (EditText) findViewById(R.id.enterPenalty);
//        if(editText.getText().toString().equals("")) {
//            Toast.makeText(getApplicationContext(), "Enter number of penalties", Toast.LENGTH_LONG).show();
//            return;
//        }
    }

    public void createCSV (View view) {
        /* if (robotClimbed == true) {
            GameEvent climb = new GameEvent();
            climb.eventType = "climb";
            climb.eventValue = "1";
            climb.eventTime = System.currentTimeMillis();
            myAppVariables.eventList.add(climb);
        }
        if (robotBroke == true) {
            GameEvent broke = new GameEvent();
            broke.eventType = "broke";
            broke.eventValue = "1";
            broke.eventTime = System.currentTimeMillis();
            myAppVariables.eventList.add(broke);
        }
        if(robotParked == true) {
            GameEvent park = new GameEvent();
            park.eventType = "park";
            park.eventValue = "1";
            park.eventTime = System.currentTimeMillis();
            myAppVariables.eventList.add(park);

        }
        if(robotTipped == true) {
            GameEvent tipped = new GameEvent();
            tipped.eventType = "tipped";
            tipped.eventValue = "1";
            tipped.eventTime = System.currentTimeMillis();
            myAppVariables.eventList.add(tipped);
        }

        if(myAppVariables.autoPosition == "left") {
            GameEvent autoPosition = new GameEvent();
            autoPosition.eventType = "autoPosition";
            autoPosition.eventValue = "Left";
            autoPosition.eventTime = System.currentTimeMillis();
            myAppVariables.eventList.add(autoPosition);
        }

        if(myAppVariables.autoPosition == "middle") {
            GameEvent autoPosition = new GameEvent();
            autoPosition.eventType = "autoPosition";
            autoPosition.eventValue = "middle";
            autoPosition.eventTime = System.currentTimeMillis();
            myAppVariables.eventList.add(autoPosition);

        }

        if(myAppVariables.autoPosition == "right") {
            GameEvent autoPosition = new GameEvent();
            autoPosition.eventType = "autoPosition";
            autoPosition.eventValue = "right";
            autoPosition.eventTime = System.currentTimeMillis();
            myAppVariables.eventList.add(autoPosition);
        }

        if(myAppVariables.numberCarriedRobots == 1) {
            GameEvent carriedRobots = new GameEvent();
            carriedRobots.eventType = "carriedRobots";
            carriedRobots.eventValue = "1";
            carriedRobots.eventTime = System.currentTimeMillis();
            myAppVariables.eventList.add(carriedRobots);
        }

        if(myAppVariables.numberCarriedRobots == 2) {
            GameEvent carriedRobots = new GameEvent();
            carriedRobots.eventType = "carriedRobots";
            carriedRobots.eventValue = "1";
            carriedRobots.eventTime = System.currentTimeMillis();
            myAppVariables.eventList.add(carriedRobots);
            myAppVariables.eventList.add(carriedRobots);
        } */


        myAppVariables.CSVCreate(this,useBluetoothActivity,saveFileOnly);
        if (useBluetoothActivity == false) {
            startMainActivity();
        }
    }
}

