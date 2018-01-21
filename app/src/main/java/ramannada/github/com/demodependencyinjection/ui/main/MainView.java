package ramannada.github.com.demodependencyinjection.ui.main;

import java.util.List;

import ramannada.github.com.demodependencyinjection.data.entity.Article;

/**
 * Created by ramannada on 1/19/2018.
 */

public interface MainView {
    void onResume();

    void showProgress();

    void hideProgress();

    void setItem(List<Article> articles);

    void updateItem(List<Article> articles);
}
