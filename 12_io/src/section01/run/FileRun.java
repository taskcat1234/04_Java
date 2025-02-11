package section01.run;

import section01.service.FileService;

public class FileRun {
	public static void main(String[] args) {
		FileService server = new FileService();
		server.test3();
	}
}
