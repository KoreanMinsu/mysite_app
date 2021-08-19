package com.javaex.mysite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.javaex.vo.GuestbookVo;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView lvGuestbookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //toolbar 영역
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //DATA 가져옴(서버로부터) - 오늘은 가상으로
        List<GuestbookVo> guestbookVoList = getListFromServer();


        //객체화
        lvGuestbookList = (ListView) findViewById(R.id.lvGuestbookList);

        //어댑터 생성
        GuestbookListAdapter guestbookListAdapter =
                new GuestbookListAdapter(getApplicationContext(), R.id.lvGuestbookList, guestbookVoList);

        //어댑터 세팅
        lvGuestbookList.setAdapter(guestbookListAdapter);

        //어탭터리스너 클릭이벤트
        lvGuestbookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //클릭한 view - index
                Log.d("study", "index="+i);

                //클릭한  view-  txtNo
                TextView txtNo = (TextView) view.findViewById(R.id.txtNo);
                Log.d("Study", "No=" + txtNo.getText().toString());

                //화면에 출력안된 리스트의 값 가져오기
                GuestbookVo guestbookVo = (GuestbookVo) adapterView.getItemAtPosition(i);
                Log.d("Study", "Vo=" + guestbookVo.toString());
                Log.d("Study", "Vo.no=" + guestbookVo.getNo());

            }
        });

    }

    //가상의 방명록 정보 만들기
    public List<GuestbookVo> getListFromServer(){
        List<GuestbookVo> guestbookVoList = new ArrayList<GuestbookVo>();

        for(int i=1; i<=50; i++) {
            GuestbookVo guestbookVo = new GuestbookVo();
            guestbookVo.setNo(i);
            guestbookVo.setName(" 쩡우성+"+i);
            guestbookVo.setRegDate("2021-08-19-"+i);
            guestbookVo.setContent(i+"번째 본문");

            guestbookVoList.add(guestbookVo);
        }

        return guestbookVoList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}