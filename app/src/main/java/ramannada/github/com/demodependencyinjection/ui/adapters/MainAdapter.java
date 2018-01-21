package ramannada.github.com.demodependencyinjection.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import ramannada.github.com.demodependencyinjection.R;
import ramannada.github.com.demodependencyinjection.data.entity.Article;
import ramannada.github.com.demodependencyinjection.data.entity.Mahasiswa;

/**
 * Created by ramannada on 1/19/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MahasiswaHolder> {
    private List<Article> articles;

    public MainAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public MahasiswaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_article, parent, false);
        return new MahasiswaHolder(view);
    }

    @Override
    public void onBindViewHolder(MahasiswaHolder holder, int position) {
        Article article = articles.get(position);
        holder.bindView(article);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


    public class MahasiswaHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_tag)
        TextView tvTag;
        @BindView(R.id.tv_content)
        TextView tvContent;

        public MahasiswaHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindView(Article article) {
            tvTitle.setText(article.getTitle());
            tvTag.setText(article.getTags().toString());
            tvContent.setText(Html.fromHtml(article.getContent()));
        }
    }
}
