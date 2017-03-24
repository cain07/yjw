package test.cain.yjw;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ActivityTwo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        LinearLayout ll_add = (LinearLayout) findViewById(R.id.ll_add);

        Header header = new Header(this);
        ll_add.addView(header);


        //绑定activity_main布局文件中的布局项,其中R.id.lenearlay_1为布局文件中设置的id
        LinearLayout linear=(LinearLayout) findViewById(R.id.ll_add_2);
        //添加文本,this代表当前项目
        TextView tv=new TextView(this);
        tv.setText("示例文本框");
        //tv.setId();//设置ID，可有可无，也可以在R文件中添加字符串，然后在这里使用引用的方式使用
        linear.addView(tv);

        // 将Button 加入到LinearLayout 中
        Button b1 = new Button(this);
        b1.setText("取消");
        linear.addView ( b1 );

        // 将Button 2 加入到LinearLayout 中
        Button b2 = new Button(this);
        b2.setText("确定");
        linear.addView ( b2 );

        Button b3 = new Button(this);
        b3.setText("oo");
        linear.addView(b3);

        //linear.removeAllViews();

        //linear.removeView(b1);

        //创建一个相对布局relative
        RelativeLayout relative = new RelativeLayout(this);
        relative.setBackgroundColor(Color.YELLOW);
        // 将Button1 加入到RelativeLayout 中
        Button btn_r1 = new Button(this);
        btn_r1.setText("取消");//设置显示的字符
        btn_r1.setId(32);
        relative.addView(btn_r1);

        // 将Button2 加入到RelativeLayout 中
        Button btn_r2 = new Button(this);
        btn_r2.setText("确定");//设置显示的字符
        relative.addView(btn_r2);

        //置RelativeLayout布局的宽高
        RelativeLayout.LayoutParams lp=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        lp.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        btn_r1.setLayoutParams(lp);   ////设置按钮的布局属性

        lp=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.RIGHT_OF, btn_r1.getId());
        btn_r2.setLayoutParams(lp);   ////设置按钮的布局属性

        //setContentView(relative);
    }
}
