package APis.Examen;

import APis.Clase14_15.Steps.BaseSteps;
import APis.Utilidades;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;

import static APis.Examen.Constantes.*;
import static APis.Examen.Constantes.SF_API_TOKEN;

public class AuthenticationHelper extends BaseSteps {
    Response respForSalesforceToken;
    HashMap<String, String> salesforceTokenQueryParams;

    @Given("I got the access token, instance url")
    public void i_got_the_access_token_instance_url() {
        RestAssured.baseURI = SALESFORCE_BASE_LOGIN;
        RestAssured.basePath = SALESFORCE_BASE_TOKEN;
        Utilidades utils = new Utilidades();

        salesforceTokenQueryParams = utils.salesForceQueryParams(SF_CLIENT_ID, SF_CLIENT_SECRET, SF_USERNAME, SF_API_TOKEN);
        respForSalesforceToken = utils.getSalesforceToken(salesforceTokenQueryParams);

        String respBody = utils.prettyPrintResponse(respForSalesforceToken);

        int statusCode = respForSalesforceToken.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        JsonPath js = new JsonPath(respBody);
        ACCESS_TOKEN = js.get("access_token");
        INSTANCE_URL = js.get("instance_url");
        String instanceId = js.get("id");
        TOKEN_TYPE = js.get("token_type");

    }

}
