import model.NameDTO;
import model.ResultDTO;
import model.UserDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import retrofit.RandomUserRetrofit;
import retrofit2.Call;
import retrofit2.mock.Calls;


import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MainTest {

    private ResultDTO resultDTO = new ResultDTO(List.of(new UserDTO(new NameDTO("Brian", "Grumpy"))));

    @Test
    void testService() throws IOException {
        RandomUserRetrofit randomUserRetrofit = Mockito.mock(RandomUserRetrofit.class);
        when(randomUserRetrofit.getUser()).thenReturn(Calls.response(resultDTO));

        Call<ResultDTO> call = randomUserRetrofit.getUser();
        ResultDTO body = call.execute().body();
        assertNotNull(body.getResults());
        assertEquals(1, body.getResults().size());
        assertEquals("Brian", body.getResults().get(0).getName().getFirst());
        assertEquals("Grumpy", body.getResults().get(0).getName().getLast());
    }
}
