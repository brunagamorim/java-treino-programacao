package br.com.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;


class CaminhoArquivoTest {
	
	@Test
	void deveRetornarInstanciaNula() {
		CaminhoArquivo caminhoArquivo = CaminhoArquivo.getInstance(null);
		assertNull(caminhoArquivo);
	}

    @Test
    public void deveMontarCaminhoParaArquivo() {

        CaminhoArquivo caminhoArquivo = CaminhoArquivo.getInstance(1);
        assertEquals(Paths.get("/tmp/1"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/1/1"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(2);
        assertEquals(Paths.get("/tmp/1"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/1/2"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(1000);
        assertEquals(Paths.get("/tmp/1"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/1/1000"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(1500);
        assertEquals(Paths.get("/tmp/2"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/2/1500"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(2000);
        assertEquals(Paths.get("/tmp/2"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/2/2000"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(2001);
        assertEquals(Paths.get("/tmp/3"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/3/2001"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(3001);
        assertEquals(Paths.get("/tmp/4"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/4/3001"), caminhoArquivo.getArquivo());
    }

}