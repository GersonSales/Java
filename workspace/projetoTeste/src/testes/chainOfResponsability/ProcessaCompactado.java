package testes.chainOfResponsability;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ProcessaCompactado extends Processador{

	public ProcessaCompactado(Processador proximoProcessador) {
		super(proximoProcessador);
	}
	
	@Override
	protected byte[] processar(byte[] bytes) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ZipOutputStream zipStream = new ZipOutputStream(byteStream);
		try {
			zipStream.putNextEntry(new ZipEntry("internal"));
			zipStream.write(bytes);
			zipStream.closeEntry();
			zipStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return byteStream.toByteArray();
	}

}
