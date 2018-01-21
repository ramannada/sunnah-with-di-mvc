package ramannada.github.com.demodependencyinjection.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import ramannada.github.com.demodependencyinjection.R;
import ramannada.github.com.demodependencyinjection.data.entity.Article;
import ramannada.github.com.demodependencyinjection.data.entity.Mahasiswa;
import ramannada.github.com.demodependencyinjection.model.SharedData;
import ramannada.github.com.demodependencyinjection.ui.adapters.MainAdapter;

import static ramannada.github.com.demodependencyinjection.App.app;

public class MainActivity extends AppCompatActivity implements MainView{
    @BindView(R.id.recycler_view_article)
    RecyclerView rvArticle;

    private MainPresenter presenter;

    @Inject
    RequestQueue requestQueue;
    @Inject
    SharedData sharedData;
    @Inject
    Gson gson;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app().appComponent().inject(this);
        ButterKnife.bind(this);

        rvArticle.setLayoutManager(new LinearLayoutManager(this));

        presenter = new MainPresenterImpl(this, new ItemInteractorImpl(),
                requestQueue, gson);

    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.getData();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setItem(List<Article> articles) {
        if (articles != null) {
            MainAdapter mainAdapter = new MainAdapter(articles);
            rvArticle.setAdapter(mainAdapter);
        }
    }

    @Override
    public void updateItem(List<Mahasiswa> mahasiswas) {

    }
}
