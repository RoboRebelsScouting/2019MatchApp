package com.example.matchapp2019;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.matchapp2019.MainActivity.myAppVariables;
//This class has the necessary methods for the Autonomous page

public class SecondActivity extends AppCompatActivity {
    public boolean crossedBaseline = false;
    public Handler autoTimer = new Handler();

    @Override
    public void onBackPressed() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // only allow one timer to be created, if onCreate launched a 2nd time
        // don't create new timer
        if (myAppVariables.timerStarted == false) {
            myAppVariables.timerStarted = true;
            /* myAppVariables.autoTime = 20000;
            TextView autoTimerText = (TextView) findViewById(R.id.autoTimerText);
            autoTimerText.setText(String.valueOf(myAppVariables.autoTime / 1000));
            autoTimer.postDelayed(updateTimer, 1000); */
            getSupportActionBar().setTitle(Integer.toString(myAppVariables.robotNumber));
            if (myAppVariables.isBlue == true) {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
            } else {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
            }
        }
    }

    /* private final Runnable updateTimer = new Runnable() {
        public void run() {
            try {
                myAppVariables.autoTime -= 1000;
                TextView autoTimerText = (TextView) findViewById(R.id.autoTimerText);
                autoTimerText.setText(String.valueOf(myAppVariables.autoTime / 1000));
                if (myAppVariables.autoTime <= 0) {
                    toTeleop((View) findViewById(R.id.activity_second));
                } else {
                    autoTimer.postDelayed(this, 1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }; */

    public void toTeleop(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        //autoTimer.removeCallbacks(updateTimer);
        startActivity(intent);
    }
    public int autoScoreHatchCS;
    public int autoScoreHatchR1;
    public int autoScoreHatchR2;
    public int autoScoreHatchR3;
    public int autoScoreCargoCS;
    public int autoScoreCargoR1;
    public int autoScoreCargoR2;
    public int autoScoreCargoR3;

    public void autoHatchGround(View view) {
        myAppVariables.autoGroundHatch ++;
        TextView grHatch1 = (TextView) findViewById(R.id.grHatch1);
        grHatch1.setText(Integer.toString(myAppVariables.autoGroundHatch));
    }
    public void minusAutoHatchGround(View view) {
        if(MainActivity.myAppVariables.autoGroundHatch > 0) {
            MainActivity.myAppVariables.autoGroundHatch--;
        }
        TextView grHatch1 = (TextView) findViewById(R.id.grHatch1);
        grHatch1.setText(Integer.toString(myAppVariables.autoGroundHatch));
    }

    public void autoCargoGround(View view) {
        myAppVariables.autoGroundCargo ++;
        TextView grCargo1 = (TextView) findViewById(R.id.grCargo1);
        grCargo1.setText(Integer.toString(myAppVariables.autoGroundCargo));
    }
    public void minusAutoCargoGround(View view) {
        if(MainActivity.myAppVariables.autoGroundCargo > 0) {
            MainActivity.myAppVariables.autoGroundCargo--;
        }
        TextView grCargo1 = (TextView) findViewById(R.id.grCargo1);
        grCargo1.setText(Integer.toString(myAppVariables.autoGroundCargo));

    }
    public void autoHatchStation(View view) {
        myAppVariables.autoStationHatch ++;
        TextView stHatch1 = (TextView) findViewById(R.id.stHatch1);
        stHatch1.setText(Integer.toString(myAppVariables.autoStationHatch));
    }
    public void minusAutoHatchStation (View view) {
        if(MainActivity.myAppVariables.autoStationHatch > 0) {
            MainActivity.myAppVariables.autoStationHatch--;
        }
        TextView stHatch1 = (TextView) findViewById(R.id.stHatch1);
        stHatch1.setText(Integer.toString(myAppVariables.autoStationHatch));
    }

    public void autoCargoStation (View view) {
        myAppVariables.autoStationCargo ++;
        TextView stCargo1 = (TextView) findViewById(R.id.stCargo1);
        stCargo1.setText(Integer.toString(myAppVariables.autoStationCargo));
    }
    public void minusAutoCargoStation (View view) {
        if(MainActivity.myAppVariables.autoStationCargo > 0) {
            MainActivity.myAppVariables.autoStationCargo--;
        }
        TextView stCargo1 = (TextView) findViewById(R.id.stCargo1);
        stCargo1.setText(Integer.toString(myAppVariables.autoStationCargo));
    }

    public void autoHatchDrop(View view) {
        myAppVariables.autoDropHatch ++;
        TextView drHatch1 = (TextView) findViewById(R.id.drCargo1);
        drHatch1.setText(Integer.toString(myAppVariables.autoDropHatch));
    }
    public void minusAutoHatchDrop (View view) {
        if(MainActivity.myAppVariables.autoDropHatch > 0) {
            MainActivity.myAppVariables.autoDropHatch--;
        }
        TextView drHatch1 = (TextView) findViewById(R.id.drCargo1);
        drHatch1.setText(Integer.toString(myAppVariables.autoDropHatch));
    }

    public void autoCargoDrop (View view) {
        myAppVariables.autoDropCargo ++;
        TextView drCargo1 = (TextView) findViewById(R.id.drCargo1);
        drCargo1.setText(Integer.toString(myAppVariables.autoDropCargo));
    }
    public void minusAutoCargoDrop (View view) {
        if(MainActivity.myAppVariables.autoDropCargo > 0) {
            MainActivity.myAppVariables.autoDropCargo--;
        }
        TextView drCargo1 = (TextView) findViewById(R.id.drCargo1);
        drCargo1.setText(Integer.toString(myAppVariables.autoDropCargo));
    }

    public void autoHatchScoreCS(View view) {
        myAppVariables.autoScoreHatchCS ++;
        TextView hatchCS1 = (TextView) findViewById(R.id.hatchCS1);
        hatchCS1.setText(Integer.toString(myAppVariables.autoScoreHatchCS));
    }
    public void minusAutoHatchScoreCS(View view) {
        if(MainActivity.myAppVariables.autoScoreHatchCS > 0) {
            MainActivity.myAppVariables.autoScoreHatchCS--;
        }
        TextView hatchCS1 = (TextView) findViewById(R.id.hatchCS1);
        hatchCS1.setText(Integer.toString(myAppVariables.autoScoreHatchCS));
    }

    public void autoHatchScoreR1(View view) {
        myAppVariables.autoScoreHatchR1 ++;
        TextView hatchR11 = (TextView) findViewById(R.id.hatchR11);
        hatchR11.setText(Integer.toString(myAppVariables.autoScoreHatchR1));
    }
    public void minusAutoHatchScoreR1(View view) {
        if(MainActivity.myAppVariables.autoScoreHatchR1 > 0) {
            MainActivity.myAppVariables.autoScoreHatchR1--;
        }
        TextView hatchR11 = (TextView) findViewById(R.id.hatchR11);
        hatchR11.setText(Integer.toString(myAppVariables.autoScoreHatchR1));
    }

    public void autoHatchScoreR2(View view) {
        myAppVariables.autoScoreHatchR2 ++;
        TextView hatchR21 = (TextView) findViewById(R.id.hatchR21);
        hatchR21.setText(Integer.toString(myAppVariables.autoScoreHatchR2));
    }
    public void minusAutoHatchScoreR2(View view) {
        if(MainActivity.myAppVariables.autoScoreHatchR2 > 0) {
            MainActivity.myAppVariables.autoScoreHatchR2--;
        }
        TextView hatchR21 = (TextView) findViewById(R.id.hatchR21);
        hatchR21.setText(Integer.toString(myAppVariables.autoScoreHatchR2));
    }

    public void autoHatchScoreR3(View view) {
        myAppVariables.autoScoreHatchR3 ++;
        TextView hatchR31 = (TextView) findViewById(R.id.hatchR31);
        hatchR31.setText(Integer.toString(myAppVariables.autoScoreHatchR3));
    }
    public void minusAutoHatchScoreR3(View view) {
        if(MainActivity.myAppVariables.autoScoreHatchR3 > 0) {
            MainActivity.myAppVariables.autoScoreHatchR3--;
        }
        TextView hatchR31 = (TextView) findViewById(R.id.hatchR31);
        hatchR31.setText(Integer.toString(myAppVariables.autoScoreHatchR3));
    }

    public void autoCargoScoreCS(View view) {
        myAppVariables.autoScoreCargoCS ++;
        TextView cargoCS1 = (TextView) findViewById(R.id.cargoCS1);
        cargoCS1.setText(Integer.toString(myAppVariables.autoScoreCargoCS));
    }
    public void minusAutoCargoScoreCS(View view) {
        if(MainActivity.myAppVariables.autoScoreCargoCS > 0) {
            MainActivity.myAppVariables.autoScoreCargoCS--;
        }
        TextView cargoCS1 = (TextView) findViewById(R.id.cargoCS1);
        cargoCS1.setText(Integer.toString(myAppVariables.autoScoreCargoCS));
    }

    public void autoCargoScoreR1(View view) {
        myAppVariables.autoScoreCargoR1 ++;
        TextView cargoR11 = (TextView) findViewById(R.id.cargoR11);
        cargoR11.setText(Integer.toString(myAppVariables.autoScoreCargoR1));
    }
    public void minusAutoCargoScoreR1(View view) {
        if(MainActivity.myAppVariables.autoScoreCargoR1 > 0) {
            MainActivity.myAppVariables.autoScoreCargoR1--;
        }
        TextView cargoR11 = (TextView) findViewById(R.id.cargoR11);
        cargoR11.setText(Integer.toString(myAppVariables.autoScoreCargoR1));
    }

    public void autoCargoScoreR2(View view) {
        myAppVariables.autoScoreCargoR2 ++;
        TextView cargoR21 = (TextView) findViewById(R.id.cargoR21);
        cargoR21.setText(Integer.toString(myAppVariables.autoScoreCargoR2));
    }
    public void minusAutoCargoScoreR2(View view) {
        if(MainActivity.myAppVariables.autoScoreCargoR2 > 0) {
            MainActivity.myAppVariables.autoScoreCargoR2--;
        }
        TextView cargoR21 = (TextView) findViewById(R.id.cargoR21);
        cargoR21.setText(Integer.toString(myAppVariables.autoScoreCargoR2));
    }

    public void autoCargoScoreR3(View view) {
        myAppVariables.autoScoreCargoR3 ++;
        TextView cargoR31 = (TextView) findViewById(R.id.cargoR31);
        cargoR31.setText(Integer.toString(myAppVariables.autoScoreCargoR3));
    }
    public void minusAutoCargoScoreR3(View view) {
        if(MainActivity.myAppVariables.autoScoreCargoR3 > 0) {
            MainActivity.myAppVariables.autoScoreCargoR3--;
        }
        TextView cargoR31 = (TextView) findViewById(R.id.cargoR31);
        cargoR31.setText(Integer.toString(myAppVariables.autoScoreCargoR3));
    }
}

