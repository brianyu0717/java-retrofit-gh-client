package retrofit;

import model.FactDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface CatFactsRetrofit {

    @GET("facts")
    Call<List<FactDTO>> listFacts();
}
