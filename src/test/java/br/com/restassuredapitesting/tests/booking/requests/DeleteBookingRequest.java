package br.com.restassuredapitesting.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.hamcrest.Condition;

import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {

    @Step("Deleta uma reserva")
    public Response deleteBooking(int id, String token) {
        return given()
                .header("Content-Type", "application/json")
                .header("Cookie", token)
                    .when()
                    .delete("booking/" + id);
    }

    @Step("Tentar deletar uma reserva inexistente")
    public Response deleteBookingInexistente(int id, String token) {
        Response cookie = given()
                .header("Content-Type", "application/json")
                .header("Cookie", token)
                .when()
                .delete("booking/" + id);
        return cookie;
    }

    public Response deleteBookingSemAutorizacao(int id) {
        Response cookie = given()
                .header("Content-Type", "application/json")
                .header("Authorisation", "Basic YWRtaW46cGFzc3dvcmQxMjM")
                .when()
                .delete("booking/" + id);
        return cookie;
    }
}
