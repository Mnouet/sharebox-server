package com.japrod.sharebox.server.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDto {

	/** ID de la base de donnée. */
	private Long id;

	/** Nom de l'utilisateur. */
	@NotEmpty
	@Size(min=2, max=50)
	private String name;

	/** Login de l'utilisateur. */
	@NotEmpty
	@Size(min=4, max=50)
	private String login;

	/** Password de l'utilisateur. */
	@Size(min=6, max=50)
	private String password;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
