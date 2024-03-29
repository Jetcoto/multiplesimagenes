package co.edu.unilibrecucuta.sliderapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class ViewPageAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private  int []images={R.drawable.i,R.drawable.m,R.drawable.g};

    public ViewPageAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container,final int position){
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView=(ImageView)view.findViewById(R.id.customImage);
        imageView.setImageResource(images[position]);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position == 0) {
                    Toast.makeText(context, "Slide 1 Clicked ", Toast.LENGTH_SHORT).show();
                }else if(position == 1) {
                    Toast.makeText(context, "Slide 2 Clicked ", Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(context, "Slide 3 Clicked ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewPager vp=(ViewPager) container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}