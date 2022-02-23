package APis.Examen.APis.Steps;

import APis.Examen.APis.Campaign;
import APis.Examen.Utilidades;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static APis.Examen.Constantes.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CampaignSteps extends BaseSteps{
    boolean active;
    String nameq = "";
    String stat = "";


    @When("I send a request to create a campaign with {string} {string} {string}")
    public void i_send_a_request_to_create_a_campaign_with(String isActive, String aName, String aStatus) {
        Utilidades utils = new Utilidades();

        active = utils.stringToBoolean(isActive);
        nameq = aName;
        stat = aStatus;

        newCampaign = new Campaign(active, nameq, stat);

        System.out.println(newCampaign);

        RestAssured.baseURI = INSTANCE_URL;
        RestAssured.basePath = SALESFORCE_VERSION_PATH + SOBJECTS + CAMPAIGN;

        newCampaignResponse = given()
                .contentType(ContentType.JSON)
                .header("Authorization", TOKEN_TYPE + " " + ACCESS_TOKEN)
                .body(newCampaign)
                .when()
                .post();
        newCampaignResponseBody = utils.prettyPrintResponse(newCampaignResponse);

        int nuevoContactoStatusCode = newCampaignResponse.getStatusCode();
        Assert.assertEquals(nuevoContactoStatusCode, 201);

        JsonPath jspr = new JsonPath(newCampaignResponseBody);
        campaignId = jspr.get("id");

    }
    @Then("A campaign is created")
    public void a_campaign_is_created() {
        Utilidades utils = new Utilidades();

        RestAssured.baseURI = INSTANCE_URL;
        RestAssured.basePath = SALESFORCE_VERSION_PATH + SOBJECTS + CAMPAIGN + campaignId;

        campaignCreated = given()
                .contentType(ContentType.JSON)
                .header("Authorization", TOKEN_TYPE + " " + ACCESS_TOKEN)
                .body(newCampaign)
                .when()
                .get();
        campaignCreatedResponseBody = utils.prettyPrintResponse(campaignCreated);

        JsonPath jsp = new JsonPath(campaignCreatedResponseBody);

        isActive = jsp.getString("IsActive");
        status = jsp.getString("Status");
        name = jsp.getString("Name");

        System.out.println("Active Campaign --> " + isActive);
        System.out.println("Status --> " + status);
        System.out.println("Name --> " + name);

        String activeStr = utils.booleanToString(active);

        Assert.assertEquals(isActive, activeStr, "la campaña no está activa");
        Assert.assertEquals(status, stat, "El estado de la campaña no es " + stat);
        Assert.assertEquals(name, nameq, "El nombre no es " + nameq);

    }

}
