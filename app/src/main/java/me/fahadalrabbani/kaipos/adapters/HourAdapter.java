package me.fahadalrabbani.kaipos.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import me.fahadalrabbani.kaipos.R;
import me.fahadalrabbani.kaipos.weather.Hour;

/**
 * Created by achernar on 10/09/15.
 * HourAdapter Class
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    private Hour[] mHours;
    private Context mContext;

    public HourAdapter(Context context ,Hour[] hours){
        mContext = context;
        mHours = hours;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hourly_list_item,viewGroup,false);
        HourViewHolder viewHolder = new HourViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder hourViewHolder, int position) {
        hourViewHolder.bindHour(mHours[position]);
    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }

    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView mTimeLabel;
        TextView mSummaryLabel;
        TextView mTemperatureLabel;
        ImageView mIconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);
            mTimeLabel = (TextView) itemView.findViewById(R.id.timeLabel2);
            mSummaryLabel = (TextView) itemView.findViewById(R.id.summaryLabel2);
            mTemperatureLabel = (TextView) itemView.findViewById(R.id.temperatureLabel2);
            mIconImageView = (ImageView) itemView.findViewById(R.id.iconImageView2);

            itemView.setOnClickListener(this);
        }

        public void bindHour(Hour hour){
            mTimeLabel.setText(hour.getHour());
            mSummaryLabel.setText(hour.getSummary());
            mTemperatureLabel.setText(String.format("%s˚", String.valueOf(hour.getTemperature())));
            mIconImageView.setImageResource(hour.getIconId());
        }

        @Override
        public void onClick(View v) {
            String time = mTimeLabel.getText().toString();
            String temp = mTemperatureLabel.getText().toString();
            String summary = mSummaryLabel.getText().toString().toLowerCase();
            String message = String.format("At %s it will be %s and %s.",time,temp,summary);

            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        }
    }
}
