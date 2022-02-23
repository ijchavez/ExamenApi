package APis.Examen.APis.Steps;

import APis.Examen.APis.Campaign;
import io.restassured.response.Response;

public class BaseSteps {
    Campaign newCampaign;
    Response newCampaignResponse;

    String newCampaignResponseBody;
    int newCampaignStatusCode;

    Response campaignCreated;
    String campaignCreatedResponseBody;

    String campaignId;

    String isActive = "";
    String name = "";
    String status = "";
}
