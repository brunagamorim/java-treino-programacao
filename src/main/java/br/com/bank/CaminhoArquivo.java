package br.com.bank;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CaminhoArquivo {


    private Path diretorio;

    private Path arquivo;

    private CaminhoArquivo(Path diretorio, Path arquivo) {
        super();
        this.diretorio = diretorio;
        this.arquivo = arquivo;
    }

    public Path getDiretorio() {
        return diretorio;
    }

    public Path getArquivo() {
        return arquivo;
    }

    public static CaminhoArquivo getInstance(Integer id) {
    	
    	if (id == null) {
    		return null;
    	}
        String raiz = "/tmp/";
        String diretorio = null;
        int grupo = 1000;
        boolean repete = true;
        int repeticoes = 1;
        while (repete) {
        	if(id <= (grupo * repeticoes)) {
        		diretorio = raiz + repeticoes;
        		repete = false;
        	}
        	repeticoes++;
        }
        String caminhoArquivo = diretorio + "/" + id;
        return new CaminhoArquivo(Paths.get(diretorio), Paths.get(caminhoArquivo));
    }
    
}
