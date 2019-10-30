package me.fahadalrabbani.kaipos.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

import me.fahadalrabbani.kaipos.R;
import me.fahadalrabbani.kaipos.adapters.DayAdapter;
import me.fahadalrabbani.kaipos.weather.Day;

public class DailyForecastActivity extends ListActivity{

    private Day[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        Intent intent = getIntent();

        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        if (parcelables != null) {
            mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);
        }

        DayAdapter adapter  = new DayAdapter(this, mDays);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String dayofTheWeek = mDays[position].getDayOfTheWeek();
        String conditions = mDays[position].getSummary();
        String highTemp = String.valueOf(mDays[position].getTemperatureMax());
        String message = String.format("On %s the high will be %s and it will be %s",dayofTheWeek,highTemp,conditions);

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
