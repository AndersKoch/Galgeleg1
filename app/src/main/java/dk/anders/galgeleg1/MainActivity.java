package dk.anders.galgeleg1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public ImageView visGalge;
    public Galgelogik spil = new Galgelogik();
    public Random random = new Random();
    public EditText bogstav;
    public Button knap, knapGenstart, hjælp;
    public TextView textSejre, textNederlag, textTitel, ord, brugteBogstaver;
    int tælSejr, tælNederlag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visGalge = findViewById(R.id.visGalge);
        bogstav = findViewById(R.id.bogstav);
        knap = findViewById(R.id.knap);
        knap.setOnClickListener(this);
        knapGenstart = findViewById(R.id.knapGenstart);
        knapGenstart.setOnClickListener(this);
        hjælp = findViewById(R.id.hjælp);
        hjælp.setOnClickListener(this);

        textSejre = findViewById(R.id.textSejre);
        textNederlag = findViewById(R.id.textNederlag);
        textTitel = findViewById(R.id.textTitel);
        brugteBogstaver = findViewById(R.id.brugteBogstaver);
        ord = findViewById(R.id.ordGæt);

        ord.setText(spil.getSynligtOrd());


    }

    public void onClick(View v) {
        if (v == knap) {
            spil.gætBogstav(bogstav.getText().toString());
            ord.setText(spil.getSynligtOrd());
            String bogstavGæt = bogstav.getText().toString().toUpperCase();
            billedeChanger();

            if (spil.erSidsteBogstavKorrekt() && !spil.erSpilletVundet()) { //Hvis det korrekt, men spillet ikke er vundet
                Toast.makeText(this, "Rigtigt gæt! Du gættede på: " + bogstav.getText().toString().toUpperCase(), Toast.LENGTH_SHORT).show();
            } else if (!spil.erSidsteBogstavKorrekt() && spil.getAntalForkerteBogstaver() < 6) { //Forkert, spil ikke vundet
                Toast.makeText(this, "Ikke rigtigt. Dette var dit " + (spil.getAntalForkerteBogstaver()) + ". forkerte gæt", Toast.LENGTH_SHORT).show();
            } else if (spil.erSpilletVundet()) { //Sidste gæt var korrekt og ordet er gættet
                Toast.makeText(this, "FEDT MAN! DU GÆTTEDE ORDET! Ordet var: " + spil.getOrdet().toUpperCase(), Toast.LENGTH_LONG).show();
                tælSejr++;
                textSejre.setText("Sejre: " + tælSejr);
                knapGenstart.setVisibility(View.VISIBLE);
            } else if (spil.erSpilletTabt()) { //Sidste gæt var forkert og ordet er ikke gættet
                Toast.makeText(this, "Så tæt på, men du har tabt! Ordet var: " + spil.getOrdet(), Toast.LENGTH_LONG).show();
                tælNederlag++;
                textNederlag.setText("Nederlag: " + tælNederlag);
                knapGenstart.setVisibility(View.VISIBLE);

            }

            brugteBogstaver.append(" " + bogstavGæt); //Tilføjer det gættede bogstav
        } else if (v == knapGenstart) {
            genstartSpil();
        }
        else if (v == hjælp) {                      //Vælger et tilfældigt bogstav i ordet
            String hjælpOrd = spil.getOrdet();
            int vælgBogstav = random.nextInt(hjælpOrd.length());
            Toast.makeText(this, "Et af bogstaverne er: " + hjælpOrd.charAt(vælgBogstav), Toast.LENGTH_LONG).show();

        }


    }

    public void genstartSpil() {
        knapGenstart.setVisibility(View.INVISIBLE);
        spil.nulstil();
        billedeChanger();
        ord.setText(spil.getSynligtOrd());
        brugteBogstaver.setText("Brugte bogstaver:");


    }

    public void billedeChanger() {
        if (spil.getAntalForkerteBogstaver() == 0) {
            visGalge.setImageResource(R.drawable.galge1);
        }
        if (spil.getAntalForkerteBogstaver() == 1) {
            visGalge.setImageResource(R.drawable.galge2);
        }
        if (spil.getAntalForkerteBogstaver() == 2) {
            visGalge.setImageResource(R.drawable.galge3);
        }
        if (spil.getAntalForkerteBogstaver() == 3) {
            visGalge.setImageResource(R.drawable.galge4);
        }
        if (spil.getAntalForkerteBogstaver() == 4) {
            visGalge.setImageResource(R.drawable.galge5);
        }
        if (spil.getAntalForkerteBogstaver() == 5) {
            visGalge.setImageResource(R.drawable.galge6);
        }

        if (spil.getAntalForkerteBogstaver() == 6) {
            visGalge.setImageResource(R.drawable.galge7);
        }

    }
}
