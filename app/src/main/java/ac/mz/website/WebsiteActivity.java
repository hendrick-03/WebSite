package ac.mz.website;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WebsiteActivity extends AppCompatActivity {


    private Button acederbtn;
    private EditText website_txt;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);


        website_txt = findViewById(R.id.website_txt);
        acederbtn = findViewById(R.id.acederbtn);

        webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient());


        acederbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String site = website_txt.getText().toString();

                if(site.isEmpty()){
                    Toast.makeText(WebsiteActivity.this, "Preencha o campo", Toast.LENGTH_SHORT).show();

                }else{
                    String mineType = "text/html";
                    String encoding = "UTF-8";
                    webView.loadData(site, mineType, encoding);
                    setContentView(webView);
                }

            }
        });




    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }

}