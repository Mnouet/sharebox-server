package com.japrod.sharebox.server.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.japrod.sharebox.server.dto.UserDto;
import com.japrod.sharebox.server.exception.UserNameAlreadyTakenException;
import com.japrod.sharebox.server.model.User;
import com.japrod.sharebox.server.repository.UserRepository;

@Service
public class UserServiceImpl extends AbstractService implements UserService{
	
	@Autowired
	private UserRepository userDao;
	
	@Transactional
    public User create(UserDto userDto) throws UserNameAlreadyTakenException {
        if (userDao.findByLogin(userDto.getLogin()) != null)
            throw new UserNameAlreadyTakenException();
        User user = this.dozerMapper.map(userDto, User.class);
        user = userDao.save(user);
        if (user != null)
            return user;
        return null;
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByLogin(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
		}
		return new UserRepositoryUserDetails(user);
	}

	/**
	 * specific user view for authentication
	 * @author alex
	 *
	 */
	private final static class UserRepositoryUserDetails extends User implements UserDetails {

		private static final long serialVersionUID = 1L;

		private UserRepositoryUserDetails(User user) {
			this.setId(user.getId());
			this.setLogin(user.getLogin());
			this.setName(user.getName());
			this.setPassword(user.getPassword());
			this.setRoles(user.getRoles());
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return getRoles();
		}

		@Override
		public String getUsername() {
			return getLogin();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

	}

}
