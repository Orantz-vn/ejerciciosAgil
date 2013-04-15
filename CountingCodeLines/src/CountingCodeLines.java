
public class CountingCodeLines {
	private final static String COMENTARIO="/";
	private final static String ASTERISCO="*";
	
	public static int count(String codigo) {
		String[] split = codigo.split("\n");
		String linea="";
		int nlineas=split.length;
		
		for(int i=0;i<split.length;i++){
			linea=split[i].trim();
			if(linea.startsWith(COMENTARIO)  || linea.isEmpty()  || linea.startsWith(ASTERISCO)){
				nlineas --;
			}
		}
		return nlineas;
	}

}
