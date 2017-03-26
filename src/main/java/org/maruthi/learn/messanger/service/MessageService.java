package org.maruthi.learn.messanger.service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.maruthi.learn.messanger.database.DatabaseClass;
import org.maruthi.learn.messanger.model.Message;
public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	public MessageService(){
		messages.put(1L, new Message(1L,"Hello world", "Maruthi H"));
		messages.put(2L, new Message(2L,"Welcome you to Rest service", "Maruthi H"));
	}
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	public List<Message> getMessagesForYear(int year){
		Calendar cal = Calendar.getInstance();
		List<Message> messagesForYear = new ArrayList<Message>();
		for(Message message : messages.values()){
			cal.setTime(message.getCreatedAt());
			if(cal.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;	
	}
	
	public List<Message> getMessagesPaginated(int start, int size){
		if(start + size > messages.size()){
			return new ArrayList<Message>();
		}
		return new ArrayList<Message>(messages.values()).subList(start, start + size);
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	
}
