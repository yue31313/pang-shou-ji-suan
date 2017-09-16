package com.cn.health;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class mainActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btn=(Button)findViewById(R.id.count);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				double eheight;//第一个数
				double eweight;//第二个数
				double result;//计算结果
				EditText text1;//第一个文本
				EditText text2;//第二个文本
				TextView ehealth;//显示计算结果的文本
				TextView esuggest;//显示建议的文本
				text1=(EditText)findViewById(R.id.eheight);
		        text2=(EditText)findViewById(R.id.eweight);
		        eheight=Double.parseDouble(text1.getText().toString());
		        eweight=Double.parseDouble(text2.getText().toString());
		        ehealth=(TextView)findViewById(R.id.ehealth);
		        esuggest=(TextView)findViewById(R.id.esuggest);
		        result=eweight/(eheight*eheight)*10000;
		        DecimalFormat df=new DecimalFormat("0.0");
		        String s=df.format(result);
				ehealth.setText(s);
				if(result<18.5){
					esuggest.setText("体重过轻，注意营养！");
				}else if(18.5<=result && result<24){
					esuggest.setText("恭喜你，你的体重正常，请保持！");
				}else if(24<=result && result<27){
					esuggest.setText("你的体重过重，还要坚持锻炼！");
				}else if(27<=result && result<30){
					esuggest.setText("轻度肥胖，请注意！");
				}else if(30<=result && result<35){
					esuggest.setText("中度肥胖，要减肥了！！");
				}else{
					esuggest.setText("重度肥胖，该绝食了！！！");
				}
			}
			
		});
    }
}