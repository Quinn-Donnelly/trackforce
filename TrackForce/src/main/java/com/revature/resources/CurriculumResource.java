package com.revature.resources;

import static com.revature.utils.LogUtil.logger;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.HibernateException;

import com.revature.entity.TfCurriculum;
import com.revature.services.AssociateService;
import com.revature.services.BatchService;
import com.revature.services.ClientService;
import com.revature.services.CurriculumService;
import com.revature.services.InterviewService;
import com.revature.services.JWTService;
import com.revature.services.TrainerService;
import com.revature.services.UserService;

import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * <p> </p>
 * @version.date v6.18.06.13
 *
 */
@Path("skillset")
@Api(value = "skillset")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CurriculumResource {

	// You're probably thinking, why would you ever do this? Why not just just make the methods all static in the service class?
	// This is to allow for Mockito tests, which have problems with static methods
	// This is here for a reason! 
	// - Adam 06.18.06.13
	AssociateService associateService = new AssociateService();
	BatchService batchService = new BatchService();
	ClientService clientService = new ClientService();
	CurriculumService curriculumService = new CurriculumService();
	InterviewService interviewService = new InterviewService();
	TrainerService trainerService = new TrainerService();
	UserService userService = new UserService();
	
	
	/**
	 * 
	 * @author Adam L. 
	 * <p> </p>
	 * @version.date v6.18.06.13
	 * 
	 * @param token
	 * @return
	 * @throws HibernateException
	 * @throws IOException
	 */
	@GET
	@ApiOperation(value = "Returns all curriculums", notes = "Returns a list of all curriculums.")
	public Response getAllCurriculums(@HeaderParam("Authorization") String token)
			throws HibernateException, IOException {
		logger.info("getAllCurriculums()...");
		Status status = null;
		List<TfCurriculum> curriculum = curriculumService.getAllCurriculums();
		Claims payload = JWTService.processToken(token);
		
		if (payload == null) { // invalid token
			status = Status.UNAUTHORIZED;
		} else if (!(payload.getId().equals("1") || payload.getId().equals("1"))) { // wrong roleid
			status = Status.FORBIDDEN;
		} else {
			status = curriculum == null || curriculum.isEmpty() ? Status.NO_CONTENT : Status.OK;
		}

		return Response.status(status).entity(curriculum).build();
	}

	@GET
	@ApiOperation(value = "Gets how many unmapped are in each curriculum (excluding empties)", notes="Gets how many unmapped are in each curriculum (excluding empties)")
	@Path("unmapped/{statusId}")
	public Response getUnmappedInfo(@PathParam("statusId") int statusId) {
		logger.info("getUnmappedInfo()...");
		return Response.ok(curriculumService.getUnmappedInfo(statusId)).build();
	}
}
