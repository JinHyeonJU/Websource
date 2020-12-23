package controller;

import action.Action;
import action.ColorAddAction;

public class ColorActionFactory {
	private static ColorActionFactory caf;
	
	private ColorActionFactory() {}
	public static ColorActionFactory getInstance() {
		if(caf==null) {
			caf = new ColorActionFactory();
		}
		return caf;
	}
	
	public Action action(String cmd) {
		Action action=null;
		
		if(cmd.equals("/addColor.do")) {
			action = new ColorAddAction("view/addColor.jsp");
		}
		return action;
	}
}
