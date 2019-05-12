package user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import common.GlobalMessage;
import config.ApiConfigurations;
import model.User.ejb.UserEJB;
import model.User.model.User;
import org.apache.http.HttpStatus;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.ValidationException;

@Path("/app/" + ApiConfigurations.V1 + "/api/")
@RequestScoped
public class UserRest {

    @EJB
    private UserEJB userEJB;

    private static ObjectWriter writer;

    static {
        writer = new ObjectMapper().writer();
    }

    @GET
    @Path("/getFiles")
    @Produces(ApiConfigurations.APPLICATION_JSON_WITH_CHARSET_UTF_8)
    public Response authenticateUser(@HeaderParam("Authorization") String authorization) {

        if (authorization == null || !authorization.startsWith("Basic")) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Неправильный метод авторизации").build();
        }

        // basic auth
        String credentials = authorization.substring("Basic".length()).trim();
        byte[] decoded = DatatypeConverter.parseBase64Binary(credentials);
        String decodedString = new String(decoded);
        String[] actualCredentials = decodedString.split(":");

        String login = actualCredentials[0];
        String password = actualCredentials[1];

        try {
            User user = userEJB.authenticateUser(login, password);
            return Response.ok(writer.writeValueAsString(user)).build();
        } catch (ValidationException ex) {
            return Response.status(HttpStatus.SC_UNPROCESSABLE_ENTITY).entity(ex.getMessage()).build();
        } catch (JsonProcessingException ex) {
            return Response.serverError().entity(GlobalMessage.GLOBAL_PROBLEM_WITH_SERVER_MESSAGE).build();
        }
    }
}
