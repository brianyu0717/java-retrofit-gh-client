import model.ResultDTO;
import retrofit.RandomUserRetrofit;
import retrofit.RetrofitFactory;
import retrofit2.Retrofit;
import service.RandomUserService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static service.ResultsHandler.printResult;

public class Main {
    private static void synchronousExample() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();

        RandomUserRetrofit randomUserRetrofit = retrofit.create(RandomUserRetrofit.class);
        RandomUserService randomUserService = new RandomUserService(randomUserRetrofit);

        ResultDTO result = randomUserService.getResult();
        printResult(result);
    }

    private static void asyncExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Retrofit retrofit = RetrofitFactory.getRetrofit(executorService);
        RandomUserRetrofit randomUserRetrofit = retrofit.create(RandomUserRetrofit.class);
        RandomUserService randomUserService = new RandomUserService(randomUserRetrofit);
        randomUserService.getUserAsync();
    }

    public static void main(String[] args) {
        asyncExample();
//        synchronousExample();
        System.out.println(Thread.currentThread().getName());
        System.out.println("here");
    }


}
