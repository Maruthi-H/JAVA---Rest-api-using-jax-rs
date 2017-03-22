package org.maruthi.learn.messanger.resources;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.maruthi.learn.messanger.service.MessageService;
import org.maruthi.learn.messanger.model.Message;

@Path("/messages")
public class MessageResource {
	MessageService messageService = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") Long messageId){
		return messageService.getMessage(messageId);
	}
	
	
}
