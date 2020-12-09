package org.electromob.jobapplications;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class jobsviewholder extends RecyclerView.ViewHolder {

    public TextView jo, va, la;

    public jobsviewholder(@NonNull View itemView) {
        super(itemView);

        jo = itemView.findViewById(R.id.sno1);
        va = itemView.findViewById(R.id.vac);
        la = itemView.findViewById(R.id.las);

    }
}
