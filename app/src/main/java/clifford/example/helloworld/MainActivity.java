package clifford.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private PopupWindow popupWindow = null;
    TextView textView = null;
    EditText cla = null;
    EditText name = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = new TextView(MainActivity.this);
        textView.setText("查看详情");
        textView.setTextSize(50f);
        textView.setBackgroundColor(android.graphics.Color.WHITE);
        popupWindow = new PopupWindow(textView);
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(1000);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                bgAlpha(1f);
            }
        });
    }

    public void buttonS(View view) {
        Button btn = this.findViewById(R.id.button);
        EditText inputEditText = this.findViewById(R.id.textV);
        String s = inputEditText.getText().toString();
        if (!s.equals("")) {
            ImageView imageView = this.findViewById(R.id.imageView);
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.touxiang);

            cla = this.findViewById(R.id.Class);
            name = this.findViewById(R.id.Name);
            cla.setEnabled(false);
            name.setEnabled(false);
            name.setVisibility(View.VISIBLE);
            cla.setVisibility(View.VISIBLE);
            name.setText("姓名:张三");
            cla.setText("班级:xx年级xx班");

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(btn.getWindowToken(), 0);
        }
    }

    public void studyC(View view) {
        bgAlpha(0.5f);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    public void liveC(View view) {
        bgAlpha(0.5f);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    private void bgAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);
    }
}
