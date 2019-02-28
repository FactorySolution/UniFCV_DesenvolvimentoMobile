package factorysolution.com.br.faculdade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder viewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Insere o layout na activity
        setContentView(R.layout.activity_main);

        // Busca os elementos da interface
        this.viewHolder.editReal = (EditText) this.findViewById(R.id.edit_valor);
        this.viewHolder.textDollar = (TextView) this.findViewById(R.id.txt_dollar);
        this.viewHolder.textEuro = (TextView) this.findViewById(R.id.txt_euro);
        this.viewHolder.buttonCalculate = (Button) this.findViewById(R.id.btn_calcular);

        // Limpa os valores iniciais
        this.clearValues();

        // Adiciona evento de click no elemento
        this.viewHolder.buttonCalculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        // Verifica se o elemento clicado é o que nos interessa
        if (view.getId() == R.id.btn_calcular) {

            // Obtém o valor do EditText
            Toast.makeText(this, "Ola mundo", Toast.LENGTH_LONG).show();
            Double mReal = Double.valueOf(this.viewHolder.editReal.getText().toString());

            // Converte valores
            this.viewHolder.textDollar.setText(String.format("%.2f", mReal * 3));
            this.viewHolder.textEuro.setText(String.format("%.2f", mReal * 4));
        }
    }

    /**
     * Limpa os valores iniciais
     */
    private void clearValues() {
        this.viewHolder.textDollar.setText("");
        this.viewHolder.textEuro.setText("");
    }

    private static class ViewHolder {
        public EditText editReal;
        public TextView textDollar;
        public TextView textEuro;
        public Button buttonCalculate;

    }


}
