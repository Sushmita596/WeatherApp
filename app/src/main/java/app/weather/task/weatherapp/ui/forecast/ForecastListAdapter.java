package app.weather.task.weatherapp.ui.forecast;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.weather.task.weatherapp.R;
import app.weather.task.weatherapp.data.model.Forecastday;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastListAdapter extends RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder>{

    private final List<Forecastday> data = new ArrayList<>();

    ForecastListAdapter(ForecastViewModel viewModel, LifecycleOwner lifecycleOwner) {
        viewModel.getForecastLiveData().observe(lifecycleOwner, forecast -> {
            data.clear();
            if (forecast != null) {
                data.addAll(forecast.getForecast().getForecastday());
                notifyDataSetChanged();
            }
        });
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getDateEpoch();
    }

    static final class ForecastViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_day)
        TextView forecastDayTextView;
        @BindView(R.id.tv_avg_temperature)
        TextView avgTempTextView;

        private Forecastday forecastday;

        ForecastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if(forecastday != null) {
                }
            });
        }

        void bind(Forecastday forecastday) {
            this.forecastday = forecastday;
            String temp = new DecimalFormat("#").format(forecastday.getDay().getAvgtempC());
            String tempC =temp+(char) 0x00B0;
            avgTempTextView.setText( tempC + " C"  );
            forecastDayTextView.setText(getDay(forecastday.getDate()));
        }

        private String getDay(String dateInString) {

            SimpleDateFormat dateFormatterCurrent = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormatterApplied = new SimpleDateFormat("EEEE");
            Date date =null;
            try {

                date = dateFormatterCurrent.parse(dateInString);


            } catch (ParseException e) {
                e.printStackTrace();
            }


            return dateFormatterApplied.format(date);



        }
    }
}
