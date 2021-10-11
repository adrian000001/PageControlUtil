package ec.com.lusocore.swipeanimationutil;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class SwipeHelp extends ConstraintLayout {



    private Context context;
    private int option;

    public SwipeHelp(Context context,int option) {
        super(context);
        this.context = context;
        this.option = option;
        initialize(context,null);

    }

    public SwipeHelp(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        initialize(context,attrs);
    }




    @SuppressLint("ResourceType")
    private void initialize(Context context, AttributeSet attrs){

        try {

            inflate(context, R.layout.view_gesture, this);
            ImageView imageView = (ImageView) findViewById(R.id.gesture);
            Drawable drawable = getImageDirection(option);
            if(drawable != null){

                imageView.setImageDrawable(drawable);
                ObjectAnimator animation = getObjectAnimator(option,imageView);
                if(animation != null){
                    animation.setDuration(700);
                    animation.start();
                }

            }



        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private Drawable getImageDirection(int option){

        try {


            if(option == ShowSwipeHelp.UP){
                return context.getResources().getDrawable(R.drawable.swipe2);
            }else if(option == ShowSwipeHelp.DOWN){
                return context.getResources().getDrawable(R.drawable.swipe2);
            }else if(option == ShowSwipeHelp.LEFT){
                return context.getResources().getDrawable(R.drawable.swipe2);
            }else if(option == ShowSwipeHelp.RIGTH){
                return context.getResources().getDrawable(R.drawable.swipe2);
            }

            return null;



        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }


    }

    private ObjectAnimator getObjectAnimator(int option, ImageView imageView){

        try {


            if(option == ShowSwipeHelp.UP){
                return ObjectAnimator.ofFloat(imageView, "translationY", -400f);
            }else if(option == ShowSwipeHelp.DOWN){
                return ObjectAnimator.ofFloat(imageView, "translationY", 400f);
            }else if(option == ShowSwipeHelp.LEFT){
                return ObjectAnimator.ofFloat(imageView, "translationX", -400f);
            }else if(option == ShowSwipeHelp.RIGTH){
                return ObjectAnimator.ofFloat(imageView, "translationX", 400f);
            }

            return null;



        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }


    }



}
