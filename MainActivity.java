package com.example.matchapp2019;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    public static Variables myAppVariables;
    public static Activity appActivity;
    public boolean isBlue;

    @Override
    public void onBackPressed() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        appActivity = this;

        if (myAppVariables == null) {
            myAppVariables = new Variables();
            //myAppVariables.startBluetooth(this);
        } else {
            if (!myAppVariables.btClient.mmSocket.isConnected()) {
                myAppVariables.btClient.cancel();
                //myAppVariables.startBluetooth(this);
            }
        }

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String assignment = sharedPref.getString("pref_assignment", "Red 1");
//        myAppVariables.setAssignment(assignment);

        setContentView(R.layout.activity_main);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
        TextView eventNameText = (TextView) findViewById(R.id.event);
        EditText scouterNameText = (EditText) findViewById(R.id.name);
        final EditText matchNumberText = (EditText) findViewById(R.id.match);
        //final EditText penaltyText = (EditText) findViewById(R.id.enterPenalty);

        // whenever match number is entered manually, try to get the robot number
        matchNumberText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (myAppVariables.robotPosition != 0) {
                        myAppVariables.matchNumber = Integer.parseInt(matchNumberText.getText().toString());
                        myAppVariables.robotNumber =
                                myAppVariables.getRobotNumber(myAppVariables.matchNumber, myAppVariables.isBlue, myAppVariables.robotPosition);
                        EditText robotText = (EditText) findViewById(R.id.robot);
                        robotText.setText(String.valueOf(myAppVariables.robotNumber));
                    }
                }
            }
        });

        if (!myAppVariables.scouterName.equals("")) {
            scouterNameText.setText(myAppVariables.scouterName);
        }
        if (!myAppVariables.scouterName.equals("")) {
            matchNumberText.setText(Integer.toString(myAppVariables.matchNumber));
            // if robotPosition is set and we have matc schedule loaded, set robot number here
            if (myAppVariables.robotPosition != 0) {
                myAppVariables.robotNumber =
                        myAppVariables.getRobotNumber(myAppVariables.matchNumber, myAppVariables.isBlue, myAppVariables.robotPosition);
                EditText robotText = (EditText) findViewById(R.id.robot);
                robotText.setText(String.valueOf(myAppVariables.robotNumber));
            }
        }
        try {
            long currentTimeInMillis = System.currentTimeMillis();

            if ((currentTimeInMillis >= sdf.parse("Feb 9 2018").getTime()) &&
                    (currentTimeInMillis < sdf.parse("Feb 20 2018").getTime())) {
                eventNameText.setText("Week_0");
            } else if ((currentTimeInMillis >= sdf.parse("Feb 19 2018").getTime()) &&
                    (currentTimeInMillis < sdf.parse("Mar 8 2018").getTime())) {
                eventNameText.setText("WPI");
            } else if ((currentTimeInMillis >= sdf.parse("Mar 8 2018").getTime()) &&
                    (currentTimeInMillis < sdf.parse("Mar 28 2018").getTime())) {
                eventNameText.setText("Bryant");
            } else if ((currentTimeInMillis >= sdf.parse("Mar 30 2018").getTime()) &&
                    (currentTimeInMillis < sdf.parse("Apr 9 2018").getTime())) {
                eventNameText.setText("BU");
            } else {
                eventNameText.setText("Worlds");
            }
            if (myAppVariables.event.equalsIgnoreCase("")) {
                myAppVariables.event = eventNameText.getText().toString();
                myAppVariables.getMatchSchedule();
            }
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }

   /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
//            case R.id.action_status:
//                startActivity(new Intent(this, BluetoothStatusActivity.class));
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    } */

    public void autoPosition(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.position1:
                if (checked) {
                    myAppVariables.robotPosition = 1;
                }
                break;
            case R.id.position2:
                if (checked) {
                    myAppVariables.robotPosition= 2;
                }
                break;
        }
    }

    public void toAuto(View view) {

        EditText t = (EditText) findViewById(R.id.robot);
        if (t.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Enter a Robot Number", Toast.LENGTH_LONG).show();
            return;
        }
        MainActivity.myAppVariables.robotNumber = Integer.parseInt(t.getText().toString());
        EditText g = (EditText) findViewById(R.id.match);
        if (g.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Enter a Match Number", Toast.LENGTH_LONG).show();
            return;
        }
        MainActivity.myAppVariables.matchNumber = Integer.parseInt(g.getText().toString());
        TextView c = (TextView) findViewById(R.id.event);
        MainActivity.myAppVariables.event = c.getText().toString();
        EditText f = (EditText) findViewById(R.id.name);
        if (f.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Enter Scouter Name", Toast.LENGTH_LONG).show();
            return;
        }
        //SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String robotPositionString = sharedPref.getString("pref_assignment", "Red 1");
        //myAppVariables.robotColor = robotPositionString;
        Boolean isBlue = new Boolean(true);
        switch (robotPositionString) {
            case "Red 1":
                // Red 1 processing code
                isBlue = false;
                myAppVariables.robotColor = "Red";
                myAppVariables.robotPosition = 1;
                break;
            case "Red 2":
                //Red 2 processing code
                isBlue = false;
                myAppVariables.robotColor = "Red";
                myAppVariables.robotPosition = 2;
                break;
            case "Red 3":
                //Red 3 processing code
                isBlue = false;
                myAppVariables.robotColor = "Red";
                myAppVariables.robotPosition = 3;
                break;
            case "Blue 1":
                //Blue 1 processing code
                isBlue = true;
                myAppVariables.robotColor = "Blue";
                myAppVariables.robotPosition = 1;
                break;
            case "Blue 2":
                //Blue 2 processing code
                isBlue = true;
                myAppVariables.robotColor = "Blue";
                myAppVariables.robotPosition = 2;
                break;
            case "Blue 3":
                //Blue 3 processing code
                isBlue = true;
                myAppVariables.robotColor = "Blue";
                myAppVariables.robotPosition = 3;
                break;
        }


        if (myAppVariables.robotPosition == 0) {
            Toast.makeText(getApplicationContext(), "Select Robot Position (1,2, or 3)", Toast.LENGTH_LONG).show();
            return;
        }
        if (myAppVariables.matchNumber == 0) {
            Toast.makeText(getApplicationContext(), "Enter Match Number", Toast.LENGTH_LONG).show();
        }
        if (myAppVariables.robotNumber == 0) {
            Toast.makeText(getApplicationContext(), "Enter Robot Number", Toast.LENGTH_LONG).show();
        }


        MainActivity.myAppVariables.scouterName = f.getText().toString();
        if (myAppVariables.scouterName == "") {
            Toast.makeText(getApplicationContext(), "Enter Scouter Name", Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(this, SecondActivity.class);
        //myAppVariables.startAutoTime = System.currentTimeMillis();
        startActivity(intent);


    }


}
