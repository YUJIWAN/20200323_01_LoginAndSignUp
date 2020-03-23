package kr.co.tjoeun.a20200323_01_loginandsignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import kr.co.tjoeun.a20200323_01_loginandsignup.databinding.ActivityMainBinding;
import kr.co.tjoeun.a20200323_01_loginandsignup.utils.ContextUtil;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {

//        체크박스에 체크가 될때 (변화가 있을때) 마다
//        체크여부를 저장.

        binding.idChexkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

//                ContextUtil을 이용해서 체크 여부를 저장.
                ContextUtil.setIdCheck(mContext, isChecked);


            }
        });


//        로그인 버튼을 누르면 => 입력되어있는 이메일 저장
//         => 입력되어있는 이메일 저장
//        그렇지 않다면 => 이메일 빈칸 "" 으로 저장.
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                체크 박스에 체크가 되어있나?
                if(binding.idChexkBox.isChecked()){
//                    체크가 되었나?
                    String inputEmail = binding.emailTxt.getText().toString();

                    ContextUtil.setEmail(mContext, inputEmail);


                }else{
                    ContextUtil.setEmail(mContext,"");
                }
                }
        });


    }

    @Override
    public void setValues() {

//        이 화면을 키면, 저장된 이메일 값을 emailEdt에 입력.
        binding.emailTxt.setText((ContextUtil.getEmail(mContext)));

        binding.idChexkBox.setChecked(ContextUtil.isIdCheck(mContext));

    }
}
