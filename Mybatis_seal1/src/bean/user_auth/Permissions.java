package bean.user_auth;

public class Permissions {

	private Integer id;

    private String href;

    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return " {id:" + id + ", href:" + href + ", text:" + text
				+ "}";
	}

  

	
}
