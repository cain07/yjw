package test.cain.yjw;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityThree extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        initView();

    }


    /**
     * 方法描述：初始化<br>
     * 创建时间：2013-4-28 上午11:47:40 创建人：李小冰
     */
    private void initView() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.ll_add);
        layout.setOrientation(LinearLayout.VERTICAL); // 设置Linearlayout 为垂直方向布局

        layout.addView(createView("小张"));
        layout.addView(createView("小林"));
        layout.addView(createView("小李"));
        layout.addView(createView("小黄"));
        layout.addView(createView2("小黄2"));
        layout.addView(createView2("小333"));
    }


    /**
     * 方法描述：创建一个新子View<br>
     * 创建时间：2013-4-28 下午12:52:37 创建人：李小冰
     *
     * @param txt1
     * @param txt2
     * @return
     * ps：这个子View 里面又有两个TextView
     */
    private View createView(String txt) {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        // View view =LayoutInflater.from(this).inflate(R.layout.view_item, null);//也可以从XML中加载布局
        LinearLayout view = new LinearLayout(this);
        view.setLayoutParams(lp);//设置布局参数
        view.setOrientation(LinearLayout.HORIZONTAL);// 设置子View的Linearlayout// 为垂直方向布局

        //定义子View中两个元素的布局
        ViewGroup.LayoutParams vlp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams vlp2 = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv1 = new TextView(this);
        TextView tv2 = new TextView(this);
        tv1.setLayoutParams(vlp);//设置TextView的布局
        tv2.setLayoutParams(vlp2);
        tv1.setText("姓名: ");
        tv2.setText(txt);
        tv2.setPadding(calculateDpToPx(50), 0, 0, 0);//设置边距
        view.addView(tv1);//将TextView 添加到子View 中
        view.addView(tv2);//将TextView 添加到子View 中
        return view;
    }

    /**
     * 方法描述：从布局中加载新子View<br>
     * 创建时间：2013-4-28  下午2:09:57   创建人：李小冰
     * @param txt
     * @return
     */
    private View createView2(String txt){
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.view_item, null);//也可以从XML中加载布局

        //view.setLayoutParams(lp);//设置布局参数

        TextView tv1 = (TextView) view.findViewById(R.id.tv_1);
        TextView tv2 = (TextView) view.findViewById(R.id.tv_2);
        tv1.setText("姓名: ");
        tv2.setText(txt);

        return view;
    }

    /**
     * 方法描述：把dp转换为px<br>
     * 创建时间：2013-4-28  下午2:17:38   创建人：李小冰
     * @param tv
     * @return
     */
    private int calculateDpToPx(int padding_in_dp){
        final float scale = getResources().getDisplayMetrics().density;
        return  (int) (padding_in_dp * scale + 0.5f);
    }

}
