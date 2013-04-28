/**
 * 
 */
package test.org.apache.lucene.analysis.standard;

import java.io.Reader;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

import test.org.apache.lucene.A_Test;

/**
 * @author hp-pro
 *
 */
public class StandardAnalysisTest extends A_Test {
	private static String str = "�л����񹲺͹���1949�꽨�����Ӵ˿�ʼ�����й���ΰ��ƪ��";
	public static void testStandardAnalysis() {
		try {
			Analyzer analyzer = new StandardAnalyzer();
			Reader r = new StringReader(str);
			StopFilter sf  = (StopFilter)analyzer.tokenStream("", r);
			Token t = null;
			while((t = sf.next()) !=null) {
				System.out.println("text:" + t.termText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		testStandardAnalysis();
	}
}
