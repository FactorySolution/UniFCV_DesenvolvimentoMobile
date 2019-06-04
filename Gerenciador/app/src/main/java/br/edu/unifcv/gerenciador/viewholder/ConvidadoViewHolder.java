package br.edu.unifcv.gerenciador.viewholder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.edu.unifcv.gerenciador.R;
import br.edu.unifcv.gerenciador.listener.OnConvidadoListener;
import br.edu.unifcv.gerenciador.model.Convidado;

public class ConvidadoViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextNome;
    private Context mContext;

    public ConvidadoViewHolder(View itemView, Context context) {
        super(itemView);
        this.mContext = context;
        this.mTextNome = itemView.findViewById(R.id.text_nome);
    }

    public void bindData(final Convidado convidado, final OnConvidadoListener listener) {
        this.mTextNome.setText(convidado.getNome());

        this.mTextNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickList(convidado.getId());
            }
        });


        this.mTextNome.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setTitle(mContext.getString(R.string.remover_convidado))
                        .setMessage(mContext.getString(R.string.pergunta_remover_convidado))
                        .setIcon(R.drawable.ic_menu_camera)
                        .setPositiveButton(mContext.getString(R.string.excluir_convidado),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        listener.onDeleteClick(convidado.getId());
                                    }
                                })
                        .setNegativeButton(mContext.getString(R.string.cancelar), null).show();
                return true;
            }
        });
    }
}
