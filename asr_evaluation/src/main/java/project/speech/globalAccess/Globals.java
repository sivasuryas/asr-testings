package project.speech.globalAccess;

import java.awt.Color;
import java.io.File;

import javax.swing.UIManager;

public class Globals {
	
	public static String theme1 = UIManager.getSystemLookAndFeelClassName();
	public static String theme2 = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	public static String theme3 = "javax.swing.plaf.metal.MetalLookAndFeel";
	
	public static Color turquoise = new Color(0, 162, 232, 255);
	
	public static String select = "--- Select ---";
	public static String asr1Name = "cmusphinx";
	public static String asr2Name = "ispeech";
	
	public static String asr1SelectionNameUI = "CmuSphinx";
	public static String asr2SelectionNameUI = "iSpeech";
	public static String allselectionUI = "All";
	
	public static String hsdiWeightsAlgorithm = "HSDI weights";
	
	public static String werUI = "WER";
	public static String serUI = "SER";
	public static String mucUI = "MUC";
	public static String accUI = "ACC";
	public static String allUI = "ALL";
	
	public static String wavFolder = "wav";
	public static String etcFolder = "etc";
	
	public static String referenceFileName = "prompts-original";
	public static String hypothesisOutputFileNameAsr1 = asr1SelectionNameUI+"-output";
	public static String hypothesisOutputFileNameAsr2 = asr2SelectionNameUI+"-output";
	
	public static String hypothesisTimeFileNameAsr1 = asr1SelectionNameUI+"-time";
	public static String hypothesisTimeFileNameAsr2 = asr2SelectionNameUI+"-time";
	
	public static File recognitionOutputDirectory = new File("asrOutput");
	public static File RecogniseAndEvaluateResultDirectory = new File("evaluationOutput");
	public static File textEvaluationResultDirectory = new File ("comparisonOutput");
	
	public static String recogniseAndEvaluateResultFileName = "evaluation-result";
	public static String textEvaluationResultFileName = "comparison-result";
	
	public static String recogniseAndEvaluateAlignmentFileName = "evaluation-alignment";
	public static String textEvaluationAlignmentFileName = "comparison-alignment";
	
	public static String recogniseAndEvaluateCompleteOutputFileName = "evaluation-complete-output";
	public static String textEvaluationCompleteOutputFileName = "comparison-complete-output";
	
	public static String model1ResultFilePath = "/"+RecogniseAndEvaluateResultDirectory+"/"+recogniseAndEvaluateResultFileName;
	public static String model2ResultFilePath = "/"+textEvaluationResultDirectory+"/"+textEvaluationResultFileName;
	
	public static String model1AlignmentFilePath = "/"+RecogniseAndEvaluateResultDirectory+"/"+recogniseAndEvaluateAlignmentFileName;
	public static String model2AlignmentFilePath = "/"+textEvaluationResultDirectory+"/"+textEvaluationAlignmentFileName;
	
	public static String model1CompleteOutputFilePath = "/"+RecogniseAndEvaluateResultDirectory+"/"+recogniseAndEvaluateCompleteOutputFileName;
	public static String model2CompleteOutputFilePath = "/"+textEvaluationResultDirectory+"/"+textEvaluationCompleteOutputFileName;
	
	public static File currentFile = new File("");
	public static String currentPath = currentFile.getAbsolutePath() + "/";
	
}