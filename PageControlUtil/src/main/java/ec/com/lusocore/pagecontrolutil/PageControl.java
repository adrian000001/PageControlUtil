package ec.com.lusocore.pagecontrolutil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PageControl extends LinearLayout {



    private ListenerPageControl listenerPageControl;
    private Context context;

    public PageControl(Context context) {
        super(context);
        this.context = context;
        initialize(context,null);

    }

    public PageControl(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        initialize(context,attrs);
    }

    HashMap<Integer,TextView> views = new HashMap<>();
    Drawable select = null;
    Drawable unselect = null;

    @SuppressLint("ResourceType")
    private void initialize(Context context, AttributeSet attrs){

        select = ContextCompat.getDrawable(context,R.drawable.borde_text_circulo);
        unselect = ContextCompat.getDrawable(context,R.drawable.borde_text_circulo);

        if(attrs!=null){

            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.pagecontrol);

            select = a.getDrawable(R.styleable.pagecontrol_backgroundSelect);
            unselect = a.getDrawable(R.styleable.pagecontrol_backgroundUnselect);


        }




        inflate(context, R.layout.item_view, this);
        TextView radious = new TextView(context);
        radious.setTextColor(Color.BLUE);
        radious.setWidth(20);
        radious.setHeight(20);
        radious.setId(1);

        radious.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelected(1);

                listenerPageControl.changePageControl(1);
            }
        });


        views.put(1,radious);

        LayoutParams params = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        params.setMargins(20, 0, 0, 0);

        radious.setBackground(unselect);

        LinearLayout view = findViewById(R.id.content);
        view.addView(radious);

        TextView radious1 = new TextView(context);
        radious1.setTextColor(Color.BLUE);
        radious1.setWidth(20);
        radious1.setHeight(20);
        radious1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelected(2);

                listenerPageControl.changePageControl(2);
            }
        });
        views.put(2,radious1);

        radious1.setLayoutParams(params);

        radious1.setBackground(unselect);

        view.addView(radious1);

        TextView radious2 = new TextView(context);
        radious2.setTextColor(Color.BLUE);
        radious2.setWidth(20);
        radious2.setHeight(20);
        radious2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelected(3);
                listenerPageControl.changePageControl(3);
            }
        });
        views.put(3,radious2);

        radious2.setLayoutParams(params);

        radious2.setBackground(unselect);

        view.addView(radious2);
    }


    public void setSelected(int position){

        Iterator<Map.Entry<Integer, TextView>> iterator = views.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, TextView> entry = iterator.next();
            entry.getValue().setBackground(unselect);
        }

        TextView textView = views.get(position);
        textView.setBackground(select);




    }

    public ListenerPageControl getListenerPageControl() {
        return listenerPageControl;
    }

    public void setListenerPageControl(ListenerPageControl listenerPageControl) {
        this.listenerPageControl = listenerPageControl;
    }
}
