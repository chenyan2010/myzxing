package com.yeepay.qrscan.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.zxing.WriterException;
import com.yeepay.qrscan.R;
import com.yeepay.qrscan.qrcode.EncodingHandler;

/**
 * Created by yp-tc-m-2567 on 16/3/18.
 */
public class QrcodeActivity extends Activity {
    EditText et_qrcode;

    ImageView iv_qrcode;

    Button btn_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrcode_main);

        et_qrcode = (EditText) findViewById(R.id.et_qrcode);

        iv_qrcode = (ImageView) findViewById(R.id.iv_qrcode);

        btn_create = (Button) findViewById(R.id.btn_create);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = et_qrcode.getText().toString();
                if(!content.equals("")) {
                    try {
                        Bitmap logo = BitmapFactory.decodeResource(getResources(),R.drawable.yeepay_logo);
                        iv_qrcode.setImageBitmap(EncodingHandler.createQrcode(content,logo,450));
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"请在输入框输入内容",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
