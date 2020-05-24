package com.mono40.types;

/**
 * @author Birendra Kumar
 * @date
 */
public class Links {

	private String rel;
	private String href;

	/**
	 *
	 * @param rel
	 * @param href
	 */
	public Links(String rel, String href) {
		super();
		this.rel = rel;
		this.href = href;
	}

	public Links() {

	}

	/**
	 * @author Birendra Kumar
	 * @return String type value
	 */
	public String getRel() {
		return rel;
	}

	/**
	 * @author Birendra Kumar
	 * @param rel
	 */
	public void setRel(String rel) {
		this.rel = rel;
	}

	/**
	 * @author Birendra Kumar
	 * @return String type value
	 */
	public String getHref() {
		return href;
	}

	/**
	 * @author Birendra Kumar
	 * @param href
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * @author Birendra Kumar
 	 * @return String type value
	 */
	@Override
	public String toString() {
		return "Links{" +
				"rel='" + rel + '\'' +
				", href='" + href + '\'' +
				'}';
	}
}
