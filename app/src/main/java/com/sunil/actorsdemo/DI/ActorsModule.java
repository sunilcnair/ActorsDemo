package com.sunil.actorsdemo.DI;

import android.content.Context;

import com.google.gson.GsonBuilder;
import com.sunil.actorsdemo.BuildConfig;
import com.sunil.actorsdemo.R;
import com.sunil.actorsdemo.business.data.ActorsApi;
import com.sunil.actorsdemo.business.data.ActorsUseCase;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sunil on 31-12-2017.
 */

@Module
public class ActorsModule {
    private Context mContext;

    public ActorsModule(Context context) {
        mContext = context;
    }

    /**
     * Actors service provider
     * @param actorsApi
     * @return
     */
    @Provides
    @Singleton
    public ActorsUseCase provideActorUseCase(ActorsApi actorsApi) {
        return new ActorsUseCase(actorsApi);
    }

    /**
     * OkHttp client provider
     * @return
     */
    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (BuildConfig.DEBUG) {
            okHttpClientBuilder
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(httpLoggingInterceptor);
        } else {
            okHttpClientBuilder
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS);
        }

        return okHttpClientBuilder.build();
    }

    /**
     * Actors api provider
     * @param okHttpClient
     * @return
     */
    @Provides
    @Singleton
    public ActorsApi provideActorsApi(OkHttpClient okHttpClient) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mContext.getApplicationContext().getString(R.string.base_url))
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(ActorsApi.class);
    }
}
