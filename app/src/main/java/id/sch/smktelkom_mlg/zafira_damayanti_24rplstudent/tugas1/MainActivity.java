package id.sch.smktelkom_mlg.zafira_damayanti_24rplstudent.tugas1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etNomor;
    EditText etEmail;
    Button bOK;
    TextView tvHasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNomor = (EditText) findViewById(R.id.editTextNomor);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        bOK = (Button) findViewById(R.id.button);
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
            }
        });

    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String nomor = etNomor.getText().toString();
            String email = etEmail.getText().toString();
            tvHasil.setText("Nama : " + nama + "\n" + "Nomor : " + nomor + "\n" + "Email : " + email);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String nomor = etNomor.getText().toString();
        String email = etEmail.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 karakter");
        } else {
            etNama.setError(null);
        }
        if (nomor.isEmpty()) {
            etNomor.setError("Anda Belum mengisi Nomor Telepon");
            valid = false;
        } else if (nomor.length() > 12) {
            etNomor.setError("Nomor Maksimal 12 karakter");
            valid = false;
        } else {
            etNomor.setError(null);
        }
        if (email.isEmpty()) {
            etEmail.setError("Anda Belum Mengisi E-Mail anda");
            valid = false;
        } else {
            etEmail.setError(null);
        }
        return valid;
    }
}
