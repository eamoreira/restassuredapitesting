package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.ContractTests;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;


@Feature("Feature - Retorno de Reservas")
public class GetBookingTest extends BaseTest {

    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class})
    @DisplayName("Listar Id's de reservas")
    public void validaListagemIdsDasReservas(){

        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o schema do retorno da listagem de reservas")
    public void validaSchemaDaListagemDeReservas() {
        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o retorno de uma reserva especifica por id")
    public void validaFiltroDeReservaPorId() {

        getBookingRequest.bookingReturnPorId()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o retorno do filtro por firstname")
    public void validaFiltroDeReservaPorFirstName() {

        getBookingRequest.bookingReturnPorFirstName()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o retorno do filtro por lastname")
    public void validaFiltroDeReservaPorLastName() {

        getBookingRequest.bookingReturnPorLastName()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o retorno do filtro por checkin")
    public void validaFiltroDeReservaPorCheckin() {

        getBookingRequest.bookingReturnPorCheckin()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o retorno do filtro por checkout")
    public void validaFiltroDeReservaPorCheckout() {

        getBookingRequest.bookingReturnPorCheckout()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o retorno do filtro por checkin e checkout")
    public void validaFiltroDeReservaPeloCheckinECheckout() {
        getBookingRequest.bookingReturnPorCheckinECheckout()
                .then()
                .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o retorno do filtro pelo firstname, checkin e checkout")
    public void validaFiltroDeReservaPeloFirstNameCheckinECheckout() {
        getBookingRequest.bookingReturnPorFirstNameCheckinECheckout()
                .then()
                .statusCode(200);
    }
}
