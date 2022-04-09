package domain;

public class Usuario {
	private int idUsuario;
	private String username;
	private String password;
	
	public Usuario() {
		
	}
	public Usuario(int idUsuario) {
		this.idUsuario= idUsuario;
	}
	public Usuario(int idUsuario, String username, String password) {
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
	}
	public Usuario(String usuario, String password) {
		this.username = usuario;
		this.password = password;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuarioNombre() {
		return username;
	}
	public void setUsuarioNombre(String usuarioNombre) {
		this.username = usuarioNombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", usuario=" + username + ", password=" + password + "]";
	}
	

}
	
