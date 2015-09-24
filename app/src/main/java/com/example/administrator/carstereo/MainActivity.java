package com.example.administrator.carstereo;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.lang.Math;


public class MainActivity extends Activity implements View.OnLongClickListener{
    ToggleButton powerOnOff;
    Switch amfm;
    TextView volume;
    Button eject;

    int AM = 1310;
    double FM = 107.7;
    boolean isAM = true;
    TextView radioDisplay;
    Button upTune;
    Button downTune;

    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;

    int[] AMpreset = {0,550,600,650,700,750,800};
    double[] FMpreset = {0,90.9,92.9,94.9,96.9,98.9,100.9};

    View.OnLongClickListener olcl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        powerOnOff = (ToggleButton) findViewById(R.id.PowerButton);
        amfm = (Switch) findViewById(R.id.AMFMSwitch);
        radioDisplay = (TextView) findViewById(R.id.tunIndicatorTV);
        volume = (TextView) findViewById(R.id.volIndicatorTV);
        eject = (Button) findViewById(R.id.ejectbutton);

        upTune = (Button) findViewById(R.id.tunerPlusButton);
        downTune = (Button) findViewById(R.id.tunerMinusButton);

        one = (Button) findViewById(R.id.preset1);
        two = (Button) findViewById(R.id.preset2);
        three = (Button) findViewById(R.id.preset3);
        four = (Button) findViewById(R.id.preset4);
        five = (Button) findViewById(R.id.preset5);
        six = (Button) findViewById(R.id.preset6);


        one.setOnLongClickListener(this);
        two.setOnLongClickListener(this);
        three.setOnLongClickListener(this);
        four.setOnLongClickListener(this);
        five.setOnLongClickListener(this);
        six.setOnLongClickListener(this);
    }

    public boolean onLongClick(View view){
        if(amfm.isChecked()){

            if(view.equals(one)) FMpreset[1] = FM;
            if(view.equals(two)) FMpreset[2] = FM;
            if(view.equals(three)) FMpreset[3] = FM;
            if(view.equals(four)) FMpreset[4] = FM;
            if(view.equals(five)) FMpreset[5] = FM;
            if(view.equals(six)) FMpreset[6] = FM;

        }else{

            if(view.equals(one)) AMpreset[1] = AM;
            if(view.equals(two)) AMpreset[2] = AM;
            if(view.equals(three)) AMpreset[3] = AM;
            if(view.equals(four)) AMpreset[4] = AM;
            if(view.equals(five)) AMpreset[5] = AM;
            if(view.equals(six)) AMpreset[6] = AM;

        }
        return false;
    }

    public void one(View view){
        if(!amfm.isChecked()){
            AM = AMpreset[1];
            radioDisplay.setText(""+AM);
        }else{
            FM = FMpreset[1];
            radioDisplay.setText(""+FM);
        }
    }
    public void two(View view){
        if(!amfm.isChecked()){
            AM = AMpreset[2];
            radioDisplay.setText(""+AM);
        }else{
            FM = FMpreset[2];
            radioDisplay.setText(""+FM);
        }
    }
    public void three(View view){
        if(!amfm.isChecked()){
            AM = AMpreset[3];
            radioDisplay.setText(""+AM);
        }else{
            FM = FMpreset[3];
            radioDisplay.setText(""+FM);
        }
    }
    public void four(View view){
        if(!amfm.isChecked()){
            AM = AMpreset[4];
            radioDisplay.setText(""+AM);
        }else{
            FM = FMpreset[4];
            radioDisplay.setText(""+FM);
        }
    }
    public void five(View view){
        if(!amfm.isChecked()){
            AM = AMpreset[5];
            radioDisplay.setText(""+AM);
        }else{
            FM = FMpreset[5];
            radioDisplay.setText(""+FM);
        }
    }
    public void six(View view){
        if(!amfm.isChecked()){
            AM = AMpreset[6];
            radioDisplay.setText(""+AM);
        }else{
            FM = FMpreset[6];
            radioDisplay.setText(""+FM);
        }
    }




    public void up(View view){
        if(isAM){
            AM += 10;
            if(AM >= 1710) AM = 530;
            radioDisplay.setText(""+AM);
        }else{
            FM += .2;
            if(FM >= 107.9) FM = 88.1;
            FM = (double) Math.round(FM * 10)/10;
            radioDisplay.setText(""+FM);
        }
    }

    public void down(View view){
        if(isAM){
            AM -= 10;
            if(AM <= 520) AM = 1700;
            radioDisplay.setText(""+AM);
        }else{
            FM -= .2;
            if(FM <= 87.9) FM = 107.9;
            FM = (double) Math.round(FM * 10)/10;
            radioDisplay.setText(""+FM);
        }
    }

    public void RadioSwitch(View view){
        if(isAM){
            radioDisplay.setText("1310");
        }else{
            radioDisplay.setText("107.7");
        }
        isAM = !isAM;
    }

    public void Power(View view) {
        if(!powerOnOff.isChecked()) {
            Paint black = new Paint();
            black.setColor(Color.BLACK);
            amfm.setBackgroundColor(Color.BLACK);
            radioDisplay.setBackgroundColor(Color.BLACK);
            volume.setBackgroundColor(Color.BLACK);
            eject.setBackgroundColor(Color.BLACK);

        }
        else
        {
            amfm.setBackgroundColor(Color.WHITE);
            radioDisplay.setBackgroundColor(Color.WHITE);
            volume.setBackgroundColor(Color.WHITE);
            eject.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
