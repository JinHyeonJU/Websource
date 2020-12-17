package controller;

import action.Action;
import action.DeleteAction;
import action.InsertAction;

public class ActionFactory {
	
	private static ActionFactory factory;
	private ActionFactory() {}
	public static ActionFactory getInstance() {
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	public Action action(String cmd) {
		Action action = null;
		if(cmd.equals("/insert.do")) {
			action = new InsertAction("index.jsp");
		}else if(cmd.equals("/delete.do")) {
			action = new DeleteAction("index.jsp");
		}else if(cmd.equals("/updatd.do")) {
			
		}else if(cmd.equals("/select.do")) {
			
		}
		return action;
	}
}
