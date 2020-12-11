package uteq.student.deberlistview.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Countries {

    private String Country;
    private String TotalConfirmed;
    private String TotalDeaths;
    private String Date;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public String getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }




    public Countries(JSONObject a) throws JSONException {
       Country = a.getString("Country").toString() ;
       TotalConfirmed  =  a.getString("TotalConfirmed").toString() ;
       TotalDeaths  =  a.getString("TotalDeaths").toString() ;
       Date  =  a.getString("Date").toString() ;

    }

    public static ArrayList<Countries> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Countries> usuarios = new ArrayList<>();

        for (int i = 0; i < datos.length() ; i++) {
            usuarios.add(new Countries(datos.getJSONObject(i)));
        }
        return usuarios;
    }
}
