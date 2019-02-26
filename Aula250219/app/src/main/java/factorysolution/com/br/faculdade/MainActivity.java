package factorysolution.com.br.faculdade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editReal;
    private TextView textDollar;
    private TextView textEuro;
    private Button buttonCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Insere o layout na activity
        setContentView(R.layout.activity_main);

        // Busca os elementos da interface
        this.editReal = (EditText) this.findViewById(R.id.edit_valor);
        this.textDollar = (TextView) this.findViewById(R.id.txt_dollar);
        this.textEuro = (TextView) this.findViewById(R.id.txt_euro);
        this.buttonCalculate = (Button) this.findViewById(R.id.btn_calcular);

        // Limpa os valores iniciais
        this.clearValues();

        // Adiciona evento de click no elemento
        this.buttonCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // Verifica se o elemento clicado é o que nos interessa
        if (view.getId() == R.id.btn_calcular) {

            // Obtém o valor do EditText
            Double mReal = Double.valueOf(this.editReal.getText().toString());

            // Converte valores
            this.textDollar.setText(String.format("%.2f", mReal * 3));
            this.textEuro.setText(String.format("%.2f", mReal * 4));
        }
    }

    /**
     * Limpa os valores iniciais
     */
    private void clearValues() {
        this.textDollar.setText("");
        this.textEuro.setText("");
    }


}
