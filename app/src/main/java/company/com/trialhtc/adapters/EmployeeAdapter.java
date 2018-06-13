package company.com.trialhtc.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import company.com.trialhtc.R;
import company.com.trialhtc.model.Employee;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private ArrayList<Employee> list;

    public EmployeeAdapter(ArrayList<Employee> list) {
        this.list = list;
    }

    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.phone.setText(list.get(position).getPhoneNumber());
        holder.skills.setText(list.get(position).getSkills().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView phone;
        TextView skills;

        public ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.textname);
            phone = v.findViewById(R.id.textphone);
            skills = v.findViewById(R.id.textskills);
        }
    }
}