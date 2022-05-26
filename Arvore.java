import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.ArrayList;


public class Arvore {
	public static void main(String[] args) throws Exception {
		// Declaração de variáveis
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<No> correnteDeNos = new ArrayList<No>();
		ArrayList<String> arvoreDeMerkel = new ArrayList<String>();
		
		
		// Entrada de dados
		do {
			No objNo = new No();
			
			System.out.print("Informe o remetente: ");
			objNo.setRemetente(leitor.readLine());
			
			System.out.print("Informe o destinatario: ");
			objNo.setDestinatario(leitor.readLine());
			
			System.out.print("Informe o valor: ");
			objNo.setValor(Double.parseDouble(leitor.readLine()));
		
			correnteDeNos.add(objNo);
			
			System.out.print("Digite <S> para mais transações: ");
		} while (leitor.readLine().equalsIgnoreCase("S"));
		
		// Processamento
		for (int i = 0 ; i < correnteDeNos.size() ; i++) {
			arvoreDeMerkel.add(calcularHash(
					correnteDeNos.get(i).getRemetente() +
					correnteDeNos.get(i).getDestinatario() +
					correnteDeNos.get(i).getValor()));
		}
		
		arvoreDeMerkel = gerarArvoreDeMerkel(arvoreDeMerkel);
		
		// Saida de dados
		System.out.println(arvoreDeMerkel.size());
		System.out.println(arvoreDeMerkel.get(0));
	}
	
	private static ArrayList<String> gerarArvoreDeMerkel(ArrayList<String> arvoreDeMerkel) throws Exception {
		ArrayList<String> retorno = new ArrayList<String>();
		
		for (int i = 0 ; i < arvoreDeMerkel.size() ; i+=2) {
			if ((i + 1) == arvoreDeMerkel.size()) {
				retorno.add(arvoreDeMerkel.get(i));
			} else {
				retorno.add(calcularHash(arvoreDeMerkel.get(i) +
										 arvoreDeMerkel.get(i + 1)));
			}
		}
		
		if (retorno.size() > 1) {
			retorno = gerarArvoreDeMerkel(retorno);
		}
		
		return retorno;
	}
	
	private static String calcularHash(String texto) throws Exception {
		MessageDigest objHash = MessageDigest.getInstance("SHA-256");
		objHash.reset();
		objHash.update(texto.getBytes("utf-8"));
		byte[] hash = objHash.digest();
		String retorno = "";
		for (int i = 0 ; i < hash.length ; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
	        if (hex.length() == 1) {
	        	hex = "0" + hex;
	        }
	        retorno += hex;
		}
		return retorno;
	}
}
