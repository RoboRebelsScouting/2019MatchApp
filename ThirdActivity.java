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

public class ThirdActivity extends AppCompatActivity {
    public Handler teleopTimer = new Handler();

    @Override
    public void onBackPressed() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().setTitle(Integer.toString( MainActivity.myAppVariables.robotNumber));
        if ( MainActivity.myAppVariables.isBlue == true) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        } else {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
        }
        /* MainActivity.myAppVariables.teleopTime = 135000;
        TextView teleopTimerText = (TextView) findViewById(R.id.teleopTimerText);
        Long timeRemaining =  MainActivity.myAppVariables.teleopTime / 1000;
        Long remainingMinutes = timeRemaining / 60;
        Long remainingSeconds = timeRemaining - (remainingMinutes * 60);
        if (remainingSeconds < 10) {
            teleopTimerText.setText(remainingMinutes + ":0" + remainingSeconds);
        } else {
            teleopTimerText.setText(remainingMinutes + ":" + remainingSeconds);
        }
        teleopTimer.postDelayed(updateTimer, 1000); */

    }

    public void toEndOfGame(View view) {
        /* if ( MainActivity.myAppVariables.teleopTime < 120000) {
            Intent intent = new Intent(this, activity_fourth.class);
            startActivity(intent);
            teleopTimer.removeCallbacks(updateTimer);
        } */
        Intent intent = new Intent(this, FourthActivity.class);
        startActivity(intent);
    }

   /* private final Runnable updateTimer = new Runnable() {
        public void run() {
            try {
                 MainActivity.myAppVariables.teleopTime -= 1000;
                TextView teleopTimerText = (TextView) findViewById(R.id.teleopTimerText);
                Long timeRemaining =  MainActivity.myAppVariables.teleopTime / 1000;
                Long remainingMinutes = timeRemaining / 60;
                Long remainingSeconds = timeRemaining - (remainingMinutes * 60);
                if (remainingSeconds < 10) {
                    teleopTimerText.setText(remainingMinutes + ":0" + remainingSeconds);
                } else {
                    teleopTimerText.setText(remainingMinutes + ":" + remainingSeconds);
                }
                if ( MainActivity.myAppVariables.teleopTime > 0) {
                    teleopTimer.postDelayed(this, 1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }; */
    public void teleopHatchGround(View view) {
        myAppVariables.teleopGroundHatch ++;
        TextView grHatch2 = (TextView) findViewById(R.id.grHatch2);
        grHatch2.setText(Integer.toString(myAppVariables.teleopGroundHatch));
    }
    public void minusTeleopHatchGround(View view) {
        if(MainActivity.myAppVariables.teleopGroundHatch > 0) {
            MainActivity.myAppVariables.teleopGroundHatch--;
        }
        TextView grHatch2 = (TextView) findViewById(R.id.grHatch2);
        grHatch2.setText(Integer.toString(myAppVariables.teleopGroundHatch));
    }

    public void teleopCargoGround(View view) {
        myAppVariables.teleopGroundCargo ++;
        TextView grCargo2 = (TextView) findViewById(R.id.grCargo2);
        grCargo2.setText(Integer.toString(myAppVariables.teleopGroundCargo));
    }
    public void minusTeleopCargoGround(View view) {
        if(MainActivity.myAppVariables.teleopGroundCargo > 0) {
            MainActivity.myAppVariables.teleopGroundCargo--;
        }
        TextView grCargo2 = (TextView) findViewById(R.id.grCargo2);
        grCargo2.setText(Integer.toString(myAppVariables.teleopGroundCargo));

    }
    public void teleopHatchStation(View view) {
        myAppVariables.teleopStationHatch ++;
        TextView stHatch2 = (TextView) findViewById(R.id.stHatch2);
        stHatch2.setText(Integer.toString(myAppVariables.teleopStationHatch));
    }
    public void minusTeleopHatchStation (View view) {
        if(MainActivity.myAppVariables.teleopStationHatch > 0) {
            MainActivity.myAppVariables.teleopStationHatch--;
        }
        TextView stHatch2 = (TextView) findViewById(R.id.stHatch2);
        stHatch2.setText(Integer.toString(myAppVariables.teleopStationHatch));
    }

    public void teleopCargoStation (View view) {
        myAppVariables.teleopStationCargo ++;
        TextView stCargo2 = (TextView) findViewById(R.id.stCargo2);
        stCargo2.setText(Integer.toString(myAppVariables.teleopStationCargo));
    }
    public void minusTeleopCargoStation (View view) {
        if(MainActivity.myAppVariables.teleopStationCargo > 0) {
            MainActivity.myAppVariables.teleopStationCargo--;
        }
        TextView stCargo2 = (TextView) findViewById(R.id.stCargo2);
        stCargo2.setText(Integer.toString(myAppVariables.teleopStationCargo));
    }

    public void teleopHatchDrop(View view) {
        myAppVariables.teleopDropHatch ++;
        TextView drHatch2 = (TextView) findViewById(R.id.drCargo2);
        drHatch2.setText(Integer.toString(myAppVariables.teleopDropHatch));
    }
    public void minusTeleopHatchDrop (View view) {
        if(MainActivity.myAppVariables.teleopDropHatch > 0) {
            MainActivity.myAppVariables.teleopDropHatch--;
        }
        TextView drHatch2 = (TextView) findViewById(R.id.drCargo2);
        drHatch2.setText(Integer.toString(myAppVariables.teleopDropHatch));
    }

    public void teleopCargoDrop (View view) {
        myAppVariables.teleopDropCargo ++;
        TextView drCargo2 = (TextView) findViewById(R.id.drCargo2);
        drCargo2.setText(Integer.toString(myAppVariables.teleopDropCargo));
    }
    public void minusTeleopCargoDrop (View view) {
        if(MainActivity.myAppVariables.teleopDropCargo > 0) {
            MainActivity.myAppVariables.teleopDropCargo--;
        }
        TextView drCargo2 = (TextView) findViewById(R.id.drCargo2);
        drCargo2.setText(Integer.toString(myAppVariables.teleopDropCargo));
    }

    public void teleopHatchScoreCS(View view) {
        myAppVariables.teleopScoreHatchCS ++;
        TextView hatchCS2 = (TextView) findViewById(R.id.hatchCS2);
        hatchCS2.setText(Integer.toString(myAppVariables.teleopScoreHatchCS));
    }
    public void minusTeleopHatchScoreCS(View view) {
        if(MainActivity.myAppVariables.teleopScoreHatchCS > 0) {
            MainActivity.myAppVariables.teleopScoreHatchCS--;
        }
        TextView hatchCS2 = (TextView) findViewById(R.id.hatchCS2);
        hatchCS2.setText(Integer.toString(myAppVariables.teleopScoreHatchCS));
    }

    public void teleopHatchScoreR1(View view) {
        myAppVariables.teleopScoreHatchR1 ++;
        TextView hatchR12 = (TextView) findViewById(R.id.hatchR12);
        hatchR12.setText(Integer.toString(myAppVariables.teleopScoreHatchR1));
    }
    public void minusTeleopHatchScoreR1(View view) {
        if(MainActivity.myAppVariables.teleopScoreHatchR1 > 0) {
            MainActivity.myAppVariables.teleopScoreHatchR1--;
        }
        TextView hatchR12 = (TextView) findViewById(R.id.hatchR12);
        hatchR12.setText(Integer.toString(myAppVariables.teleopScoreHatchR1));
    }

    public void teleopHatchScoreR2(View view) {
        myAppVariables.teleopScoreHatchR2 ++;
        TextView hatchR22 = (TextView) findViewById(R.id.hatchR22);
        hatchR22.setText(Integer.toString(myAppVariables.teleopScoreHatchR2));
    }
    public void minusTeleopHatchScoreR2(View view) {
        if(MainActivity.myAppVariables.teleopScoreHatchR2 > 0) {
            MainActivity.myAppVariables.teleopScoreHatchR2--;
        }
        TextView hatchR22 = (TextView) findViewById(R.id.hatchR22);
        hatchR22.setText(Integer.toString(myAppVariables.teleopScoreHatchR2));
    }

    public void teleopHatchScoreR3(View view) {
        myAppVariables.teleopScoreHatchR3 ++;
        TextView hatchR32 = (TextView) findViewById(R.id.hatchR32);
        hatchR32.setText(Integer.toString(myAppVariables.teleopScoreHatchR3));
    }
    public void minusTeleopHatchScoreR3(View view) {
        if(MainActivity.myAppVariables.teleopScoreHatchR3 > 0) {
            MainActivity.myAppVariables.teleopScoreHatchR3--;
        }
        TextView hatchR32 = (TextView) findViewById(R.id.hatchR32);
        hatchR32.setText(Integer.toString(myAppVariables.teleopScoreHatchR3));
    }

    public void teleopCargoScoreCS(View view) {
        myAppVariables.teleopScoreCargoCS ++;
        TextView cargoCS2 = (TextView) findViewById(R.id.cargoCS2);
        cargoCS2.setText(Integer.toString(myAppVariables.teleopScoreCargoCS));
    }
    public void minusTeleopCargoScoreCS(View view) {
        if(MainActivity.myAppVariables.teleopScoreCargoCS > 0) {
            MainActivity.myAppVariables.teleopScoreCargoCS--;
        }
        TextView cargoCS2 = (TextView) findViewById(R.id.cargoCS2);
        cargoCS2.setText(Integer.toString(myAppVariables.teleopScoreCargoCS));
    }

    public void teleopCargoScoreR1(View view) {
        myAppVariables.teleopScoreCargoR1 ++;
        TextView cargoR12 = (TextView) findViewById(R.id.cargoR12);
        cargoR12.setText(Integer.toString(myAppVariables.teleopScoreCargoR1));
    }
    public void minusTeleopCargoScoreR1(View view) {
        if(MainActivity.myAppVariables.teleopScoreCargoR1 > 0) {
            MainActivity.myAppVariables.teleopScoreCargoR1--;
        }
        TextView cargoR12 = (TextView) findViewById(R.id.cargoR12);
        cargoR12.setText(Integer.toString(myAppVariables.teleopScoreCargoR1));
    }

    public void teleopCargoScoreR2(View view) {
        myAppVariables.teleopScoreCargoR2 ++;
        TextView cargoR22 = (TextView) findViewById(R.id.cargoR22);
        cargoR22.setText(Integer.toString(myAppVariables.teleopScoreCargoR2));
    }
    public void minusTeleopCargoScoreR2(View view) {
        if(MainActivity.myAppVariables.teleopScoreCargoR2 > 0) {
            MainActivity.myAppVariables.teleopScoreCargoR2--;
        }
        TextView cargoR22 = (TextView) findViewById(R.id.cargoR22);
        cargoR22.setText(Integer.toString(myAppVariables.teleopScoreCargoR2));
    }

    public void teleopCargoScoreR3(View view) {
        myAppVariables.teleopScoreCargoR3 ++;
        TextView cargoR32 = (TextView) findViewById(R.id.cargoR32);
        cargoR32.setText(Integer.toString(myAppVariables.teleopScoreCargoR3));
    }
    public void minusTeleopCargoScoreR3(View view) {
        if(MainActivity.myAppVariables.teleopScoreCargoR3 > 0) {
            MainActivity.myAppVariables.teleopScoreCargoR3--;
        }
        TextView cargoR32 = (TextView) findViewById(R.id.cargoR32);
        cargoR32.setText(Integer.toString(myAppVariables.teleopScoreCargoR3));
    }

}

