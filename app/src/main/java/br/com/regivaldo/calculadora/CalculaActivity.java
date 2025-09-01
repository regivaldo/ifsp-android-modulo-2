package br.com.regivaldo.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculaActivity extends AppCompatActivity implements View.OnClickListener {

    String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcula);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btCalcular = findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(this);

        Button btVoltar = findViewById(R.id.btVoltar);
        btVoltar.setOnClickListener(this);

        TextView tvTitulo = findViewById(R.id.tvTitulo);

        operacao = getIntent().getStringExtra("operacao");

        tvTitulo.setText(operacao.concat(" Números"));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btVoltar) {
            finish();
        } else {
            calcular();
        }
    }

    private void calcular() {
        EditText numA = findViewById(R.id.numA);
        EditText numB = findViewById(R.id.numB);

        int nA = Integer.parseInt(numA.getText().toString());
        int nB = Integer.parseInt(numB.getText().toString());

        int resultado = 0;

        switch (operacao) {
            case "Somar":
                resultado = nA + nB;
                break;
            case "Subtrair":
                resultado = nA - nB;
                break;
            case "Multiplicar":
                resultado = nA * nB;
                break;
            case "Dividir":
                resultado = nA / nB;
                break;
        }

        Toast.makeText(CalculaActivity.this, "Resultado: ".concat(String.valueOf(resultado)), Toast.LENGTH_LONG).show();

    }
}