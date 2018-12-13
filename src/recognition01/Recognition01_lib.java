package recognition01;

import java.io.File;
import java.io.FileNotFoundException;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectFacesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;



public class Recognition01_lib {
	VisualRecognition service;
	IamOptions iamOptions;
	DetectFacesOptions detectFacesOptions;
	DetectedFaces result;
	
	public Recognition01_lib() {
		this.service = new VisualRecognition("2018-03-19");
		this.iamOptions = new IamOptions.Builder()
			.apiKey("9gi3quhfqhfIUGFIWEHjwefiurniOUiaierIFEhewifwo")
			.build();
		service.setIamCredentials(iamOptions);
	}

	public void getResult(String filename) {
		// TODO Auto-generated method stub
		detectFacesOptions = null;
		try {
			detectFacesOptions = new DetectFacesOptions.Builder()
					  .imagesFile(new File(filename))
					  .build();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		result = service.detectFaces(detectFacesOptions).execute();
			System.out.println(result);


	}

}