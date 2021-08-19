package com.javaex.mysite;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.javaex.vo.GuestbookVo;


public class MainActivity extends AppCompatActivity {

    private Button btnWrite;
    private EditText edtName;
    private EditText edtPwd;
    private EditText edtContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = (Button)findViewById(R.id.btnWrite);
        edtName = (EditText)findViewById(R.id.edtName);
        edtPwd = (EditText)findViewById(R.id.edtPwd);
        edtContents = (EditText)findViewById(R.id.edtContents);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setTitle("방명록쓰기"); //xml 에서 찾아서 처리


        //저장버튼 클릭시
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("study", "저장버튼 클릭");

                //방명록데이터 VO 만들기
                String name = edtName.getText().toString();
                String password = edtName.getText().toString();
                String content = edtName.getText().toString();

                GuestbookVo guestbookVo = new GuestbookVo(name, password, content);
                Log.d("sutdy", "vo="+guestbookVo.toString());

                //서버 전송

                //리스트 액티비티로 전환
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("Study", "home버튼 클릭");
        Log.d("Study", "item.getItemId()-->"+item.getItemId());
        Log.d("Study", "android.R.id.home-->"+android.R.id.home);

        switch (item.getItemId()) {

            case R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}