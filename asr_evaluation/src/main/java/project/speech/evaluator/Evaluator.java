package project.speech.evaluator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Evaluator {
	private int hits = 0;
	private int substitutions = 0;
	private int deletions = 0;
	private int insertions = 0;
	private static String empty = "=====";
	File ref = null;
	File hyp = null;

	public Evaluator(File referenceFile, File hypothesisFile) {
		ref = referenceFile;
		hyp = hypothesisFile;
	}

	public static List<String> shift(List<String> original, int leftPose,
			int rightPose) {
		int gap = Math.abs(leftPose - rightPose);
		for (int i = 0; i < gap; i++) {
			original.add(original.get(original.size() - 1));
		}
		int pose = (leftPose < rightPose) ? leftPose : rightPose;
		for (int i = 0; i < gap; i++) {
			for (int k = original.size() - 1; k > pose; k--) {
				original.set(k, original.get(k - 1));
			}
			original.set(pose, empty);
		}
		return original;
	}

	public EvaluatorResult evaluate() throws IOException {
		System.out.println("Hello world...");
		BufferedReader readRef = new BufferedReader(new FileReader(ref));
		BufferedReader readHyp = new BufferedReader(new FileReader(hyp));
		String refLine;
		while ((refLine = readRef.readLine()) != null) {
			String hypLine = readHyp.readLine();
			System.out.println("REF : " + refLine);
			System.out.println("HYP : " + hypLine);
			refLine = refLine.replace(".", " ");
			List<String> refWords = new ArrayList<String>(Arrays.asList(refLine
					.split(" ")));
			List<String> hypWords = new ArrayList<String>(Arrays.asList(hypLine
					.split(" ")));

			for (int r_idx = 0; r_idx < refWords.size(); r_idx++) {
				int store = Integer.MAX_VALUE;
				int index = 0;
				int hit = 1;
				Boolean hitFlag = false;
				for (int h_idx = 0; h_idx < hypWords.size(); h_idx++) {
					if ((refWords.get(r_idx) != empty)
							&& (hypWords.get(h_idx) != empty)) {
						hit = refWords.get(r_idx).compareToIgnoreCase(
								hypWords.get(h_idx));
						if (hit == 0) {
							hitFlag = true;
							System.out.println(refWords.get(r_idx) + ":::::"
									+ hypWords.get(h_idx));
							if (Math.abs(r_idx - h_idx) < store) {
								store = Math.abs(r_idx - h_idx);
								index = h_idx;
							}
						}
					}
				}
				if ((hitFlag == true) && (r_idx != index) && (store<4)) {
					if (index > r_idx) {
						refWords = shift(refWords, r_idx, index);
					} else if (r_idx > index) {
						hypWords = shift(hypWords, r_idx, index);
					}
				}
			}
			int difference = hypWords.size() - refWords.size();
			if (difference != 0){
				for(int i=0; i<difference; i++){
					refWords.add("=====");
				}
			}
			for (int k = 0; k < hypWords.size(); k++) {
/*				System.out.println("k :   "+k);
				System.out.println("size r...:   "+refWords.size());
				System.out.println("size h...:   "+hypWords.size());*/
				System.out.println(refWords.get(k) + "   " + hypWords.get(k));
			}

			for (int k = 0; k < hypWords.size() ; k++) {
				if (refWords.get(k) == empty){
					insertions++;}
				if (hypWords.get(k) == empty){
					deletions++;}
				if ((refWords.get(k) != empty) && (hypWords.get(k) != empty)) {
					if (refWords.get(k).compareToIgnoreCase(hypWords.get(k)) == 0){
						hits++;}
					else{
						substitutions++;}
				}
			}
		}
		readRef.close();
		EvaluatorResult eval = new EvaluatorResult(hits-1, substitutions,
				deletions, insertions);
		return eval;
	}
}