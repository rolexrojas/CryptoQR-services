package com.mono40.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Birendra Kumar
 * @date
 */
public class Partners implements Serializable {

	private String partnerId;
	private String name;
	private String category;
	private String description;
	private boolean active;
	private List<Links> links=new ArrayList();

	public Partners() {

	}

	/**
	 *
	 * @param partnerId
	 * @param name
	 * @param category
	 * @param description
	 * @param active
	 * @param links
	 */
	public Partners(String partnerId, String name, String category,
                    String description, boolean active, List<Links> links) {
		super();
		this.partnerId = partnerId;
		this.name = name;
		this.category = category;
		this.description = description;
		this.active = active;
		this.links = links;
	}

	/**
	 * @author Birendra Kumar
	 * @return String value
	 */
	public String getPartnerId() {
		return partnerId;
	}

	/**
	 *
	 * @param partnerId
	 */
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @author Birendra Kumar
	 * @return String value
	 */
	public String getName() {
		return name;
	}

	/**
	 * @author Birendra Kumar
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @author Birendra Kumar
	 * @return String value
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @author Birendra Kumar
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @author Birendra Kumar
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @author Birendra Kumar
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @author Birendra Kumar
	 * @return Boolean value
	 */
	public boolean getActive() {
		return active;
	}

	/**
	 * @author Birendra Kumar
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @author Birendra Kumar
	 * @return List of links
	 */
	public List<Links> getLinks() {
		return links;
	}

	/**
	 * @author Birendra Kumar
	 * @param links
	 */
	public void setLinks(List<Links> links) {
		this.links = links;
	}



}
