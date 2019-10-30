package me.fahadalrabbani.kaipos.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.fahadalrabbani.kaipos.R;
import me.fahadalrabbani.kaipos.adapters.HourAdapter;
import me.fahadalrabbani.kaipos.weather.Hour;

public class HourlyForecastActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
        Hour[] mHours = new Hour[0];
        if (parcelables != null) {
            mHours = Arrays.copyOf(parcelables, parcelables.length, Hour[].class);
        }

        final HourAdapter hourAdapter = new HourAdapter(this, mHours);
        mRecyclerView.setAdapter(hourAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);
    }
}
