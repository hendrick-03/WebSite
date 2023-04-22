package ac.mz.website;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmailActivity extends AppCompatActivity {

    private EditText corpo_ed, remetente_ed, destino_ed;
    private Button enviarbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        corpo_ed = findViewById(R.id.corpo_ed);
        remetente_ed = findViewById(R.id.remetente_ed);
        destino_ed = findViewById(R.id.destino_ed);
        enviarbtn = findViewById(R.id.enviarbtn);



        enviarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = destino_ed.getText().toString();
                String from = remetente_ed.getText().toString();
                String msg = corpo_ed.getText().toString();

                try {
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("text/plain");
                        i.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                        i.putExtra(Intent.EXTRA_SUBJECT, "Assunto do email");
                        i.putExtra(Intent.EXTRA_TEXT, msg + "\n\nDe: "+ from);
                        startActivity(Intent.createChooser(i,"Enviar email"));


                } catch (NumberFormatException e) {
                    Toast.makeText(EmailActivity.this, "Preencha os campos corretamente", Toast.LENGTH_SHORT).show();
                } catch (NullPointerException e) {
                    Toast.makeText(EmailActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}