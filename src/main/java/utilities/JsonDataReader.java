package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Utf8;

public class JsonDataReader  {

	
	public List<HashMap<String, String>> jsonDataReader(String filepath) throws IOException
	{
		
		//convert from json to string
		String jsonFilePath = FileUtils.readFileToString(new File(filepath) , StandardCharsets.UTF_8);
		//convert string to hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String ,String>> data = mapper.readValue(jsonFilePath, new TypeReference<List<HashMap<String ,String>>>() {});
		return data;
		
	}
}
