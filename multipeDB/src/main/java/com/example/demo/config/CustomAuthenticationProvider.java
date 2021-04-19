package com.example.demo.config;

import com.example.demo.base.JwtTokenUtil;
import com.example.demo.core.CustomUserDetails;
import com.example.demo.core.RequestLogin;
import com.example.demo.dto.ObjectDTO;
import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.impl.ObjectServiceImpl;
import com.example.demo.service.impl.RoleServiceImpl;
import com.example.demo.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
//    @Autowired
//    private UserDetailsService userDetailService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private ObjectServiceImpl objectService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jTokenUtil;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RequestLogin loginRequest = (RequestLogin) authentication.getPrincipal();
        CustomUserDetails customUserDetails = (CustomUserDetails) userDetailsServiceImpl
                .loadUserByUsername(loginRequest.getUsername());
        UserDTO userDTO = customUserDetails.getUser();
        // logic xac thuc user
        boolean tag = passwordEncoder.matches(authentication.getCredentials().toString(), customUserDetails.getPassword());
        UsernamePasswordAuthenticationToken result = null;
        // intances true
//        passwordEncoder
//                .matches(authentication.getCredentials().toString(), customUserDetails.getPassword())
        if (userDTO.getUserName().equals(loginRequest.getUsername()) && true) {
            List<RoleDTO> lstRole = roleService.getListRole(userDTO.getId());
            userDTO.setListRole(lstRole);
            List<ObjectDTO> lstObject = objectService.getListObject(userDTO.getId());
            userDTO.setListObject(lstObject);

            customUserDetails.setUser(userDTO);
            String jwt = jTokenUtil.generateToken(customUserDetails);
            customUserDetails.setJwt(jwt);
            result = new UsernamePasswordAuthenticationToken(customUserDetails, customUserDetails.getPassword(),
                    customUserDetails.getAuthorities());
        }
        else {
//            throw new BusinessException(MessageUtils.getMessage("username_password_incorrect"));
        }
        return result;

    }

    public void setUserDetailService(UserDetailsService userDetailService) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
