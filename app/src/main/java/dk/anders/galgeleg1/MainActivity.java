package dk.anders.galgeleg1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public ImageView visGalge;
    public Galgelogik spil = new Galgelogik();
    public EditText bogstav;
    public Button knap;
    public TextView textSejre, textNederlag, textTitel, ord, brugteBogstaver;


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
        ord = findViewById(R.id.ordGæt);

        ord.setText(spil.getSynligtOrd());
    }

    public void onClick(View v) {
        if (v == knap) {
            spil.gætBogstav(bogstav.getText().toString());
            ord.setText(spil.getSynligtOrd());
            String currentWord = "";

            if (spil.erSidsteBogstavKorrekt() && !spil.erSpilletVundet()) {
                Toast.makeText(this, "Rigtigt gæt! Du gættede på: " + bogstav.getText().toString().toUpperCase(), Toast.LENGTH_SHORT).show();
            } else if (!spil.erSidsteBogstavKorrekt() && spil.getAntalForkerteBogstaver() < 6) {
                Toast.makeText(this, "Ikke rigtigt. Dette var dit " + (spil.getAntalForkerteBogstaver()) + ". forkerte gæt", Toast.LENGTH_SHORT).show();
            } else if (spil.erSpilletVundet()){
                Toast.makeText(this, "FEDT MAN! DU GÆTTEDE ORDET! Ordet var: " + spil.getOrdet(), Toast.LENGTH_SHORT).show();
            } else if (spil.erSpilletTabt()){
                Toast.makeText(this, "Så tæt på, men du har tabt! Ordet var: " + spil.getOrdet(), Toast.LENGTH_SHORT).show();

            }
            // for (int i = 0; i < spil.getBrugteBogstaver().size(); i++){
            //   currentWord = currentWord + " " + spil.getBrugteBogstaver().get(i);

            //}
            //brugteBogstaver.setText(currentWord);

        }
    }

    public void billedeChanger() {


    }
}
