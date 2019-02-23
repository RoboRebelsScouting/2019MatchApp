package com.example.matchapp2019;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.util.ArrayList;
import java.util.List;

public class Variables {
    public int robotNumber;
    public boolean isBlue = true;
    public int matchNumber;
    public String scouterName;
    public String event;
    public int autoGroundCargo;
    public int autoGroundHatch;
    public int autoDropCargo;
    public int autoDropHatch;
    public int autoStationCargo;
    public int autoStationHatch;
    public int autoScoreHatchCS;
    public int autoScoreHatchR1;
    public int autoScoreHatchR2;
    public int autoScoreHatchR3;
    public int autoScoreCargoCS;
    public int autoScoreCargoR1;
    public int autoScoreCargoR2;
    public int autoScoreCargoR3;
    public int teleopGroundCargo;
    public int teleopGroundHatch;
    public int teleopDropCargo;
    public int teleopDropHatch;
    public int teleopStationCargo;
    public int teleopStationHatch;
    public int teleopScoreHatchCS;
    public int teleopScoreHatchR1;
    public int teleopScoreHatchR2;
    public int teleopScoreHatchR3;
    public int teleopScoreCargoCS;
    public int teleopScoreCargoR1;
    public int teleopScoreCargoR2;
    public int teleopScoreCargoR3;
    public int climb;
    public boolean crossHAB;
    public boolean broke;
    public boolean playedDefense;
    public boolean tipped;
    public boolean timerStarted;
    public BluetoothClient btClient;
    public boolean btClientSendOnStart = false;
    public String btClientFileName;
    public String btClientMessageString;
    public int robotPosition = 0;
    public String position = "";
    public String robotColor;
    public Activity btClientActivity;
    ArrayList<Match> matchArrayList = new ArrayList<Match>();


    public Variables() {

        reset();
    }

    public void getMatchSchedule() {
        File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "");
        String fileName = event + "_schedule.dat.csv";
        File file = new File(folder, fileName);

        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                try {
                    while ((line = br.readLine()) != null) {
                        String[] lineList = line.split(",");
                        Match newMatch = new Match();
                        // skip header line
                        if (!lineList[0].equalsIgnoreCase("Start Time")) {
                            newMatch.matchNumber = Integer.parseInt(lineList[1]);
                            newMatch.red1 = Integer.parseInt(lineList[2]);
                            newMatch.red2 = Integer.parseInt(lineList[3]);
                            newMatch.red3 = Integer.parseInt(lineList[4]);
                            newMatch.blue1 = Integer.parseInt(lineList[5]);
                            newMatch.blue2 = Integer.parseInt(lineList[6]);
                            newMatch.blue3 = Integer.parseInt(lineList[7]);
                            matchArrayList.add(newMatch);
                        }
                    }
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public int getRobotNumber(int matchNumber, boolean allianceColor, int robotPosition) {
        for (Match m : matchArrayList) {
            if (m.matchNumber == matchNumber) {
                if (!allianceColor) {
                    if (robotPosition == 1) {
                        return m.red1;
                    } else if (robotPosition == 2) {
                        return m.red2;
                    } else {
                        return m.red3;
                    }
                } else {
                    if (robotPosition == 1) {
                        return m.blue1;
                    } else if (robotPosition == 2) {
                        return m.blue2;
                    } else {
                        return m.blue3;
                    }
                }
            }
        }
        return 0;
    }

    public void setAssignment(String assignment) {
        switch (assignment) {
            case "Red 1":
                isBlue = false;
                robotPosition = 1;
                break;
            case "Red 2":
                isBlue = false;
                robotPosition = 2;
                break;
            case "Red 3":
                isBlue = false;
                robotPosition = 3;
                break;
            case "Blue 1":
                isBlue = true;
                robotPosition = 1;
                break;
            case "Blue 2":
                isBlue = true;
                robotPosition = 2;
                break;
            case "Blue 3":
                isBlue = true;
                robotPosition = 3;
                break;
        }
    }

    /* public void startBluetoothWithFile(Activity theActivity, String fileString, String fileNameBase) {
        btClientSendOnStart = true;
        btClientFileName = btClient.fname =  String.format("%50s",fileNameBase);
        btClientMessageString = fileString;
        btClientActivity = theActivity;
        btClient = startBluetooth(theActivity);
    }
    public BluetoothClient startBluetooth(Activity theActivity) {
        // create bluetooth client and send file
        int REQUEST_ENABLE_BT = 1;
        BluetoothAdapter mBluetoothAdapter = android.bluetooth.BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Toast.makeText(theActivity.getApplicationContext(), "No Bluetooth", Toast.LENGTH_LONG).show();
        }
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(android.bluetooth.BluetoothAdapter.ACTION_REQUEST_ENABLE);
            theActivity.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

        // bluetooth enabled
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address

                if (deviceName.equalsIgnoreCase("TestingServer")) {
                    // create the client, set the file namd and message string, start the thread to send it
                    btClient = new BluetoothClient(mBluetoothAdapter,device);

                    if (btClientSendOnStart) {
                        btClient.sendOnStart = btClientSendOnStart;
                        btClient.launchActivity = btClientActivity;
                        btClient.fname = btClientFileName;
                        btClient.messageString = btClientMessageString;
                    }
                    btClient.start();
                    return btClient;
                }
            }
        }
        return null;
    } */

    public void reset() {

        autoGroundCargo = 0;
        autoGroundHatch = 0;
        autoDropCargo = 0;
        autoDropHatch = 0;
        autoStationCargo = 0;
        autoStationHatch = 0;
        autoScoreHatchCS = 0;
        autoScoreHatchR1 = 0;
        autoScoreHatchR2 = 0;
        autoScoreHatchR3 = 0;
        autoScoreCargoCS = 0;
        autoScoreCargoR1 = 0;
        autoScoreCargoR2 = 0;
        autoScoreCargoR3 = 0;
        teleopGroundCargo = 0;
        teleopGroundHatch = 0;
        teleopDropCargo = 0;
        teleopDropHatch = 0;
        teleopStationCargo = 0;
        teleopStationHatch = 0;
        teleopScoreHatchCS = 0;
        teleopScoreHatchR1 = 0;
        teleopScoreHatchR2 = 0;
        teleopScoreHatchR3 = 0;
        teleopScoreCargoCS = 0;
        teleopScoreCargoR1 = 0;
        teleopScoreCargoR2 = 0;
        teleopScoreCargoR3 = 0;
        scouterName = "";
        event = "";
        isBlue = false;
        matchNumber = 0;
        timerStarted = false;
    }

    public File getAlbumStorageDir(String albumName) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), albumName);
        if (!file.mkdirs()) {
            Log.e("ERROR", "directory NOT Created");
        }
        return file;
    }

    void CSVCreate(Activity theActivity, Boolean useBluetoothActivity, Boolean saveFileOnly) {
        String fileNameBase = event + "-" + robotColor + "-" + robotPosition;
        String fileName = fileNameBase +
                ".csv";
        File directory = getAlbumStorageDir("/FRC2019");
        File file = new File(directory, fileName);
        try {
            FileWriter writer = new FileWriter(file, true);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                String fileString = new String();
                String lineOne = event + "," + matchNumber + "," + robotNumber + "," + robotColor + "," + robotPosition + "," + scouterName.trim() + "," + crossHAB + "," + autoGroundCargo + "," + autoGroundHatch + "," + autoDropCargo + "," + autoDropHatch + "," + autoStationCargo + "," + autoStationHatch + "," + autoScoreHatchCS + "," + autoScoreHatchR1 + "," + autoScoreHatchR2 + "," + autoScoreHatchR3 + "," + autoScoreCargoCS + "," + autoScoreCargoR1 + "," + autoScoreCargoR2 + "," + teleopGroundCargo + "," + teleopGroundHatch + "," + teleopDropCargo + "," + teleopStationCargo + "," + teleopStationHatch + "," + teleopScoreHatchCS + "," + teleopScoreHatchR1 + "," + teleopScoreHatchR2 + "," + teleopScoreHatchR3 + "," + teleopScoreCargoCS + "," + teleopScoreCargoR1 + "," + teleopScoreCargoR2 + "," + teleopScoreCargoR3 + "," + climb + "," + broke + "," + playedDefense + "," + tipped;
                writer.write(lineOne + "\n");
                fileString = fileString + lineOne + "\n";

                String output = "";
                writer.write(output + "\n");
                fileString = fileString + output + "\n";
                writer.close();
            } catch (IOException e) {
                Log.e("ERROR", "File NOT Created", e);
            }
        } catch (IOException e) {
            Log.e("ERROR", "File NOT Created", e);
        }
        /* finally {
            if (file != null) {
                file.flush();
                file.close();
            }
        } */
    }
}



            /* for (int c = 0; c < eventList.size(); c++) {
                String output = "";
                //Long timeSinceStart = (eventList.get(c).eventTime - startAutoTime)/1000 ;
                output = //timeSinceStart + "," +
                        eventList.get(c).eventType + "," +
                        eventList.get(c).eventValue;

                writer.write(output + "\n");
                fileString = fileString + output + "\n";

            } */
    //
            /* if (useBluetoothActivity == true) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                theActivity.startActivityForResult(intent, 0);
                //
            } else if (saveFileOnly == false){
                //btClient.start();
                btClient.fname =  String.format("%50s",fileNameBase);
                btClient.messageString = fileString;
                btClient.launchActivity = theActivity;

                // if not connected
                if (!btClient.mmSocket.isConnected()) {
                    btClient.cancel();
                    this.startBluetoothWithFile(theActivity,fileString,fileNameBase);
                } else {
                    btClient.btSend(fileString);
                }
            } */

