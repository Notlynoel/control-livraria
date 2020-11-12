package br.com.notlinoel.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@Entity 
@Table(name = "Usuarios")
public class Usuario implements Serializable, UserDetails {

	private static final long serialVersionUID = 6600158065316700588L;
	
	private Integer id;
	private String nome;
	private String login;
	private String senha;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	// OS METODOS A SEGUIR FORAM CRIADOS APÓS A IMPLEMENTAÇÃO DA INTERFACE
		// UserDetails
		@SuppressWarnings("deprecation")
		@Override
		@Transient
		public Collection<? extends GrantedAuthority> getAuthorities() {
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
			
			return authorities;
		}

		@Override
		@Transient
		public String getPassword() {
			return senha;
		}

		@Override
		@Transient
		public String getUsername() {
			return login;
		}

		@Override
		@Transient
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		@Transient
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		@Transient
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		@Transient
		public boolean isEnabled() {
			return true;
		}
	
}
