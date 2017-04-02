package org.maruthi.learn.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.maruthi.learn.messanger.database.DatabaseClass;
import org.maruthi.learn.messanger.model.Comment;
import org.maruthi.learn.messanger.model.Message;

public class CommentService {
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);	
	}
	
	public Comment addComment(long messageId, Comment comment){
		if(messageId < 1){
			return null;
		}
		comment.setId(messages.get(messageId).getComments().size()+ 1);
		messages.get(messageId).getComments().put(comment.getId(), comment);
		return comment;				
	}
	
	public Comment updateComment(long messageId, Comment comment){
		if(messageId < 0 || comment.getId() < 0){
			return null;
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.put(comment.getId(), comment);
	}
	public Comment deleteComment(long messageId, long commentId){
		if(messageId < 0 || commentId < 0){
			return null;
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}


