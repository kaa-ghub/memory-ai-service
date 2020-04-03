package memoryhack.snowballs.memory.ai;

import com.algorithmia.APIException;
import com.algorithmia.AlgorithmException;
import com.algorithmia.Algorithmia;
import com.algorithmia.AlgorithmiaClient;
import com.algorithmia.algo.AlgoResponse;
import com.algorithmia.algo.Algorithm;
import com.algorithmia.data.DataDirectory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);


//		String input = "kaa_algo";
//		AlgorithmiaClient client = Algorithmia.client("simY04UKzLzli2oPS9YK1ip89IV1");
//		Algorithm algo = client.algo("kaa_algo/Hello/0.1.0");
//		algo.setTimeout(300L, java.util.concurrent.TimeUnit.SECONDS); //optional
//		AlgoResponse result = null;
//		try {
//			result = algo.pipe(input);
//			System.out.println(result.asJsonString());
//		} catch (APIException | AlgorithmException e) {
//			e.printStackTrace();
//		}



		String input = "{"
				+ "  \"image\": \"data://.my/test/0bd73193c44f73d809392dae4a350be1_origin.jpg\""
				+ "}";
		AlgorithmiaClient client = Algorithmia.client("XXX");

//		DataDirectory dataDirectory = client.dir("data://.my/test");
//		try {
//			dataDirectory.putFile(new File("/home/kaa/Загрузки/0bd73193c44f73d809392dae4a350be1_origin.jpg"));
//		} catch (APIException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}

		Algorithm algo = client.algo("deeplearning/ColorfulImageColorization/1.1.13");
		algo.setTimeout(300L, java.util.concurrent.TimeUnit.SECONDS); //optional
		AlgoResponse result = null;
		try {
				result = algo.pipe(input);
			System.out.println(result.asJsonString());
		} catch (APIException | AlgorithmException e) {
			e.printStackTrace();
		}

	}

}
