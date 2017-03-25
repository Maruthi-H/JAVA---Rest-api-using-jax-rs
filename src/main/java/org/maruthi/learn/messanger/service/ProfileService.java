package org.maruthi.learn.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.maruthi.learn.messanger.database.DatabaseClass;
import org.maruthi.learn.messanger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getPofiles();
	
	public ProfileService(){
		profiles.put("maruthi_h", new Profile(1L, "maruthi_h", "Maruthi", "H"));
	}
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName() == null){
			return null;
		}
		profile.setProfileName(profile.getProfileName());
		profiles.put(profile.getProfileName(), profile);
		return profile;
		
	}
	
	public void deleteProfile(String profileName){
		profiles.remove(profileName);
	}
	
}
