package org.maruthi.learn.messanger.service;
import java.util.ArrayList;
import java.util.List;

import org.maruthi.learn.messanger.model.Message;
public class MessageService {
	
	public List<Message> getAllMessages(){
		List<Message> list = new ArrayList<Message>();
		Message m1 = new Message(1l, "Hello world1", "Maruthi H" );
		Message m2 = new Message(2l,"Hello world2", "Maruthi H" );
		list.add(m1);
		list.add(m2);
		return list;
	}
	
}
