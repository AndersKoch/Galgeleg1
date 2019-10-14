package dk.anders.galgeleg1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public ImageView visGalge;
    public Galgelogik spil = new Galgelogik();
    public EditText bogstav;
    public Button knap;
    public TextView textSejre, textNederlag, textTitel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visGalge = findViewById(R.id.visGalge);
        bogstav = findViewById(R.id.bogstav);
        knap = findViewById(R.id.knap);
        knap.setOnClickListener(this);

        textSejre = findViewById(R.id.textSejre);
        textNederlag = findViewById(R.id.textNederlag);
        textTitel = findViewById(R.id.textTitel);
        



    }

public void billedeChanger() {


}
}
