package com.mpssdi.test.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mpssdi.test.R;
import com.mpssdi.test.repository.local.entity.MachineWatch;

import java.util.List;



public class WatchAdapter extends BaseAdapter {

    Context context;
    List<MachineWatch> dataList;

    private View vi;
    private ViewHolder viewHolder;
    private static LayoutInflater inflater = null;


    public WatchAdapter(Context context,List<MachineWatch> dataList){
        this.context = context;
        this.dataList = dataList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        vi = view;
        //Populate the Listview
        final int pos = position;
        MachineWatch watch = dataList.get(pos);
        if(vi == null) {
            vi = inflater.inflate(R.layout.listitem_watch, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) vi.findViewById(R.id.watchnameTxt);
            viewHolder.price = (TextView) vi.findViewById(R.id.watchpriceTxt);
            vi.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder) view.getTag();

        viewHolder.name.setText("Machine Name: "+watch.getMachineResult().getName());
        viewHolder.price.setText("\nWatch Name: "+watch.getWatch().getWname()+"  "+
                "Watch Price: "+watch.getWatch().getPrice());

        return vi;
    }

    public class ViewHolder{
        TextView name;
        TextView price;
    }

}
