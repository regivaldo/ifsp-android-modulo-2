package br.com.regivaldo.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;
import java.util.Locale;

public class ViagemActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_viagem);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btCalcular = findViewById(R.id.cvBtCalcular);
        btCalcular.setOnClickListener(this);

        Button btVoltar = findViewById(R.id.cvBtVoltar);
        btVoltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cvBtVoltar) {
            finish();
        } else if (v.getId() == R.id.cvBtCalcular) {
            calcular();
        }
    }

    private void calcular() {
        EditText cvDistancia = findViewById(R.id.cvDistancia);
        EditText cvValorLitro = findViewById(R.id.cvValorLitro);
        EditText cvMediaLitro = findViewById(R.id.cvKmMedia);

        double distancia = Double.parseDouble(cvDistancia.getText().toString());
        double valorLitro = Double.parseDouble(cvValorLitro.getText().toString());
        double mediaValor = Double.parseDouble(cvMediaLitro.getText().toString());

        double resultado = (distancia / mediaValor) * valorLitro;
        Locale locale = new Locale("pt", "BR");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

        Toast.makeText(ViagemActivity.this, "Custo total: R$".concat(numberFormat.format(resultado)), Toast.LENGTH_SHORT).show();
    }
}