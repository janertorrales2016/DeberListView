package uteq.student.deberlistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uteq.student.deberlistview.Model.Countries;
import uteq.student.deberlistview.R;

public class adaptador extends ArrayAdapter<Countries> {

    public adaptador(Context context, ArrayList<Countries> datos) {
        super(context, R.layout.ly_covid, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_covid, null);

        TextView LblCountry = (TextView)item.findViewById(R.id.LblCountry);
        TextView LblTotalConfirmed = (TextView)item.findViewById(R.id.LblTotalConfirmed);
        TextView LblTotalDeaths = (TextView)item.findViewById(R.id.LblTotalDeaths);
        TextView LblDate = (TextView)item.findViewById(R.id.LblDate);

        LblCountry.setText(getItem(position).getCountry());
        LblTotalConfirmed.setText("Total Infectados: "+getItem(position).getTotalConfirmed());
        LblTotalDeaths.setText("Total Muertes: "+ getItem(position).getTotalDeaths());
        LblDate.setText("Fecha Actualizacion: "+ getItem(position).getDate());
        return(item);
    }

}