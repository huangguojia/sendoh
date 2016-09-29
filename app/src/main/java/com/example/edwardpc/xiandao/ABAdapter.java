package com.example.edwardpc.xiandao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by EdwardPC on 2016/9/27.
 */
public class ABAdapter extends BaseAdapter {
    private static final int TYPE_Write = 1;
    //itemB类的type标志
    private static final int TYPE_Blank = 0;

    private Context context;
    //整合数据
    private List<String> data = new ArrayList<>();


    public ABAdapter(Context context, ArrayList<String> as) {
        this.context = context;

        //把数据装载同一个list里面
        //这里把所有数据都转为object类型是为了装载同一个list里面好进行排序
        data.addAll(as);
        //按时间排序来填充数据
        Collections.sort(data, new MyComparator());
    }

    /**
     * 获得itemView的type
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        int result = 0;
        if (DiaryList.myDiray.contains(getDate(position))){
            result=TYPE_Write;
        }else{
            result=TYPE_Blank;
        }
        return result;
    }

    public String getDate(int position){
        String day=String.valueOf(position);
        return DiaryList.Year+DiaryList.Month+day;
    }
    /**
     * 获得有多少中view type
     * @return
     */
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        switch (Integer.parseInt(DiaryList.Month)){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:return 31;
            case 2:return 29;
            default:return 30;
        }
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //创建两种不同种类的viewHolder变量
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        //根据position获得View的type
        int type = getItemViewType(position);
        if (convertView == null) {
            //实例化
            holder1 = new ViewHolder1();
            holder2 = new ViewHolder2();
            //根据不同的type 来inflate不同的item layout
            //然后设置不同的tag
            //这里的tag设置是用的资源ID作为Key
            switch (type) {
                case TYPE_Write:
                    convertView = View.inflate(context, R.layout.blank_diary, null);
                    holder1.title = (TextView) convertView.findViewById(R.id.item_list_for_a_title);
                    holder1.time = (TextView) convertView.findViewById(R.id.item_list_for_a_time);
                    holder1.describe = (TextView) convertView.findViewById(R.id.item_list_for_a_dec);
                    convertView.setTag(R.id.tag_first, holder1);
                    break;
                case TYPE_Blank:
                    convertView = View.inflate(context, R.layout.blackpoint_layout,null);
                    holder2.img = (ImageView) convertView.findViewById(R.id.tag_second);
                    convertView.setTag(R.id.tag_second, holder2);
                    break;
            }

        } else {
            //根据不同的type来获得tag
            switch (type) {
                case TYPE_Write:
                    holder1 = (ViewHolder1) convertView.getTag(R.id.tag_first);
                    break;
                case TYPE_Blank:
                    holder2 = (ViewHolder2) convertView.getTag(R.id.tag_second);
                    break;
            }
        }

       // Object o = data.get(getDate(position));
        //根据不同的type设置数据
        switch (type) {
            case TYPE_Write:
               // A a = (A) o;
                /*holder1.describe.setText("ADescribe:" );
                holder1.time.setText("ATime:" );
                holder1.title.setText("ATitle");*/
                break;

            case TYPE_Blank:
              //  B b = (B) o;
              //  holder2.img.setImageResource(b.getImgResourceID());
                break;
        }
        return convertView;
    }


    public class MyComparator implements Comparator {

        public int compare(Object arg0, Object arg1) {
            //根据不同的情况来进行排序
            Diary a=(Diary) arg0;
            Diary b=(Diary) arg1;
            if (a.getDate()>b.getDate()){
                return 1;
            }else{
                if (a.getDate()<b.getDate()){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }

    /**
     * item A 的Viewholder
     */
    private static class ViewHolder1 {
        TextView time;
        TextView describe;
        TextView title;

    }

    /**
     * item B 的Viewholder
     */
    private static class ViewHolder2 {
        ImageView img;
    }

}

