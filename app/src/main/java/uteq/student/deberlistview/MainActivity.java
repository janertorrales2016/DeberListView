package uteq.student.deberlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uteq.student.deberlistview.Model.Countries;
import uteq.student.deberlistview.WebService.Asynchtask;
import uteq.student.deberlistview.WebService.WebService;
import uteq.student.deberlistview.adapter.adaptador;


public class MainActivity extends AppCompatActivity implements Asynchtask, AdapterView.OnItemClickListener{
    public static final String URL = "https://api.covid19api.com/summary";

    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstOpciones = (ListView)findViewById(R.id.lstListaCovid);


        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(URL,
                datos, this, this);
        ws.execute("GET", "X-Access-Token", "5cf9dfd5-3449-485e-b5ae-70a60e997864");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Countries> lstUsuarios = new ArrayList<Countries> ();

        try {

            JSONObject JSONlista =  new JSONObject(result);
            JSONArray JSONlistaUsuarios=  JSONlista.getJSONArray("Countries");

            lstUsuarios = Countries.JsonObjectsBuild(JSONlistaUsuarios);

            adaptador adapatorUsuario = new adaptador(this, lstUsuarios);
            View header = getLayoutInflater().inflate(R.layout.ly_covid_header, null);

            lstOpciones.addHeaderView(header);
            lstOpciones.setAdapter(adapatorUsuario);
            lstOpciones.setOnItemClickListener(this);
        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }


    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,
                ((Countries)parent.getItemAtPosition(position)).getCountry(),
                Toast.LENGTH_LONG).show();
    }
}