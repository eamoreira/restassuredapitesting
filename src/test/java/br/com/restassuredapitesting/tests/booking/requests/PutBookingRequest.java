package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.booking.payloads.BookingsPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {

    BookingsPayloads bookingsPayloads = new BookingsPayloads();

    @Step("Atualiza uma reserva específica com o token")
    public Response updateBookingToken(int id, String token) {
        Response put = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", token)
                .when()
                .body(bookingsPayloads.payloadValidBooking().toString())
                .put("booking/" + id);
        return put;
    }

    @Step("Atualiza uma reserva específica com o basic auth")
    public Response updateBookingBasicAuth(int id) {

        Response put = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorisation","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .body(bookingsPayloads.payloadValidBooking().toString())
                .put("booking/" + id);
        return put;
    }

}
