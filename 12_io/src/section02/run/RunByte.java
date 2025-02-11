package section02.run;

import section02.service.ByteService;

public class RunByte {
	public static void main(String[] args) {
		ByteService service = new ByteService();

//		service.fileByteOutput();
//		service.bufferedFileByteOutput();
//		service.fileByteInput();
//		service.fileByteInput2();
//		service.bufferdFileByteInput();
		service.fileCopy();
	}
}
