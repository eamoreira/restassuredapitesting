package br.com.restassuredapitesting.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.hamcrest.Condition;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    @Step("Retorna os Ids da listagem de reserva")
    public Response bookingReturnIds() {
        return given()
                    .when()
                    .get("booking");
    }

    @Step("Retorna reserva a partir do Id")
    public Response bookingReturnPorId() {
        GetBookingRequest getBookingRequest = new GetBookingRequest();
        int primeiroId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        return given()
                .when()
                .get("booking/"+primeiroId);
    }

    @Step("Retorna reserva a partir do firstname")
    public Response bookingReturnPorFirstName() {
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        String firstname = getBookingRequest.bookingReturnPorId().then()
                .statusCode(200)
                .extract()
                .path("firstname");
        return given()
                .when()
                .get("booking?firstname=" + firstname);

    }

    @Step("Retorna reserva a partir do lastname")
    public Response bookingReturnPorLastName() {
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        String lastname = getBookingRequest.bookingReturnPorId().then()
                .statusCode(200)
                .extract()
                .path("lastname");
        return given()
                .when()
                .get("booking?lastname=" + lastname);
    }

    @Step("Retorna reserva a partir da data de checkin")
    public Response bookingReturnPorCheckin() {
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        String checkin = getBookingRequest.bookingReturnPorId().then()
                .statusCode(200)
                .extract()
                .path("bookingdates.checkin");
        return given()
                .when()
                .get("booking?checkin=" + checkin);
    }

    @Step("Retorna reserva a partir da data de checkout")
    public Response bookingReturnPorCheckout() {
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        String checkout = getBookingRequest.bookingReturnPorId().then()
                .statusCode(200)
                .extract()
                .path("bookingdates.checkout");

        return given()
                .when()
                .get("booking?checkout=" + checkout);
    }

    @Step("Retorna reserva a partir da data de checkin e checkout")
    public Response bookingReturnPorCheckinECheckout() {
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        String checkin = getBookingRequest.bookingReturnPorId().then()
                .statusCode(200)
                .extract()
                .path("bookingdates.checkin");

        String checkout = getBookingRequest.bookingReturnPorId().then()
                .statusCode(200)
                .extract()
                .path("bookingdates.checkout");

        return given()
                .when()
                .get("booking?checkin=" + checkin + "&checkout=" + checkout);
    }

    @Step("Retorna reserva a partir do firstname, data de checkin e checkout")
    public Response bookingReturnPorFirstNameCheckinECheckout() {
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        String firstname = getBookingRequest.bookingReturnPorId().then()
                .statusCode(200)
                .extract()
                .path("firstname");
        
        String checkin = getBookingRequest.bookingReturnPorId().then()
                .statusCode(200)
                .extract()
                .path("bookingdates.checkin");

        String checkout = getBookingRequest.bookingReturnPorId().then()
                .statusCode(200)
                .extract()
                .path("bookingdates.checkout");

        Response response = given()
                .when()
                .get("booking?firstname=" + firstname + "&checkin=" + checkin + "&checkout=" + checkout);
        return response;
    }
}
