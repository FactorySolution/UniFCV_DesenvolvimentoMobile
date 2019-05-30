package br.edu.unifcv.gerenciador.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.edu.unifcv.gerenciador.R;
import br.edu.unifcv.gerenciador.model.Convidado;

public class ConvidadoViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextNome;

    public ConvidadoViewHolder(View itemView) {
        super(itemView);

        this.mTextNome = itemView.findViewById(R.id.text_nome);
    }

    public void bindData(Convidado convidado) {
        this.mTextNome.setText(convidado.getNome());
    }
}
