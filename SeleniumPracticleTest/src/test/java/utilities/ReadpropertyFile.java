package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

		System.out.println("The Path is :"+System.getProperty("user.dir"));
		FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/config.properties");
		
		//FileReader fr = new FileReader("/Users/swaprenu/eclipse-workspace/EclipseNewWorkspace/SeleniumPracticleTest/src/test/resources/configfiles/config.properties");
		
		Properties prop = new Properties();
		prop.load(fr);
		System.out.print("browsername is :"+prop.getProperty("browser"));
		
	}

}
