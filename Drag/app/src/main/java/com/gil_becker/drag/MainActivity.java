package com.gil_becker.drag;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.view).setOnTouchListener(new touchListener());
//        findViewById(R.id.view).getRootView().setOnDragListener(new dragListener());
    }
//    void click(View v){
//        Toast.makeText(v.getContext(),"click",Toast.LENGTH_SHORT).show();
//    }

    private final class touchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("click", "hi");

                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);

                v.startDrag(data, shadowBuilder, v, 0);

                Toast.makeText(v.getContext(), "click", Toast.LENGTH_SHORT).show();

                return true;
            }
            if (event.getAction() == MotionEvent.ACTION_CANCEL) {

                Toast.makeText(v.getContext(), "finish", Toast.LENGTH_SHORT).show();

            }

            return false;

        }
    }
        class dragListener implements View.OnDragListener{
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DROP:
                        float x = event.getX();
                        float y = event.getY();

                        View view = (View) event.getLocalState();
                        view.setX(x - (view.getWidth() / 2));
                        view.setY(y - (view.getHeight() / 2));
                        view.setVisibility(view.INVISIBLE);
                        case DragEvent.ACTION_DRAG_ENDED:
                            v.setVisibility(View.VISIBLE);

                    default:
                        break;
                }
                return false;
            }
        }





}
