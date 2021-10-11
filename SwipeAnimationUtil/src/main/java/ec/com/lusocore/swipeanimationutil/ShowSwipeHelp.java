package ec.com.lusocore.swipeanimationutil;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

import java.util.List;

public class ShowSwipeHelp {


    public final static int UP = 0;
    public final static int DOWN = 1;
    public final static int LEFT = 2;
    public final static int RIGTH = 3;


    private Dialog dialog;

    public void showHelp(Context context,List<Integer> swipeArray){


        try{


          execAnimation(swipeArray,0,context);








        }catch (Exception e){
            Log.e("","",e);
        }

    }




    private void execAnimation(List<Integer> swipeArray, int position,Context context){
        try {


            final Handler handlerStart = new Handler();
            final Runnable rs = new Runnable() {
                public void run() {
                    dialog = getDialog(context,swipeArray.get(position));

                    if(dialog != null){


                        dialog.show();

                        final Handler handler = new Handler();
                        final Runnable r = new Runnable() {
                            public void run() {
                                if(dialog != null){
                                    dialog.hide();
                                }


                            }
                        };

                        handler.postDelayed(r, 700);


                    }




                }
            };

            handlerStart.postDelayed(rs, 1500);


        }catch (Exception e){
            Log.e(this.getClass().getSimpleName(),"ERROR AL EJECUTAR ANIMACION",e);
            if(dialog != null){
                dialog.hide();
            }
        }
    }

    private Dialog getDialog(Context context,int option){
        try{

            SwipeHelp swipeHelp = new SwipeHelp(context,option);

            dialog = new Dialog(context, R.style.Dialog_Translucent);
            dialog.setContentView(swipeHelp);
            dialog.setCancelable(false);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT);


            return dialog;


        }catch (Exception e){
            Log.e(this.getClass().getSimpleName(),"ERROR AL INICIAR ANIMACION",e);
            return null;
        }
    }
}
