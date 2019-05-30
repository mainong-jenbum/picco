package ui.mainong.pico;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Calendar;

import ui.mainong.pico.codec.Type;
import ui.mainong.pico.helper.PicoListener;
import ui.mainong.pico.util.Converter;

public class Pico extends Dialog implements View.OnClickListener {
    private String title;
    private Type type;

    private DatePicker datePicker;
    private TimePicker timePicker;
    private PicoListener listener;

    private Pico(@NonNull Context context) {
        super(context);
    }

    private Pico(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public Pico(@NonNull Context context, @Nullable String title, @NonNull Type type) {
        this(context);

        this.title = title;
        this.type = type;
    }

    public Pico(@NonNull Context context, String title , @NonNull Type type, int themeResId) {
        this(context, themeResId);

        this.title = title;
        this.type = type;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Sets layout by type
        if (type == Type.CALENDAR) {
            setContentView(R.layout.layout_date_picker);
            datePicker = findViewById(R.id.date_picker);
        } else if(type == Type.TIME){
            setContentView(R.layout.layout_time_picker);
            timePicker = findViewById(R.id.time_picker);
            timePicker.setIs24HourView(false);
        }

        // init controls
        // Controls
        TextView txtTitle = findViewById(R.id.title);
        TextView btnPico = findViewById(R.id.btn_pico);

        // init click listener
        btnPico.setOnClickListener(this);

        // Cancelable
        setCancelable(true);

        // displaying title
        if (title != null)
            txtTitle.setText(title);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_pico) {
            setData();
            dismiss();
        }
    }

    private void setData() {
        Calendar cal = Calendar.getInstance();
        if (type == Type.CALENDAR) {
            cal.set(Calendar.YEAR, datePicker.getYear());
            cal.set(Calendar.MONTH, datePicker.getMonth());
            cal.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
            listener.result(cal);
        }

        if (type == Type.TIME) {
            if(Build.VERSION.SDK_INT < 23){
                cal.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                cal.set(Calendar.MINUTE, timePicker.getCurrentMinute());
            } else{
                cal.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                cal.set(Calendar.MINUTE, timePicker.getMinute());
            }

            listener.result(cal);
        }
    }

    public static String formatDate(Calendar cal){
        return Converter.formatDate(cal.getTime());
    }

    public static String formatTime(Calendar cal){
        return Converter.formatTime(cal);
    }
    public void setPicoListener(PicoListener listener) {
        this.listener = listener;
    }
}
