package datos;

import static datos.Conexion.*;

import java.sql.*;
import java.util.*;

import domain.Usuario;

public class UsuarioDAO {

	private static final String SQL_SELECT = "SELECT id_usuario, username, password FROM usuario";
	private static final String SQL_INSERT = "INSERT INTO usuario(username, password) VALUES(?, ?)";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
	private static final String SQL_UPDATE = "UPDATE  usuario SET username = ?, password= ? WHERE id_usuario = ?";

	public List<Usuario> seleccionar() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		List<Usuario> usuarios = new ArrayList<>();

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int idUsuario = rs.getInt("id_usuario");
				String username = rs.getString("username");
				String password = rs.getString("password");
				usuario = new Usuario(idUsuario, username, password);

				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
				try {
					Conexion.close(rs);
					Conexion.close(stmt);
					Conexion.close(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				

			
		}
		return usuarios;
	}

	public int insertar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, usuario.getUsuarioNombre());
			stmt.setString(2, usuario.getPassword());

			registros = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close(stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return registros;
	}

	public int borrar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, usuario.getIdUsuario());
			registros = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close(stmt);
				close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return registros;

	}

	public int actualizar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, usuario.getUsuarioNombre());
			stmt.setString(2, usuario.getPassword());
			stmt.setInt(3, usuario.getIdUsuario());
			registros = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close(stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return registros;

	}

	public void imprimir(UsuarioDAO usuarioDao) {

		List<Usuario> usuarios = usuarioDao.seleccionar();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);

		}
	}

}
