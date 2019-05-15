package Serializador;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import NOSQL.HashTable;
import Server.Response;
import estructurasDeDatos.ListaEnlazadaSimple;
import estructurasDeDatos.Nodo;


public class Serializador {
	static ObjectMapper mapper = new ObjectMapper();
	
	public static <T> String serializar(Response Lista) throws IOException {
			String jsonTemp = mapper.writerWithDefaultPrettyPrinter()
		            .writeValueAsString(Lista);
			return jsonTemp;	
			
	}
			
	public static Response deserializar(String json) throws JsonParseException, JsonMappingException, IOException {
				
		Response objeto = mapper.readValue(json, new TypeReference<Response>(){});
				
				return objeto;
		
		
	}
	
	

	


	
}
