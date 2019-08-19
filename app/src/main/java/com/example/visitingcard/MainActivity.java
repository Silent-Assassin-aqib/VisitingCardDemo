package com.example.visitingcard;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity implements OnTouchListener, OnDragListener {

    private TextView text1,text2,text3;
    private EditText text5,text4,text6;
    private LinearLayout linLay;

    //When touched text gets dropped into either text4 or text5 or text6 then this method will be called
    @Override
    public boolean onDrag(View v, DragEvent event) {

        if (event.getAction()==DragEvent.ACTION_DROP)
        {
            //handle the dragged view being dropped over a target view

            if(v.equals(findViewById(R.id.text4)) || v.equals(findViewById(R.id.text5))
                    || v.equals(findViewById(R.id.text6) )){
                TextView dropped1 = (TextView) event.getLocalState();
                EditText dropTarget1 = (EditText) v;

                Log.d("as", "onDrag: E" + dropped1.getText() + " " + dropTarget1.getText());
                String text=dropTarget1.getText().toString();
                //stop displaying the view where it was before it was dragged
                dropped1.setVisibility(VISIBLE);
                //dropped.setText(dropTarget.getText());
                //if an item has already been dropped here, there will be different string



                //if there is already an item here, set it back visible in its original place
                //  if(text.equals(text1.getText().toString())) text1.setVisibility(View.VISIBLE);
                //  else if(text.equals(text2.getText().toString())) text2.setVisibility(View.VISIBLE);
                //  else if(text.equals(text3.getText().toString())) text3.setVisibility(View.VISIBLE);


                //update the text and color in the target view to reflect the data being dropped
                dropTarget1.setText(dropped1.getText());
                dropped1.setText(text);
            }
            else {
                TextView dropped = (TextView) event.getLocalState();
                TextView dropTarget = (TextView) v;

                Log.d("as", "onDrag: " + dropped.getText() + " " + dropTarget.getText());
                String text = dropTarget.getText().toString();
                //stop displaying the view where it was before it was dragged
                dropped.setVisibility(VISIBLE);
                //dropped.setText(dropTarget.getText());
                //if an item has already been dropped here, there will be different string


                //if there is already an item here, set it back visible in its original place
                //  if(text.equals(text1.getText().toString())) text1.setVisibility(View.VISIBLE);
                //  else if(text.equals(text2.getText().toString())) text2.setVisibility(View.VISIBLE);
                //  else if(text.equals(text3.getText().toString())) text3.setVisibility(View.VISIBLE);


                //update the text and color in the target view to reflect the data being dropped
                dropTarget.setText(dropped.getText());
                dropped.setText(text);
                // dropTarget.setBackgroundColor(Color.BLUE);
            }
        }
        return true;
    }


/*    private final class MyClickListener implements OnLongClickListener {

        // called when the item is long-clicked
        @Override
        public boolean onLongClick(View view) {
            // TODO Auto-generated method stub
            //view.setFocusable(true);
            // create it from the object's tag
            ClipData.Item item = new ClipData.Item((CharSequence)view.getTag());

            String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
            ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);

            DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

            view.startDrag( data, //data to be dragged
                    shadowBuilder, //drag shadow
                    view, //local data about the drag and drop operation
                    0   //no needed flags
            );


            view.setVisibility(View.INVISIBLE);
            return true;
        }
    }*/

    //When text1 or text2 or text3 gets clicked or touched then this method will be called
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN)
        {
            DragShadowBuilder shadowBuilder = new DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            return true;
        }
        else if (event.getAction()==MotionEvent.ACTION_UP)
        {
            DragShadowBuilder shadowBuilder = new DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            return true;
        }
        else return false;
    }

/*    class MyDragListener implements OnDragListener {
        //Drawable normalShape = getResources().getDrawable(R.drawable.normal_shape);
        //Drawable targetShape = getResources().getDrawable(R.drawable.target_shape);

        @Override
        public boolean onDrag(View v, DragEvent event) {

            // Handles each of the expected events
            switch (event.getAction()) {

                //signal for the start of a drag and drop operation.
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;

                //the drag point has entered the bounding box of the View
                case DragEvent.ACTION_DRAG_ENTERED:
                   // v.setBackground(targetShape);   //change the shape of the view
                    break;

                //the user has moved the drag shadow outside the bounding box of the View
                case DragEvent.ACTION_DRAG_EXITED:
                   // v.setBackground(normalShape);   //change the shape of the view back to normal
                    break;

                //drag shadow has been released,the drag point is within the bounding box of the View
                case DragEvent.ACTION_DROP:
                    // if the view is the bottomlinear, we accept the drag item
                    if(v == findViewById(R.id.text6)) {
                        View view = (View) event.getLocalState();
                        ViewGroup viewgroup = (ViewGroup) view.getParent();
                        viewgroup.removeView(view);

                        //change the text
                        TextView text = (TextView) v.findViewById(R.id.text);
                        text.setText("The item is dropped");

                        LinearLayout containView = (LinearLayout) v;
                        containView.addView(view);
                        view.setVisibility(View.VISIBLE);
                    } else {
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                        Context context = getApplicationContext();
                        Toast.makeText(context, "You can't drop the image here",
                                Toast.LENGTH_LONG).show();
                        break;
                    }
                    break;

                //the drag and drop operation has concluded.
                case DragEvent.ACTION_DRAG_ENDED:
                   // v.setBackground(normalShape);   //go back to normal shape

                default:
                    break;
            }
            return true;
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        text3 = (TextView)findViewById(R.id.text3);
        text4 = (EditText)findViewById(R.id.text4);
        text5 = (EditText)findViewById(R.id.text5);
        text6 = (EditText)findViewById(R.id.text6);
        //linLay = (LinearLayout)findViewById(R.id.linAll);

        OnLongClickListener longClickListener = new OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                ClipData data = ClipData.newPlainText("", "");
                DragShadowBuilder shadowBuilder = new DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.VISIBLE);

                return true;
            }
        };

        //Setting touch and drag listeners
/*        text1.setOnTouchListener(this);
        text2.setOnTouchListener(this);
        text3.setOnTouchListener(this);*/

        text1.setOnLongClickListener(longClickListener);
        text2.setOnLongClickListener(longClickListener);
        text3.setOnLongClickListener(longClickListener);
        text4.setOnLongClickListener(longClickListener);
        text5.setOnLongClickListener(longClickListener);
        text6.setOnLongClickListener(longClickListener);

        text4.setOnDragListener(this);
        text5.setOnDragListener(this);
        text6.setOnDragListener(this);
        //text4.setOnLongClickListener(new MyClickListener());
       // text5.setOnLongClickListener(new MyClickListener());
       // text5.setOnTouchListener(this);
       // text6.setOnTouchListener(this);
        text1.setOnDragListener(this);
        text2.setOnDragListener(this);
        text3.setOnDragListener(this);

      //  text4.setOnClickListener(this);

    }




}
