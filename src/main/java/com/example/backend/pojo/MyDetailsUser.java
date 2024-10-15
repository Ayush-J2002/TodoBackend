// package com.example.backend.pojo;

// import java.util.Collection;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;

// import io.jsonwebtoken.lang.Collections;

// public class MyDetailsUser implements UserDetails {
//     private User user;

//     public MyUserPrincipal(User user) {
//         this.user = user;
//     }

//     public User getUser() {
//         return user;
//     }

//      @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         return Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
//     }

//     @Override
//     public String getPassword() {
//         return user.getPassword();
//     }

//     @Override
//     public String getUsername() {
//         return user.getUsername();
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         return true;
//     }

   
// }
