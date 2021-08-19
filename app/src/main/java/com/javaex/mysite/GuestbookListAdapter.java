package com.javaex.mysite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.javaex.vo.GuestbookVo;

import java.util.List;

public class GuestbookListAdapter extends ArrayAdapter<GuestbookVo> {

    private TextView txtNo;
    private TextView txtName;
    private TextView txtRegDate;
    private TextView txtContent;

    //constructor
    public GuestbookListAdapter(Context context, int resource, List<GuestbookVo> objects) {
        super(context, resource, objects);
    }


    //getView 는 ListView 에서 view 를 리턴하여 row 로 사용(item 을 정의)
    //뻥튀기 기계로 예를 들어 처음 화면 + 여유분/ 나머지는 기존 뻥튀기 기계 사용
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        //기존 view 없을때 만들어야함 추가 여유분까지
        if(view==null) {// view 없다 만들어야 한다
            //layout 뻥튀기 기계 받기
            LayoutInflater layoutInflater = (LayoutInflater) LayoutInflater.from(getContext());

            //layout 뻥튀기 view 객체로 부풀리기
            view = layoutInflater.inflate(R.layout.activity_list_item, null);

        }
        //1개의 방명록 데이터
        //1개의 데이터 처리(xml 매칭)

        txtNo = view.findViewById(R.id.txtNo);
        txtName = view.findViewById(R.id.txtName);
        txtRegDate = view.findViewById(R.id.txtRegDate);
        txtContent = view.findViewById(R.id.txtContent);


        //방명록 데이터 가져오기(1개) - 부모쪽에 전체 리스트가 있다
        //getItem : 포지션의 data 가져오기
        GuestbookVo guestbookVo = super.getItem(position);
        txtNo.setText(""+guestbookVo.getNo());
        txtName.setText(""+guestbookVo.getName());
        txtRegDate.setText(""+guestbookVo.getRegDate());
        txtContent.setText(""+guestbookVo.getContent());

        return view;


    }
}
