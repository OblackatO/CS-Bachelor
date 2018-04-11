package exercise3;

import java.io.*;

public class Multiple_Output extends OutputStream {

	private OutputStream[] outstreams;

	public Multiple_Output(OutputStream... outstreams) {
		this.outstreams = outstreams;
	}

	@Override
	public void write(int b) throws IOException {
		for (OutputStream os : outstreams) {
			os.write(b);
		}
	}
	
	@Override
	public void flush() throws IOException {
		for (OutputStream stream : this.outstreams) {
			stream.flush();
		}
	}

	@Override
	public void close() throws IOException {
		for (OutputStream stream : this.outstreams) {
			stream.close();
		}
	}
}