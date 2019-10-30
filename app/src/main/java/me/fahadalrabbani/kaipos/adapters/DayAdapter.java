package me.fahadalrabbani.kaipos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import me.fahadalrabbani.kaipos.R;
import me.fahadalrabbani.kaipos.weather.Day;

/**
 * Created by achernar on 06/09/15.
 * DayAdapter Class
 */
public class DayAdapter  extends BaseAdapter {

    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context,Day[] days){
        mContext = context;
        mDays = days;
    }
    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item,null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.dayLabel = (TextView) convertView.findViewById(R.id.dayNameLabel);
            holder.temperatureLabel = (TextView) convertView.findViewById(R.id.temperatureLabel);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Day day = mDays[position];

        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatureLabel.setText(String.format(Locale.ENGLISH,"%d", day.getTemperatureMax()));
        if (position == 0){
            holder.dayLabel.setText(R.string.day_today);
        } else if(position == 1) {
            holder.dayLabel.setText(R.string.day_tomorrow);
        } else {
        holder.dayLabel.setText(day.getDayOfTheWeek());
        }


        return convertView;
    }

    private static class ViewHolder {
        ImageView iconImageView;
        TextView temperatureLabel;
        TextView dayLabel;
    }
}
