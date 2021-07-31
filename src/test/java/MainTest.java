import model.FactDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import retrofit.CatFactsRetrofit;
import retrofit2.Call;
import retrofit2.mock.Calls;


import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MainTest {

    private final List<FactDTO> factDTOS = List.of(
            new FactDTO("happy", "cat"),
            new FactDTO("liquid", "cat"));

    @Test
    void testService() throws IOException {
        CatFactsRetrofit catFactsRetrofit = Mockito.mock(CatFactsRetrofit.class);
        when(catFactsRetrofit.listFacts()).thenReturn(Calls.response(factDTOS));

        Call<List<FactDTO>> facts = catFactsRetrofit.listFacts();
        List<FactDTO> body = facts.execute().body();
        assertEquals(2, body.size());
    }
}
