package br.edu.unifcv.gerenciador.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.edu.unifcv.gerenciador.R;
import br.edu.unifcv.gerenciador.adapter.ConvidadoAdapter;
import br.edu.unifcv.gerenciador.model.Convidado;
import br.edu.unifcv.gerenciador.service.ConvidadoService;

public class TodosFragment extends Fragment {

    private ViewHolder mViewHolder = new ViewHolder();
    private ConvidadoService mConvidadoService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_todos, container, false);

        Context context = view.getContext();

        this.mViewHolder.mRecyclerViewTodos = view.findViewById(R.id.recycler_convidados);

        this.mConvidadoService = new ConvidadoService(context);

        // todos as pessoas do banco
        List<Convidado> convidados = this.mConvidadoService.findAll();

        // definir um adapter
        ConvidadoAdapter adapter = new ConvidadoAdapter(convidados);
        this.mViewHolder.mRecyclerViewTodos.setAdapter(adapter);


        // definir um layout
        this.mViewHolder.mRecyclerViewTodos.setLayoutManager(
                new LinearLayoutManager(context));



        return view;
    }

    private static class ViewHolder {
        RecyclerView mRecyclerViewTodos;
    }

}
