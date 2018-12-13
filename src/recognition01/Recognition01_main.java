package recognition01;

import java.io.File;
import java.io.FileNotFoundException;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectFacesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;

public class Recognition01_main {

	public static void main(String[] args) {
		VisualRecognition service = new VisualRecognition("2018-03-19");
		IamOptions iamOptions = new IamOptions.Builder()
		  .apiKey("834iufuheuhefh9f43hjfj98yg3jh38yYYIQWHF9hf899f")
		  .build();
		service.setIamCredentials(iamOptions);

		DetectFacesOptions detectFacesOptions = null;
		try {
			detectFacesOptions = new DetectFacesOptions.Builder()
					  .imagesFile(new File("img/img_5008f1cd72f6318332f53b2654a2f3be397279.jpg"))
					  .build();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DetectedFaces result = service.detectFaces(detectFacesOptions).execute();
			System.out.println(result);



	}
}
