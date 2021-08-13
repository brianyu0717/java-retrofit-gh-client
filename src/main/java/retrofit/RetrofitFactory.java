package retrofit;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.Executor;

public class RetrofitFactory {

    public static Retrofit getRetrofit(){
        return getDefault().build();
    }

    public static Retrofit getRetrofit(Executor executor){
        return getDefault()
                .callbackExecutor(executor)
                .build();
    }

    private static Retrofit.Builder getDefault() {
        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)))
                .baseUrl("https://randomuser.me/");
    }
}
