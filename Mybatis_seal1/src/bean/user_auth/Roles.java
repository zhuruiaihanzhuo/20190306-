package bean.user_auth;

import java.util.List;



public class Roles {

	 private Integer id;

	    private String text;

	    private List<Permissions> children;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }
	  
	 

	  

	    public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public List<Permissions> getChildren() {
			return children;
		}

		public void setChildren(List<Permissions> children) {
			this.children = children;
		}

		@Override
	    public String toString() {
	        return "{id:" + id + ", text:" + text + ", children:" + children + "}";
	    }
	

	
}
