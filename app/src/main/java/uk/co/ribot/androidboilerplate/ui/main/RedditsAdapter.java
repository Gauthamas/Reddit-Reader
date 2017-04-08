package uk.co.ribot.androidboilerplate.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.ribot.androidboilerplate.R;

public class RedditsAdapter extends RecyclerView.Adapter<RedditsAdapter.RibotViewHolder> {

    private List<String> mSubReddits;

    @Inject
    public RedditsAdapter() {
        mSubReddits = new ArrayList<>();
    }

    public void setReddits(List<String> subreddits) {
        mSubReddits = subreddits;
    }

    @Override
    public RibotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_subreddit, parent, false);
        return new RibotViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RibotViewHolder holder, int position) {

        String s = mSubReddits.get(position);
        holder.nameTextView.setText(s);

    }

    @Override
    public int getItemCount() {
        return mSubReddits.size();
    }

    class RibotViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_name) TextView nameTextView;

        public RibotViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
