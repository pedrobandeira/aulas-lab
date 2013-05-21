package br.com.senacrs.alp.aulas;

import java.io.File;
import java.util.Arrays;

public class ListaConteudo implements ListaConteudoDiretorio {

	@Override
	public String[] listarConteudo(File diretorio) {
		if (diretorio == null || !diretorio.exists() || !diretorio.isDirectory() || !diretorio.canRead()) {
			throw new IllegalArgumentException();
		}
		
		File[] files = diretorio.listFiles();
		Arrays.sort(files, new MeuComparador());
		
		String[] nomes = new String[files.length];	
		
		for (int i = 0; i<files.length; i++) {
			File f = files[i];
	
			String resultado =  ""
				+ (f.isDirectory() ? ListaConteudoDiretorio.IDENTIFICA_DIRETORIO : ListaConteudoDiretorio.NADA_CONSTA) + ListaConteudo.SEPARADOR
				+ (f.canRead() ? ListaConteudoDiretorio.PERMISSAO_LEITURA : ListaConteudoDiretorio.NADA_CONSTA)
				+ (f.canWrite() ? ListaConteudoDiretorio.PERMISSAO_ESCRITA : ListaConteudoDiretorio.NADA_CONSTA)
				+ (f.canExecute() ? ListaConteudoDiretorio.PERMISSAO_EXECUCAO : ListaConteudoDiretorio.NADA_CONSTA)
				+ ListaConteudo.SEPARADOR
				+ f.length()
				+ ListaConteudoDiretorio.SEPARADOR
				+ f.getName();
			
			nomes[i] = resultado;
		}
		return nomes;
	}

}