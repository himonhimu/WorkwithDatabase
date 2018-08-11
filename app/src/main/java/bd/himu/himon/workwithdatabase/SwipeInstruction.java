package bd.himu.himon.workwithdatabase;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Design on 7/2/2018.
 */

public class SwipeInstruction extends PagerAdapter {
    LayoutInflater layoutInflater;
    Context context;

    public SwipeInstruction(Context c){
        context =c;
    }

    @Override
    public int getCount() {
        return MainActivity.Instructions.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myInstruction=layoutInflater.inflate(R.layout.instruct_layout, container,false);
        TextView mytext = (TextView)myInstruction.findViewById(R.id.MyText);

        mytext.setText(MainActivity.Instructions[position]);
        container.addView(myInstruction, 0);

        return myInstruction;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);

        object=null;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        //return view==(View)object;
        return (view==object);
    }
}
