package DesginePrinciple.CensusAnalyzer;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyzerTest 
{
	private final String INDIAN_CENSUS_CSV_FILE_PATH = "./IndiaCensus.csv";
	private static final String WRONG_CENSUS_CSV_FILE_PATH = "IndiaCensus.csv";
	private static final String WRONG_CENSUS_FILE_TYPE_PATH = "./IndiaCensus.pdf";
	
	private final String INDIAN_STATE_CODE_CSV_FILE_PATH = "./StateCodes.csv";
	private static final String WRONG_STATE_CODE_CSV_FILE_PATH = "StateCodes.csv";
	private static final String WRONG_STATE_CODE_FILE_TYPE_PATH = "./StateCodes.pdf";
	
	//Indian Census analyzer tests
	@Test
	public void givenIndianCensusCSVFileReturnsCorrectNumOfRecords() throws IOException, CensusAnalyzerException {
		CensusAnalyzer censusAnalyzer = new CensusAnalyzer();
		int numOfRecords = censusAnalyzer.loadDataFromCSVFile(INDIAN_CENSUS_CSV_FILE_PATH);
		Assert.assertEquals(1, numOfRecords);
	}
	
	@Test
	public void given_IndiaCensusData_WithWrongFile_ShoulThrewException() throws IOException {
		try {
			CensusAnalyzer censusAnalyzer = new CensusAnalyzer();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyzerException.class);
			censusAnalyzer.loadDataFromCSVFile(WRONG_CENSUS_CSV_FILE_PATH);
		} catch(CensusAnalyzerException e) {
			Assert.assertEquals(CensusAnalyzerException.ExceptionType.CSV_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void given_IndiaCensusData_WithCorrectFile_ButWrongType_ShoulThrewException() throws IOException{
		try {
			CensusAnalyzer censusAnalyzer = new CensusAnalyzer();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(IOException.class);
			censusAnalyzer.loadDataFromCSVFile(WRONG_CENSUS_FILE_TYPE_PATH);
		} catch(CensusAnalyzerException e) {
			Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void given_IndiaCensusData_WithCorrectFile_ButWrongDelimiter_ShoulThrewException() throws IOException{
		try {
			CensusAnalyzer censusAnalyzer = new CensusAnalyzer();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(IOException.class);
			censusAnalyzer.loadDataFromFile(INDIAN_CENSUS_CSV_FILE_PATH);
		} catch(CensusAnalyzerException e) {
			Assert.assertEquals(CensusAnalyzerException.ExceptionType.UNABLE_TO_PARSE, e.type);
		}
	}
	
	
	//State codes analyzer tests
		@Test
		public void givenStateCodeCSVFileReturnsCorrectNumOfRecords() throws IOException, CensusAnalyzerException {
			CensusAnalyzer statecodeAnalyzer = new CensusAnalyzer();
			int numOfRecords = statecodeAnalyzer.loadDataFromCSVFile(INDIAN_STATE_CODE_CSV_FILE_PATH);
			Assert.assertEquals(1, numOfRecords);
		}
		
		
		@Test
		public void given_StateCodesData_WithWrongFile_ShoulThrewException() throws IOException {
			try {
				CensusAnalyzer statecodeAnalyzer = new CensusAnalyzer();
				ExpectedException exceptionRule = ExpectedException.none();
				exceptionRule.expect(CensusAnalyzerException.class);
				statecodeAnalyzer.loadDataFromCSVFile(WRONG_STATE_CODE_CSV_FILE_PATH);
			} catch(CensusAnalyzerException e) {
				Assert.assertEquals(CensusAnalyzerException.ExceptionType.CSV_FILE_PROBLEM, e.type);
			}
		}
		
		@Test
		public void given_StateCodesData_WithCorrectFile_ButWrongType_ShoulThrewException() throws IOException{
			try {
				CensusAnalyzer statecodeAnalyzer = new CensusAnalyzer();
				ExpectedException exceptionRule = ExpectedException.none();
				exceptionRule.expect(IOException.class);
				statecodeAnalyzer.loadDataFromCSVFile(WRONG_STATE_CODE_FILE_TYPE_PATH);
			} catch(CensusAnalyzerException e) {
				Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
			}
		}
		
		@Test
		public void given_StateCodesData_WithCorrectFile_ButWrongDelimiter_ShoulThrewException() throws IOException{
			try {
				CensusAnalyzer statecodeAnalyzer = new CensusAnalyzer();
				ExpectedException exceptionRule = ExpectedException.none();
				exceptionRule.expect(IOException.class);
				statecodeAnalyzer.loadDataFromFile(INDIAN_STATE_CODE_CSV_FILE_PATH);
			} catch(CensusAnalyzerException e) {
				Assert.assertEquals(CensusAnalyzerException.ExceptionType.UNABLE_TO_PARSE, e.type);
			}
		}
}
