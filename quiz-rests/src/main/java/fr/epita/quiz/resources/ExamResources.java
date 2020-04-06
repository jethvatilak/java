package fr.epita.quiz.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/exam")
public class ExamResources {

	@POST
	@Path("/answer")
	public void addAnswerToQuestion() {
		System.out.println("testPost");
	}
	
	@GET
	@Path("/answer")
	public Response getAnswers() {
		return Response.status(Status.OK).entity("I am here in get answer").build();
	}
}