package test;

//import java.util.List;

import datos.UsuarioDAO;
import domain.Usuario;

public class TestManejoUsuarios {
	public static void main(String[] args) {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		//List<Usuario> usuarios = usuarioDao.seleccionar();
		
		
		
	    Usuario usuarioMod =  new Usuario(3, "Pedro" , "43242");
	   // usuarioDao.insertar(usuarioNuevo);
			
		usuarioDao.actualizar(usuarioMod);
		usuarioDao.borrar(usuarioMod);
	    usuarioDao.imprimir(usuarioDao);
		
		
	}

}
