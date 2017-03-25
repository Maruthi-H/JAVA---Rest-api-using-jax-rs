package org.maruthi.learn.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.maruthi.learn.messanger.model.Profile;
import org.maruthi.learn.messanger.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	private ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles(){
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public  Profile getProfile(@PathParam("profileName") String profileName){
		return profileService.getProfile(profileName);
	}
	
	@POST
	public Profile createProfile(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@PUT 
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName){
		profileService.deleteProfile(profileName);
	}
	
}
