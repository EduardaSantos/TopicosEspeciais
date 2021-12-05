package com.example.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListPopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Validator.ValidationListener{

    @NotEmpty(message = "Por gentileza, insira um nome")
    @Length(min = 3, max = 20, message = "Por gentileza, insira um nome valido" )
    private TextInputEditText nome;

    @NotEmpty(message = "Por gentileza, insira um e-mail")
    @Email(message = "Por gentileza, insira um e-mail valido" )
    private TextInputEditText email;

    @NotEmpty(message = "Por gentileza, insira um telefone")
    @Length(min = 13, max = 13, message = "Por gentileza, insira um telefone valido")
    private TextInputEditText telefone;

    @NotEmpty(message = "Por gentileza, insira uma data")
    @Length(min = 10, max = 10, message = "Por gentileza, insira uma data valida")
    private TextInputEditText dtNasc;

    @Checked(message = "Por gentileza, insira um genero")
    private RadioGroup rgGenero;
    private RadioButton rbFem;
    private RadioButton rbMasc;

    private CheckBox cbFilme;
    private CheckBox cbMusica;

    private TextInputLayout tlNome;
    private TextInputLayout tlEmail;
    private TextInputLayout tlTelefone;
    private TextInputLayout tlDataNasc;

    private Button btCadastrar;
    private Button btEnviar;

    private final static List<Usuario> usuario = new ArrayList<>();

    private Validator validador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponetes();

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validador.validate();
            }
        });
    }

    private void inicializaComponetes(){
        nome = findViewById(R.id.id_tiNome);
        email = findViewById(R.id.id_tiEmail);
        telefone = findViewById(R.id.id_tiTelefone);
        dtNasc = findViewById(R.id.id_tiDatNasc);

        rgGenero = findViewById(R.id.id_rgGenero);
        rbFem = findViewById(R.id.id_rbfeminino);
        rbMasc = findViewById(R.id.id_rbmasc);
        cbFilme = findViewById(R.id.id_cbFilme);
        cbMusica = findViewById(R.id.id_cbMusica);
        btCadastrar = findViewById(R.id.id_btCadastrar);
        btEnviar = findViewById(R.id.id_btEnviar);

        validador = new Validator(this);
        validador.setValidationListener(this);

        tlNome = findViewById(R.id.id_tlNome);
        tlEmail = findViewById(R.id.id_tlEmail);
        tlTelefone = findViewById(R.id.id_tlTelefone);
        tlDataNasc = findViewById(R.id.id_tlDatNasc);

    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "Cadastrado com Sucesso!", Toast.LENGTH_SHORT).show();
        Usuario usuario = new Usuario();
        usuario.setNome(tlNome.getEditText().getText().toString());
        usuario.setEmail(tlEmail.getEditText().getText().toString());
        usuario.setTelefone(tlTelefone.getEditText().getText().toString());
        usuario.setDataNasc(tlDataNasc.getEditText().getText().toString());
        usuario.setGenero(rbMasc.isChecked() ? "Masculino" : "Feminino");
        usuario.setInteresseFilme(cbFilme.isChecked());
        usuario.setInteresseMusica(cbMusica.isChecked());

        limparCampos();

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            if (view instanceof TextInputEditText) {
                switch (view.getId()) {
                    case R.id.id_tiNome:
                        tlNome.setError(message);
                        break;
                    case R.id.id_tiEmail:
                        tlEmail.setError(message);
                        break;
                    case R.id.id_tiTelefone:
                        tlTelefone.setError(message);
                        break;
                    case R.id.id_tiDatNasc:
                        tlDataNasc.setError(message);
                }
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }

    private void limparCampos() {
        nome.setText("");
        email.setText("");
        telefone.setText("");
        dtNasc.setText("");
        rgGenero.clearCheck();
        cbMusica.setChecked(false);
        cbFilme.setChecked(false);
    }
}
