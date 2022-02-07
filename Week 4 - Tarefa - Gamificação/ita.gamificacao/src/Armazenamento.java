package src;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Armazenamento extends AArmazenamento {
	ArrayList<Ponto> _pointsRecords = new ArrayList<>();
	
	public Armazenamento() {
		insertItens();
	}
	
	private void insertItens() {
        final String DEFAULT_FILE = System.getProperty("user.dir") + "/ita.gamificacao/src/data.txt";
        BufferedReader bufferedCurrentFile = null;
        
        try {
            bufferedCurrentFile = new BufferedReader(new InputStreamReader(new FileInputStream(DEFAULT_FILE), "UTF-8"));               
            
            for(String readedLine; (readedLine = bufferedCurrentFile.readLine()) != null; ) {
                String[] splitedLine = readedLine.split(";");
                if (splitedLine.length != 3 )
                    throw new Exception("Formato de dados no arquivo de leitura incorreto!");

                Ponto ponto = new Ponto(splitedLine[0], Integer.parseInt(splitedLine[1]), splitedLine[2]);
                this._pointsRecords.add(ponto);
            }

            bufferedCurrentFile.close();

        } catch (FileNotFoundException e ) {
            System.out.println("<Arquivo não encontrado! Encerrando Execução!>");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("<Arquivo não pode ser lido! Encerrando Execução!>");
            System.exit(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
	}

}
