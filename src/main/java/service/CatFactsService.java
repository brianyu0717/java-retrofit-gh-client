package service;

import model.Fact;
import model.FactDTO;
import retrofit.CatFactsRetrofit;
import retrofit2.Response;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wraps the retrofit interface and do error handling etc
 */
public class CatFactsService {
    private final CatFactsRetrofit catFactsRetrofit;

    public CatFactsService(CatFactsRetrofit catFactsRetrofit) {
        this.catFactsRetrofit = catFactsRetrofit;
    }

    public List<Fact> listFacts() {
        //do some logging...
        System.out.println("Listing facts....");
        try {
            Response<List<FactDTO>> response = catFactsRetrofit.listFacts().execute();

            if (response.isSuccessful()) {
                return response
                        .body()
                        .stream()
                        .map(factDTO -> new Fact(factDTO.getText()))
                        .collect(Collectors.toList());
            } else {
                System.out.println("error: http " + response.code());
                return Collections.emptyList();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int countFacts() {
        return listFacts().size();
    }
}
