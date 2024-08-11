package com.example.d_xnyl;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.IconMarginSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.journeyapps.barcodescanner.ScanIntentResult;

public class QRcodeProfile extends AppCompatActivity {
 Bitmap bitmap;
    private ActivityResultLauncher<Intent> scanQrResultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qrcode_profile);
        ImageView imageView=findViewById(R.id.iv_qrcode);
        Button generate_qr=findViewById(R.id.generate);
        Button scan_qr=findViewById(R.id.scan);
        TextView textView=findViewById(R.id.name);
        scanQrResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                resultData ->{
                    if (resultData.getResultCode() == RESULT_OK) {
                        ScanIntentResult result = ScanIntentResult.parseActivityResult(resultData.getResultCode(), resultData.getData());

                        //this will be qr activity result
                        if (result.getContents() == null) {
                            Toast.makeText(QRcodeProfile.this, textView.getText().toString(), Toast.LENGTH_LONG).show();

                        } else {
                            String qrContents = result.getContents();
                            //TODO Handle qr result here
                        }
                    }
                });
        generate_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(
                        textView.getText().toString())) {

                    // if the edittext inputs are empty
                    // then execute this method showing
                    // a toast message.
                    Toast.makeText(QRcodeProfile.this,"Enter some text to generate QR Code",Toast.LENGTH_SHORT).show();
                }
                else {
                    generateQRCode(
                            textView.getText().toString());
                }
            }

            private void generateQRCode(String string) {
                try {
                    int width = 512;
                    int height = 512;
                    BitMatrix result = new MultiFormatWriter().encode(string, BarcodeFormat.QR_CODE, width, height, null);
                    final int w = result.getWidth();
                    final int h = result.getHeight();
                    final int[] pixels = new int[w * h];

                    for (int y = 0; y < h; y++) {
                        final int offset = y * w;
                        for (int x = 0; x < w; x++) {
                            pixels[offset + x] = result.get(x, y) ? Color.BLACK : Color.WHITE;
                        }
                    }

                    bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                    bitmap.setPixels(pixels, 0, width, 0, 0, w, h);

                    imageView.setImageBitmap(bitmap);


                } catch (WriterException e) {
//                    throw new RuntimeException(e);
                }
            }

            });
        scan_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanQrCode(bitmap);
            }

            private void scanQrCode(Bitmap bitmap) {

                IntentIntegrator intentIntegrator = new IntentIntegrator(QRcodeProfile.this);
                intentIntegrator.setPrompt("Scan a barcode or QR Code");
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.initiateScan();

            }
        });
    }




}