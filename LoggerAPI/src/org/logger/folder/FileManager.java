package org.logger.folder;

import java.io.File;
import java.io.IOException;

public class FileManager {
	/**
	 * Create the path and the files in the path
	 * @param name The name of the file
	 * @param folderPath The path were the file are created
	 */
	public static void createLogsFolder(String name, String folderPath) {
		File path = new File(folderPath);
		File file = new File(folderPath+name+".txt");
		System.out.println();
		if(!file.exists()) {
			path.mkdirs();
			try {file.createNewFile();} catch (IOException e) {System.err.println("The file \""+name+"\" cannot be created : "+e.getMessage());}
		}
	}
	/**
	 * Create a file with the param "name" on the folder path "./src/logs/"
	 * @param name The name of the logs file
	 */
	public static void createLogsFolder(String name) {
		createLogsFolder(name, "./src/logs/");
	}
}
