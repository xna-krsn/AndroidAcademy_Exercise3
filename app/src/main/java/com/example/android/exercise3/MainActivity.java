package com.example.android.exercise3;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CatsAdapter.OnItemClickListener clickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.cats_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager;
        int columnCount = getResources().getInteger(R.integer.column_count);
        if (columnCount > 1) {
            layoutManager = new StaggeredGridLayoutManager(columnCount, StaggeredGridLayoutManager.VERTICAL);
        } else {
            layoutManager = new LinearLayoutManager(this);
        }
        recyclerView.setLayoutManager(layoutManager);

        clickListener = new CatsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Cat cat) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(cat.getAlbumUrl()));
                startActivity(browserIntent);
            }
        };
        RecyclerView.Adapter catAdapter = new CatsAdapter(getCats(), clickListener);
        recyclerView.setAdapter(catAdapter);
    }

    public static List<Cat> getCats() {
        List<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat(8269, "Дымок Муринский", "https://pp.userapi.com/c845417/v845417446/d103/qgpcQ3QKspA.jpg", "https://vk.com/album-19158506_253594211"));
        cats.add(new Cat(6986, "Саин", "https://pp.userapi.com/c836322/v836322470/6121b/I-aXN-XuSSU.jpg", "https://vk.com/album-19158506_247209704"));
        cats.add(new Cat(7024, "Йога", "https://pp.userapi.com/c836322/v836322129/680b1/5qin4hv_x5A.jpg", "https://vk.com/album-19158506_247361259"));
        cats.add(new Cat(7112, "Ида Первомайская", "https://pp.userapi.com/c841220/v841220370/34feb/kzyMx84M8Qo.jpg", "https://vk.com/album-19158506_247680310"));
        cats.add(new Cat(7139, "Феечка", "https://pp.userapi.com/c840323/v840323370/209ab/7jzmnQq5mNo.jpg", "https://vk.com/album-19158506_247794697"));
        cats.add(new Cat(6771, "Рыжебелович", "https://pp.userapi.com/c836335/v836335713/45c96/Q--5Fh6qK4s.jpg", "https://vk.com/album-19158506_246382286"));
        cats.add(new Cat(7208, "Подружка", "https://pp.userapi.com/c824410/v824410769/cc457/k8vIITbo_pE.jpg", "https://vk.com/album-19158506_248145468"));
        cats.add(new Cat(7241, "Забияка", "https://pp.userapi.com/c841031/v841031370/3dc36/0sEdxjzGM5o.jpg", "https://vk.com/album-19158506_248287278"));
        cats.add(new Cat(7247, "Пиксель", "https://pp.userapi.com/c837539/v837539231/628b0/OKfn9o69hvE.jpg", "https://vk.com/album-19158506_248287516"));
        cats.add(new Cat(7349, "Гулар", "https://sun9-7.userapi.com/c840421/v840421372/1069d/-Cg98wJSRuQ.jpg", "https://vk.com/album-19158506_248714459"));
        cats.add(new Cat(6922, "Зайна", "https://pp.userapi.com/c840222/v840222209/5353f/tib2YZvGyDY.jpg", "https://vk.com/album-19158506_246927460"));
        cats.add(new Cat(6975, "Сильвестр", "https://pp.userapi.com/c621513/v621513542/8973/sKZS-f0B9w4.jpg", "https://vk.com/album-19158506_247116978"));
        cats.add(new Cat(8340, "Клёпа Литейная", "https://sun9-8.userapi.com/c840420/v840420352/7727c/CrffqmiPIUE.jpg", "https://vk.com/album-19158506_254180911"));
        cats.add(new Cat(7313, "Маркиз Шиши", "https://pp.userapi.com/c840135/v840135012/3a42a/E0ZU5P0aADE.jpg", "https://vk.com/album-19158506_248485061"));
        return cats;
    }
}
