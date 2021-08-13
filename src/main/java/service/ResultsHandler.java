package service;

import model.NameDTO;
import model.ResultDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultsHandler implements Callback<ResultDTO> {
    @Override
    public void onResponse(Call<ResultDTO> call, Response<ResultDTO> response) {
        System.out.println(Thread.currentThread().getName());
        printResult(response.body());
    }

    @Override
    public void onFailure(Call<ResultDTO> call, Throwable t) {
        System.err.println(t);
    }

    public static void printResult(ResultDTO resultDTO) {
        NameDTO nameDTO = resultDTO.getResults().get(0).getName();
        System.out.println(nameDTO.getFirst() + " " + nameDTO.getLast());
    }
}
