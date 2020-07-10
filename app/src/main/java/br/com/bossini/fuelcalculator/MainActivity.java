package br.com.bossini.fuelcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView gas;
    private TextView etanol;
    private TextView result;
    private ImageView imgFuel;
    private float gasValue;
    private float etanolValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gas = (TextView) findViewById(R.id.gasTextView);
        SeekBar gasSeekBar = (SeekBar) findViewById(R.id.gasSeekBar);
        gasSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float value = ((float)progress / 100);
                gasValue = value;
                gas.setText(String.format("%s %s", getString(R.string.gasoline_mod), value));
                result = (TextView) findViewById(R.id.resultTextView);
                imgFuel = (ImageView) findViewById(R.id.fuelImageView);
                if (etanolValue/gasValue>=0.7){
                    result.setText(R.string.gasoline_option);
                    imgFuel.setImageDrawable(getDrawable(R.drawable.gasoline));
                }else{
                    if (gasValue<=etanolValue){
                        result.setText(R.string.gasoline_option);
                        imgFuel.setImageDrawable(getDrawable(R.drawable.gasoline));
                    }else {
                        result.setText(R.string.ethanol_option);
                        imgFuel.setImageDrawable(getDrawable(R.drawable.ethanol));
                    };
                };
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        etanol = (TextView) findViewById(R.id.etanolTextView);
        SeekBar etanolSeekBar = (SeekBar) findViewById(R.id.etanolSeekBar);
        etanolSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float value = ((float)progress / 100);
                etanolValue = value;
                etanol.setText(String.format("%s %s", getString(R.string.ethanol_mod), value));
                result = (TextView) findViewById(R.id.resultTextView);
                if (etanolValue/gasValue>=0.7){
                    result.setText(R.string.gasoline_option);
                    imgFuel.setImageDrawable(getDrawable(R.drawable.gasoline));
                }else{
                    if (gasValue<=etanolValue){
                        result.setText(R.string.gasoline_option);
                        imgFuel.setImageDrawable(getDrawable(R.drawable.gasoline));
                    }else{
                        result.setText(R.string.ethanol_option);
                        imgFuel.setImageDrawable(getDrawable(R.drawable.ethanol));
                    };
                };
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}