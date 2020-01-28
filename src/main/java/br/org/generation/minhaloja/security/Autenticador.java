package br.org.generation.minhaloja.security;

import javax.xml.bind.DatatypeConverter;

import br.org.generation.minhaloja.model.Usuario;

public class Autenticador {
	private static final String PREFIXO="*G3N3R@T10N";
	
	public static Token generateToken(Usuario usuario) {
		Token token = new Token();
		String str = PREFIXO+"|"+usuario.getId()+"|"+usuario.getEmail()+"|"+usuario.getNome();
		String strToken = DatatypeConverter.printHexBinary(str.getBytes());
		
		token.setStrToken(strToken);
		return token;
		
	}
	
	public static boolean isValid(String token) {
		String str = new String(DatatypeConverter.parseHexBinary(token));
		System.out.println("Token decode:"+str);
		String parts[] = str.split("\\|");
		System.out.println(parts.length);
		System.out.println(parts[0].equals(PREFIXO));
		return (parts.length == 4 && parts[0].equals(PREFIXO));
	}
	
	public static Usuario extractUser(String token) {
		String str = new String(DatatypeConverter.parseHexBinary(token));
		String parts[] = str.split("\\|");
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(parts[1]));
		usuario.setEmail(parts[2]);
		usuario.setNome(parts[3]);
		return usuario;
	}

	
}
