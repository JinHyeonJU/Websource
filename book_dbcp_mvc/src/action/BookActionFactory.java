package action;

public class BookActionFactory {
	private static BookActionFactory factory;
	private BookActionFactory() {}
	
	public static BookActionFactory getInstance() {
		if(factory==null) {
			factory = new BookActionFactory();
		}
		return factory;
	}
	
	public Action action(String cmd) {
		Action action = null;
		
		return action;
	}
}
