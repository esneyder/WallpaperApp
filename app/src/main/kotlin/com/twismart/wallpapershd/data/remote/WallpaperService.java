package com.twismart.wallpapershd.data.remote;

import com.twismart.wallpapershd.data.model.Wallpaper;
import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface WallpaperService {
    String END_POINT = "http://52.45.144.5/wallpapers/";

    @GET
    Observable<ArrayList<Wallpaper>> getWallpapersList(@Url String url);

    class Factory {
        public static WallpaperService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(WallpaperService.END_POINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return retrofit.create(WallpaperService.class);
        }
    }
}