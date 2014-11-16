package simple.test.maventest;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;

public class App {

	public static void main(String[] args) throws IOException {
		File resource = new File("asrOutput");
		ArrayList<File> database = new ArrayList<File>();
		ArrayList<File> speechFiles = new ArrayList<File>();
		ArrayList<File> promptFiles = new ArrayList<File>();
		System.out.println(resource.listFiles());

		database = changeDirectory(resource);
		System.out.println(database);
		for (int i = 0; i < database.size(); i++) {
			File currentFolder = database.get(i);
			System.out.println(currentFolder.getName());
			if (currentFolder.isDirectory() == true) {
				System.out.println(currentFolder.listFiles());
				for (File each : currentFolder.listFiles()) {
					if (each.getName().compareTo("prompt-original.txt") == 0) {
						File hypEvaluationFile = each;
					} else if (each.getName().compareTo("speechOutput.txt") == 0) {
						File refEvaluationFile = each;
						BufferedReader readRef = new BufferedReader(
								new FileReader(refEvaluationFile));
						String refLine;
						while ((refLine = readRef.readLine()) != null) {
							List<String> refWords = new ArrayList<String>(
									Arrays.asList(refLine.split(" ")));
							for (int ii = 0; ii < refWords.size(); ii++) {
								System.out.println(refWords.get(ii));
							}
							System.out.println(refLine);
						}
					}
				}
			}
		}
	}

	/*
	 * for (int i = 0; i < database.size(); i++) { if
	 * (database.get(i).isDirectory() == true) {
	 * System.out.println(database.get(i).getName()); /*File dirr = new
	 * File("created/hi"); dirr.mkdirs(); File newone = new File (dirr,
	 * "res.txt"); PrintWriter write = new PrintWriter(newone, "UTF-8");
	 * write.close(); File newone = new File("created/hi/res.txt"); File resout
	 * = new File("out/resout.txt"); FileUtils.copyFile(newone,resout); //File
	 * hypothesisFile = new File("created/hi/speechOutput.txt");
	 * //outFile.println("helo worlkjslddd..."); //outFile.close(); for (File
	 * each : database.get(i).listFiles()) { if (each.getName().compareTo("wav")
	 * == 0) { speechFiles = changeDirectory(each); } if
	 * (each.getName().compareTo("etc") == 0) { promptFiles =
	 * changeDirectory(each); for (File files : promptFiles) { if
	 * (files.getName().compareTo("prompts-original") == 0) { File prompt =
	 * files; } } } } } } }
	 */
	public static ArrayList<File> changeDirectory(File currentPath) {
		ArrayList<File> folders = new ArrayList<File>();
		for (File eachPath : currentPath.listFiles()) {
			folders.add(eachPath);
		}
		return folders;

	}
}