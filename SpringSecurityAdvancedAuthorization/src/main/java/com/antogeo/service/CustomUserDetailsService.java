package com.antogeo.service;

import com.antogeo.dao.UserDao;
import com.antogeo.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    /**Method that returns a UserDetails object
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        //get user from the database, via Hibernate
        com.antogeo.entity.User user = userDao.getUserByUsername(username);

        //Collect User authorities
        List<GrantedAuthority> authorities = buildUserAuthority(user);

        //Build Spring Security User
        User springSecurityUser = buildUserForAuthentication(user, authorities);
        return springSecurityUser;
    }


    /**Build the Spring Security User.
     *
     * @param user
     * @param authorities
     * @return
     */
    private User buildUserForAuthentication(com.antogeo.entity.User user, List<GrantedAuthority> authorities) {

        return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
    }


    private List<GrantedAuthority> buildUserAuthority(com.antogeo.entity.User user) {

        Set<GrantedAuthority> authoritiesSet = new HashSet<GrantedAuthority>();

        //Get user permissions from role
        Set<Permission> permissions = user.getRole().getPermissions();

        // Build user's authorities
        for (Permission permission : permissions) {
            authoritiesSet.add(new SimpleGrantedAuthority(permission.getName()));
        }

        //Transform the Set into List
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(authoritiesSet);
        return result;
    }



    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
