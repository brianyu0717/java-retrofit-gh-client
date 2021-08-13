package retrofit;

import model.ResultDTO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomUserRetrofit {

    @GET("api")
    Call<ResultDTO> getUser();
}
