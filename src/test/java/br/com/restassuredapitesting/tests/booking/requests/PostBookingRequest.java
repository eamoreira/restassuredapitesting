package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.booking.payloads.BookingsPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {

    BookingsPayloads bookingsPayloads = new BookingsPayloads();

    @Step("Cria uma reserva")
    public Response CriaBooking() {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(bookingsPayloads.payloadValidBooking().toString())
                .post("booking");
    }
}
