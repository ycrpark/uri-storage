package core.service;

import java.util.HashMap;
import java.util.Map;

import core.comm.RepositoryUtils;
import core.model.Datum;

public class RepositoryService {
	private Map<String, Map<String, Map<String, Datum>>> repositories = new HashMap<>();
	
	public RepositoryService() {
	}
	
	private static class Loader {
		public static final RepositoryService INSTANCE = new RepositoryService();
	}
	
	public static RepositoryService getInstance() {
		return Loader.INSTANCE;
	}
	
	/**
	 * uri들을 저장할 저장소 생성 or get
	 * 
	 * @param repositoryKey
	 * @return
	 */
	public Map<String, Map<String, Datum>> getRepository(String repositoryKey) {
		if(repositoryKey == null) {
			return null;
		}
		
		Map<String, Map<String, Datum>> repository = repositories.get(repositoryKey);
		if(repository == null) {
			repository = new HashMap<>();
			repositories.put(repositoryKey, repository);
		}
		
		return repository;
	}
	
	/**
	 * 해당 종류의 uri를 저장할 data 생성 or get
	 * @param repositoryKey
	 * @param dataKey
	 * @return
	 */
	public Map<String, Datum> getData(String repositoryKey, String dataKey) {
		if(repositoryKey == null || dataKey == null) {
			return null;
		}
		
		Map<String, Map<String, Datum>> repository = getRepository(repositoryKey);
		if(repository == null) {
			return null;
		}
		
		Map<String, Datum> data = repository.get(dataKey);
		if(data == null) {
			data = new HashMap<>();
			repository.put(dataKey, data);
		}
		
		return data;
	}
	
	/**
	 * 해당 저장소, 데이터에 uri 저장 후 keys 반환
	 * @param repositoryKey
	 * @param dataKey
	 * @param uri
	 * @return
	 */
	public Map<String, Integer> saveUri(String repositoryKey, String dataKey, String uri) {
		if(repositoryKey == null || dataKey == null) {
			return null;
		}
		
		Map<String, Datum> data = getData(repositoryKey, dataKey);
		if(data == null) {
			return null;
		}
		
		Map<String, Integer> keys = new HashMap<>();
		RepositoryUtils.addURI(data, keys, uri);
		
		return keys;
	}
	
	/**
	 * 해당 저장소, 데이터에 uri 저장 후 keys 반환
	 * @param repositoryKey
	 * @param dataKey
	 * @param uri
	 * @return
	 */
	public Map<String, Integer> saveParameterString(String repositoryKey, String dataKey, String parameterString) {
		if(repositoryKey == null || dataKey == null) {
			return null;
		}
		
		Map<String, Datum> data = getData(repositoryKey, dataKey);
		if(data == null) {
			return null;
		}
		
		Map<String, Integer> keys = new HashMap<>();
		RepositoryUtils.addParameterString(data, keys, parameterString);
		
		return keys;
	}
}
