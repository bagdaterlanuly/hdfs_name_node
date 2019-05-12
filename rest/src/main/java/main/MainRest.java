package main;

import config.ApiConfigurations;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.ws.Response;

@Path("/app/" + ApiConfigurations.V1 + "/api/")
@RequestScoped
public class MainRest {

    @GET
    @Path("/getFiles")
    @Produces(ApiConfigurations.APPLICATION_JSON_WITH_CHARSET_UTF_8)
    public Response findUserFiles(){

    }
}
