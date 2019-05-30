package ui.mainong.picco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

import ui.mainong.pico.Pico;
import ui.mainong.pico.codec.Type;
import ui.mainong.pico.helper.PicoListener;
import ui.mainong.pop.Pop;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDatePicker = findViewById(R.id.date_picker);
        Button btnTimePicker = findViewById(R.id.time_picker);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.date_picker:
                showDatePickerDialog();
                break;

            case R.id.time_picker:
                showTimePickerDialog();
                break;
        }
    }

    private void showDatePickerDialog() {
        Pico pico = new Pico(this, null, Type.CALENDAR);
        pico.setPicoListener(new PicoListener() {
            @Override
            public void result(Calendar calendar) {
                Pop.info(MainActivity.this, Pico.formatDate(calendar));
                Log.i("DatePicker", Pico.formatTime(calendar));
            }
        });
        pico.show();

    }

    private void showTimePickerDialog() {
        Pico pico = new Pico(this, null, Type.TIME);
        pico.setPicoListener(new PicoListener() {
            @Override
            public void result(Calendar calendar) {
                Pop.info(MainActivity.this, Pico.formatTime(calendar));
                Log.i("TimePicker", Pico.formatDate(calendar));
            }
        });
        pico.show();
    }
}
