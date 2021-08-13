package service;

import model.ResultDTO;
import retrofit.RandomUserRetrofit;
import retrofit2.Response;

/**
 * Wraps the retrofit interface and do error handling etc
 */
public class RandomUserService {
    private final RandomUserRetrofit randomUserRetrofit;

    public RandomUserService(RandomUserRetrofit randomUserRetrofit) {
        this.randomUserRetrofit = randomUserRetrofit;
    }

    public ResultDTO getResult() {
        try {
            Response<ResultDTO> response = randomUserRetrofit.getUser().execute();

            if (response.isSuccessful()) {
                System.out.println(Thread.currentThread().getName());

                return response.body();
            } else {
                System.out.println("error: http " + response.code());
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void getUserAsync() {
        System.out.println(Thread.currentThread().getName());

        ResultsHandler resultsHandler = new ResultsHandler();
        randomUserRetrofit.getUser().enqueue(resultsHandler);
    }

}
