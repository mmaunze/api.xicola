package mz.co.mefemasys.xicola.backend.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import mz.co.mefemasys.xicola.backend.models.Utilizador;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UtilizadorDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String username;

  private String email;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UtilizadorDetailsImpl(Long id, String username, String email, String password,
                               Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
  }

  public static UtilizadorDetailsImpl build(Utilizador utilizador) {
    List<GrantedAuthority> authorities = utilizador.getRoles().stream()
                               .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                               .collect(Collectors.toList());

    return new UtilizadorDetailsImpl(utilizador.getId(),
                               utilizador.getUsername(),
                               utilizador.getEmail(),
                               utilizador.getPassword(),
                               authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
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

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UtilizadorDetailsImpl user = (UtilizadorDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
