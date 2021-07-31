import model.Fact;
import retrofit.CatFactsRetrofit;
import retrofit.RetrofitFactory;
import retrofit2.Retrofit;
import service.CatFactsService;

public class Main {
    public static void main(String[] args) {
        Retrofit retrofit = RetrofitFactory.getRetrofit();

        CatFactsRetrofit catFactsRetrofit = retrofit.create(CatFactsRetrofit.class);
        CatFactsService catFactsService = new CatFactsService(catFactsRetrofit);

        System.out.println("Num of facts: " + catFactsService.countFacts());
        System.out.println();
        catFactsService.listFacts().stream()
                .map(Fact::getFact)
                .forEach(System.out::println);
    }
}
