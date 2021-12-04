package localhost;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class ClientsTest {

    @Test
    void testListaClientes_TodosClientesSaoListados() {
        RestAssured.given() //Dado - Given
                .log().all() //loga toda a request - solicitação (entrada) - mostrará o cabeçalho da solicitação
                .when() //Quando - When
                .get("http://localhost:8080/clients") //Faz a solicitação em si, método/verbo GET passando como parâmetro a URL/URI a ser acessada
                .then() //Então
                .log().all()  // loga toda a response - resposta
                .statusCode(200);  //verifica se o resultado da request é HTTP 200 OK
    }

    @Test
    void testListaUnicoCliente_ClienteEhListadoComTodasAsInformacoes() {
        RestAssured.given() //Dado - Given
                .log().all() //loga toda a request - solicitação (entrada) - mostrará o cabeçalho da solicitação
                .when() //Quando - When - REQUEST
                .get("http://localhost:8080/clients/1") //Faz a solicitação em si, método/verbo GET passando como parâmetro a URL/URI a ser acessada
                .then() //Então - RESPONSE
                .log().all()  // loga toda a response - resposta
                .statusCode(200)  //verifica se o resultado da request é HTTP 200 OK
                .body("id", is(1));
    }


}
