package br.edu.unifcv.faculdade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import br.edu.unifcv.faculdade.model.Usuario;
import br.edu.unifcv.faculdade.service.UsuarioService;
import br.edu.unifcv.faculdade.utils.ToastUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        this.loadComponents();

        this.mViewHolder.buttonLogar.setOnClickListener(this);
    }

    private void loadComponents() {
        this.mViewHolder.editUsuario = this.findViewById(R.id.edit_usuario);
        this.mViewHolder.editSenha = this.findViewById(R.id.edit_senha);
        this.mViewHolder.chkLembrar = this.findViewById(R.id.chk_lembrar);
        this.mViewHolder.buttonLogar = this.findViewById(R.id.button_logar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_logar: {
                this.logar();
                break;
            }
        }

    }

    private void logar() {
        Usuario mUsuario = new Usuario();
        mUsuario.setNome(this.mViewHolder.editUsuario.getText().toString());
        mUsuario.setSenha(this.mViewHolder.editSenha.getText().toString());
        UsuarioService mUsuarioService = new UsuarioService(mUsuario);

        if (mUsuarioService.isLoginOk()) {
            Intent mIntent = new Intent(this, MainActivity.class);
            startActivity(mIntent);
            finish();
        } else {
            ToastUtils.ShowToast(this, "Usuário e/ou login inválido");
        }
    }

    private class ViewHolder {
        public EditText editUsuario;
        public EditText editSenha;
        public CheckBox chkLembrar;
        public Button buttonLogar;
    }
}
